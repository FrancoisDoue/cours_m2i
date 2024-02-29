import React from 'react';
import { useDispatch } from 'react-redux'
import { deleteProduct, modifyProduct } from './productsSlice';
import { useState } from 'react';
import { useRef } from 'react';

const ProductItem = ({product}) => {
    const dispatch = useDispatch()
    const [isEdit, setIsEdit] = useState(false)
    const nameRef = useRef()
    const priceRef = useRef()

    const handleModify = () => {
        const modifiedProduct = {
            id: product.id,
            name: nameRef.current.value,
            price: priceRef.current.value,
        }
        if (modifiedProduct.name || modifiedProduct.value) {
            dispatch(modifyProduct(modifiedProduct))
            setIsEdit(false)
        }
    }

    if (!isEdit){
        return (
            <tr>
                <td>{product.name}</td>
                <td>{product.price} €</td>
                <td className='row'>
                    <div className='col-6 border-end'>
                        <button 
                            onClick={() => setIsEdit(true)}
                            className='btn btn-outline-success w-100'
                        >
                            Modifier le produit
                        </button>
                    </div>
                    <div className='col-6'>
                        <button 
                            onClick={() => dispatch(deleteProduct(product.id))}
                            className='btn btn-outline-danger w-100'
                        >
                            Supprimer
                        </button>
                    </div>
                </td>
            </tr>
        );
    }else {
        return (
            <tr>
                <td>
                    <input className='form-control' type="text" defaultValue={product.name} ref={nameRef} />
                </td>
                <td>
                    <input className='form-control' type="number" step={.1} defaultValue={product.price} ref={priceRef} />
                </td>
                <td className='row'>
                    <div className='col-6 border-end'>
                        <button 
                            onClick={handleModify}
                            className='btn btn-warning w-100'
                        >
                            Modifier
                        </button>
                    </div>
                    <div className='col-6'>
                        <button
                            onClick={() => setIsEdit(false)} 
                            className='btn btn-danger w-100'
                        >
                            Annuler
                        </button>
                    </div>
                </td>
            </tr>
        )
    }
}

export default ProductItem;
