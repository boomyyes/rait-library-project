'use client';
import { useEffect, useState, useMemo } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { fetchBooks } from '@/lib/bookSlice';
import BookList from '@/components/BookList';
import gsap from 'gsap';

export default function BrowsePage() {
  const dispatch = useDispatch();
  const { items: allBooks, status: bookStatus, error } = useSelector((state) => state.books);

  const [searchQuery, setSearchQuery] = useState('');

  useEffect(() => {
    if (bookStatus === 'idle') {
      dispatch(fetchBooks());
    }
  }, [bookStatus, dispatch]);

  // Filter books based on the search query
  const filteredBooks = useMemo(() => {
    if (!searchQuery) {
      return allBooks;
    }
    return allBooks.filter(book =>
      book.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
      book.genre.toLowerCase().includes(searchQuery.toLowerCase())
    );
  }, [allBooks, searchQuery]);

  // GSAP animation for the title and search bar
  useEffect(() => {
    const ctx = gsap.context(() => {
      gsap.fromTo('.page-header-element', 
        { y: 30, opacity: 0 },
        { y: 0, opacity: 1, duration: 1, stagger: 0.2, ease: 'power3.out' }
      );
    });
    return () => ctx.revert();
  }, []);

  let content;

  if (bookStatus === 'loading' || bookStatus === 'idle') {
    content = <p className="text-center mt-20">Loading books...</p>;
  } else if (bookStatus === 'succeeded') {
    content = <BookList books={filteredBooks} />;
  } else if (bookStatus === 'failed') {
    content = <p className="text-center mt-20 text-red-500">{error}</p>;
  }

  return (
    <div>
      <div className="page-header-element">
        <h1 className="text-5xl font-bold mb-4 tracking-tighter">
          Browse Collection
        </h1>
        <p className="text-gray-400 mb-8">Search for books by title or genre.</p>
      </div>

      <div className="page-header-element mb-12 relative">
        <input
          type="text"
          placeholder="Search for a book..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
          className="w-full p-4 bg-black border border-gray-700 focus:outline-none focus:border-white rounded-md text-white placeholder-gray-500"
        />
      </div>
      
      {bookStatus === 'succeeded' && filteredBooks.length === 0 && (
        <p className="text-center text-gray-400 mt-20">No books found matching your search.</p>
      )}

      {content}
    </div>
  );
}