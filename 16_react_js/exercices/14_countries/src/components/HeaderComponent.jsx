import React, { useRef } from 'react';
import reactLogo from '../assets/react.svg'


const HeaderComponent = ({searchAction}) => {

    const search = useRef()

    const handleInput = () => searchAction(search.current.value.toLowerCase().trim())


    return (
        <header className='p-3 bg-dark text-light'>
            <div className='container d-flex justify-content-between align-items-center'>
                <h1>Exercice 14 <span><img src={reactLogo} alt="logo-bootstrap" /></span> RESTCOUNTRIES</h1>
                <div>
                    <div className='input-group'>

                        <input 
                            onInput={handleInput}
                            className='form-control bg-dark text-light' 
                            type="text" 
                            ref={search}
                        />

                        <button  
                            onClick={handleInput}
                            className='btn btn-outline-light'
                        >
                            <i className="bi bi-search"></i>
                        </button>

                    </div>
                </div>
            </div>
        </header>
    );
}

export default HeaderComponent;
