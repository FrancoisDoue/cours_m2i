import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        user: JSON.parse(localStorage.getItem('userInfos')) || null,
        formMode: true
    },
    reducers: {
        setUser : (state, action) => {
            localStorage.setItem('userInfos', JSON.stringify(action.payload))
            state.user = action.payload
        },
        removeUser : (state) => {
            localStorage.removeItem('userInfos')
            state.user = null
        },
        setFormMode : (state) => {
            state.formMode = !state.formMode
        },

    }
})

export const {setUser, removeUser, setFormMode} = authSlice.actions

export default authSlice.reducer