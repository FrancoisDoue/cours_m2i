import React, { useEffect, useLayoutEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { Outlet, useNavigate } from 'react-router-dom';
import { selectors } from '../store/authSlice';

const ProtectedRoute = () => {
    const navigate = useNavigate()
    const isLogged = useSelector(state => state.auth.isLogged)

    useEffect(() => {
        console.log("on protected route\nUser is logged : ", isLogged)
        if (!isLogged) navigate("/login")
    }, [isLogged])

    return (<Outlet />);
};

export default ProtectedRoute;