import React from 'react';
import { Link } from 'react-router-dom';

const FormPage = () => {
    return (
        <div>
            <h1>Form page</h1>
            <form action="">
                <label htmlFor="">Nom</label>
                <input type="text" />
                <label htmlFor="">Prénom</label>
                <input type="text" />
            </form>
            <hr />
            <Link to={'/'}>Page d'accueil</Link>
        </div>
    );
}

export default FormPage;
