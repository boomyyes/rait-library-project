'use client';
import { createContext, useState } from 'react';

export const NavbarContext = createContext();

export const NavProvider = ({ children }) => {
  const [isNavOpen, setIsNavOpen] = useState(false);

  return (
    <NavbarContext.Provider value={{ isNavOpen, setIsNavOpen }}>
      {children}
    </NavbarContext.Provider>
  );
};