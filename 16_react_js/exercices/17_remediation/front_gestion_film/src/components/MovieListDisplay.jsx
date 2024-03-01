import React, { useEffect, useRef, useState } from 'react';
import MovieItem from './MovieItem';
import { useSelector } from 'react-redux';
import { getMovies } from '../services/moviesServices.jsx';
import { useDispatch } from 'react-redux';

const MovieListDisplay = () => {

    const movies = useSelector(state => state.movies.movies)
    const dispatch = useDispatch()
    const [searchResult, setSearchResult] = useState([])
    const searchRef = useRef()

    const handleInput = () => {
        const search = searchRef.current.value.toLowerCase()
        setSearchResult(
            [...movies.filter(movie => movie.title.toLowerCase().includes(search))]
        )
    }

    useEffect(() => {
        // si pas de film dans le movies, remplir movies
        if (!movies.length) getMovies(dispatch)
        setSearchResult(movies)
    }, [movies])


    return (
        <div >
            <div className='container'>
                <div className='input-group '>
                    <input
                        onInput={handleInput}
                        className='form-control bg-dark text-light border-primary-subtle'
                        type="text"
                        ref={searchRef}
                    />
                    <button
                        onClick={handleInput}
                        className='btn text-light border-primary-subtle'
                    >
                        <i className="bi bi-search"></i>
                    </button>
                </div>
            </div>
            <div className='mt-4 pt-4 d-flex flex-wrap justify-content-center '>
            {!!searchResult.length ? 
                searchResult.map(m => 
                    <MovieItem key={m._id} movie={m}/>
                )
                :
                <div className='p-4'>
                    <h4>No result</h4>
                </div>
            }
            </div>
        </div>
    );
};

export default MovieListDisplay;