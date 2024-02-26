import { useRef, useState } from 'react';

const MutableValueComponent = () => {
  const mutableValue = useRef<number | null>(null);
  const [displayValue, setDisplayValue] = useState<number | null>(null);

  const handleClick = () => {
    mutableValue.current = Math.random();
    setDisplayValue(mutableValue.current);
  };

  return (
    <div>
      <h1>Mutate Values</h1>
      <button onClick={handleClick}>Update Value</button>
      {displayValue !== null && (
        <p>Mutable Value: {displayValue}</p>
      )}
    </div>
  );
};

export default MutableValueComponent;
