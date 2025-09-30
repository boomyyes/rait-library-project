'use client';
import { useState, useEffect, useRef } from 'react';
import { registerUser } from '@/services/api';
import { useRouter } from 'next/navigation';
import Link from 'next/link';
import gsap from 'gsap';

export default function RegisterPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(false);
  const router = useRouter();
  const containerRef = useRef(null);

  useEffect(() => {
    const elements = gsap.utils.toArray(containerRef.current.children);
    gsap.set(elements, { opacity: 0, y: 30 });
    gsap.to(elements, {
      duration: 1,
      opacity: 1,
      y: 0,
      stagger: 0.2,
      ease: 'power3.out',
    });
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    setSuccess(false);
    try {
      await registerUser({ email, password });
      setSuccess(true);
      // Redirect to login page after a short delay
      setTimeout(() => {
        router.push('/login');
      }, 2000);
    } catch (err) {
      setError('Registration failed. This email may already be in use.');
      console.error('Registration failed:', err);
    }
  };

  return (
    <main className="flex items-center justify-center min-h-screen">
      <div ref={containerRef} className="w-full max-w-lg p-8 text-center">
        <h1 className="text-5xl font-bold mb-12 tracking-tighter">
          Create an Account
        </h1>
        <form onSubmit={handleSubmit} className="text-left">
          <div className="mb-8 relative">
            <label htmlFor="email" className="absolute -top-3 left-4 bg-black px-1 text-gray-400 text-sm">Email</label>
            <input
              id="email"
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="w-full p-4 bg-black border border-gray-700 focus:outline-none focus:border-white"
              required
            />
          </div>
          <div className="mb-8 relative">
            <label htmlFor="password" className="absolute -top-3 left-4 bg-black px-1 text-gray-400 text-sm">Password</label>
            <input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="w-full p-4 bg-black border border-gray-700 focus:outline-none focus:border-white"
              required
            />
          </div>
          {error && <p className="text-red-500 text-center mb-6">{error}</p>}
          {success && <p className="text-green-500 text-center mb-6">Success! Redirecting to login...</p>}
          <button
            type="submit"
            className="w-full p-4 bg-white text-black font-semibold tracking-wider uppercase hover:bg-gray-300 transition-colors"
            disabled={success}
          >
            Register
          </button>
        </form>
        <p className="text-center mt-8 text-gray-400">
          Already have an account?{' '}
          <Link href="/login" className="text-white underline hover:opacity-75">
            Log In
          </Link>
        </p>
      </div>
    </main>
  );
}