import React from 'react';

const ProductCard = ({product, action}) => {
    
    return (
        <div className='card m-4 shadow-sm' style={{width: "24rem"}}>
            <div className='card-body'>
                <h3 className='card-title'>{product.name}</h3>
                <p className='card-text'>{product.description}</p>
                <p className='card-subtitle text-end'>{product.price} €</p>

            </div>
            <button className='btn btn-outline-primary m-2' onClick={() => action(product)}>Ajouter au panier</button>
        </div>
    );
};

export default ProductCard;