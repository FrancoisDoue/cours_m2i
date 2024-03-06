import React from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import {useSelector} from 'react-redux'
import { selectIsLogged } from './auth/authSlice';

const ProtectedRoute = ({children}) => {
    const isLogged = useSelector(selectIsLogged)
    
    if (!isLogged) return (
        <Navigate to={'/login'}/>
    )
    return <>{children}</>
}

export default ProtectedRoute;
