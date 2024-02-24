import React, { useContext } from 'react';
import ProductContext from '../../context/ProductContext';

const ModalListItem = ({product}) => {
    
    const { removeItemFromCart } = useContext(ProductContext)

    return (
        <div className='text-start d-flex align-items-center mx-4 my-1'>
        <h5>{product.name}</h5>
        <div className='flex-fill d-flex justify-content-end align-items-center'>
            <p className='my-auto me-4'>{product.price} €</p>
            <p className='my-auto me-4'>qte: {product.qte}</p>
            <button 
                onClick={() => removeItemFromCart(product)} 
                className='btn btn-outline-danger'
            >Supprimer</button>
        </div>
    </div>
    );
};

export default ModalListItem;