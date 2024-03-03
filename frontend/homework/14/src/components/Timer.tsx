import React, { useState, useRef } from 'react';

const TimerComponent: React.FC = () => {
  const [seconds, setSeconds] = useState<number>(0);
  const intervalRef = useRef<number | null>(null);

  const startTimer = () => {
    intervalRef.current = window.setInterval(() => {
      setSeconds(prevSeconds => prevSeconds + 1);
    }, 1000);
  };

  const stopTimer = () => {
    if (intervalRef.current) {
      window.clearInterval(intervalRef.current);
      console.log(intervalRef.current)
    }
  };

  const resetTimer = () => {
    if (intervalRef.current) {
      window.clearInterval(intervalRef.current);
    }
    setSeconds(0);
  };

  return (
    <div>
      <h1>Timer: {seconds} seconds</h1>
      <button onClick={startTimer}>Start</button>
      <button onClick={stopTimer}>Stop</button>
      <button onClick={resetTimer}>Reset</button>
    </div>
  );
};

export default TimerComponent;
