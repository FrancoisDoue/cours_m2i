import React, { useEffect, useRef, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { Input } from '../shared/form/Input';
import { register } from '../service/authService';

const RegisterView = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const error = useSelector(state => state.auth.error)
    const [isSent, setSent] = useState(false)
    const [isAdmin, setAdmin] = useState(false)

    const schemaRef = {
        firstname: useRef(),
        lastname: useRef(),
        email: useRef(),
        password: useRef(),
    }

    const handleRegisterSubmit = (e) => {
        e.preventDefault()
        const formResult = {
            firstname: schemaRef.firstname.current.value,
            lastname: schemaRef.lastname.current.value,
            email: schemaRef.email.current.value,
            password: schemaRef.password.current.value,
            role: [{name: "ROLE_USER"}]
        }
        if (isAdmin) formResult.role.push({name: "ROLE_ADMIN"})
        console.log(formResult)
        dispatch(register({body: formResult}))
        setTimeout(() => {
            setSent(true)
        }, 300)
    }

    useEffect(() => {
        if (isSent && !error) navigate("/login")
    }, [isSent])


    return (
        <form className='w-50 p-3 bg-body border border-light-subtle shadow-sm rounded-1 mx-auto mt-5 row'
            onSubmit={handleRegisterSubmit}>
            <h3>Inscription</h3>
            <hr className='border border-light-subtle' />
            <div className='col-6'>
                <Input name={"lastname"} givenRef={schemaRef.lastname} label={"Nom"} isRequired />
            </div>
            <div className='col-6'>
                <Input name={"firstname"} givenRef={schemaRef.firstname} label={"Prénom"} isRequired />
            </div>
            <hr className='border border-light-subtle' />
            <Input name={"email"} type={"email"} givenRef={schemaRef.email} label={"Adresse email"} isRequired />
            <Input name={"password"} type={"password"} givenRef={schemaRef.password} label={"Mot de passe"} isRequired />
            <div className='px-3'>
                <div className="form-check form-switch">
                    <input className="form-check-input" type="checkbox" id="admin" 
                        onChange={e => setAdmin(e.target.checked)} />
                    <label className="form-check-label" htmlFor="admin">Définir ce compte comme administrateur</label>
                </div>
            </div>
            <hr className='border border-light-subtle' />
            <button type='submit' className='btn btn-outline-primary w-75 mx-auto'>Inscription</button>
        </form>
    );
};

export default RegisterView;