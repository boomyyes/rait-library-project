'use client';
import { useEffect, useState } from 'react';
import Link from 'next/link';
import gsap from 'gsap';
import { useSelector, useDispatch } from 'react-redux';
import { logout } from '@/lib/authSlice';
import { useRouter } from 'next/navigation';

const videoSrc = "/rait.mp4"; 

const BackgroundMedia = ({ src }) => (
  <div className="absolute top-0 left-0 w-full h-full bg-black z-0">
    <div className="absolute inset-0 bg-black/60 z-10"></div>
    <video autoPlay loop muted playsInline className="w-full h-full object-cover object-center">
      <source src={src} type="video/mp4" />
    </video>
  </div>
);

const HeroText = ({ videoSrc }) => {
  useEffect(() => {
    gsap.fromTo('.hero-line', { y: 60, opacity: 0 }, { y: 0, opacity: 1, duration: 1, stagger: 0.2, ease: 'power3.out', delay: 0.5 });
  }, []);

  return (
    <div className='font-extrabold text-white text-center'>
      <div className='hero-line lg:text-[9.5vw] text-[12vw] flex justify-center items-center uppercase lg:leading-[8vw] leading-[10vw] tracking-tighter'>WELCOME TO THE</div>
      <div className='hero-line lg:text-[9.5vw] text-[12vw] flex justify-center items-center uppercase lg:leading-[8vw] leading-[10vw] tracking-tighter'>
        RAIT 
        <div className='relative h-[7vw] w-[16vw] rounded-full mx-4 overflow-hidden -mt-[1vw]'>
          <video autoPlay loop muted playsInline className="absolute top-0 left-0 w-full h-full object-cover object-center">
             <source src={videoSrc} type="video/mp4" />
          </video>
        </div>
        LIBRARY
      </div>
      <div className='hero-line lg:text-[9.5vw] text-[12vw] flex justify-center items-center uppercase lg:leading-[8vw] leading-[10vw] tracking-tighter'>BOOKS</div>
    </div>
  );
};

// Reusable Circle Button Component
const CircleButton = ({ href, onClick, children, className }) => {
  const content = (
    <div className={`lg:h-36 h-24 w-24 lg:w-36 flex items-center justify-center border-2 border-white rounded-full uppercase transition-colors duration-300 ${className}`}>
      <span className='text-md lg:text-xl font-semibold tracking-wider pt-1'>{children}</span>
    </div>
  );

  return href ? <Link href={href} className="group relative">{content}</Link> : <button onClick={onClick} className="group relative">{content}</button>;
};

const BottomSection = () => {
  const [time, setTime] = useState('');
  const { isAuthenticated } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const router = useRouter();

  const handleLogout = () => {
    dispatch(logout());
    router.push('/');
  };

  useEffect(() => {
    const timer = setInterval(() => {
      const now = new Date();
      const timeString = now.toLocaleTimeString('en-US', { hour12: false, hour: '2-digit', minute: '2-digit', second: '2-digit', timeZone: 'Asia/Kolkata' }).replace(/:/g, '-');
      setTime(timeString);
    }, 1000);
    return () => clearInterval(timer);
  }, []);

  return (
    <div className="w-full absolute bottom-0 left-0 p-4 lg:p-8 z-20">
      <div className="flex justify-between items-end">
        <div className="flex items-end gap-6">
          <CircleButton href="/browse" className="group-hover:border-lime-300 group-hover:text-lime-300">Browse</CircleButton>
          
          {isAuthenticated ? (
            <CircleButton href="/dashboard" className="group-hover:border-blue-400 group-hover:text-blue-400">Dashboard</CircleButton>
          ) : (
            <>
              <CircleButton href="/login" className="group-hover:border-blue-400 group-hover:text-blue-400">Log In</CircleButton>
              <CircleButton href="/register" className="group-hover:border-green-400 group-hover:text-green-400">Register</CircleButton>
            </>
          )}
        </div>
        
        <div className="text-right">
          <p className='hidden lg:block lg:w-[22vw] font-light text-gray-300 text-base leading-relaxed text-right mb-4'>
            Made by Avanish Wankhede, Jash Verma, Gaurav Vojhala, and Ansh Yadav.
          </p>
          <div className="flex justify-end items-center gap-4 text-sm text-gray-400">
            <span>Nerul, Sector 7, Navi Mumbai-400706</span>
            <span className="text-white font-mono">{time}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default function LandingPage() {
  return (
    <main className="h-screen w-screen relative text-white overflow-hidden flex items-center justify-center">
      <BackgroundMedia src={videoSrc} />
      <div className="relative z-10"><HeroText videoSrc={videoSrc} /></div>
      <BottomSection />
    </main>
  );
}