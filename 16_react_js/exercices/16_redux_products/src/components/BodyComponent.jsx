import React from 'react';
import reactLogo from '../assets/react.svg'


const BodyComponent = ({children}) => {
    return (
        <>
        <header className='p-2 mb-4 bg-dark text-white text-center'>
            <h1><span><img src={reactLogo} alt="" /></span> Application de gestion de produits <span><img src={reactLogo} alt="" /></span></h1>
        </header>
        <main className='container pt-4'>
            <div className='row'>
                {children}
            </div>
        </main>
        </>
    );
}

export default BodyComponent;
