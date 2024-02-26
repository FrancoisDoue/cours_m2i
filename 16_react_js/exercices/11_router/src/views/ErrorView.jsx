import React from 'react';
import { useRouteError, Link } from 'react-router-dom';

const ErrorView = () => {
    const error = useRouteError()

    return (
        <div>
            <h1>Error: {error.status}</h1>
            <p>{error.data}</p>

            <Link to='/'>Retour à l'accueil</Link>
        </div>
    );
}

export default ErrorView;
