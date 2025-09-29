import './globals.css';
import { StoreProvider } from '../../lib/StoreProvider'; // Corrected Path

export const metadata = {
  title: 'RAIT Library',
  description: 'A modern online library application',
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <StoreProvider>{children}</StoreProvider>
      </body>
    </html>
  );
}
