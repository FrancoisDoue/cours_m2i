import React, { useContext } from 'react';
import ProductContext from '../context/ProductContext';
import ProductCard from './ProductCard';

const ProductList = () => {

    const { productList, addToCart } = useContext(ProductContext)
    
    return (
        <main className='container pt-4'>
            <div className='d-flex flex-wrap'>
                {!!productList.length && 
                    productList.map((e, i) => <ProductCard key={i} product={e} action={addToCart}/>)
                }
            </div>
        </main>
    );
};

export default ProductList;