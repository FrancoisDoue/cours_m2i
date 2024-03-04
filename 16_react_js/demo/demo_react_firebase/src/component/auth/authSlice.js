import {createSlice} from '@reduxjs/toolkit'

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        user: null,
        authMode: true
    },
    reducers: {
        setUser: (state, action) => {
            state.user = action.payload
        },
        removeUser : (state, _action) => {
            state.user = null
            localStorage.removeItem('token')
        },
        setAuthMode : (state, action) => {
            state.authMode = action.payload
        }
    }
})

export const { setUser, removeUser, setAuthMode } = authSlice.actions

export default authSlice.reducer