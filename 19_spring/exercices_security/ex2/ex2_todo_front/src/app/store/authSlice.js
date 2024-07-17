import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
    name: "auth",
    initialState: {
        user: null,
        isLogged: false,
        roles: [],
        isLoading: false,
        error: null,
    },
    reducers: {
        initializeLogin: (action, {payload}) => {
            
        },

    },
    extraReducers: ({addMatcher}) => {
        addMatcher(({type}) => (type.endsWith('/fulfilled') && type.startsWith("auth")), (state) => {
            state.isLoading = false
            state.error = null
        })
        addMatcher(({type}) => (type.endsWith('/pending') && type.startsWith("auth")), (state) => {
            state.isLoading = true
        })
        addMatcher(({type}) => (type.endsWith('/rejected') && type.startsWith("auth")), (state, action) => {
            state.isLoading = false
            state.error = action.error
        })
    }
})


export const {
    initializeLogin
} = authSlice.actions

export default authSlice.reducer