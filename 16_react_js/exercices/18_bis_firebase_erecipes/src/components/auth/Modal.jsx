import React, { useRef } from 'react';
import { createPortal } from 'react-dom'
import {modal, modalContent} from './Modal.module.css'
import { useDispatch, useSelector } from 'react-redux';
import { setFormMode, setUser } from './authSlice';
import axios from 'axios'
import { SIGN_IN_URL, SIGN_UP_URL } from '../../firebaseConfig';

const Modal = ({modalAction}) => {
    const formMode = useSelector(state => state.auth.formMode)
    const dispatch = useDispatch()
    const URL = formMode ? SIGN_IN_URL : SIGN_UP_URL

    const emailRef = useRef()
    const passwordRef = useRef()

    const handleSubmit = (e) => {
        e.preventDefault()
        const credentials = {
            email : emailRef.current.value,
            password: passwordRef.current.value,
            returnSecureToken: true
        }
        axios.post(URL, credentials)
            .then(res => {
                modalAction(false)
                dispatch(setUser(res.data))
            })

    }


    return createPortal(
        <div className={modal}>
            <div className={modalContent + ' card bg-dark text-white'}>
                <div className='card-header border-light'>
                    <h3 className='card-title text-center'>{formMode ? 'Connexion' : 'Inscription'}</h3>
                </div>
                <form onSubmit={handleSubmit} className='card-content'>
                    <div className="p-4">
                        <label htmlFor="connect-email" className='p-2'>Email : </label>
                        <div className='input-group'>
                            <input type="email" className='form-control' id='connect-email' name='connect-email' ref={emailRef}/>
                        </div>
                        <label htmlFor="connect-password" className='p-2'>Mot de passe: </label>
                        <div className='input-group'>
                            <input type="password" className='form-control' id='connect-password' name='connect-password' ref={passwordRef}/>
                        </div>
                        <div className='p-3 text-center'>
                            <button className='btn btn-outline-light w-50'>{formMode ? 'Connexion' : 'Inscription'}</button>
                        </div>
                    </div>
                </form>
                <div className='card-footer border-light text-center pb-1'>
                    <p> {formMode ? 'Vous n\'avez pas encore de compte?' : 'Vous avez déjà un compte ?'}
                        <span>
                            <button 
                                onClick={() => dispatch(setFormMode())}
                                className='btn btn-outline-light p-1 mx-2'
                            >{formMode ? 'Inscription' : 'Connexion'}</button>
                        </span>
                    </p>
                    <hr className='m-0' />
                    <p className='text-end text-light p-0'>
                        <button 
                            onClick={() => modalAction(false)} 
                            className='btn btn-outline-light p-1 ml-auto mt-1'
                        > Retour </button>
                    </p>

                </div>
            </div>
        </div>,
        document.body
    );
}

export default Modal;
