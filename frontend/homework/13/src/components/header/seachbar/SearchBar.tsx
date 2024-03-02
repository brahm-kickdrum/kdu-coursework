// import { useContext } from 'react';
// import { SearchContext } from '../../../contexts/SearchQueryProvider';

// export function SearchBar() {

//     const searchBar: React.CSSProperties = {
//         display: "flex",
//         height: "1.5rem"
//     }

//     const searchImage: React.CSSProperties = {
//         width: "1.5rem"
//     }

//     const searchInput: React.CSSProperties = {
//         width: "10rem",
//         height: "1.5rem"
//     }

//     const searchButton: React.CSSProperties = {
//         display: "flex",
//         height: "auto"
//     }

//     const { searchQuery, setSearchQuery } = useContext(SearchContext);

//     const handleSearchClick = () => {
//         setSearchQuery(searchQuery);
//         console.log(searchQuery);
//     };

//     console.log(searchQuery);

//     return (
//         <div style={searchBar} >
//             <input
//                 style={searchInput}
//                 type="text"
//                 value={searchQuery}
//                 placeholder="Search..."
//                 onChange={(event) => setSearchQuery(event.target.value)} 
//             />
//             <button
//                 style={searchButton} 
//                 onClick={handleSearchClick} 
//                 aria-label="Search"

//             >
//                 <img style={searchImage} src="search.png" alt="search" />  
//             </button>
//         </div>
//     );
// }


import React, { useContext, useRef, useEffect } from 'react';
import { SearchContext } from '../../../contexts/SearchQueryProvider';

export function SearchBar() {
    const searchBarStyle: React.CSSProperties = {
        display: "flex",
        height: "1.5rem"
    }

    const searchInputStyle: React.CSSProperties = {
        width: "10rem",
        height: "1.5rem"
    }

    const searchButtonStyle: React.CSSProperties = {
        display: "flex",
        height: "auto"
    }

    const searchImage: React.CSSProperties = {
        width: "1.5rem"
    }

    const { searchQuery, setSearchQuery } = useContext(SearchContext);
    const searchInputRef = useRef<HTMLInputElement>(null);

    useEffect(() => {
        const handleSearch = () => {
            setSearchQuery(searchInputRef.current?.value || '');
        };

        if (searchInputRef.current) {
            searchInputRef.current.addEventListener('input', handleSearch);

            return () => {
                searchInputRef.current?.removeEventListener('input', handleSearch);
            };
        }
    }, [searchQuerysetSearchQuery]);

    const handleSearchClick = () => {
        setSearchQuery(searchQuery);
        console.log(searchQuery);
    };

    return (
        <div style={searchBarStyle} >
            <input
                ref={searchInputRef}
                style={searchInputStyle}
                type="text"
                value={searchQuery}
                placeholder="Search..."
                onChange={(event) => setSearchQuery(event.target.value)} 
            />
            <button
                style={searchButtonStyle} 
                onClick={handleSearchClick} 
                aria-label="Search"
            >
                <img style={searchImage} src="search.png" alt="search" />  
            </button>
        </div>
    );
}
