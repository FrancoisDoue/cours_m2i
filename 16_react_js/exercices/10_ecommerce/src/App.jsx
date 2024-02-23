import { useContext, useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-icons/font/bootstrap-icons.min.css'
import dataProducts from './datas/dataProducts'
import './App.css'
import ProductList from './components/ProductList'
import ProductContext from './context/ProductContext'
import Header from './components/Header'
import ModalCart from './components/Modal/ModalCart'

function App() {
  const [productList, setProductList] = useState(dataProducts)
  const [cart, setCart] = useState([])
  const [showModal, setShowModal] = useState(false)

  const addToCart = (product) => setCart([...cart, product])
  const removeItemFromCart = (item) => {
    setCart(prevCart => prevCart.filter(e => e != item))
  }

  console.log(cart)
  return (
    <ProductContext.Provider value={{productList, cart, addToCart, removeItemFromCart }}>

      {(showModal && !!cart.length) && 
        <ModalCart 
          btnCloseAction={() => setShowModal(false)}
        />
      }

      <Header cartBtnAction={() => !!cart.length && setShowModal(true)} />
      <ProductList />

    </ProductContext.Provider>
  )
}

export default App
