import { useState } from 'react'
import viteLogo from '/vite.svg'
import BodyComponent from './components/BodyComponent'
import ProductList from './components/ProductList'
import ProductForm from './components/ProductForm'
// import './App.css'

function App() {

  return (
    <>
    <BodyComponent>
      <ProductForm />
      <ProductList />
    </BodyComponent>
    </>
  )
}

export default App
