'use client';
import { useContext, useEffect, useRef } from 'react';
import Link from 'next/link';
import { usePathname, useRouter } from 'next/navigation';
import { useSelector, useDispatch } from 'react-redux';
import { NavbarContext } from '@/context/NavContext';
import { logout } from '@/lib/authSlice';
import gsap from 'gsap';

export default function Header() {
  const { isNavOpen, setIsNavOpen } = useContext(NavbarContext);
  const pathname = usePathname();
  const router = useRouter();
  const dispatch = useDispatch();
  const { isAuthenticated } = useSelector((state) => state.auth);
  const dropdownRef = useRef(null);

  // Effect to close the dropdown whenever the page changes
  useEffect(() => {
    setIsNavOpen(false);
  }, [pathname, setIsNavOpen]);

  // GSAP animation for the dropdown
  useEffect(() => {
    if (isNavOpen) {
      gsap.to(dropdownRef.current, { 
        y: 0, 
        opacity: 1, 
        display: 'block', 
        duration: 0.5, 
        ease: 'power3.out' 
      });
    } else {
      gsap.to(dropdownRef.current, { 
        y: -20, 
        opacity: 0, 
        duration: 0.5, 
        ease: 'power3.inOut',
        onComplete: () => {
          gsap.set(dropdownRef.current, { display: 'none' });
        }
      });
    }
  }, [isNavOpen]);

  const handleLinkClick = () => {
    setIsNavOpen(false);
  };

  const handleLogout = () => {
    dispatch(logout());
    setIsNavOpen(false);
    router.push('/login');
  };

  const isLandingPage = pathname === '/';
  const headerBg = isLandingPage ? 'bg-transparent' : 'bg-black/80 backdrop-blur-sm';
  const hamburgerColor = isNavOpen ? 'bg-black' : 'bg-white';

  return (
    <>
      <header className={`fixed top-0 left-0 w-full p-8 z-[100] transition-colors duration-300 ${headerBg}`}>
        <div className="flex justify-between items-center text-base">
          <Link href="/" className="font-semibold tracking-tighter uppercase text-lg text-white">RAIT Library</Link>
          
          {!isLandingPage && (
            <button onClick={() => setIsNavOpen(!isNavOpen)} className="z-[101]">
              <div className="relative h-6 w-8">
                <span className={`absolute top-0 left-0 h-0.5 w-full ${hamburgerColor} transition-all duration-300 ${isNavOpen ? 'rotate-45 translate-y-[10px]' : ''}`}></span>
                <span className={`absolute top-[10px] left-0 h-0.5 w-full ${hamburgerColor} transition-opacity duration-300 ${isNavOpen ? 'opacity-0' : ''}`}></span>
                <span className={`absolute bottom-0 left-0 h-0.5 w-full ${hamburgerColor} transition-all duration-300 ${isNavOpen ? '-rotate-45 -translate-y-[10px]' : ''}`}></span>
              </div>
            </button>
          )}
        </div>
      </header>
      
      {/* Dropdown Menu */}
      {!isLandingPage && (
        <div 
          ref={dropdownRef}
          className="fixed top-[88px] right-[32px] bg-white text-black p-6 rounded-md shadow-lg z-[99] hidden opacity-0"
        >
          <nav className="flex flex-col gap-4 text-right">
            {isAuthenticated ? (
              <>
                <Link href="/dashboard" onClick={handleLinkClick} className="font-semibold hover:text-gray-600">Dashboard</Link>
                <button onClick={handleLogout} className="font-semibold text-right hover:text-gray-600">Log Out</button>
              </>
            ) : (
              <>
                <Link href="/login" onClick={handleLinkClick} className="font-semibold hover:text-gray-600">Log In</Link>
                <Link href="/register" onClick={handleLinkClick} className="font-semibold hover:text-gray-600">Register</Link>
              </>
            )}
          </nav>
        </div>
      )}
    </>
  );
}