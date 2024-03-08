import React from 'react';

const Layout = ({children}) => {
    return (
        <div
            style={{maxWidth: '100dvw', minHeight: '100dvh'}}
            className='d-flex flex-column justify-content-between bg-dark text-light'
        >
            <header className='p-2 mb-4 bg-dark d-flex justify-content-center text-light border-bottom'>
                <div className='container row'>
                    <div className='col-4'>
                        <h1>MTGAPI</h1>

                    </div>
                    <nav className='col-8 d-flex align-items-center'>
                        
                    </nav>
                </div>
            </header>
            <main className='flex-fill d-flex'>
                <div className='container flex-fill d-flex flex-column'>
                    {children}
                </div>
            </main>
        </div>
    );
}

export default Layout;
