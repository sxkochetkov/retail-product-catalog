import React from 'react'
import { Link } from 'react-router-dom'

const Product = ({ product }) => {
    console.log("inside product: "+product.name);
    return (
        <Link to={`/products/${product.id}`} className="product__item">
                <div className="product__header">
                    <div className="product__image">
                        <img src={product.imageUrl} alt={product.name}  />
                    </div>
                    <div className="product__details">
                        <p className="product_name">{product.name.substring(0, 25)} </p>
                        <p className="product_title">{product.description}</p>
                    </div>
                </div>
                <div className="product__body">
                    <p><i className="bi bi-envelope"></i> {product.category.productCategory} </p>
                </div>
            </Link>
    )
}

export default Product