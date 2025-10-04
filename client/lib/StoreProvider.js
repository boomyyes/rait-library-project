// lib/StoreProvider.js
'use client'; // This is a client component
import { Provider } from 'react-redux';
import { store } from './store';

export function StoreProvider({ children }) {
  return <Provider store={store}>{children}</Provider>;
}
