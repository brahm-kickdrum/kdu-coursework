import { useContext } from "react";
import { useParams } from "react-router-dom";
import { ProductListContext } from "../contexts/ProductListProvider";

export function Product() {

    const {id} = useParams();

    const {productList } = useContext(ProductListContext);

    if (!id) {
        return <div>No product ID specified</div>;
    }

    const product = productList.find(product => product.id === parseInt(id));

    if (!product) {
        return <div>Product not found</div>;
    }

    return ( 
        <div>
            <h2>{product.title}</h2>
            <div>
            <img src= {product.image} alt= "product"/>
            </div>
            
            <p>Price: ${product.price}</p>
            <p>Description: {product.description}</p>
            <p>Category: {product.category}</p>
            <p>Rating: {product.rating.rate}</p>
            <p>Rating: {product.rating.count}</p>
        </div>
    );
}
