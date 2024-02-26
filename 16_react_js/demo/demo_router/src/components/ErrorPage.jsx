import React from 'react';
import { useRouteError, Link } from 'react-router-dom';

const ErrorPage = () => {

    const error = useRouteError()

    return (
        <div>
            <h1>Erreur: {error.status}</h1>
            <p>{error.data}</p>
            <Link to={'/'}>Home</Link>    
        </div>
    );
}

export default ErrorPage;
