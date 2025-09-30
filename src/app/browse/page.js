'use client';
import { useEffect, useMemo, useRef, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { fetchBooks } from '@/lib/bookSlice';
import BookList from '@/components/BookList';
import gsap from 'gsap';

export default function BrowsePage() {
  const dispatch = useDispatch();
  const { items: books, status: bookStatus, error } = useSelector((state) => state.books);
  
  const [searchQuery, setSearchQuery] = useState('');
  const [selectedGenre, setSelectedGenre] = useState('All');
  const [showAvailableOnly, setShowAvailableOnly] = useState(false);

  const titleRef = useRef(null);
  const filtersRef = useRef(null);

  useEffect(() => {
    if (bookStatus === 'idle') {
      dispatch(fetchBooks());
    }
  }, [bookStatus, dispatch]);
  
  useEffect(() => {
      const ctx = gsap.context(() => {
        gsap.fromTo([titleRef.current, filtersRef.current], 
            { y: 40, opacity: 0 }, 
            { y: 0, opacity: 1, duration: 0.8, stagger: 0.2, ease: 'power3.out' }
        );
      });
      return () => ctx.revert();
  }, []);

  // Get a unique list of genres for the dropdown
  const genres = useMemo(() => {
      if (!books) return [];
      const allGenres = books.map(book => book.genre);
      return ['All', ...new Set(allGenres)];
  }, [books]);

  // Filter books based on search query, genre, and availability
  const filteredBooks = useMemo(() => {
    if (!books) return [];
    
    return books.filter(book => {
      const matchesSearch = book.title.toLowerCase().includes(searchQuery.toLowerCase()) || 
                            book.genre.toLowerCase().includes(searchQuery.toLowerCase());
      
      const matchesGenre = selectedGenre === 'All' || book.genre === selectedGenre;

      const matchesAvailability = !showAvailableOnly || book.available;

      return matchesSearch && matchesGenre && matchesAvailability;
    });
  }, [books, searchQuery, selectedGenre, showAvailableOnly]);

  let content;

  if (bookStatus === 'loading' || bookStatus === 'idle') {
    content = <p className="text-center mt-20">Loading books...</p>;
  } else if (bookStatus === 'succeeded') {
    content = filteredBooks.length > 0 
      ? <BookList books={filteredBooks} />
      : <p className="text-center mt-20 text-gray-400">No books match your criteria.</p>;
  } else if (bookStatus === 'failed') {
    content = <p className="text-center mt-20 text-red-500">{error}</p>;
  }

  return (
    <div>
      <h1 ref={titleRef} className="text-5xl font-bold mb-8 tracking-tighter">
        Browse Collection
      </h1>
      
      {/* Search and Filter Controls */}
      <div ref={filtersRef} className="mb-12 flex flex-col md:flex-row gap-4">
        <input
          type="text"
          placeholder="Search by title or genre..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
          className="w-full md:w-1/2 p-4 bg-black border border-gray-700 focus:outline-none focus:border-white rounded-md"
        />
        <select
            value={selectedGenre}
            onChange={(e) => setSelectedGenre(e.target.value)}
            className="w-full md:w-1/4 p-4 bg-black border border-gray-700 focus:outline-none focus:border-white rounded-md"
        >
            {genres.map(genre => (
                <option key={genre} value={genre}>{genre}</option>
            ))}
        </select>
        <div className="flex items-center justify-center p-4 border border-gray-700 rounded-md">
            <input 
                type="checkbox"
                id="availability"
                checked={showAvailableOnly}
                onChange={(e) => setShowAvailableOnly(e.target.checked)}
                className="h-5 w-5 bg-black border-gray-600 rounded text-lime-400 focus:ring-lime-500"
            />
            <label htmlFor="availability" className="ml-3 text-white">
                Show Available Only
            </label>
        </div>
      </div>

      {content}
    </div>
  );
}