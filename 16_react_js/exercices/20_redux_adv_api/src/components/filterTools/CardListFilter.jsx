import React from 'react';

const CardListFilter = ({children}) => {

    return (
        <div className=' card bg-dark shadow border-light p-2 mb-4 '>
            <div className='d-flex justify-content-arount'>
                {children}
            </div>
        </div>
    );
};

export default CardListFilter;