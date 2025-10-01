'use client';
import Link from 'next/link';
import { usePathname, useRouter } from 'next/navigation';
import { useSelector, useDispatch } from 'react-redux';
import { logout } from '@/lib/authSlice';

export default function Header() {
  const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);
  const dispatch = useDispatch();
  const router = useRouter();
  const pathname = usePathname();

  const handleLogout = () => {
    dispatch(logout());
    router.push('/login');
  };

  const isLandingPage = pathname === '/';
  const headerBg = isLandingPage ? 'bg-transparent' : 'bg-black/80 backdrop-blur-sm';

  return (
    <header className={`fixed top-0 left-0 w-full p-8 z-50 transition-colors duration-300 ${headerBg}`}>
      <div className="flex justify-between items-center text-base">
        <Link href="/" className="font-semibold tracking-tighter uppercase text-lg text-white">RAIT Library</Link>
        <nav className="flex items-center gap-8 uppercase tracking-wider text-white">
          {!isLandingPage && <Link href="/browse" className="hover:opacity-75">Browse</Link>}
          {isAuthenticated ? (
            <>
              <Link href="/dashboard" className="hover:opacity-75">Dashboard</Link>
              <button onClick={handleLogout} className="hover:opacity-75 uppercase">Log Out</button>
            </>
          ) : (
            <Link href="/login" className="hover:opacity-75">Log In</Link>
          )}
        </nav>
      </div>
    </header>
  );
}