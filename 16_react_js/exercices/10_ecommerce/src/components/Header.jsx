import React from 'react';

const Header = ({cartBtnAction}) => {
    return (
        <header className='bg-dark text-light p-1 px-4 d-flex justify-content-between'>
            <h1>E-C<span><i className="bi bi-globe2"></i></span>MMERCE</h1>
            <div className='align-self-center mx-4'>
                <button 
                    className='btn btn-primary'
                    onClick={cartBtnAction}
                >
                    <span><i className="bi bi-cart"></i></span> Panier
                </button>
            </div>
        </header>
    );
};

export default Header;