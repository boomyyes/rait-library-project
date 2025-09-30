'use client';
import { useEffect, useRef } from 'react';
import gsap from 'gsap';
import BookCard from './BookCard';

export default function BookList({ books }) {
  const gridRef = useRef(null);

  useEffect(() => {
    const grid = gridRef.current;
    if (!grid) return;

    const cards = grid.children;
    if (cards.length === 0) return;

    // Use a GSAP context for safe animation cleanup
    const ctx = gsap.context(() => {
      // Set the initial state (hidden)
      gsap.set(cards, { opacity: 0, y: 40 });
      // Animate to the final state (visible)
      gsap.to(cards, {
        duration: 0.8,
        opacity: 1,
        y: 0,
        ease: 'power3.out',
        stagger: 0.15,
      });
    }, grid);

    // Cleanup function: this runs when the component unmounts or re-renders
    return () => ctx.revert();

  }, [books]);

  return (
     <div ref={gridRef} className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
        {books.map((book) => (
          <BookCard key={book.id} book={book} />
        ))}
     </div>
  );
}
