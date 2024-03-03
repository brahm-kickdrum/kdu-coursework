import { createContext, useState } from "react";


export interface ISearchBarContext {
    searchBar: string;
    setSearchBar: (searchQuery: string) => void;
}
// while using context, we need to return an object of items

export const SearchBarContext = createContext<ISearchBarContext>({
    searchBar: "",
    setSearchBar: () => { }
});

export interface ISearchBarProviderProps {
    children: React.ReactNode;
}

export const SearchBarProvider = ({ children }: ISearchBarProviderProps) => {
    const [searchBar, setSearchBar] = useState("");

    return (
        <SearchBarContext.Provider value={{ searchBar, setSearchBar }}>
            {children}
        </SearchBarContext.Provider>
    );
};
