import React, { useRef } from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux'
import { fetchCards } from '../../services/cardServices';
import { useState } from 'react';

const CardsMain = () => {
    const dispatch = useDispatch()
    const {currentPage, isLoading, error} = useSelector(state => state.card)
    const [paginate, setPaginate] = useState(1)
    const pageRef = useRef()

    const handleLoadCards = (e) => {
        e.key === 'Enter' && setPaginate(+pageRef.current.value)
    }

    useEffect(() => {
        console.log('on CardsMain')
        pageRef.current.value = paginate
        !isLoading && dispatch(fetchCards({page: paginate}))
        currentPage
    }, [paginate > 1])
    console.log(currentPage)

    return (
        <>
        <div>
            <div className='input-group w-25'>
            <button 
                className='btn btn-outline-light rounded-start-pill'
                disabled={paginate <= 1 }
                onClick={() => setPaginate(prev => !!(prev-1) ? prev - 1 : prev)}
            ><i className='bi bi-arrow-left'></i></button>
            {/* <p className='m-0 form-control bg-dark border-light text-light text-center'>{paginate}</p> */}
            <input type="number" name="" id="" 
                onKeyDown={handleLoadCards} 
                ref={pageRef} 
                defaultValue={pageRef?.current?.value}
                style={{MozAppearance: 'textfield', WebkitAppearance: 'none'}}
                className='m-0 form-control bg-dark border-light text-light text-center'
            />
            <button 
                className='btn btn-outline-light rounded-end-pill' 
                onClick={() => setPaginate(prev => prev + 1)}
                
            ><i className='bi bi-arrow-right'></i></button>


            </div>
        </div>
        <div>
            {error && <h5>Do something with error ...</h5> }
            {isLoading && <h4>Chargement . . .</h4> }
            {!isLoading && !!currentPage?.length && 
                currentPage?.map(e => <img src={e.imageUrl} alt={e.name} key={e.id} />) 
            }
        </div>
        </>
    );
}

export default CardsMain;
