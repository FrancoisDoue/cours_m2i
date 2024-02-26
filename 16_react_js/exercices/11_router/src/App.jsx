import React from 'react';
import { Outlet, Link, NavLink } from 'react-router-dom';
import reactLogo from './assets/react.svg'

const App = () => {
    const handleNavLink = ({isActive}) => isActive ? {color: 'white'} : {color: 'lightblue'}
    
    return (
        <>
        <nav>
            <h1><span><img src={reactLogo} alt="logo" /></span>Exercice 11 - routes</h1>
            <div>
                <ul>
                    <li><NavLink to={'/'} style={handleNavLink}>Accueil</NavLink></li>
                    <li><NavLink to={'/form'} style={handleNavLink}>Formulaire</NavLink></li>
                    <li><NavLink to={'/about'} style={handleNavLink}>A propos</NavLink></li>
                </ul>
            </div>
        </nav>
        <Outlet />
        </>
    );
}

export default App;
