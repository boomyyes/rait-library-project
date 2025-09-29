'use client';
import { useState, useEffect, useRef } from 'react';
import { useDispatch } from 'react-redux';
import { setCredentials } from '../../lib/authSlice'; // Updated import
import { loginUser } from '../../services/api';
import { useRouter } from 'next/navigation';
import { jwtDecode } from 'jwt-decode'; // New import
import gsap from 'gsap';

export default function LoginPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const dispatch = useDispatch();
  const router = useRouter();
  const formRef = useRef(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    try {
      const response = await loginUser({ email, password });
      const token = response.data.token;
      const user = jwtDecode(token); // Decode the token
      dispatch(setCredentials({ token, user })); // Dispatch credentials
      router.push('/');
    } catch (err) {
      setError('Invalid credentials. Please try again.');
      console.error('Login failed:', err);
    }
  };
  
    useEffect(() => {
    // Animate the form elements fading in and sliding up
    gsap.from(formRef.current.children, {
        duration: 0.8,
        opacity: 0,
        y: 50,
        stagger: 0.2,
        ease: 'power3.out',
    });
    }, []);

  return (
    <div className="flex items-center justify-center min-h-screen">
      <div className="w-full max-w-md p-8">
        <h1 className="text-4xl font-semibold mb-8 text-center tracking-tighter">Log In</h1>
        <form ref={formRef} onSubmit={handleSubmit}>
          <div className="mb-6">
            <input
              type="email"
              placeholder="Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="w-full p-4 bg-black border border-gray-700 focus:outline-none focus:border-white"
              required
            />
          </div>
          <div className="mb-8">
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="w-full p-4 bg-black border border-gray-700 focus:outline-none focus:border-white"
              required
            />
          </div>
          {error && <p className="text-red-500 text-center mb-6">{error}</p>}
          <button
            type="submit"
            className="w-full p-4 bg-white text-black font-semibold tracking-wider uppercase hover:bg-gray-300 transition-colors"
          >
            Continue
          </button>
        </form>
      </div>
    </div>
  );
}
