import React from 'react';
import PropagateLoader from 'react-spinners/PropagateLoader'

const LoadingComponent = () => {
    
    return (
        <div className='flex-fill d-flex flex-column align-items-center justify-content-center'>
            <PropagateLoader color='#ffffff'/>
            <h3 className='text-center mt-4 ps-2'>Chargement</h3>
        </div>
    );
};

export default LoadingComponent;