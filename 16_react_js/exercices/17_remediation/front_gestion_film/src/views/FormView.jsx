import React, { useEffect, useRef, useState } from 'react';
import api from '../api/api.backend';
import { useNavigate, useParams } from 'react-router-dom';
import { Input, TextArea} from '../components/FormElements';
import { useDispatch, useSelector } from 'react-redux';
import { getMovies, postMovie, putMovie } from '../services/moviesServices';


const FormView = () => {
    const navigate = useNavigate()
    const dispatch = useDispatch()
    const movies = useSelector(state => state.movies.movies)
    const {id} = useParams()
    
    const [movieToEdit, setMovieToEdit] = useState(null)

    const titleRef = useRef()
    const descriptionRef = useRef()
    const directorRef = useRef()
    const dateRef = useRef()

    const handleSubmit = (e) => {
        e.preventDefault()

        let error = false

        const newMovie = {
            title: titleRef.current.value,
            description: descriptionRef.current.value,
            director: directorRef.current.value,
            releaseDate: new Date(dateRef.current.value).toJSON(),
        }
        for (const key in newMovie) {
            if (!newMovie[key]) error = true
        }
        
        if(!error) {
            if(id && movieToEdit){
                putMovie(dispatch, id, newMovie)
            }else{
                postMovie(dispatch, newMovie)
            }
            navigate('/')
        }
    }

    useEffect(() => {
        // si pas de film dans le store, remplir le store
        if(!movies.length) getMovies(dispatch)
        setMovieToEdit(movies.find(m => m._id == id))  
    }, [movies])

    return (
        <div >
            <h3 className='border-bottom border-start border-primary-subtle p-2 ps-4 m-0'>
                {!id ? 'Add a movie': `Edit "${movieToEdit?.title}"`}
            </h3>
            <div className='w-100 pt-4 border-end border-primary-subtle'>
                <form className='w-50 m-auto pt-4 border border-primary-subtle'
                    onSubmit={handleSubmit}
                >
                    <div className='p-4'>
                        <div className='py-1'>
                            <Input type='text' label='Title' setRef={titleRef} defaultValue={
                                (id) ? movieToEdit?.title : ''
                            } setFor='title' />
                        </div>
                        <div className='py-4'>
                            <TextArea type='text' label='Description' setRef={descriptionRef} defaultValue={
                                (id) ? movieToEdit?.description : ''
                            } setFor='description' />
                        </div>
                        <div className='py-4'>
                            <Input type='text' label='Director' setRef={directorRef} setFor='director' defaultValue={
                                (id) ? movieToEdit?.director : ''
                            }/>
                        </div>
                        <div className='py-4'>
                            <Input type='date' label='Released Date' setRef={dateRef} defaultValue={
                                (id) ? movieToEdit?.releaseDate : ''
                            } setFor='date' />
                        </div>
                        <div className='py-4'>
                            <button className='btn btn-outline-primary text-light w-100'>
                                {id? 'Edit movie' :'Add movie'}
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default FormView;