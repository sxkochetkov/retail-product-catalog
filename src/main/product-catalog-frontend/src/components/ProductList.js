import React from 'react';
import Product from "./Product";

const ProductList = ({ data, currentPage, getAllProducts, prepopulate }) => {
    return (
        <main className='main'>
            {data?.items?.length === 0 && <div>No Products. Please add a new product or prepopulate catalog by clicking <button onClick={() => prepopulate()} type='button' className="btn btn-danger">Here</button> and refresh the page</div>}

            <ul className='product__list'>
                {data?.items?.length > 0 && data.items.map(product => <Product product={product} key={product.id} />)}
            </ul>

            {data?.items?.length > 0 &&
                <div className='pagination'>
                    <a onClick={() => getAllProducts(currentPage - 1)} className={0 === currentPage ? 'disabled' : ''}>&laquo;</a>

                    {data.items && [...Array(data.totalPages).keys()].map((page, index) =>
                        <a onClick={() => getAllProducts(page)} className={currentPage === page ? 'active' : ''} key={page}>{page + 1}</a>)}

                    <a onClick={() => getAllProducts(currentPage + 1)} className={data.totalPages - 1 === currentPage ? 'disabled' : ''}>&raquo;</a>
                </div>
            }
        </main>
    )
}

export default ProductList