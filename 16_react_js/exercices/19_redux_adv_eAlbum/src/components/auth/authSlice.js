import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import axios from 'axios'

export const sendCredentials = createAsyncThunk(
    'auth/sendCredentials',
    async (request, {rejectWithValue}) => axios.post(request.url, request.body)
        .then(res => res.data)
        .catch(e => rejectWithValue(e.response?.data?.error))
)

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        formMode: true,
        user: JSON.parse(localStorage.getItem('userInfos'))|| null,
        isLoading: false,
        error: null
    },
    reducers: {
        setFormMode : (state) => {
            state.formMode = !state.formMode
        },
        logout: (state) => {
            state.user = null
            localStorage.removeItem('userInfos')
        }
    },
    extraReducers: (builder) => {
        builder.addCase(sendCredentials.fulfilled, (state, action) => {
            state.error = null
            state.isLoading = false
            console.log('loggin success')
            action.payload.expiresIn = +action.payload.expiresIn * 1000 + Date.now()
            localStorage.setItem('userInfos', JSON.stringify(action.payload))
            state.user = action.payload
        })
        builder.addCase(sendCredentials.rejected, (state, action) => { 
            console.log('rejected')
            state.isLoading = false
            state.error = action.payload 
        })
        builder.addCase(sendCredentials.pending, (state) => { 
            console.log('is pending')
            state.isLoading = true
        })
    }
})

export const selectIsLogged = (state) => (!!state.auth.user && state.auth.user?.expiresIn > Date.now())

export const { setFormMode, logout } = authSlice.actions

export default authSlice.reducer