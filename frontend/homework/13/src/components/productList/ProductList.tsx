import { useContext } from "react";
import { ProductListContext } from "../../contexts/ProductListProvider";
import { Link } from "react-router-dom";

export function ProductList() {
    const { productList } = useContext(ProductListContext);

    console.log(productList);
    return (
        <div>
            <h2>Product List</h2>
            <ul>
                
                {productList.map(product => (
                    <Link key={product.id} to={`/${product.id}`}>
                        <div >{product.title}</div>
                    </Link>
                    
                ))}
            </ul>
        </div>
    );
}

