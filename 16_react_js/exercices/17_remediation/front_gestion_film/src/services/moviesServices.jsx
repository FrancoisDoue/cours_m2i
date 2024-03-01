import api from "../api/api.backend";
import { setMovies, addMovie, replaceMovie, removeMovie } from "../components/moviesSlice";

export const getMovies = async (dispatch) => {
    const res = await api.get('/')
    dispatch(setMovies(res))
    return res 
}

export const postMovie = async (dispatch, values) => {
    const res = await api.post('/add-movie', values)
    dispatch(addMovie(res))
    return res
}

export const putMovie = async (dispatch, id, values) => {
    const res = await api.put(`/update-movie/${id}`, values)
    dispatch(replaceMovie({id: res._id, movie: res}))
    return res
}

export const deleteMovie = async (dispatch, id) => {
    const res = await api.delete(`/delete-movie/${id}`)
    dispatch(removeMovie(id))
    return res
}
