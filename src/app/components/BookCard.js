'use client';
import { useSelector } from 'react-redux';
import { useRouter } from 'next/navigation';
import { borrowBook } from '../../services/api';
import { useState } from 'react';

export default function BookCard({ book }) {
  const { isAuthenticated, user } = useSelector((state) => state.auth);
  const router = useRouter();
  const [isBorrowed, setIsBorrowed] = useState(false);
  const [error, setError] = useState('');

  const handleBorrow = async () => {
    if (!isAuthenticated) {
      router.push('/login');
      return;
    }
    setError('');
    try {
      await borrowBook(book.id, user.userId);
      setIsBorrowed(true);
    } catch (err) {
      setError('Could not borrow book.');
      console.error('Borrow failed:', err);
    }
  };

  return (
    <div className="border border-gray-800 p-6 flex flex-col">
      <div className="flex-grow">
        <h3 className="text-xl font-semibold mb-2 tracking-tighter">{book.title}</h3>
        <p className="text-gray-400 mb-4">Genre: {book.genre}</p>
        <p className="mb-4 text-gray-300">{book.synopsis}</p>
        <div className="flex justify-between items-center mb-4">
          <span>Price: ${book.price.toFixed(2)}</span>
          <span>Rating: {book.rating}/5</span>
        </div>
      </div>
      <button
        onClick={handleBorrow}
        disabled={isBorrowed}
        className={`w-full p-3 font-semibold tracking-wider uppercase transition-colors ${
          isBorrowed
            ? 'bg-gray-700 text-gray-400 cursor-not-allowed'
            : 'bg-white text-black hover:bg-gray-300'
        }`}
      >
        {isBorrowed ? 'Borrowed' : 'Borrow'}
      </button>
      {error && <p className="text-red-500 text-center mt-2">{error}</p>}
    </div>
  );
}
