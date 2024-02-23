import React, { useRef }  from 'react';

const LoginForm = ({handleSubmit}) => {
    const loginRef = useRef()
    const passwordRef = useRef()

    const handleForm = (e) => {
        e.preventDefault()
        handleSubmit(loginRef.current.value, passwordRef.current.value)
        loginRef.current.value = ''
        passwordRef.current.value = ''
    }

    return (
        <>
        <form onSubmit={handleForm}>
            <div>
                <label htmlFor="login">Login : </label>
                <input type="text" name="login" id="login" ref={loginRef}/>
            </div>
            <div>
                <label htmlFor="password">Password : </label>
                <input type="password" name="password" id="password" ref={passwordRef}/>
            </div>
            <button type='submit'>Login</button>
        </form>
        </>
    );
}

export default LoginForm;
