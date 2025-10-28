import axios from 'axios';

// Base URLs from Render
const AUTH_SERVICE_BASE_URL = 'https://rait-library-project-1.onrender.com';
const BOOK_SERVICE_BASE_URL = 'https://library-service-m49l.onrender.com';
const PAYMENT_SERVICE_BASE_URL = 'https://payment-service-4q8w.onrender.com';

// Construct the full API endpoint URLs
const API_URLS = {
  auth: `${AUTH_SERVICE_BASE_URL}/api/auth`,     // Added /api/auth path
  books: `${BOOK_SERVICE_BASE_URL}/api`,        // Added /api path
  payments: `${PAYMENT_SERVICE_BASE_URL}/api/payments`, // Added /api/payments path
};

// --- Auth Service Calls ---
export const loginUser = (credentials) => axios.post(`${API_URLS.auth}/login`, credentials);
export const registerUser = (userData) => axios.post(`${API_URLS.auth}/register`, userData);

// --- Book Service Calls ---
export const getBooks = (page = 0, size = 10) => axios.get(`${API_URLS.books}/books?page=${page}&size=${size}`);
export const getBookById = (id) => axios.get(`${API_URLS.books}/books/${id}`);

const getAuthHeaders = (userId) => ({ headers: { 'X-User-Id': userId } });

export const borrowBook = (bookId, userId) => axios.post(`${API_URLS.books}/books/${bookId}/borrow`, null, getAuthHeaders(userId));
export const returnBook = (recordId, userId) => axios.post(`${API_URLS.books}/records/${recordId}/return`, null, getAuthHeaders(userId));
export const getUserRecords = (userId) => axios.get(`${API_URLS.books}/users/me/records`, getAuthHeaders(userId));
export const markFineAsPaid = (recordId, userId) => axios.post(`${API_URLS.books}/records/${recordId}/mark-paid`, null, getAuthHeaders(userId));

// --- Payment Service Calls ---
export const createPaymentOrder = (fineData) => axios.post(`${API_URLS.payments}/create-order`, fineData);

