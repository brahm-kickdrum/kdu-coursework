import React, { useRef } from 'react';

const ScrollToTopComponent: React.FC = () => {
  const topRef = useRef<HTMLDivElement>(null);

  const scrollToTop = () => {
    window.scrollTo({ behavior: 'smooth', top: 0 });
  };

  const scrollBar: React.CSSProperties = {
    display: "flex",
    flexDirection: "column",
    width: "12rem",
    height: "200vh",
    justifyContent: "space-between"
  };

  const scrollToTopButton: React.CSSProperties = {
    alignSelf: "auto"
  }


  return (
    <div style={scrollBar}>
      <h1>Scroll To Top</h1>
      <button onClick={scrollToTop} style={scrollToTopButton}>Scroll To Top</button>
      <div ref={topRef}></div>
    </div>
  );
};

export default ScrollToTopComponent;
