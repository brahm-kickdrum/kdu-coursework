import { useContext } from "react";
import { FilterContext } from "../../../contexts/FilterProvider";

export function Filter() {

    const filter: React.CSSProperties = {
        display: "flex",
        alignItems: "center"
    }

    const {selectedCategory, setSelectedCategory} = useContext(FilterContext);

    const categories = ['men\'s clothing', 'jewelery', 'electronics', 'women\'s clothing'];

    const selectChangeHandler = (event: React.ChangeEvent<HTMLSelectElement>) => {

        setSelectedCategory(event.target.value);
        console.log(event.target.value);
    };

    return (
        <div style={filter}>
            <p>Filter: </p>
            <select value={selectedCategory} onChange={selectChangeHandler}>
            <option disabled selected value="">Select an option</option>
                {categories.map((category) => (
                    <option key={category}>{category}</option>
                ))}
            </select>
        </div>
    );
}