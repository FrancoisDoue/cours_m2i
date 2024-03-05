import React from 'react';
import { useRouteError } from 'react-router-dom';

const ErrorView = ({errorCode, errorDetail}) => {
    const error = useRouteError()
    console.log(error)
    return (
        <>
        <p>{error?.status}</p>
        <p>{error?.data}</p>
        <p>{errorCode && errorCode}</p>
        <p>{errorDetail && errorDetail}</p>
            
        </>
    );
};

export default ErrorView;