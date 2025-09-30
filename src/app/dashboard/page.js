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

  useEffect(() => {
    if (!isAuthenticated) {
      router.push('/login');
    } else {
      const fetchRecords = async () => {
        try {
          const response = await getUserRecords(user.userId);
          setRecords(response.data);
        } catch (error) {
          console.error('Failed to fetch records:', error);
        } finally {
          setLoading(false);
        }
      };
      fetchRecords();
    }
  }, [isAuthenticated, router, user]);

  const handleReturn = async (recordId) => {
    try {
      await returnBook(recordId, user.userId);
      // Refresh the list by filtering out the returned book
      setRecords(records.filter((record) => record.id !== recordId));
    } catch (error) {
      console.error('Failed to return book:', error);
    }
  };

  if (loading) return <p>Loading dashboard...</p>;

  return (
    <div>
      <h1 className="text-5xl font-bold mb-12 tracking-tighter">My Dashboard</h1>
      <h2 className="text-2xl font-semibold mb-6">Currently Borrowed Books</h2>
      {records.length > 0 ? (
        <div className="space-y-4">
          {records.filter(r => r.status === 'BORROWED').map((record) => (
            <div key={record.id} className="flex justify-between items-center p-4 border border-gray-800">
              <div>
                <p className="font-semibold">Book ID: {record.bookId}</p>
                <p className="text-gray-400">Due Date: {record.dueDate}</p>
              </div>
              <button 
                onClick={() => handleReturn(record.id)}
                className="p-2 bg-white text-black font-semibold"
              >
                Return Book
              </button>
            </div>
          ))}
        </div>
      ) : (
        <p>You have no books currently borrowed.</p>
      )}
    </div>
  );
}
