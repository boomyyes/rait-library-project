'use client';

export default function BookCard({ book }) {
  const handleBorrow = () => {
    // We will implement this functionality later
    console.log('Borrowing book:', book.title);
  };

  return (
    <div className="border border-gray-800 p-6">
      <h3 className="text-xl font-semibold mb-2 tracking-tighter">{book.title}</h3>
      <p className="text-gray-400 mb-4">Genre: {book.genre}</p>
      <p className="mb-4 text-gray-300">{book.synopsis}</p>
      <div className="flex justify-between items-center mb-4">
        <span>Price: ${book.price.toFixed(2)}</span>
        <span>Rating: {book.rating}/5</span>
      </div>
      <button
        onClick={handleBorrow}
        className="w-full p-3 bg-white text-black font-semibold tracking-wider uppercase hover:bg-gray-300 transition-colors"
      >
        Borrow
      </button>
    </div>
  );
}
