import { createSlice } from '@reduxjs/toolkit'

const moviesSlice = createSlice({
    name: 'movies',
    initialState: {
        movies: []
    },
    reducers: {
        setMovies: (state, action) => {
            state.movies = [...action.payload]
        },
        addMovie: (state, action) => {
            state.movies.push(action.payload)
        },
        replaceMovie: (state, action) => {
            const i = state.movies.findIndex(m => m._id == action.payload.id)
            state.movies[i] = action.payload.movie
        },
        removeMovie: (state, action) => {
            state.movies = state.movies.filter(m => m._id != action.payload)
        }
    }
})

export const {setMovies, addMovie, replaceMovie, removeMovie} = moviesSlice.actions

export default moviesSlice.reducer