import { createContext, useState } from "react";

export interface ISearchContext {
    searchQuery: string;
    setSearchQuery: React.Dispatch<React.SetStateAction<string>>;
}

export const SearchContext = createContext<ISearchContext>({
    searchQuery: "",
    setSearchQuery: () => {}
});



interface ISearchQueryProps {
    children: React.ReactNode;
}

export const SearchProvider = ({children}:ISearchQueryProps) => {

    const [searchQuery, setSearchQuery] = useState<string>("");

    return (
        <SearchContext.Provider value={{searchQuery, setSearchQuery }}>
            {children}
        </SearchContext.Provider>
    );
};