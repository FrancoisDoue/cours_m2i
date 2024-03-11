import React, { useRef, useState } from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux'
import { fetchCards } from '../../services/cardServices';
import CardListItem from './CardListItem';
import { useParams } from 'react-router-dom';
import LoadingComponent from '../shared/LoadingComponent';
import Paginator from '../filterTools/Paginator'
import { clearCardList } from './cardSlice';
import FilterSider from '../filterTools/FilterSider';

const CardsMain = () => {
    const dispatch = useDispatch()
    const {page = '1'} = useParams() 
    const {currentPage, isLoading, error} = useSelector(state => state.card)
    const [maxInPage, setMaxInpage] = useState('20')

    const handleCardsPerPage = (number) => setMaxInpage(number)

    const fetchCardList = () => {
        !isLoading && dispatch(fetchCards({page: page, pageSize: maxInPage}))
    }

    useEffect(fetchCardList, [page])

    useEffect(() => {
        dispatch(clearCardList())
        fetchCardList()
    }, [maxInPage])

    return (
        <>
            <Paginator page={page} loading={isLoading} actions={{handleCardsPerPage}} currentMax={maxInPage}/>

            <div className='row flex-fill'>
                <div className='col-9 flex-fill d-flex flex-wrap justify-content-around'>
                {isLoading ? 
                    <LoadingComponent /> :
                    <>
                        {error && <h5>Do something with error ...</h5> }
                    
                        {!isLoading && !!currentPage?.cards?.length && 
                            currentPage?.cards.map(card => <CardListItem card={card} key={card.id} /> ) 
                        }
                    </>
                }
                </div>
                <FilterSider />
            </div>
            {!isLoading && <Paginator page={page} loading={isLoading} actions={{handleCardsPerPage}} currentMax={maxInPage}/>}
            
        </>
    );
}

export default CardsMain;
