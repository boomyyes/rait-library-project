'use client';
import React, { useEffect, useRef } from 'react';
import { usePathname } from 'next/navigation';
import gsap from 'gsap';

export default function Stairs({ children }) {
  const pathname = usePathname();
  const animatorRef = useRef(null);

  useEffect(() => {
    if (animatorRef.current) {
      animatorRef.current.runAnimation();
    }
  }, [pathname]);

  return (
    <div>
      <StairAnimation ref={animatorRef} />
      {children}
    </div>
  );
}

const StairAnimation = React.forwardRef((props, ref) => {
  const stairContainerRef = useRef(null);

  React.useImperativeHandle(ref, () => ({
    runAnimation() {
      const stairContainer = stairContainerRef.current;
      if (!stairContainer) return;

      const stairs = gsap.utils.toArray('.stair', stairContainer);
      const tl = gsap.timeline();

      // This timeline now ONLY controls the stair animation
      tl.set(stairContainer, { display: 'flex', zIndex: 9999, top: 0, y: '0%' });
      tl.set(stairs, { y: '0%', height: '0%' });

      tl.to(stairs, {
        height: '100%',
        duration: 0.5,
        ease: 'power3.inOut',
        stagger: { amount: 0.2 },
      })
      .to(stairs, {
        y: '-100%',
        duration: 0.5,
        ease: 'power3.inOut',
        stagger: { amount: -0.2 },
      })
      .set(stairContainer, { display: 'none' });
    },
  }));

  return (
    <div ref={stairContainerRef} className="fixed top-0 left-0 w-full h-screen hidden pointer-events-none">
      <div className="flex h-full w-full">
        <div className="stair h-0 w-1/5 bg-white"></div>
        <div className="stair h-0 w-1/5 bg-white"></div>
        <div className="stair h-0 w-1/5 bg-white"></div>
        <div className="stair h-0 w-1/5 bg-white"></div>
        <div className="stair h-0 w-1/5 bg-white"></div>
      </div>
    </div>
  );
});
