import React from 'react';
import reactLogo from '../assets/react.svg'


const BodyComponent = ({children}) => {
    return (
        <>
        <header className='p-2 mb-3 bg-dark text-white text-center'>
            <h1><span><img src={reactLogo} alt="" /></span> Application de gestion de produits <span><img src={reactLogo} alt="" /></span></h1>
        </header>
        <main className='container'>
            <div className='row'>
                {children}
            </div>
        </main>
        </>
    );
}

export default BodyComponent;
