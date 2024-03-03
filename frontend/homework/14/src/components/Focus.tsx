import React, { useRef, useEffect } from 'react';

const FormComponent: React.FC = () => {
  const firstInputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    firstInputRef.current?.focus();
  }, []);

  const style: React.CSSProperties = {
    display: "flex",
    flexDirection: "column",
    width: "12rem",
    margin: "1rem",
    height: "5rem",
    justifyContent: "space-between"
  };

  return (
    <div>
      <h1>Focus on Form Field</h1>
      <form style={style}>
        <input ref={firstInputRef} type="text" />
        <input type="text" />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default FormComponent;
