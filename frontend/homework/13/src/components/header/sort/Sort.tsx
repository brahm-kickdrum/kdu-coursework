import React, { useContext } from "react";
import { SortContext } from "../../../contexts/SortProvider";

export function Sort() {
    const sort: React.CSSProperties = {
        display: "flex",
        alignItems: "center"
    }

    const { selectedSort, setSelectedSort } = useContext(SortContext);

    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedSort(event.target.value); 
        console.log(event.target.value);
    };

    return (
        <div style={sort}>
            <p>Sort: </p>
            <select value={selectedSort} onChange={handleChange}> 
                <option disabled value="">Select an option</option>
                <option>High to Low</option>
                <option>Low to High</option>
            </select>
        </div>
    );
}
