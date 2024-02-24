import React, { useContext } from 'react';
import ProductContext from '../context/ProductContext';

const Header = ({cartBtnAction}) => {
    const {cart} = useContext(ProductContext)
    return (
        <header className='bg-dark text-light p-1 px-4 d-flex justify-content-between'>
            <h1>E-C<span><i className="bi bi-globe2"></i></span>MMERCE</h1>
            <div className='align-self-center mx-4'>
                <button 
                    className='btn btn-primary position-relative'
                    onClick={cartBtnAction}
                >
                    
                    <span className=''>
                        <i className="bi bi-cart"></i>
                        Panier
                    </span>
                    {!!cart.length &&
                        <span className='position-absolute top-0 start-100 translate-middle badge rounded-pill text-bg-warning'>
                            {cart.reduce((total, e) => total + e.qte, 0)}
                        </span>
                    }
                </button>
            </div>
        </header>
    );
};

export default Header;