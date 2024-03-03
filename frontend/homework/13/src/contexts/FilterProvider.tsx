import { createContext, useState } from "react";


export interface IFilterContext {
    selectedCategory: string;
    setSelectedCategory: React.Dispatch<React.SetStateAction<string>>;
}

export const FilterContext = createContext<IFilterContext>({
    selectedCategory: '',
    setSelectedCategory: () => { }
});

interface IFilterProviderProps {
    children: React.ReactNode;
}

export const FilterProvider = ({ children }: IFilterProviderProps) => {
    const [selectedCategory, setSelectedCategory] = useState<string>('');

    return (
        <FilterContext.Provider value={{ selectedCategory, setSelectedCategory }}>
            {children}
        </FilterContext.Provider>
    );
};
