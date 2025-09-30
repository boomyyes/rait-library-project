'use client';
import { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { useRouter } from 'next/navigation';
import { getUserRecords, returnBook } from '@/services/api';

export default function DashboardPage() {
  const { isAuthenticated, user } = useSelector((state) => state.auth);
  const router = useRouter();
  const [records, setRecords] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState('');
  const [returningBookId, setReturningBookId] = useState(null);

  useEffect(() => {
    if (!isAuthenticated) {
      router.push('/login');
    } else if (user?.userId) {
      const fetchRecords = async () => {
        try {
          setLoading(true);
          const response = await getUserRecords(user.userId);
          setRecords(response.data);
          setError(null);
        } catch (error) {
          console.error('Failed to fetch records:', error);
          setError('Could not fetch your borrowed books. Please try again later.');
        } finally {
          setLoading(false);
        }
      };
      fetchRecords();
    }
  }, [isAuthenticated, router, user]);

  const handleReturn = async (recordId, bookTitle) => {
    if (!user || !user.userId) {
      setError("You must be logged in to return a book.");
      return;
    }
    setReturningBookId(recordId);
    setError(null);
    setSuccess('');

    try {
      await returnBook(recordId, user.userId);
      setRecords(records.filter((record) => record.id !== recordId));
      setSuccess(`Successfully returned "${bookTitle}"!`);
    } catch (error) {
      console.error('Failed to return book:', error);
      setError('Failed to return the book. Please try again.');
    } finally {
      setReturningBookId(null);
    }
  };
  
  const borrowedRecords = records.filter(r => r.status === 'BORROWED');

  if (loading) return <div className="text-center mt-20">Loading dashboard...</div>;

  return (
    <div>
      <h1 className="text-5xl font-bold mb-12 tracking-tighter">My Dashboard</h1>

      {error && <div className="bg-red-900 border border-red-700 text-white px-4 py-3 rounded-lg relative mb-6" role="alert">{error}</div>}
      {success && <div className="bg-green-900 border border-green-700 text-white px-4 py-3 rounded-lg relative mb-6" role="alert">{success}</div>}

      <h2 className="text-2xl font-semibold mb-6">Currently Borrowed Books</h2>
      
      {borrowedRecords.length > 0 ? (
        <div className="space-y-4">
          {borrowedRecords.map((record) => (
            <div key={record.id} className="flex flex-col sm:flex-row justify-between items-start sm:items-center p-4 border border-gray-800 rounded-lg bg-gray-900/50">
              <div>
                <p className="font-semibold text-lg">{record.book.title}</p>
                <p className="text-gray-400 text-sm">Borrowed On: {new Date(record.borrowDate).toLocaleDateString()}</p>
                <p className="text-red-400 text-sm">Due Date: {new Date(record.dueDate).toLocaleDateString()}</p>
              </div>
              <button 
                onClick={() => handleReturn(record.id, record.book.title)}
                disabled={returningBookId === record.id}
                className="w-full sm:w-auto mt-4 sm:mt-0 p-3 bg-white text-black font-semibold tracking-wider uppercase hover:bg-gray-300 transition-colors rounded-md disabled:bg-gray-500 disabled:cursor-not-allowed"
              >
                {returningBookId === record.id ? 'Returning...' : 'Return Book'}
              </button>
            </div>
          ))}
        </div>
      ) : (
        <p className="text-gray-400">You have no books currently borrowed.</p>
      )}
    </div>
  );
}