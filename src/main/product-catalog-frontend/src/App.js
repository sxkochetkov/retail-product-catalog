import { useEffect, useRef, useState } from 'react';
import 'react-toastify/dist/ReactToastify.css';
import { Routes, Route, Navigate } from 'react-router-dom';
import Header from './components/Header'
import ProductList from './components/ProductList'
import ProductDetail from './components/ProductDetail'
import SearchProducts from './components/SearchProducts'
import { getProducts, addProduct, prepopulate } from './api/ProductService';
import { toastError } from './api/ToastService';
import { ToastContainer } from 'react-toastify';

function App() {
  const modalRef = useRef();
  const [data, setData] = useState({});
  const [currentPage, setCurrentPage] = useState(0);
  const [values, setValues] = useState({
    name: '',
    category: '',
    description: '',
    price: '',
    imageUrl: ''
  });

  const getAllProducts = async (page = 0, size = 9) => {
    try {
      setCurrentPage(page);
      const { data } = await getProducts(page, size);
      setData(data);
      console.log("data retrieved: " + data);
    } catch (error) {
      console.log(error);
    }
  }

  const onChange = (event) => {
    setValues({ ...values, [event.target.name]: event.target.value });
  };

  const handleNewProduct = async (event) => {
    event.preventDefault();
    try {
      const { product } = await addProduct(values);
      toggleModal(false);
      setValues({
        name: '',
        category: '',
        description: '',
        price: '',
        imageUrl: ''
      })
      getAllProducts();
    } catch (error) {
      console.log(error);
      toastError(error.message);
    }
  };

  useEffect(() => {
    getAllProducts();
  }, []);

  const toggleModal = show => show ? modalRef.current.showModal() : modalRef.current.close();
  //console.log("data length  is : " + data?.length);

  return (
    <>
      <Header toggleModal={toggleModal} numberOfProducts={data.totalItems} />
      <main className='main'>
        <div className='container'>
          <Routes>
            <Route path="/" element={<ProductList data={data} currentPage={currentPage} getAllProducts={getAllProducts} prepopulate={prepopulate} />} />
            <Route path="/products/:id" element={<ProductDetail data={data} />} />
            <Route path="/search" element={<SearchProducts />} />
            <Route path="/products" element={<ProductList data={data} currentPage={currentPage} getAllProducts={getAllProducts} prepopulate={prepopulate} />} />

          </Routes>
        </div>
      </main>

      {/* Modal */}
      <dialog ref={modalRef} className="modal" id="modal">
        <div className="modal__header">
          <h3>New Product</h3>
          <i onClick={() => toggleModal(false)} className="bi bi-x-lg"></i>
        </div>
        <div className="divider"></div>
        <div className="modal__body">
          <form onSubmit={handleNewProduct}>
            <div className="product-details">
              <div className="input-box">
                <span className="details">Name</span>
                <input type="text" value={values.name} onChange={onChange} name='name' required />
              </div>
              <div className="input-box">
                <span className="details">Category</span>
                <input type="text" value={values.category} onChange={onChange} name='category' required />
              </div>
              <div className="input-box">
                <span className="details">Description</span>
                <input type="text" value={values.description} onChange={onChange} name='description' required />
              </div>
              <div className="input-box">
                <span className="details">Price</span>
                <input type="text" value={values.price} onChange={onChange} name='price' required />
              </div>
              <div className="input-box">
                <span className="details">Url</span>
                <input type="text" value={values.imageUrl} onChange={onChange} name='imageUrl' required />
              </div>
              <div className="form_footer">
                <button onClick={() => toggleModal(false)} type='button' className="btn btn-danger">Cancel</button>
                <button type='submit' className="btn">Save</button>
              </div>
            </div>
          </form>
        </div>
      </dialog>
      <ToastContainer />
    </>
  );
}

export default App;
