import { createContext, useState } from "react";

export interface IRating {
    rate: number;
    count: number;
}

export interface IProduct {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: IRating;
}

export interface IProductListContext {
    productList: IProduct[];
    setProductList: React.Dispatch<React.SetStateAction<IProduct[]>>;
}

export const ProductListContext = createContext<IProductListContext>({
    productList: [],
    setProductList: () => { }
});
interface IProductListProviderProps {
    children: React.ReactNode;
}

export const ProductListProvider = ({ children }: IProductListProviderProps) => {
    const [productList, setProductList] = useState<IProduct[]>([]);

    return (
        <ProductListContext.Provider value={{ productList, setProductList }}>
            {children}
        </ProductListContext.Provider>
    );
};
