'use client';
import { useContext, useRef, useEffect } from 'react';
import { usePathname } from 'next/navigation';
import { NavbarContext } from '@/context/NavContext';
import SideNav from '@/components/SideNav';
import Stairs from '@/components/Stairs';
import Template from '@/components/Template';
import PageWrapper from '@/components/PageWrapper';
import gsap from 'gsap';

export default function AppContainer({ children }) {
  const { isNavOpen, setIsNavOpen } = useContext(NavbarContext);
  const pathname = usePathname();
  const mainContentRef = useRef(null);
  const sideNavRef = useRef(null);

  useEffect(() => {
    // This function forces the nav to close whenever you navigate to a new page.
    setIsNavOpen(false);
  }, [pathname, setIsNavOpen]);

  useEffect(() => {
    const navWidth = 250;
    // Reset animations if on the landing page
    if (pathname === '/') {
        gsap.to(mainContentRef.current, { x: 0, duration: 0 });
        gsap.to(sideNavRef.current, { x: navWidth, duration: 0 });
        return;
    }

    if (isNavOpen) {
      gsap.to(mainContentRef.current, { x: -navWidth, duration: 0.7, ease: 'power3.inOut' });
      gsap.to(sideNavRef.current, { x: 0, duration: 0.7, ease: 'power3.inOut' });
    } else {
      gsap.to(mainContentRef.current, { x: 0, duration: 0.7, ease: 'power3.inOut' });
      gsap.to(sideNavRef.current, { x: navWidth, duration: 0.7, ease: 'power3.inOut' });
    }
  }, [isNavOpen, pathname]);

  return (
    <div className="relative min-h-screen w-full overflow-x-hidden">
      <div ref={mainContentRef} className="relative min-h-screen bg-black w-full">
        <main>
          <Stairs>
            <Template>
              <PageWrapper>{children}</PageWrapper>
            </Template>
          </Stairs>
        </main>
      </div>
      
      {pathname !== '/' && <SideNav navRef={sideNavRef} />}
    </div>
  );
}