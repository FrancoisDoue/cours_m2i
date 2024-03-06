import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getAlbums } from './albumSlice';
import AlbumItem from './AlbumItem';
import SortTool from './SortTool';

const AlbumListDisplay = () => {

    const dispatch = useDispatch()
    const albumList = useSelector(state => state.album.albumList)
    const [searchList, setSearchList] = useState(albumList || [])

    useEffect(() => {
        if(!albumList.length) dispatch(getAlbums())
        setSearchList(albumList)
    }, [albumList])

    const sortByTitle = () => {
        setSearchList([...searchList].sort((a, b) => a.title > b.title))
    }
    const sortByScore = () => {
        setSearchList([...searchList].sort((a, b) => a.score < b.score))
    }

    return (
        <div className='card bg-dark text-white'>
            <div className='card-header border-light d-flex justify-content-between'>
                <h3>Albums</h3>
                <div className='input-group w-25'>
                    <SortTool actions={{sortByTitle, sortByScore}} />
                </div>
            </div>
            <div className='card-content p-4'>
                <div className="d-flex flex-wrap justify-content-around">
                {searchList?.map(a => <AlbumItem key={a.id} album={a} /> )}
                </div>
            </div>
        </div>
    );
}

export default AlbumListDisplay;
