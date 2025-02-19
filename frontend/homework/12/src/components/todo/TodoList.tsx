import { createContext, useState } from "react";
import { Header } from "./header/Header";
import { TodoSection } from "./todo-section/TodoSection";

export interface ISearchBarContext {
    searchBar: string,
    setSearchBar: (searchQuery: string) => void
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
        <SearchBarContext.Provider value={{searchBar, setSearchBar}}>
            {children}
        </SearchBarContext.Provider>
    );
}

export function Todo() {
    return (
        <SearchBarProvider>
            <div className="todo-list">
                <Header />
                <TodoSection />
            </div>
        </SearchBarProvider>
    );
}
