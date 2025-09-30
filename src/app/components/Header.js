'use client';
import Link from 'next/link';
import { useSelector } from 'react-redux';
import { usePathname } from 'next/navigation';

export default function Header() {
  const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);
  const pathname = usePathname();

  // Make header transparent on the landing page, and black on others.
  const headerClasses = pathname === '/' 
    ? 'bg-transparent text-white' 
    : 'bg-black text-white';

  return (
    <header className={`fixed top-0 left-0 w-full p-8 z-30 transition-colors duration-300 ${headerClasses}`}>
      <div className="flex justify-between items-center text-base">
        <Link
          href="/"
          className="font-semibold tracking-tighter uppercase text-lg"
        >
          RAIT Library
        </Link>
        <nav className="uppercase tracking-wider flex items-center gap-8">
          <Link href="/browse" className="hover:opacity-75 transition-opacity">
            Browse
          </Link>
          {isAuthenticated ? (
            <Link href="/dashboard">Dashboard</Link>
          ) : (
            <Link href="/login" className="hover:opacity-75 transition-opacity">
              Log In
            </Link>
          )}
        </nav>
      </div>
    </header>
  );
}