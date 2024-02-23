import React from 'react';
import { useState } from 'react';

const FormComponent = () => {

    const [firstname, setFirtname] = useState('Georges')
    const [lastname, setLastname] = useState('Abidbol')
    const firstnameHandler = (e) => setFirtname(e.target.value)
    const lastnameHandler = (e) => setLastname(e.target.value)

    return (
        <div>
            <div>
                <label htmlFor="firstname">Prénom</label>
                <input type="text" name='firstname' value={firstname} onChange={firstnameHandler}/>
                <label htmlFor="lastname">Nom</label>
                <input type="text" name='lastname' value={lastname} onChange={lastnameHandler}/>

            </div>
            <p>
                Bonjour <b>{`${firstname} ${(lastname).toUpperCase()}`}</b>, bienvenue sur l'application
            </p>
        </div>
    );
}

export default FormComponent;
