import './globals.css';
import { StoreProvider } from '../../lib/StoreProvider';
import Header from './components/Header'; // Import the header

export const metadata = {
  title: 'RAIT Library',
  description: 'A modern online library application designed for students, by students',
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <StoreProvider>
          <Header /> {/* Add the header here */}
          <main className="pt-24 px-8">{children}</main> {/* Add padding for the fixed header */}
        </StoreProvider>
      </body>
    </html>
  );
}
