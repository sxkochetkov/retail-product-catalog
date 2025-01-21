import React from 'react'
import { Link } from 'react-router-dom'

const Header = ({ toggleModal, numberOfProducts }) => {
  return (
    <header className='header'>
      <div className='container'>
        <h3><Link to="/products">Product List ({numberOfProducts})</Link></h3>
        <button onClick={() => toggleModal(true)} className='btn'>
          <i className='bi bi-plus-square'></i> Add New Product
        </button>
        <Link to={`/search`} className="product__search">
          <i className='bi bi-plus-square'></i> Search Product
        </Link>
      </div>
    </header>
  )
}

export default Header