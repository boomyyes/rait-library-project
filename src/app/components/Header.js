'use client';
import Link from 'next/link';
import { useSelector } from 'react-redux';

export default function Header() {
  const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);

  return (
    <header className="fixed top-0 left-0 w-full p-8 z-10">
      <div className="flex justify-between items-center text-base">
        <Link
          href="/"
          className="font-semibold tracking-tighter uppercase text-lg"
        >
          RAIT Library
        </Link>
        <nav className="uppercase tracking-wider">
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