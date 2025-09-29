'use client';
import { useEffect, useRef } from 'react';
import gsap from 'gsap';
import BookCard from './BookCard';

export default function BookList({ books }) {
  const gridRef = useRef(null);

  useEffect(() => {
    // Ensure the grid and its children exist before animating
    if (gridRef.current && gridRef.current.children.length > 0) {
      gsap.from(gridRef.current.children, {
        duration: 0.8,
        opacity: 0,
        y: 50,
        stagger: 0.1, // This creates the staggered effect
        ease: 'power3.out',
      });
    }
  }, [books]); // Rerun the animation if the books array changes

  return (
    <div ref={gridRef} className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
      {books.map((book) => (
        <BookCard key={book.id} book={book} />
      ))}
    </div>
  );
}
