import axios from 'axios';

const API_URLS = {
  auth: 'https://rait-library-project-1.onrender.com',
  books: 'https://library-service-m49l.onrender.com',
  payments: 'https://payment-service-4q8w.onrender.com',
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