import React, { useRef } from 'react';

const SearchTool = () => {
    const searchRef = useRef()
    

    return (
        <div className='input-group w-25'>
            <input 
                type="text"
                placeholder='Recherche par nom . . .'
                className='bg-dark border border-light rounded-start-pill text-light ps-4'
            />
            <button className='btn btn-outline-light rounded-end-pill' ><i className='bi bi-search'></i></button>
        </div>
    );
};

export default SearchTool;