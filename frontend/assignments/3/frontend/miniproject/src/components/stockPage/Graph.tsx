import { useState, useEffect, useRef } from "react";
import { Bar } from "react-chartjs-2";
import { Chart, BarController, BarElement, LinearScale, Title, CategoryScale } from "chart.js";

Chart.register(BarController, BarElement, LinearScale, Title, CategoryScale);

function generateRandomValue() {
  return Math.floor(Math.random() * (5000 - 100 + 1)) + 100;
}

const Graph = () => {
  const [data, setData] = useState<number[]>([]);
  const chartRef = useRef<Chart<"bar", number[], string> | null>(null);

  useEffect(() => {
    const interval = setInterval(() => {
      const newValue = generateRandomValue();
      setData((prevData) => [...prevData, newValue]);
    }, 5000);

    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    if (chartRef.current) {
      chartRef.current.data.datasets[0].data = data;
      chartRef.current.update();
    }
  }, [data]);

  return (
    <div>
      <Bar
        ref={chartRef}
        data={{
          labels: data.map((_, index) => `Value ${index + 1}`),
          datasets: [
            {
              label: "Random Values",
              data: data,
              backgroundColor: "rgba(75, 192, 192, 0.2)",
              borderColor: "rgba(75, 192, 192, 1)",
              borderWidth: 1,
            },
          ],
        }}
      />
    </div>
  );
};

export default Graph;
