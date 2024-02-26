import React from 'react';
import { NavLink, Link, Outlet } from 'react-router-dom';

const Navbar = () => {


    return (
        <>
        <nav>
            <NavLink to={'/'}>Accueil</NavLink>
            <NavLink to={'/form'}>Formulaire</NavLink>
        </nav>
        <Outlet/>
        <footer>Foutère</footer>
        </>
    );
}

export default Navbar;
