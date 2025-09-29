'use client';
import Link from 'next/link';
import { useSelector } from 'react-redux';

export default function Header() {
  const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);

  return (
    <header className="fixed top-0 left-0 w-full p-8 z-10">
      <div className="flex justify-between items-center text-lg">
        <Link href="/" className="font-semibold tracking-tighter">
          RAIT Library
        </Link>
        <nav>
          {isAuthenticated ? (
            <Link href="/dashboard">Dashboard</Link>
          ) : (
            <Link href="/login">Log In</Link>
          )}
        </nav>
      </div>
    </header>
  );
}