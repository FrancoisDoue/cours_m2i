import { createSlice } from '@reduxjs/toolkit'
import { initializeFilters } from '../../services/filterSevices'

const filterSlice = createSlice({
    name: 'filter',
    initialState: {
        filters: {},
        types: [],
        subTypes: [],
        superTypes: [],
        formats: [],
        isLoading: false,
        error: null
    },
    reducers: {

    },
    extraReducers: ({addCase}) => {
        addCase(initializeFilters.fulfilled, (state, action) => {
            console.log('on fullfilled initializeFilters')
        })
    }
})

export const {  } = filterSlice.actions

export default filterSlice.reducer