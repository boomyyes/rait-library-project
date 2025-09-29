import axios from 'axios';

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

export const borrowBook = (bookId, userId) => {
  // For authenticated requests, we need to pass the userId in the headers
  const config = {
    headers: {
      'X-User-Id': userId,
    },
  };
  return axios.post(`${API_URLS.books}/books/${bookId}/borrow`, null, config);
};

export const returnBook = (recordId, userId) => {
  const config = {
    headers: {
      'X-User-Id': userId,
    },
  };
  return axios.post(`${API_URLS.books}/records/${recordId}/return`, null, config);
};

export const getUserRecords = (userId) => {
  const config = {
    headers: {
      'X-User-Id': userId,
    },
  };
  return axios.get(`${API_URLS.books}/users/me/records`, config);
};

// --- Payment Service Calls ---

export const createPaymentOrder = (fineData) => {
  return axios.post(`${API_URLS.payments}/create-order`, fineData);
};
