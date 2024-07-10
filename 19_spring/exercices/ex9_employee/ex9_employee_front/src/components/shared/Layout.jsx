import React from 'react';
import { Outlet } from 'react-router-dom';

const Layout = () => {
    return (
        <div
            style={{maxWidth: '100dvw', minHeight: '100dvh'}}
            className='d-flex flex-column justify-content-between bg-light'
        >
            <header className='p-2 mb-4 border border-light-subtle shadow-sm d-flex justify-content-center border-bottom'>
                <div className='container row'>
                    <div className='col-4'>
                        <h2>Exo9-Recrutement</h2>

                    </div>
                    <nav className='col-8 d-flex align-items-center'>
                        
                    </nav>
                </div>
            </header>
            <main className='flex-fill d-flex'>
                <div className='container flex-fill d-flex flex-column'>
                    <Outlet />
                </div>
            </main>
        </div>
    );
}

export default Layout;
