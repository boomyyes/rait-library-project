'use client';
import { useState } from 'react';
import { useSelector } from 'react-redux';
import { useRouter } from 'next/navigation';
import { borrowBook } from '@/services/api';
import Link from 'next/link';

 export default function BookCard({ book }) {
   const { isAuthenticated, user } = useSelector((state) => state.auth);
   const router = useRouter();
   const [isBorrowing, setIsBorrowing] = useState(false);
   const [borrowed, setBorrowed] = useState(false);
   const [error, setError] = useState(null);

   const handleBorrow = async (e) => {
    e.stopPropagation(); // Prevent the link from navigating
    e.preventDefault();

     if (!isAuthenticated) {
       router.push('/login');
       return;
     }

     setIsBorrowing(true);
     setError(null);

     try {
       await borrowBook(book.id, user.userId);
       setBorrowed(true);
     } catch (err) {
       console.error('Failed to borrow book:', err);
       setError('Could not borrow book.');
     } finally {
       setIsBorrowing(false);
     }
   };

   return (
    <Link href={`/books/${book.id}`} className="block h-full">
     <div className="border border-gray-800 p-6 flex flex-col h-full hover:border-white transition-colors duration-300">
       <div className="flex-grow">
         <h3 className="text-xl font-semibold mb-2 tracking-tighter text-white">{book.title}</h3>
         <p className="text-gray-400 mb-4 text-sm uppercase tracking-wider">{book.genre}</p>
         <p className="mb-4 text-gray-300 leading-relaxed line-clamp-3">{book.synopsis}</p>
       </div>
       <div className="flex justify-between items-center text-sm text-gray-400 mb-4">
         <span>Price: ${book.price.toFixed(2)}</span>
         <span>Rating: {book.rating}/5</span>
       </div>
       <button
         onClick={handleBorrow}
         disabled={isBorrowing || borrowed}
         className="w-full mt-auto p-3 bg-white text-black font-semibold tracking-wider uppercase hover:bg-gray-300 transition-colors disabled:bg-gray-500 disabled:cursor-not-allowed"
       >
         {borrowed ? 'Borrowed' : isBorrowing ? 'Borrowing...' : 'Borrow'}
       </button>
       {error && <p className="text-red-500 text-center text-sm mt-2">{error}</p>}
     </div>
    </Link>
   );
 }

