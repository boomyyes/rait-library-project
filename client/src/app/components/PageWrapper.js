'use client';

import { usePathname } from 'next/navigation';

export default function PageWrapper({ children }) {
  const pathname = usePathname();
  const isLandingPage = pathname === '/';

  if (isLandingPage) {
    return <>{children}</>;
  }

  return (
    <div className="pt-24 px-8">
      {children}
    </div>
  );
}