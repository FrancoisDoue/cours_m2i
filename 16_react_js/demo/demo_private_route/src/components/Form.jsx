import React from 'react';

const Form = () => {

    const setStorage = () => {
        localStorage.setItem('token', "mon_token_qu_il_est_bien")
    }
    return (
        <div>
            <h1>Authentifications?</h1>
            <form >
                <button onClick={setStorage}>Identification</button>
            </form>
        </div>
    );
}

export default Form;
