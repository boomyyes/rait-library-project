import { Inter } from 'next/font/google';
import './globals.css';
import { StoreProvider } from '@/lib/StoreProvider';
import Header from '@/components/Header';
import Stairs from '@/components/Stairs';
import Template from '@/components/Template';
import PageWrapper from '@/components/PageWrapper';

const inter = Inter({ subsets: ['latin'] });

export const metadata = {
  title: 'RAIT Library',
  description: 'A modern online library application',
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <StoreProvider>
          <Header />
          <main>
            <Stairs>
              <Template>
                <PageWrapper>{children}</PageWrapper>
              </Template>
            </Stairs>
          </main>
        </StoreProvider>
      </body>
    </html>
  );
}