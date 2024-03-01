import React from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { deleteMovie } from '../services/moviesServices';

const MovieItem = ({movie}) => {
    const navigate = useNavigate()
    const dispatch = useDispatch()
    const date = new Date(movie.releaseDate).getFullYear()

    const handleDelete = () => {
        deleteMovie(dispatch, movie._id)
    }

    return (
        <div className='card bg-dark text-light border-primary-subtle m-4' style={{width: '32em'}}>
            <div className='card-body'>
                <h3 className='card-title'>{movie.title}</h3>
                <h6 className='card-subtitle'>{date}</h6>
                <p className='card-text'>{movie.description}</p>
                <p className='card-text text-end'>Director: {movie.director}</p>
            </div>
            <div className='card-footer border-primary-subtle row m-0 input-group '>

                <button className='text-light col-6 btn btn-outline-primary border-primary-subtle' 
                    onClick={() => navigate(`/edit/${movie._id}`)}
                >
                    Edit
                </button>

                <button className='text-light col-6 btn btn-outline-danger'
                    onClick={handleDelete}
                >
                    Delete
                </button>
                
            </div>
        </div>
    );
};

export default MovieItem;