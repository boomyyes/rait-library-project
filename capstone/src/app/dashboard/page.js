'use client';
import { useEffect, useState, useCallback } from 'react';
import { useSelector } from 'react-redux';
import { useRouter } from 'next/navigation';
import { getUserRecords, returnBook, createPaymentOrder, markFineAsPaid } from '@/services/api';

export default function DashboardPage() {
  const { isAuthenticated, user } = useSelector((state) => state.auth);
  const router = useRouter();
  const [records, setRecords] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);
  const [returningId, setReturningId] = useState(null);

  const fetchRecords = useCallback(async () => {
    try {
      if (user?.userId) {
        const response = await getUserRecords(user.userId);
        setRecords(response.data);
      }
    } catch (err) {
      console.error('Failed to fetch records:', err);
      setError('Could not load your records.');
    } finally {
      setLoading(false);
    }
  }, [user]);

  useEffect(() => {
    if (!isAuthenticated) {
      router.push('/login');
    } else {
      fetchRecords();
    }
  }, [isAuthenticated, router, fetchRecords]);

  const handleReturn = async (recordId) => {
    setReturningId(recordId);
    setError(null);
    setSuccess(null);
    try {
      await returnBook(recordId, user.userId);
      setSuccess('Book returned successfully!');
      fetchRecords();
    } catch (err) {
      setError('Failed to return book.');
    } finally {
      setReturningId(null);
    }
  };
  
  const handlePayFine = async (record) => {
    if (!document.getElementById('razorpay-checkout-js')) {
        const script = document.createElement('script');
        script.id = 'razorpay-checkout-js';
        script.src = "https://checkout.razorpay.com/v1/checkout.js";
        document.body.appendChild(script);
        await new Promise(resolve => script.onload = resolve);
    }
    
    try {
        const { data: order } = await createPaymentOrder({
            amount: record.fine * 100,
            currency: 'INR',
            receipt: `receipt_fine_${record.id}`,
            notes: { bookId: record.book.id, userId: user.userId, recordId: record.id }
        });
        
        const options = {
            key: process.env.NEXT_PUBLIC_RAZORPAY_KEY_ID,
            amount: order.amount,
            currency: order.currency,
            name: "RAIT Library Fine",
            description: `Fine for: ${record.book.title}`,
            order_id: order.id,
            handler: async (response) => {
                try {
                  await markFineAsPaid(record.id, user.userId);
                  setSuccess(`Payment successful! The fine has been cleared.`);
                  setError(null);
                  fetchRecords();
                } catch (err) {
                   setError("Payment was successful, but there was an error updating our records.");
                }
            },
            prefill: { name: "Library User", email: user.email },
            theme: { color: "#000000" }
        };
        
        const rzp = new window.Razorpay(options);
        rzp.open();
    } catch (err) {
        setError("Could not initiate payment.");
    }
  };

  if (loading) return <p className="text-center mt-20">Loading dashboard...</p>;
  
  const borrowedBooks = records.filter(r => r.status === 'BORROWED');
  const lateBooks = records.filter(r => r.status === 'RETURNED_LATE' && r.fine > 0);

  return (
    <div>
      <h1 className="text-5xl font-bold mb-12 tracking-tighter">My Dashboard</h1>
      {error && <p className="bg-red-900 border border-red-600 text-white p-4 mb-8 rounded-md">{error}</p>}
      {success && <p className="bg-green-900 border border-green-600 text-white p-4 mb-8 rounded-md">{success}</p>}
      {lateBooks.length > 0 && (
          <div className="mb-12">
              <h2 className="text-2xl font-semibold mb-6 text-red-400">Overdue Fines</h2>
              <div className="space-y-4">
                  {lateBooks.map((record) => (
                      <div key={record.id} className="flex flex-col md:flex-row justify-between items-start md:items-center p-4 border border-red-800 bg-red-900/20 rounded-lg">
                          <div>
                              <p className="font-semibold text-lg">Book: {record.book?.title || `ID ${record.book.id}`}</p>
                              <p className="text-gray-400">Returned on: {new Date(record.returnDate).toLocaleDateString()}</p>
                              <p className="text-red-300 font-bold mt-1">Fine: ₹{record.fine.toFixed(2)}</p>
                          </div>
                          <button onClick={() => handlePayFine(record)} className="mt-4 md:mt-0 px-6 py-2 bg-lime-300 text-black font-semibold rounded-md hover:bg-lime-400">Pay Fine</button>
                      </div>
                  ))}
              </div>
          </div>
      )}
      <div>
        <h2 className="text-2xl font-semibold mb-6">Currently Borrowed Books</h2>
        {borrowedBooks.length > 0 ? (
          <div className="space-y-4">
            {borrowedBooks.map((record) => (
              <div key={record.id} className="flex flex-col md:flex-row justify-between items-start md:items-center p-4 border border-gray-800 rounded-lg">
                <div>
                  <p className="font-semibold text-lg">Book: {record.book?.title || `ID ${record.book.id}`}</p>
                  <p className="text-gray-400">Due Date: {new Date(record.dueDate).toLocaleDateString()}</p>
                </div>
                <button onClick={() => handleReturn(record.id)} disabled={returningId === record.id} className="mt-4 md:mt-0 px-6 py-2 bg-white text-black font-semibold rounded-md hover:bg-gray-300 disabled:bg-gray-500">
                  {returningId === record.id ? 'Returning...' : 'Return Book'}
                </button>
              </div>
            ))}
          </div>
        ) : (
          <p className="text-gray-400">You have no books currently borrowed.</p>
        )}
      </div>
    </div>
  );
}