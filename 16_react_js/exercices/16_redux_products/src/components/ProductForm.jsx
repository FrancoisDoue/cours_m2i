import React from 'react';
import { useRef } from 'react';
import { useDispatch } from 'react-redux'
import { addProduct } from './productsSlice';

const ProductForm = () => {
    const dispatch = useDispatch()

    const nameRef = useRef()
    const priceRef = useRef()


    const handleSubmit = (e) => {
        e.preventDefault()
        console.log('on handleSubmit')
        const newProduct = {
            name: nameRef.current.value,
            price: +priceRef.current.value,
        }
        if (newProduct.name && newProduct.price) {
            dispatch(addProduct(newProduct))
            nameRef.current.value = ''
            priceRef.current.value = ''
        } 
    }

    return (
        <form className='col-4 border-end' onSubmit={handleSubmit}>
            <h3 className='pb-4 border-bottom text-center'>Ajouter un produit</h3>
            <div className='p-4'>
                <label>Nom Du produit</label>
                <div className='input-group pb-4 mb-2 border-bottom'>
                    <input className='form-control' type="text" ref={nameRef} />
                </div>
                <label>Prix</label>
                <div className='input-group pb-4 mb-2 border-bottom'>
                    <input className='form-control' type="number" ref={priceRef} step={0.1}/>
                </div>
                <div className="mt-4">
                    <button className='btn btn-outline-primary btn-block w-100'>Ajouter le produit</button>
                </div>
            </div>
        </form>
    );
}

export default ProductForm;
