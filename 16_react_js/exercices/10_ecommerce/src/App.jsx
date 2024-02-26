import { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-icons/font/bootstrap-icons.min.css'
import dataProducts from './datas/dataProducts'
import './App.css'
import ProductList from './components/ProductList'
import ProductContext from './context/ProductContext'
import Header from './components/Header'
import ModalCart from './components/Modal/ModalCart'


function App() {
  const [productList, _setProductList] = useState(dataProducts)
  const [cart, setCart] = useState([])
  const [showModal, setShowModal] = useState(false)

  const addToCart = (product) => {
    const productFinded = cart.find((e) => e.name == product.name)
    if (!!productFinded) {
      productFinded.qte += 1
      setCart([...cart])
    } else setCart([...cart, {...product, qte: 1}])
  }

  const removeItemFromCart = (item) => {
    const productFinded = cart.find((e) => e == item)
    if (productFinded.qte > 1){
      productFinded.qte --
      setCart([...cart])
    } else setCart((prevCart) => prevCart.filter(e => e != item))
  }

  // console.log(cart)
  
  return (
    <ProductContext.Provider value={{productList, cart, addToCart, removeItemFromCart }}>

      {showModal && <ModalCart btnCloseAction={() => setShowModal(false)} />}
      <Header cartBtnAction={() => setShowModal(true)} />
      <ProductList />

    </ProductContext.Provider>
  )
}

export default App
