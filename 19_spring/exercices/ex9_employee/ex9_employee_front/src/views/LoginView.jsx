import React, { useRef } from 'react';
import { Input } from '../components/form/Input';
import { useDispatch } from 'react-redux';

const LoginView = () => {
    const dispatch = useDispatch()
    const schemaRef = {
        email: useRef(),
        password: useRef()
    }

    const handleAuthSubmit = (e) => {
        e.preventDefault()
        const formResult = {
            
        }
    }

    return (
        <form className='w-50 p-3 bg-body border border-light-subtle shadow-sm rounded-1 mx-auto mt-5 row'
            onSubmit={handleAuthSubmit}>
            <h3 className='mb-4'>Connexion</h3>
            <Input name={"email"} givenRef={schemaRef.email} label={"Adresse email"} isRequired />
            <Input type='password' name={"password"} givenRef={schemaRef.password} label={"Mot de passe"} isRequired />
            <hr className='border border-light-subtle' />
            <button type='submit' className='btn btn-outline-primary w-75 mx-auto'>Connexion</button>
        </form>
    );
};

export default LoginView;