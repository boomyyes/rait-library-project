import { configureStore } from '@reduxjs/toolkit';
import authReducer from './authSlice';
import bookReducer from './bookSlice'; // Import the new reducer

export const store = configureStore({
  reducer: {
    auth: authReducer,
    books: bookReducer, // Add the book reducer
  },
});
