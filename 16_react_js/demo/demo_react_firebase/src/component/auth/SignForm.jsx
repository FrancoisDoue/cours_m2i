import React, { useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { setAuthMode, setUser } from './authSlice';
import { SIGN_IN_URL, SIGN_UP_URL } from '../../firebaseConfig';
import axios from 'axios'

const SignForm = () => {

    const authMode = useSelector(state => state.auth.authMode)
    const dispatch = useDispatch()

    const emailRef = useRef()
    const passwordRef = useRef()

    const submitForm = (e) => {
        e.preventDefault()
        const URL = authMode ? SIGN_IN_URL : SIGN_UP_URL

        const credentials = {
            email : emailRef.current.value,
            password: passwordRef.current.value,
            returnSecureToken: true
        }

        axios.post(URL, credentials).then(
            (res) => {
                console.log(res)
                localStorage.setItem('token', res.data.idToken)
                dispatch(setUser(res.data))
            }
        )
    }

    return (
        <>
            <h3>{authMode ? "Se connecter": "S'inscrire"}</h3>
            <form onSubmit={submitForm}>
                <label htmlFor="email">email</label>
                <input type="email" id='email' name='email' ref={emailRef}/>
                <label htmlFor="password">password</label>
                <input type="password" id='password' name='password' ref={passwordRef}/>
                <button>{authMode ? "Se connecter": "S'inscrire"}</button>
            </form>
            <button
                onClick={() => dispatch(setAuthMode(!authMode))}
            >{authMode ? "S'inscrire": "Se connecter"}</button>
        </>
    );
}

export default SignForm;
