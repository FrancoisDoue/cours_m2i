import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { selectIsLogged } from '../auth/authSlice';
import { useNavigate } from 'react-router-dom';
import { deleteAlbum } from './albumSlice';

const AlbumItem = ({album}) => {

    const isLogged = useSelector(selectIsLogged)
    const token = useSelector(state => state.auth.user?.idToken)
    const navigate = useNavigate()
    const dispatch = useDispatch()

    const handleDelete = () => {
        if(isLogged){
            const request = {id: album.id, token: token}
            dispatch(deleteAlbum(request))
        }
    }

    return (
        <div className='card bg-dark text-light border-light m-2' style={{width: '30%', minWidth: '300px'}}>
            <div className='card-header p-0'>
                <img src={album.cover} alt="" className='w-100 rounded-top'/>
            </div>
            <div className="card-content p-2 pb-0">
                <h4 className='card-title border-bottom pb-2 text-center'>{album.title}</h4>
                <div className='p-3'>
                    <div className='d-flex justify-content-between border-bottom mb-0'>
                        <p><strong>Artiste :</strong></p>
                        <p>{album.artist}</p>
                    </div>
                    <div className='d-flex justify-content-between border-bottom mb-0'>
                        <p><strong>Date de sortie :</strong></p>
                        <p>{new Date(album.release).toLocaleDateString()}</p>
                    </div>
                    <div className='d-flex justify-content-between border-bottom mb-0'>
                        <p><strong>Score :</strong></p>
                        <p>{album.score}/5</p>
                    </div>
                    <div className='d-flex justify-content-between'>
                        <p><strong>Price :</strong></p>
                        <p>{album.price} €</p>
                    </div>
                </div>
            </div>
            {isLogged && 
            <div className='card-footer border-light text-center'>
                <button 
                    onClick={() => navigate(`/album/edition/${album.id}`)}
                    className='btn btn-outline-light w-50'
                >
                    <span><i className='bi bi-pencil-square'></i> Editer</span>
                </button>
                <button 
                    onClick={handleDelete}
                    className='btn btn-outline-danger text-light w-50'
                >
                    <span><i className='bi bi-trash'></i> Supprimer</span>
                </button>
            </div>
            }
        </div>
    );
}

export default AlbumItem;
