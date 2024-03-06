import reactLogo from '../assets/react.svg'
import React from 'react';
import { Outlet, useNavigate, useLocation } from 'react-router-dom'

const Layout = () => {

    const navigate = useNavigate()
    const { pathname } = useLocation()

    const navBtnProvider = {
        href: (pathname == '/') ? '/login' : '/',
        content: (pathname == '/') ? 'Sign in / Sign up' : 'Home'
    }


    return (
        <>
        <div 
            style={{maxWidth: '100dvw', minHeight: '100dvh'}}
            className='d-flex flex-column justify-content-between bg-light'
        >
            <header className='p-2 mb-4 bg-dark d-flex justify-content-center text-light'>
                <div className='container row'>
                    <div className='col-6'>
                        <h1>
                            E<span><img src={reactLogo} alt='logo' /></span>Album
                        </h1>
                    </div>
                    <nav className='d-flex justify-content-end col-6 p-2'>
                        <button 
                            onClick={() => navigate(navBtnProvider.href)}
                            className='btn btn-outline-light'
                        >{navBtnProvider.content}</button>
                    </nav>
                </div>
            </header>
            <main className='flex-fill'>
                <div className='container'>
                    <Outlet />
                </div>
            </main>
        </div>
        </>
    );
}

export default Layout;
