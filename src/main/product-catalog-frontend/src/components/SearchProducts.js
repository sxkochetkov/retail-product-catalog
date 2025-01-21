import React, { useState } from "react";
import { FaSearch } from "react-icons/fa";
import "./SearchBar.css";
import Product from "./Product"
import { searchProducts } from '../api/ProductService';

const SearchProducts = () => {
    const [input, setInput] = useState("");
    const [data, setData] = useState({});

    const fetchData = async (value) => {
        try {
            console.log("search term is: " + value);
            const { data } = await searchProducts(value);

            setData(data);
            console.log("data from search: " + data);
        } catch (error) {
            console.log(error);
        }
    }

    const handleSearchChange = (value) => {
        setInput(value);
        fetchData(value);
    }

    return (
        <div>
            <div className="input-wrapper">
                <FaSearch id="search-icon" />
                <input
                    placeholder="Type to do fuzzy search. For example: roedarv"
                    value={input}
                    onChange={(e) => handleSearchChange(e.target.value)}
                />
            </div>
            <div>
                <ul className='search-product-list'>
                    {data?.length > 0 && data.map(product => <Product product={product} key={product.id} />)}
                </ul>
            </div>
        </div>
    );
}

export default SearchProducts;