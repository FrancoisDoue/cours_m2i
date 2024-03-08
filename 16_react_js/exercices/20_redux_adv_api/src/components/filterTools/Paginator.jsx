import React, { useEffect, useRef } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const CardListFilter = ({page, loading, maxInPage}) => {

    const navigate = useNavigate()
    const pageRef = useRef()

    const {maxPage} = useSelector(state => state.card)

    const handleInputNavigate = (e) => {
        if (e.key !== 'Enter') return
        let targetPage = pageRef?.current.value
        if(targetPage < 1) {
            pageRef.current.value = 1
            targetPage = 1
            page = 1
        }
        navigate(`/cards/${targetPage}`)
    }
    const handleBtnNavigate = (isNext) => {
        if (isNext) navigate(`/cards/${+page + 1}`)
        else navigate(`/cards/${(page < 2) ? page : +page - 1}`)
    }
    const handlePaginateChange = (e) => {
        console.log(e.target.value)
    }
    useEffect(() => {
        pageRef.current.value = page
    }, [page])

    return (
        <>
        <div className='input-group w-25 text-light'>
            <button 
                className='btn btn-outline-light rounded-start-pill'
                disabled={page <= 1 || loading}
                onClick={() => handleBtnNavigate(false)}
            ><i className='bi bi-arrow-left'></i></button>
            <input type="number" name="" id="" 
                onKeyDown={handleInputNavigate}
                ref={pageRef} 
                defaultValue={page} min={1} step={1}
                disabled={loading}
                style={{appearance: 'textfield', maxWidth: '5em'}}
                className='bg-dark border border-end-0 border-light text-light text-end'
            />
             <p className='border border-light border-start-0 p-2 pe-4 m-0'>{!!maxPage && `/ ${maxPage}`}</p>
            <button 
                className='btn btn-outline-light rounded-end-pill'
                disabled={loading}
                onClick={() => handleBtnNavigate(true)}
            ><i className='bi bi-arrow-right'></i></button>
        </div>
        <label className='text-light'>Nombre de card par page</label>
        <select className='form-select bg-dark text-light' style={{maxWidth: '5em'}} ref={maxInPage} onChange={(e) => maxInPage(e.target.value)}>
            <option value="20" >20</option>
            <option value="50" >50</option>
            <option value="100" >100</option>
        </select>
        </>
    );
};

export default CardListFilter;