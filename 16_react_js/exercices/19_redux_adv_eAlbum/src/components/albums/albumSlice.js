import { createAsyncThunk, createSlice } from "@reduxjs/toolkit"
import api from '../../api/api.backend'

export const addAlbum = createAsyncThunk(
    "album/addAlbum",
    async (request, {rejectWithValue}) => api.post(`albums.json?auth=${request.token}`, request.body)
        .then(res => ({id: res.name, ...request.body}))
        .catch(rejectWithValue)
)
export const getAlbums = createAsyncThunk(
    "album/getAlbums",
    async (_request, {rejectWithValue}) => api.get(`albums.json`)
        .then(res => {
            const setAlbums = []
            for (const key in res) {
                setAlbums.push ({id: key, ...res[key]})
            }
            return setAlbums
        })
        .catch(rejectWithValue)
)
export const editAlbum = createAsyncThunk(
    "album/editAlbum",
    async (request, {rejectWithValue}) => 
        api.put(`albums/${request.id}.json?auth=${request.token}`, request.body)
            .then(res =>({result: res, id: request.id}))
            .catch(rejectWithValue)
)
export const deleteAlbum = createAsyncThunk(
    "album/deleteAlbum",
    async (request, {rejectWithValue}) => api.delete(`albums/${request.id}.json?auth=${request.token}`)
        .then(() => request.id)
        .catch(rejectWithValue)
)

const albumSlice = createSlice({
    name: 'album',
    initialState: {
        albumList: [],
        error: null,
        isLoading: false
    },
    reducers: {

    },
    extraReducers: (builder) => {
        builder.addCase(addAlbum.fulfilled, (state, action) => {
            state.albumList.push(action.payload)
        })
        builder.addCase(getAlbums.fulfilled, (state, action) => {
            state.albumList = action.payload
        })
        builder.addCase(editAlbum.fulfilled, (state, action) => {
            const {result, id} = action.payload
            const index = state.albumList.findIndex(a => a.id == id )
            state.albumList[index] = {id:id, ...result}
        })
        builder.addCase(deleteAlbum.fulfilled, (state, action) => {
            state.albumList = state.albumList.filter(a => a.id != action.payload)
        })
    }
})

export const { } = albumSlice.actions

export default albumSlice.reducer