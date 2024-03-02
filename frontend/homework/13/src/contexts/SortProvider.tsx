import { createContext, useState } from "react";


export interface ISortContext {
    selectedSort: string;
    setSelectedSort: React.Dispatch<React.SetStateAction<string>>;
}

export const SortContext = createContext<ISortContext>({
    selectedSort: '',
    setSelectedSort: () => { }
});

interface ISortProviderProps {
    children: React.ReactNode;
}

export const SortProvider = ({ children }: ISortProviderProps) => {
    const [selectedSort, setSelectedSort] = useState<string>('');

    return (
        <SortContext.Provider value={{ selectedSort, setSelectedSort }}>
            {children}
        </SortContext.Provider>
    );
};
