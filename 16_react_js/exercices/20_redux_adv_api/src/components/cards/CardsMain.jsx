import React, { useRef, useState } from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux'
import { fetchCards } from '../../services/cardServices';
import CardListItem from './CardListItem';
import CardListFilter from '../filterTools/CardListFilter';
import { useParams } from 'react-router-dom';
import LoadingComponent from '../shared/LoadingComponent';
import Paginator from '../filterTools/Paginator'
import SearchTool from '../filterTools/SearchTool';

const CardsMain = () => {
    const dispatch = useDispatch()
    const {page = '1'} = useParams() 
    const {currentPage, isLoading, error} = useSelector(state => state.card)
    const [maxInPage, setMaxInpage] = useState('20')

    const fetchCardList = () => {
        !isLoading && dispatch(fetchCards({page: page, pageSize: maxInPage}))
    }

    useEffect(fetchCardList, [page])
    useEffect(() => {
        console.log(maxInPage)
    }, [maxInPage])

    // console.log('on page : ',paginate,'\n result => \n', currentPage)

    return (
        <>
            <CardListFilter>
                <SearchTool />
                <Paginator page={page} loading={isLoading} maxInPage={setMaxInpage}/>

            </CardListFilter>
            
            {isLoading ? 
                <LoadingComponent /> :
                <div className='flex-fill d-flex flex-wrap justify-content-around'>
                    {error && <h5>Do something with error ...</h5> }
                
                    {!isLoading && !!currentPage?.cards?.length && 
                        currentPage?.cards.map(card => <CardListItem card={card} key={card.id} /> ) 
                    }
                </div>
            }
        </>
    );
}

export default CardsMain;
