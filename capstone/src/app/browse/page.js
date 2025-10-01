'use client';
import { useEffect, useMemo, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { fetchBooks } from '@/lib/bookSlice';
import BookList from '@/components/BookList';
import gsap from 'gsap';

export default function BrowsePage() {
  const dispatch = useDispatch();
  const { items: bookPage, status: bookStatus, error } = useSelector((state) => state.books);
  
  const [searchQuery, setSearchQuery] = useState('');
  const [selectedGenre, setSelectedGenre] = useState('All');
  const [showAvailableOnly, setShowAvailableOnly] = useState(false);
  const [currentPage, setCurrentPage] = useState(0);

  useEffect(() => {
    dispatch(fetchBooks({ page: currentPage, size: 9 }));
  }, [dispatch, currentPage]);
  
  useEffect(() => {
      const ctx = gsap.context(() => {
        gsap.fromTo('.animate-in', { y: 40, opacity: 0 }, { y: 0, opacity: 1, duration: 0.8, stagger: 0.2, ease: 'power3.out' });
      });
      return () => ctx.revert();
  }, []);

  const books = bookPage?.content || [];

  const genres = useMemo(() => ['All', ...new Set(books.map(book => book.genre))], [books]);

  const filteredBooks = useMemo(() => {
    return books.filter(book => 
      (book.title.toLowerCase().includes(searchQuery.toLowerCase()) || book.genre.toLowerCase().includes(searchQuery.toLowerCase())) &&
      (selectedGenre === 'All' || book.genre === selectedGenre) &&
      (!showAvailableOnly || book.available)
    );
  }, [books, searchQuery, selectedGenre, showAvailableOnly]);

  const handleNextPage = () => {
    if (!bookPage.last) {
      setCurrentPage(currentPage + 1);
    }
  };

  const handlePreviousPage = () => {
    if (!bookPage.first) {
      setCurrentPage(currentPage - 1);
    }
  };

  return (
    <div>
      <h1 className="animate-in text-5xl font-bold mb-8 tracking-tighter">Browse Collection</h1>
      <div className="animate-in mb-12 flex flex-col md:flex-row gap-4">
        <input type="text" placeholder="Search..." value={searchQuery} onChange={(e) => setSearchQuery(e.target.value)} className="w-full md:w-1/2 p-4 bg-black border border-gray-700 rounded-md"/>
        <select value={selectedGenre} onChange={(e) => setSelectedGenre(e.target.value)} className="w-full md:w-1/4 p-4 bg-black border border-gray-700 rounded-md">
            {genres.map(genre => <option key={genre} value={genre}>{genre}</option>)}
        </select>
        <div className="flex items-center justify-center p-4 border border-gray-700 rounded-md">
            <input id="availability" type="checkbox" checked={showAvailableOnly} onChange={(e) => setShowAvailableOnly(e.target.checked)} className="h-5 w-5 bg-black border-gray-600 rounded text-lime-400 focus:ring-lime-500"/>
            <label htmlFor="availability" className="ml-3">Available Only</label>
        </div>
      </div>
      {bookStatus === 'succeeded' ? <BookList books={filteredBooks} /> : <p className="text-center mt-20">Loading...</p>}
      {bookStatus === 'succeeded' && filteredBooks.length === 0 && <p className="text-center mt-20 text-gray-400">No books match your criteria.</p>}
      {bookStatus === 'failed' && <p className="text-center mt-20 text-red-500">{error}</p>}
      <div className="flex justify-center items-center gap-4 mt-12">
        <button onClick={handlePreviousPage} disabled={bookPage?.first} className="px-6 py-2 bg-white text-black font-semibold rounded-md hover:bg-gray-300 disabled:bg-gray-500">Previous</button>
        <span>Page {bookPage ? bookPage.number + 1 : 1} of {bookPage?.totalPages}</span>
        <button onClick={handleNextPage} disabled={bookPage?.last} className="px-6 py-2 bg-white text-black font-semibold rounded-md hover:bg-gray-300 disabled:bg-gray-500">Next</button>
      </div>
    </div>
  );
}