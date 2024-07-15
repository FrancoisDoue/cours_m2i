import { createSlice } from "@reduxjs/toolkit";

const SLICE_NAME = 'auth'

const authSlice = createSlice({
    name: SLICE_NAME,
    initialState: {
        user: null,
        isLoading: false,
        error: null,
    },
    reducers: {
        setUser: (state, {payload}) => {
            state.user = payload
        },
        logout: (state) => {
            state.user = null
        }
    },
    extraReducers: ({addMatcher}) => {
        addMatcher(({type}) => (type.endsWith('/fulfilled') && type.startsWith(SLICE_NAME)), (state) => {
            state.isLoading = false
            state.error = null
        })
        addMatcher(({type}) => (type.endsWith('/pending') && type.startsWith(SLICE_NAME)), (state) => {
            state.isLoading = true
        })
        addMatcher(({type}) => (type.endsWith('/rejected') && type.startsWith(SLICE_NAME)), (state, action) => {
            state.isLoading = false
            state.error = action.error
        })
    }
})

export const isLoggedSelector = (state) => state[SLICE_NAME]?.user != null

export const isAdminSelector = (state) => !!state[SLICE_NAME]?.user?.admin

export const {
    setUser,
    unsetUser
} = authSlice.actions

export default authSlice.reducer