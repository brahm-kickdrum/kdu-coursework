import { useContext, useEffect } from "react";
import { Header } from "./header/Header";
import { ProductListContext} from "../contexts/ProductListProvider";
import { ProductList } from "./productList/ProductList";


export function Homepage() {

    const {setProductList } = useContext(ProductListContext);

    useEffect(() => {
        fetch("https://fakestoreapi.com/products")
            .then(response => response.json())
            .then(data => {
                setProductList(data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);

    return (
        <div>
            <Header />
            <ProductList />
        </div>
    );
}
