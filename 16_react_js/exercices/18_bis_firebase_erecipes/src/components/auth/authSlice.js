import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        user: JSON.parse(localStorage.getItem('userInfos')) || null,
        formMode: true
    },
    reducers: {
        setUser : (state, action) => {
            action.payload.expiresIn = +action.payload.expiresIn * 1000 + Date.now()
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

export const selectIsLogged = (state) => (!!state.auth.user && state.auth.user?.expiresIn > Date.now())

export const selectToken = (state) => {
    if (!state.auth.user) return ''
    else return state.auth.user.idToken
}

export const {setUser, removeUser, setFormMode} = authSlice.actions

export default authSlice.reducer