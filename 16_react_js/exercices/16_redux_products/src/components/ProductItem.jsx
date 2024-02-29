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
        dispatch(modifyProduct(modifiedProduct))
        setIsEdit(false)
    }

    if (!isEdit){
        return (
            <tr>
                <td>{product.name}</td>
                <td>{product.price} €</td>
                <td> 
                    <button 
                        onClick={() => setIsEdit(true)}
                        className='btn btn-outline-success mx-2'
                    >
                        Modifier le produit
                    </button>
                    <button 
                        onClick={() => dispatch(deleteProduct(product.id))}
                        className='btn btn-outline-danger mx-2'
                    >
                        Supprimer
                    </button>
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
                <td>
                    <button 
                        onClick={handleModify}
                        className='btn btn-outline-warning mx-2'
                    >
                        Modifier
                    </button>
                    <button
                        onClick={() => setIsEdit(false)} 
                        className='btn btn-outline-danger mx-2'
                    >
                        Annuler
                    </button>
                </td>
            </tr>
        )
    }
}

export default ProductItem;
