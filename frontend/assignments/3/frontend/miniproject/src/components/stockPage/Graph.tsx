
import { useState, useEffect, useRef } from "react";
import { Bar } from "react-chartjs-2";
import { Chart, BarController, BarElement, LinearScale, Title, CategoryScale } from "chart.js";

Chart.register(BarController, BarElement, LinearScale, Title, CategoryScale);

function generateRandomValue() {
    return Math.floor(Math.random() * (5000 - 100 + 1)) + 100;
}

interface ChartComponentProps {
    setCurrentValue: React.Dispatch<React.SetStateAction<number>>;
    setPercentageChange: React.Dispatch<React.SetStateAction<number>>;
}

const Graph: React.FC<ChartComponentProps> = ({setCurrentValue, setPercentageChange }) => {
    const [data, setData] = useState<number[]>([]);
    const [labels, setLabels] = useState<string[]>(Array.from({ length: 50 }, (_, i) => `${i * 5}`));
    const [color, setColor] = useState<string[]>([]);
    const chartRef = useRef<Chart<"bar", number[], string> | null>(null);
    const counterRef = useRef<number>(51);

    useEffect(() => {
        const interval = setInterval(() => {
            const newValue = generateRandomValue();
            if (data.length < 50) {
                const prevValue = data[data.length - 1];
                setData((prevData) => [...prevData, newValue]);
                const diff = prevValue ? ((newValue - prevValue) / prevValue) * 100 : 0;
                setColor((prevColor) => [...prevColor, prevValue && newValue >= prevValue ? '#b2f2bb' :'#ffc9c9'  ]);
                setCurrentValue(newValue);
                setPercentageChange(parseFloat(diff.toFixed(2)));
            } else {
                const newLabel = `${counterRef.current}`;
                counterRef.current++;
                setLabels((prevLabels) => [...prevLabels.slice(1), newLabel]);
                const prevValue = data[data.length - 1];
                const newValue = generateRandomValue();
                const diff = prevValue ? ((newValue - prevValue) / prevValue) * 100 : 0;
                setData((prevData) => [...prevData.slice(1), newValue]);
                setColor((prevColor) => [...prevColor.slice(1), prevValue && newValue >= prevValue ?  '#b2f2bb': '#ffc9c9' ]);
                setCurrentValue(newValue); 
                setPercentageChange(parseFloat(diff.toFixed(2)));
            }
        }, 5000);

        return () => clearInterval(interval);
    }, [data]);

    useEffect(() => {
        if (chartRef.current) {
            chartRef.current.data.labels = labels;
            chartRef.current.data.datasets[0].data = data;
            chartRef.current.data.datasets[0].backgroundColor = color;
            chartRef.current.update();
        }
    }, [data, labels, color]);

    const chartConfig = {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [
                {
                    label: "Random Values",
                    data: data,
                    backgroundColor: color,
                    borderWidth: 1,
                    barThickness: 25,
                },
            ],
        },
        indexAxis: "x",
        barThickness: 'flex',
        categoryPercentage: 0.5,
        barPercentage: 0.2,
    };

    return (
        <div>
            <Bar
                ref={chartRef}
                data={chartConfig.data}
            />
        </div>
    );
};

export default Graph;
