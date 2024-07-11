import { createSlice } from "@reduxjs/toolkit";

const SLICE_NAME = 'employee'

const employeeSlice = createSlice({
    name: SLICE_NAME,
    initialState: {
        employeeList: [],
        isLoading: false,
        error: null
    },
    reducers: {
        setEmployeeList : (state, {payload}) => {
            console.log("on setEmployeeList")
            state.employeeList = payload
        },
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

export const {
    setEmployeeList,
} = employeeSlice.actions

export default employeeSlice.reducer