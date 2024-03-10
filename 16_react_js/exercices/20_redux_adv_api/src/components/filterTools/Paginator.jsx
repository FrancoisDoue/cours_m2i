import React, { useEffect, useRef } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const CardListFilter = ({ page, loading, actions , currentMax}) => {

    const navigate = useNavigate()
    const pageRef = useRef()

    const { maxPage } = useSelector(state => state.card)

    const handleInputNavigate = (e) => {
        if (e.key !== 'Enter') return
        let targetPage = pageRef?.current.value
        if (targetPage < 1) {
            pageRef.current.value = 1
            targetPage = 1
            // page = 1
        }
        navigate(`/cards/${((targetPage > maxPage) ? maxPage : targetPage)}`)
    }
    const handleBtnNavigate = (isNext) => {
        if (isNext) navigate(`/cards/${(page <= maxPage) ? +page + 1 : maxPage}`)
        else navigate(`/cards/${(page < 2) ? page : +page - 1}`)
    }
    useEffect(() => {
        console.log(page >= maxPage)
        pageRef.current.value = page
    }, [page])

    return (
        <div className=' card bg-dark shadow border-light p-2 mb-4 '>
            <div className='d-flex justify-content-arount'>

                <div className='input-group d-flex justify-content-center text-light'>

                    <button
                        className='btn btn-outline-light rounded-start-pill'
                        disabled={page <= 1 || loading}
                        onClick={() => handleBtnNavigate(false)}
                    >
                        <i className='bi bi-arrow-left'></i>
                    </button>

                    <input type="number"
                        onKeyDown={handleInputNavigate}
                        ref={pageRef}
                        defaultValue={page} min={1} max={maxPage} step={1}
                        disabled={loading}
                        style={{ appearance: 'textfield', maxWidth: '5em' }}
                        className='bg-dark border border-end-0 border-light text-light text-end'
                    />

                    <p className='border border-light border-start-0 p-2 pe-4 m-0'>
                        {!!maxPage && `/ ${maxPage}`}
                    </p>

                    <button
                        className='btn btn-outline-light rounded-0 pe-4'
                        disabled={page >= maxPage || loading}
                        onClick={() => handleBtnNavigate(true)}
                    >
                        <i className='bi bi-arrow-right'></i>
                    </button>

                    <select
                        className='form-select bg-dark text-light rounded-end-pill' style={{ maxWidth: '10em' }}
                        onChange={(e) => actions.handleCardsPerPage(e.target.value)}
                    >
                        <option disabled defaultValue>{currentMax} par page</option>
                        <option value="20" >20 par page</option>
                        <option value="50" >50 par page</option>
                        <option value="100" >100 par page</option>
                    </select>
                </div>
            </div>
        </div>
    );
};

export default CardListFilter;