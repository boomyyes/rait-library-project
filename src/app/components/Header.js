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
    router.push('/login'); // Redirect to login page after logout
  };

  // Determine header background color and if we are on the landing page
  const isLandingPage = pathname === '/';
  const headerBg = isLandingPage ? 'bg-transparent' : 'bg-black/80 backdrop-blur-sm';

  return (
    <header className={`fixed top-0 left-0 w-full p-8 z-50 transition-colors duration-300 ${headerBg}`}>
      <div className="flex justify-between items-center text-base">
        <Link
          href="/"
          className="font-semibold tracking-tighter uppercase text-lg text-white"
        >
          RAIT Library
        </Link>
        <nav className="flex items-center gap-8 uppercase tracking-wider text-white">
          {/* Conditionally render the Browse link */}
          {!isLandingPage && (
            <Link href="/browse" className="hover:opacity-75 transition-opacity">
              Browse
            </Link>
          )}
          
          {isAuthenticated ? (
            <>
              <Link href="/dashboard" className="hover:opacity-75 transition-opacity">
                Dashboard
              </Link>
              <button onClick={handleLogout} className="hover:opacity-75 transition-opacity uppercase">
                Log Out
              </button>
            </>
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

