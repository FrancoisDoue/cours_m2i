import React from 'react';
import reactLogo from '../assets/react.svg'

const DefaultLayer = ({children}) => {
    return (
        <>
            <header>
                <h1>
                    <span><img src={reactLogo} alt='logo' /></span>
                    Perfectionnement
                </h1>
            </header>
            <main>
                {children}
            </main>
            
        </>
    );
};

export default DefaultLayer;