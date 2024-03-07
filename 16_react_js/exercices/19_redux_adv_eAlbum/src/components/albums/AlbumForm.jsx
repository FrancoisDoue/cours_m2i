import React, { useEffect, useRef, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux'
import { addAlbum, getAlbums, editAlbum } from './albumSlice';
import { useNavigate, useParams } from 'react-router-dom'

const AlbumForm = () => {
    const {id} = useParams()

    const dispatch = useDispatch()

    const navigate = useNavigate()
    const token = useSelector(state => state.auth.user.idToken)
    const albumList = useSelector(state => state.album.albumList)

    const coverRef = useRef()
    const titleRef = useRef()
    const artistRef = useRef()
    const releaseRef = useRef()
    const scoreRef = useRef()
    const priceRef = useRef()
    const [selectedAlbum, setSelectedAlbum] = useState(null)
    const [imgDisplay, setImgDisplay] = useState(selectedAlbum?.cover || '')

    const handleImgDisplay = () => {
        setImgDisplay(coverRef.current.value)
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        const request = {
            token: token,
            body: {
                cover: coverRef.current.value,
                title: titleRef.current.value,
                artist: artistRef.current.value,
                release: releaseRef.current.value,
                score: scoreRef.current.value,
                price: priceRef.current.value
            }
        }
        if(!!id && !!selectedAlbum) {
            request.id = id
            dispatch(editAlbum(request))
        }else {
            dispatch(addAlbum(request))
        }
        navigate('/')
    }

    useEffect(() => {
        if (!albumList.length) dispatch(getAlbums())
        if (!!id && !!albumList.length) setSelectedAlbum(albumList.find(a => a.id === id) || null)
    }, [albumList, selectedAlbum])

    return (
        <>
        <h3>{!!selectedAlbum ? 'Editer l\'album' : 'Ajouter un album'}</h3>
        <div className='card bg-dark text-white'>
            <div className='card-content p-4'>
            <form onSubmit={handleSubmit}>
                <div className='card-header border-light '>
                    <div className='d-flex'>
                        <div className='text-center w-50 border-end' style={{minHeight: "200px"}}>
                            <label htmlFor="form-cover">Cover image : </label>
                            <input type="text" className='form-control rounded-pill bg-dark text-light px-4' id='form-cover' name='form-cover'
                                defaultValue={id && (selectedAlbum?.cover || '')}
                                ref={coverRef}
                                onChange={handleImgDisplay}
                            />
                        </div>
                        <div style={{minHeight: "200px"}} className='w-50 d-flex align-items-center justify-content-center'>
                            <img src={imgDisplay || selectedAlbum?.cover} alt="" height={200}/>
                        </div>

                    </div>

                </div>
                <div className='d-flex flex-wrap justify-content-around mb-4'>
                    <div className='col-12'>
                        <h4 className='text-center mt-3'>Titre :</h4>
                        <div className='input-group'>
                            <input type="text" className='form-control rounded-pill bg-dark text-light px-4' id='album-artist' name='album-artist'
                                ref={titleRef}
                                defaultValue={id && (selectedAlbum?.title || '')}
                            />
                        </div>
                        <hr />
                    </div>
                    <div className='col-5'>
                        <label htmlFor="album-artist" className='p-2'>Artiste : </label>
                        <div className='input-group'>
                            <input type="text" className='form-control rounded-pill bg-dark text-light px-4' id='album-artist' name='album-artist'
                                ref={artistRef}
                                defaultValue={selectedAlbum?.artist || ''}
                            />
                        </div>
                    </div>
                    <div className='col-5'>
                        <label htmlFor="album-release" className='p-2'>Date de sortie </label>
                        <div className='input-group'>
                            <input type="date" className='form-control rounded-pill bg-dark text-light px-4' id='album-release' name='album-release'
                                ref={releaseRef}
                                defaultValue={selectedAlbum?.release || ''}
                            />
                        </div>
                    </div>
                    <div className='col-5'>
                        <label htmlFor="album-score" className='p-2'>Score: </label>
                        <div className='input-group'>
                            <input type="number" step={.5} max={5} min={0} className='form-control rounded-pill bg-dark text-light px-4' id='album-score' name='album-score'
                                ref={scoreRef}
                                defaultValue={`${selectedAlbum?.score || ''}`}
                            />
                        </div>
                    </div>
                    <div className='col-5'>
                        <label htmlFor="album-price" className='p-2'>Prix: </label>
                        <div className='input-group'>
                            <input type="number" step={.01} min={0} className='form-control rounded-start-pill bg-dark text-light ps-4' id='album-price' name='album-price'
                                ref={priceRef}
                                defaultValue={`${selectedAlbum?.price || ''}`}
                            />
                            <div className='input-group-prepend'>
                                <div className='input-group-text rounded-end-pill bg-dark text-light pe-4'>€</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className='card-footer border-light text-center pb-1'>
                    <button
                        className='btn btn-outline-light w-50'
                    >{!!selectedAlbum ? 'Editer' : 'Ajouter'}</button>
            </div>
            </form>
                
            </div>

        </div>
        </>
    );
}

export default AlbumForm;
