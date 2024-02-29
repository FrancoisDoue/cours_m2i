import React from 'react';
import { useSelector } from 'react-redux'
import ProductItem from './ProductItem';

const ProductList = () => {
    
    const productList = useSelector(state => state.products.productList)

    return (
        <div className='col-8'>
            <h3 className='pb-4 border-bottom text-center'>Liste des produits</h3>
            <table className='table'>
                <thead className='text-center'>
                    <tr >
                        <th className="col-3">Nom</th>
                        <th className="col-3"> Prix</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {!!productList.length && productList.map(e => <ProductItem key={e.id} product={e} />)}
                </tbody>
            </table>  
        </div>
    );
}

export default ProductList;
