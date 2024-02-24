export function Filter() {
    const categories = ['men\'s clothing', 'jewelry', 'electronics', 'women\'s clothing'];

    return (
        <div>
            <p>Filter: </p>
            <select>
                {categories.map((category, index) => (
                    <option key={index}>{category}</option>
                ))}
            </select>
        </div>
    );
}
