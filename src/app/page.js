'use client';
import { useEffect, useRef, useState } from 'react';
import Link from 'next/link';
import gsap from 'gsap';

const videoSrc = "/rait.mp4"; 

// --- Background Media Component ---
const BackgroundMedia = ({ src }) => {
  return (
    <div className="absolute top-0 left-0 w-full h-full bg-black z-0">
      <div className="absolute inset-0 bg-black/60 z-10"></div>
      {/* The 'object-center' class is added here to fix the positioning */}
      <video autoPlay loop muted playsInline className="w-full h-full object-cover object-center">
        <source src={src} type="video/mp4" />
      </video>
    </div>
  );
};

// --- Hero Text Component ---
const HeroText = ({ videoSrc }) => {
  useEffect(() => {
    gsap.fromTo('.hero-line', 
      { y: 60, opacity: 0 }, 
      { y: 0, opacity: 1, duration: 1, stagger: 0.2, ease: 'power3.out', delay: 0.5 }
    );
  }, []);

  return (
    <div className='font-extrabold text-white text-center'>
      <div className='hero-line lg:text-[9.5vw] text-[12vw] flex justify-center items-center uppercase lg:leading-[8vw] leading-[10vw] tracking-tighter'>
        A DIGITAL HOME
      </div>
      <div className='hero-line lg:text-[9.5vw] text-[12vw] flex justify-center items-center uppercase lg:leading-[8vw] leading-[10vw] tracking-tighter'>
        FOR ALL 
        <div className='relative h-[7vw] w-[16vw] rounded-full mx-4 overflow-hidden -mt-[1vw]'>
          <video autoPlay loop muted playsInline className="absolute top-0 left-0 w-full h-full object-cover object-center">
             <source src={videoSrc} type="video/mp4" />
          </video>
        </div>
        THINGS
      </div>
      <div className='hero-line lg:text-[9.5vw] text-[12vw] flex justify-center items-center uppercase lg:leading-[8vw] leading-[10vw] tracking-tighter'>
        BOOKS
      </div>
    </div>
  );
};

// --- Bottom Section Component ---
const BottomSection = () => {
  const [time, setTime] = useState('');

  useEffect(() => {
    const timer = setInterval(() => {
      const now = new Date();
      // Using IST for demonstration, you can adjust the timezone as needed
      const timeString = now.toLocaleTimeString('en-US', {
          hour12: false,
          hour: '2-digit',
          minute: '2-digit',
          second: '2-digit',
          timeZone: 'Asia/Kolkata' 
      }).replace(/:/g, '-');
      setTime(timeString);
    }, 1000);

    return () => clearInterval(timer);
  }, []);

  return (
    <div className="w-full absolute bottom-0 left-0 p-4 lg:p-8 z-20">
      <div className="flex justify-between items-end">
        {/* Left Side: Action Buttons */}
        <div className="flex items-center gap-4">
          <Link href="/browse" className='group relative'>
            <div className='lg:h-36 h-24 w-24 lg:w-36 flex items-center justify-center border-2 border-white rounded-full uppercase transition-colors duration-300 group-hover:border-lime-300 group-hover:text-lime-300'>
              <span className='text-md lg:text-xl font-semibold tracking-wider pt-1'>Browse</span>
            </div>
          </Link>
          <Link href="/login" className='group relative'>
            <div className='lg:h-36 h-24 w-24 lg:w-36 flex items-center justify-center border-2 border-white rounded-full uppercase transition-colors duration-300 group-hover:border-lime-300 group-hover:text-lime-300'>
              <span className='text-md lg:text-xl font-semibold tracking-wider pt-1'>Login</span>
            </div>
          </Link>
        </div>
        
        {/* Right Side: Info and Clock */}
        <div className="text-right">
          <p className='hidden lg:block lg:w-[22vw] font-light text-gray-300 text-base leading-relaxed text-left mb-4'>
            The RAIT Library Project is a modern digital solution designed to streamline book management for students and staff. Discover, borrow, and engage with our extensive collection effortlessly.
          </p>
          <div className="flex justify-end items-center gap-4 text-sm text-gray-400">
            <span>Nerul, Navi Mumbai-400706</span>
            <span className="text-white font-mono">{time}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

// --- Main Landing Page ---
export default function LandingPage() {
  return (
    <main className="h-screen w-screen relative text-white overflow-hidden flex items-center justify-center">
      <BackgroundMedia src={videoSrc} />
      <div className="relative z-10">
        <HeroText videoSrc={videoSrc} />
      </div>
      <BottomSection />
    </main>
  );
}
