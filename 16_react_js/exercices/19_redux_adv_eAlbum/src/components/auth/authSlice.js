import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import axios from 'axios'

export const sendCredentials = createAsyncThunk(
    'auth/sendCredentials',
    async (request) => {
        console.log(request.body)
        return axios.post(request.url, request.body)
            .then(res => res)
            .catch(err => {
                console.log(err.response)
                return Promise.reject(err.response)
            })
    }
)

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        formMode: true,
        user: null,
        isLoading: false,
        error: null
    },
    reducers: {
        setFormMode : (state) => {
            state.formMode = !state.formMode
        },
        setUser : (state, action) => {
            console.log(action.payload)
        }
    },
    extraReducers: (builder) => {
        builder.addCase(sendCredentials.fulfilled, (state, action) => {
            console.log('on fulfilled', action.payload)
        })
        builder.addCase(sendCredentials.rejected, (state, action) => {
            console.log('on rejected', action.payload)
        })
    }
})

export const { setFormMode } = authSlice.actions

export default authSlice.reducer