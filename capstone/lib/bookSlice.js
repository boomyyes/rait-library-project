import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { getBooks } from '@/services/api';

export const fetchBooks = createAsyncThunk('books/fetchBooks', async ({ page, size }) => {
  console.log('1. Starting fetchBooks thunk...');
  const response = await getBooks(page, size);
  console.log('2. API response received:', response.data);
  return response.data;
});

const initialState = {
  items: [],
  status: 'idle',
  error: null,
};

const bookSlice = createSlice({
  name: 'books',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchBooks.pending, (state) => {
        console.log('3. Reducer: status is PENDING');
        state.status = 'loading';
      })
      .addCase(fetchBooks.fulfilled, (state, action) => {
        console.log('3. Reducer: status is FULFILLED');
        state.status = 'succeeded';
        state.items = action.payload;
      })
      .addCase(fetchBooks.rejected, (state, action) => {
        console.error('3. Reducer: status is REJECTED', action.error);
        state.status = 'failed';
        state.error = action.error.message;
      });
  },
});

export default bookSlice.reducer;
