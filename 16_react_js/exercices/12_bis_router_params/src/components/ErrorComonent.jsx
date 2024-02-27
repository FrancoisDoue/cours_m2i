import React from 'react';
import { useRouteError } from 'react-router-dom';

const ErrorComonent = () => {
    const error = useRouteError()
    console.log(error)
    return (
        <div>
            <h2>Error: {error.status}</h2>
            <p>{error.data}</p>
        </div>
    );
};

export default ErrorComonent;