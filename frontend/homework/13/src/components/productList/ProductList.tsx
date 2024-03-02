import { useContext, useEffect, useState } from "react";
import { IProduct, ProductListContext } from "../../contexts/ProductListProvider";
import { FilterContext } from "../../contexts/FilterProvider";
import { Link } from "react-router-dom";
import { SortContext } from "../../contexts/SortProvider";

export function ProductList() {
    const { productList } = useContext(ProductListContext);
    const { selectedCategory } = useContext(FilterContext);
    const { selectedSort } = useContext(SortContext);
    const [filteredAndSortedProductList, setFilteredAndSortedProductList] = useState<IProduct[]>([]);
    const url = new URLSearchParams(window.location.search);
    const filter = url.get('filter');
  
    useEffect(() => {
        let filteredList;
        if (filter) {
            filteredList = filter
                ? productList.filter(product => product.category === filter)
                : productList;
        }
        else {
            filteredList = selectedCategory
                ? productList.filter(product => product.category === selectedCategory)
                : productList;
        }
        if (selectedSort === 'High to Low') {
            console.log(selectedSort);
            filteredList?.sort((a, b) => b.price - a.price);
        } else if (selectedSort === 'Low to High') {
            filteredList?.sort((a, b) => a.price - b.price);
        }

        setFilteredAndSortedProductList(filteredList);

    }, [selectedCategory, productList, selectedSort]);

    return (
        <div>
            <h2>Product List</h2>
            <ul>
                {filteredAndSortedProductList.map(product => (
                    <Link key={product.id} to={`/${product.id}`}>
                        <div >
                            {product.title}
                            <div>
                                <img src={product.image} alt="" />
                            </div>
                            <div>
                                <div>x
                                    {product.title}
                                </div>
                                <div>
                                    ${product.price}
                                </div>

                            </div>
                        </div>
                    </Link>
                ))}
            </ul>
        </div>
    );
}