'use client';
import { useEffect, useRef } from 'react';
import gsap from 'gsap';
import { usePathname } from 'next/navigation';

export default function Template({ children }) {
  const mainRef = useRef(null);
  const pathname = usePathname();

  useEffect(() => {
    const ctx = gsap.context(() => {
      gsap.fromTo(mainRef.current,
        { opacity: 0, y: 20 },
        { 
          opacity: 1, 
          y: 0, 
          duration: 0.8, 
          ease: 'power3.out',
          // This delay is the key: it waits for the stairs to finish
          delay: 0.8 
        }
      );
    }, mainRef);
    return () => ctx.revert();
  }, [pathname]);

  return (
    <div ref={mainRef}>
      {children}
    </div>
  );
}