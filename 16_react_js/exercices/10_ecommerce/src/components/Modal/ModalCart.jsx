import React, { useContext } from 'react';
import { createPortal } from 'react-dom'
import classes from './Modal.module.css'
import ProductContext from '../../context/ProductContext';

const ModalCart = ({btnCloseAction}) => {
    // console.log(classes)

    const {cart, removeItemFromCart} = useContext(ProductContext)

    return createPortal(


        <div className={`${classes.modal} d-flex justify-content-center align-items-center`}>
            <div 
                className='bg-light rounded text-center d-flex flex-column justify-content-between' 
                style={{width: '30%', maxHeight: '80%', minHeight: '200px'}}
            >
                <div className='pt-2'>
                    <h3>Votre panier</h3>
                    <hr />
                </div>
                <div className='m-4'>
                    {cart.map((e, i)=>
                        <div className='text-start d-flex align-items-center mx-4 my-1'>
                            <h5 key={i}>{e.name}</h5>
                            <div className='flex-fill d-flex justify-content-end align-items-center'>
                                <p className='my-auto me-4'>{e.price} €</p>
                                <button 
                                    onClick={() => removeItemFromCart(e)} 
                                    className='btn btn-outline-danger'
                                >Supprimer</button>
                            </div>
                        </div>
                    )}
                </div>
                <div className='mx-4'>
                    <h4>Total: {
                       Math.round(cart.reduce((total, e) => total + Number(e.price), 0)*100) / 100
                    }</h4>
                </div>
                <div className='pb-2'>
                    <hr />
                    <button 
                        className='btn btn-outline-secondary'
                        onClick={btnCloseAction}
                    >Revenir aux produits</button>
                </div>
            </div>
        </div>
        ,
        document.body
    )
};

export default ModalCart;