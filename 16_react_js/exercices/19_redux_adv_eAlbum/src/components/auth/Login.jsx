import React, { useEffect, useRef } from 'react';
import {useDispatch, useSelector} from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { /*refreshAuthToken,*/ selectIsLogged, /*selectUserStayLogged,*/ sendCredentials, setFormMode } from './authSlice';
import { SIGN_IN_URL, SIGN_UP_URL } from '../../firebaseConfig';

const Login = () => {

    // const user = useSelector(state => state.auth.user)
    const isLogged = useSelector(selectIsLogged)
    // const userStayLogged = useSelector(selectUserStayLogged)

    const formMode = useSelector(state => state.auth.formMode)
    const dispatch = useDispatch()
    const navigate = useNavigate()

    const URL = formMode? SIGN_IN_URL : SIGN_UP_URL

    const emailRef = useRef()
    const passwordRef = useRef()
    const stayConnectedRef = useRef()
    const handleSubmit = (e) => {
        e.preventDefault()
        const request = {
            url: URL,
            isLoginContext: formMode,
            // stayLogged: stayConnectedRef.current?.checked || false,
            body: {
                email: emailRef.current.value,
                password: passwordRef.current.value,
                returnSecureToken: formMode
            }
        }
        console.log(request)
        dispatch(sendCredentials(request))
        !formMode && dispatch(setFormMode())
    }

    // useEffect(() => {
    //     userStayLogged && dispatch(refreshAuthToken())
    // }, [userStayLogged])

    useEffect(() => {
        // isLogged && navigate(-2)
        isLogged && navigate('/')
    }, [isLogged])

    // if (userStayLogged) return <></>

    return (
    <div className='d-flex justify-content-center'>
        <div className='card bg-dark text-white'>
            <div className='card-header border-light'>
                <h3 className='card-title text-center'>{formMode ? 'Connexion' : 'Inscription'}</h3>
            </div>
            <form onSubmit={handleSubmit} className='card-content'>
                <div className="p-4 row">
                    <div className="col-6">
                        <label htmlFor="connect-email" className='p-2'>Email : </label>
                        <div className='input-group'>
                            <input type="email" className='form-control rounded-pill bg-dark text-light' id='connect-email' name='connect-email' ref={emailRef}/>
                        </div>
                    </div>
                    <div className="col-6">
                        <label htmlFor="connect-password" className='p-2'>Mot de passe: </label>
                        <div className='input-group'>
                            <input type="password" className='form-control rounded-pill bg-dark text-light' id='connect-password' name='connect-password' ref={passwordRef}/>
                        </div>
                    </div>
                    {/* {formMode &&
                    <div className='p-3 d-flex justify-content-center'>
                        <div className='form-check'>
                            <input className='form-check-input' type="checkbox" name="connect-stay-connect" id="connect-stay-connect" ref={stayConnectedRef}/>
                            <label htmlFor="connect-stay-connect" className='form-check-label'> Rester connecté</label>
                        </div>
                    </div>
                    } */}
                    <div className='p-3 text-center '>
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
                        onClick={() => navigate('/')} 
                        className='btn btn-outline-light p-1 ml-auto mt-1'
                    >Retour</button>
                </p>
            </div>
        </div>

    </div>
    );
};

export default Login;