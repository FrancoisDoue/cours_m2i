import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import axios from 'axios'

export const sendCredentials = createAsyncThunk(
    'auth/sendCredentials',
    async (url, credentials) => {
        try {
            const response = await axios.post(url, credentials)
            return response
        } catch (error) {
            return error
        }
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