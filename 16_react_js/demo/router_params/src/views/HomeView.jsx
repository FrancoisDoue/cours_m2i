import React from 'react';
import { Link } from 'react-router-dom';

const HomeView = () => {

    
    return (
        <div>
            <h1>Home</h1>
            <ul>
                <li><Link to={'/product/123'}>Produit 123</Link></li>
                <li><Link to={'/product/458?mode=1&toto=5'}>Produit 458</Link></li>
                <li><Link to={'/product/4?toto=8'}>Produit 4</Link></li>
            </ul>
        </div>
    );
}

export default HomeView;
