import React from 'react';
import { Outlet } from 'react-router-dom';
import reactLogo from '../assets/react.svg'
import { NavLink } from 'react-router-dom';


const DefaultLayout = () => {
    const CustomLink = ({to = '/', children}) => {
        return (
        <NavLink 
            to={to} 
            className={({isActive}) => isActive ? 
                'mx-4 text-light text-decoration-none' :
                'mx-4 text-light'
            }
        >
            {children}
        </NavLink>
        )
    }

    return (
        <div 
            style={{maxWidth: '100dvw', minHeight: '100dvh'}}
            className='d-flex flex-column justify-content-between bg-dark text-light'
        >
            <header className='p-4 mb-4 bg-dark bg-gradient border-bottom border-primary-subtle'>
                <div className='container'>
                    <h1 className='text-center'>
                        Atom
                        <span><img src={reactLogo} alt='logo' /></span>
                        flims
                    </h1>
                </div>
                <nav className='container d-flex justify-content-end'>
                    <CustomLink>Home</CustomLink>
                    <CustomLink to={"/add"}>Add a movie</CustomLink>
                </nav>
            </header>
            <main className='flex-fill'>
                <div className='container'>
                    
                    <Outlet />

                </div>
            </main>
        </div>
    );
};

export default DefaultLayout;