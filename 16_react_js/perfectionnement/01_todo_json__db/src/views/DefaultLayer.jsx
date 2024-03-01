import React from 'react';
import reactLogo from '../assets/react.svg'

const DefaultLayer = ({children}) => {
    return (
        <>
        <div 
            style={{minWidth: '100dvw', minHeight: '100dvh'}}
            className='d-flex flex-column justify-content-between bg-dark text-light'
        >
            <header className='p-1 mb-4 bg-dark bg-gradient border-bottom border-warning-subtle'>
                <div className='container'>
                    <h1 className='text-center'>
                        <span><img src={reactLogo} alt='logo' /> </span>
                        Perfectionnement
                    </h1>
                </div>
            </header>
            <main className='flex-fill bg-dark'>
                <div className='container'>
                    
                    {children}

                </div>
            </main>
            {/* <footer>
                <h5>Footer</h5>
            </footer> */}
        </div>
            
        </>
    );
};

export default DefaultLayer;