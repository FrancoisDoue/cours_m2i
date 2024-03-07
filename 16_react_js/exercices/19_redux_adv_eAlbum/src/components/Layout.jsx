import reactLogo from '../assets/react.svg'
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useLocation, Link } from 'react-router-dom'
import { logout, selectIsLogged } from './auth/authSlice';

const Layout = ({children}) => {

    const isLogged = useSelector(selectIsLogged)
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const { pathname } = useLocation()

    const navBtnProvider = {
        href: () => navigate((pathname == '/') ? '/login' : '/'),
        content: (pathname == '/') ? 'Connexion / Inscription' : 'Accueil'
    }

    return (
        <>
        <div 
            style={{maxWidth: '100dvw', minHeight: '100dvh'}}
            className='d-flex flex-column justify-content-between bg-light'
        >
            <header className='p-2 mb-4 bg-dark d-flex justify-content-center text-light'>
                <div className='container row'>
                    <div className='col-4'>
                        <h1>
                            E<span><img src={reactLogo} alt='logo' /></span>Album
                        </h1>
                    </div>
                    <nav className='d-flex justify-content-between align-items-center col-8 p-2'>
                        <div>
                            {isLogged && 
                                <Link to={'/album/edition'} className='text-light mx-4'>Ajouter un album</Link>
                            }
                        </div>
                        <div>
                            {(!isLogged || pathname != '/') &&
                            <button 
                                onClick={navBtnProvider.href}
                                className='btn btn-outline-light mx-2'
                            >{navBtnProvider.content}</button>}

                            {isLogged &&
                            <button
                                onClick={() => dispatch(logout())}
                                className='btn btn-outline-danger mx-2 text-light'
                            >Déconnexion</button>
                            }

                        </div>
                    </nav>
                </div>
            </header>
            <main className='flex-fill'>
                <div className='container'>
                    {/* <Outlet /> */}
                    {children}
                </div>
            </main>
        </div>
        </>
    );
}

export default Layout;
