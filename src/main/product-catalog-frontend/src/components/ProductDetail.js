import React, { useState, useEffect, useRef } from 'react';
import { Link, useParams } from 'react-router-dom';
import { getProduct } from '../api/ProductService';
import { toastError, toastSuccess } from '../api/ToastService';

const ProductDetail = () => {
    const inputRef = useRef();
    const [product, setProduct] = useState({
        id: '',
        name: '',
        category: '',
        description: '',
        price: '',
        imageUrl: ''
    });

    const { id } = useParams();

    const fetchProduct = async (id) => {
        console.log("fetch product by id:" + id);
        try {
            const { data } = await getProduct(id);
            setProduct(data);
            console.log(data);
        } catch (error) {
            console.log(error);
            toastError(error.message);
        }
    };

    useEffect(() => {
        fetchProduct(id);
    }, []);

    return (
        <>
            <Link to={'/'} className='link'><i className='bi bi-arrow-left'></i> Back to list</Link>
            <div className='product'>
                <div className='product__details'>
                    <img src={product.imageUrl} alt={`Product photo of ${product.name}`} />
                    <div className='product__metadata'>
                        <p className='product__name'>Product name: {product.name}</p>
                        <p className='product__name'>Product category: {product.category.productCategory}</p>
                        <p className='product__name'>Description: {product.description}</p>
                        <p className='product__name'>Product price: {product.price}</p>
                    </div>
                </div>
            </div>
        </>
    )
}

export default ProductDetail;