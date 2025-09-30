'use client';
import { useEffect, useRef } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { fetchBooks } from '@/lib/bookSlice';
import BookList from '@/components/BookList';
import gsap from 'gsap';

export default function Home() {
  const dispatch = useDispatch();
  // Get the book data from the Redux store
  const { items: books, status: bookStatus, error } = useSelector((state) => state.books);

  const titleRef = useRef(null);

  useEffect(() => {
      // Create a GSAP context scoped to the component
      const ctx = gsap.context(() => {
        // Animate the title
        gsap.from(titleRef.current, {
          duration: 1,
          opacity: 0,
          y: 30,
          ease: 'power3.out',
          delay: 0.2,
        });
      }); // No scope element needed here

      if (bookStatus === 'idle') {
        dispatch(fetchBooks());
      }

      // Return the cleanup function
      return () => ctx.revert();

    }, [bookStatus, dispatch]);

  let content;

  if (bookStatus === 'loading' || bookStatus === 'idle') {
    content = <p className="text-center mt-20">Loading...</p>;
  } else if (bookStatus === 'succeeded') {
    content = <BookList books={books} />;
  } else if (bookStatus === 'failed') {
    content = <p className="text-center mt-20 text-red-500">{error}</p>;
  }

  return (
    <div>
      <h1 ref={titleRef} className="text-5xl font-bold mb-12 tracking-tighter">
        Available Books
      </h1>
      {content}
    </div>
  );
}
