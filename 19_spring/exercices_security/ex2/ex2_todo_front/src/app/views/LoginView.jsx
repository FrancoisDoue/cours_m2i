import React, { useEffect, useRef, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Input } from '../shared/form/Input';
import { login } from '../service/authService';
import { useNavigate } from 'react-router-dom';

const LoginView = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const error = useSelector(state => state.auth.error)
    const [isSent, setSent] = useState(false)

    const schemaRef = {
        email: useRef(),
        password: useRef()
    }

    const handleAuthSubmit = (e) => {
        e.preventDefault()
        const formResult = {
            email: schemaRef.email.current?.value,
            password: schemaRef.password.current?.value
        }
        dispatch(login({body: formResult}))
        setTimeout(() => {
            setSent(true)
        }, 300)
    }

    useEffect(() => {
        if (isSent && !error) navigate("/tasks")
    }, [isSent])

    return (
        <form className='w-50 p-3 bg-body border border-light-subtle shadow-sm rounded-1 mx-auto mt-5 row'
            onSubmit={handleAuthSubmit}>
            <h3 className='mb-4'>Connexion</h3>
            <hr className='border border-light-subtle' />

            <Input name={"email"} givenRef={schemaRef.email} label={"Adresse email"} isRequired />
            <Input type='password' name={"password"} givenRef={schemaRef.password} label={"Mot de passe"} isRequired />
            <hr className='border border-light-subtle' />
            <button type='submit' className='btn btn-outline-primary w-75 mx-auto'>Connexion</button>
        </form>
    );
};

export default LoginView;