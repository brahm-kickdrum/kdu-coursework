import { useContext } from 'react';
import { SearchContext } from '../../../contexts/SearchQueryProvider';

export function SearchBar() {
    const { searchQuery, setSearchQuery } = useContext(SearchContext);

    const handleSearchClick = () => {
        setSearchQuery(searchQuery);
        console.log(searchQuery);
    };

    console.log(searchQuery);

    return (
        <div>
            <input
                type="text"
                value={searchQuery}
                placeholder="Search..."
                onChange={(event) => setSearchQuery(event.target.value)} 
            />
            <button
                onClick={handleSearchClick} 
                aria-label="Search"
            >
                <img src="search.png" alt="search" />
            </button>
        </div>
    );
}
