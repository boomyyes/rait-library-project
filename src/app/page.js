'use client';
import { useEffect, useState } from 'react';
import { getBooks } from '../../services/api';
import BookList from './components/BookList';

export default function Home() {
  const [books, setBooks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        const response = await getBooks();
        setBooks(response.data);
      } catch (err) {
        setError('Failed to fetch books. Please try again later.');
        console.error(err);
      } finally {
        setLoading(false);
      }
    };
    fetchBooks();
  }, []);

  if (loading) return <p className="text-center mt-20">Loading books...</p>;
  if (error) return <p className="text-center mt-20 text-red-500">{error}</p>;

  return (
    <div>
      <h1 className="text-5xl font-bold mb-12 tracking-tighter">Available Books</h1>
      <BookList books={books} />
    </div>
  );
}
