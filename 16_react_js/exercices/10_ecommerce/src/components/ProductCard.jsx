import React from 'react';

const ProductCard = ({product, action}) => {
    
    return (
        <div>
            <h3>{product.name}</h3>
            <p>{product.description}</p>
            <p>Prix : {product.price} €</p>
            <button onClick={() => action(product)}>Ajouter au panier</button>
        </div>
    );
};

export default ProductCard;