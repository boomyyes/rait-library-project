'use client';

 export default function BookCard({ book }) {
   const handleBorrow = () => {
     console.log('Borrowing book:', book.title);
   };

   return (
     <div className="border border-gray-800 p-6 flex flex-col h-full">
       <div className="flex-grow">
         {/* Main title is already bright white */}
         <h3 className="text-xl font-semibold mb-2 tracking-tighter text-white">{book.title}</h3>
         {/* Lighter gray for genre */}
         <p className="text-gray-400 mb-4 text-sm uppercase tracking-wider">{book.genre}</p>
         {/* Brighter gray for the synopsis */}
         <p className="mb-4 text-gray-300 leading-relaxed">{book.synopsis}</p>
       </div>
       {/* Brighter gray for the details */}
       <div className="flex justify-between items-center text-sm text-gray-400 mb-4">
         <span>Price: ${book.price.toFixed(2)}</span>
         <span>Rating: {book.rating}/5</span>
       </div>
       <button
         onClick={handleBorrow}
         className="w-full mt-auto p-3 bg-white text-black font-semibold tracking-wider uppercase hover:bg-gray-300 transition-colors"
       >
         Borrow
       </button>
     </div>
   );
 }
