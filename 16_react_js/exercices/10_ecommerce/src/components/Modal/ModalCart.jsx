import React, { useContext } from 'react';
import { createPortal } from 'react-dom'
import classes from './Modal.module.css'
import ProductContext from '../../context/ProductContext';
import ModalListItem from './ModalListItem';

const ModalCart = ({btnCloseAction}) => {

    const {cart} = useContext(ProductContext)


    return createPortal(
        <div className={`${classes.modal} d-flex justify-content-center align-items-center`}>
            <div 
                className='bg-light rounded text-center d-flex flex-column justify-content-between' 
                style={{width: '40%', maxHeight: '80%', minHeight: '200px'}}
            >
                <div className='pt-2'>
                    <h3>Votre panier</h3>
                    <hr />
                </div>
                <div className='m-4'>
                    {cart.map((e, i) => <ModalListItem product={e} key={i} />)}
                </div>
                <div className='mx-4'>
                    <h4>Total: 
                        {Math.round(cart.reduce((total, e) => (total + Number(e.price) * e.qte), 0) * 100) / 100}
                    </h4>
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