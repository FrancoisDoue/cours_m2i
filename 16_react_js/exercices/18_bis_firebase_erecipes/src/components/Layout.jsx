import reactLogo from '../assets/react.svg'
import React, { useState } from 'react';
import Modal from './auth/Modal';
import { useDispatch, useSelector } from 'react-redux';
// import { removeUser } from './auth/authSlice';
import { useContext } from 'react';
import AuthContext from '../context/AuthContext';

const Layout = ({children}) => {
    
    const {isLogged, removeUser} = useContext(AuthContext)

    const [openModal, setOpenModal] = useState(false)
    const dispatch = useDispatch()

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
                            E<span><img src={reactLogo} alt='logo' /></span>Recipes
                        </h1>
                    </div>
                    <nav className='d-flex justify-content-end col-6 p-2'>
                        {!isLogged ? 
                            <button 
                                onClick={() => setOpenModal(true)}
                                className='btn btn-outline-light'
                            >Sign In / Sign Up</button>
                            :
                            <button
                                onClick={() => dispatch(removeUser())}
                                className='btn btn-outline-danger text-white'
                            >
                                Déconnexion
                            </button>
                        }
                    </nav>
                </div>
            </header>
            <main className='flex-fill'>
                <div className='container'>
                    {children}
                </div>
            </main>
        </div>
        {openModal && <Modal modalAction={setOpenModal} />}
        </>
    );
}

export default Layout;
