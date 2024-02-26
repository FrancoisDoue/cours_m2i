import React from 'react';
import { useParams, Link, useSearchParams } from 'react-router-dom';

const ProductView = () => {

    const {productId} = useParams()
    const [searchParams, setSearchParams] = useSearchParams()

    const mode = searchParams.get('mode') ?? 'default'
    const toto = searchParams.get('toto') ?? 'duh'

    return (
        <div>
            <h1>produit n° {productId}</h1>
            <p>mode : {mode}</p>
            <p>toto : {toto}</p>
            <Link to={'/'}>Home</Link>
        </div>
    );
}

export default ProductView;
