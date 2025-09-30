import axios from 'axios';

// --- Helper to get the auth token ---
// PLACEHOLDER!!!!!!!!!!!! in a real app, you'd get this from your Redux store or local storage
const getAuthHeaders = (userId) => {
    return {
        headers: {
            'X-User-Id': userId,
            // If  using JWT tokens directly with this service, add:
            // 'Authorization': `Bearer ${token}`
        },
    };
};


const API_URLS = {
  auth: 'http://localhost:3001/api/auth',
  books: 'http://localhost:8080/api',
  payments: 'http://localhost:3002/api/payments',
};

// --- Auth Service Calls ---

export const loginUser = (credentials) => {
  return axios.post(`${API_URLS.auth}/login`, credentials);
};

export const registerUser = (userData) => {
  return axios.post(`${API_URLS.auth}/register`, userData);
};

// --- Book Service Calls ---

export const getBooks = () => {
  return axios.get(`${API_URLS.books}/books`);
};

export const getBookById = (bookId) => {
    return axios.get(`${API_URLS.books}/books/${bookId}`);
};

export const borrowBook = (bookId, userId) => {
  return axios.post(`${API_URLS.books}/books/${bookId}/borrow`, null, getAuthHeaders(userId));
};

export const returnBook = (recordId, userId) => {
  return axios.post(`${API_URLS.books}/records/${recordId}/return`, null, getAuthHeaders(userId));
};

export const getUserRecords = (userId) => {
  return axios.get(`${API_URLS.books}/users/me/records`, getAuthHeaders(userId));
};

export const markFineAsPaid = (recordId, userId) => {
    return axios.post(`${API_URLS.books}/records/${recordId}/mark-paid`, null, getAuthHeaders(userId));
}

// --- Payment Service Calls ---

export const createPaymentOrder = (fineData) => {
  return axios.post(`${API_URLS.payments}/create-order`, fineData);
};
