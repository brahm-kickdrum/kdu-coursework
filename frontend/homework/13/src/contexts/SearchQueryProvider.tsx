// // import { createContext, useState } from "react";

// // export interface ISearchContext {
// //     searchQuery: string;
// //     setSearchQuery: React.Dispatch<React.SetStateAction<string>>;
// // }

// // export const SearchContext = createContext<ISearchContext>({
// //     searchQuery: "",
// //     setSearchQuery: () => {}
// // });



// // interface ISearchQueryProps {
// //     children: React.ReactNode;
// // }

// // export const SearchProvider = ({children}:ISearchQueryProps) => {

// //     const [searchQuery, setSearchQuery] = useState<string>("");

// //     return (
// //         <SearchContext.Provider value={{searchQuery, setSearchQuery}}>
// //             {children}
// //         </SearchContext.Provider>
// //     );
// // };

// import React, { createContext, useRef } from "react";

// export interface ISearchContext {
//     setSearchQuery: (newValue: string) => void;
//     searchInputRef: React.RefObject<HTMLInputElement>;
// }

// export const SearchContext = createContext<ISearchContext>({
//     setSearchQuery: () => {},
//     searchInputRef: null
// });

// interface ISearchQueryProps {
//     children: React.ReactNode;
// }

// export const SearchProvider = ({ children }: ISearchQueryProps) => {
//     const searchInputRef = useRef<HTMLInputElement>(null);

//     const setSearchQuery = (newValue: string) => {
//         if (searchInputRef.current) {
//             searchInputRef.current.value = newValue;
//         }
//     };

//     return (
//         <SearchContext.Provider value={{ setSearchQuery, searchInputRef }}>
//             {children}
//         </SearchContext.Provider>
//     );
// };


import React, { createContext, useRef } from "react";

export interface ISearchContext {
    setSearchQuery: (newValue: string) => void;
    searchInputRef: React.RefObject<HTMLInputElement>;
}

export const SearchContext = createContext<ISearchContext>({
    setSearchQuery: () => {},
    searchInputRef: { current: null }
});

interface ISearchQueryProps {
    children: React.ReactNode;
}

export const SearchProvider = ({ children }: ISearchQueryProps) => {
    const searchInputRef = useRef<HTMLInputElement>(null);

    const setSearchQuery = (newValue: string) => {
        if (searchInputRef.current) {
            searchInputRef.current.value = newValue;
        }
    };

    return (
        <SearchContext.Provider value={{ setSearchQuery, searchInputRef }}>
            {children}
        </SearchContext.Provider>
    );
};
