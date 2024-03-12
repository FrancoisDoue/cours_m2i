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
        setTypes: (state, action) => {
            const {types} = action.payload
            state.types = types
        },
        setSubTypes: (state, action) => {
            const {subtypes} = action.payload
            state.subTypes = subtypes
        },
        setSuperTypes: (state, action) => {
            const {supertypes } = action.payload
            state.superTypes = supertypes
        },
        setFormats: (state, action) => {
            const {formats} = action.payload
            state.formats = formats
        },
    },
    extraReducers: ({addCase}) => {
        addCase(initializeFilters.fulfilled, (state, action) => {
            state.isLoading = false
            state.error = null
            // console.log('on fullfilled initializeFilters')
        })
        addCase(initializeFilters.pending, (state, action) => {
            state.error = null
            state.isLoading = true
        })
        addCase(initializeFilters.rejected, (state, action) => {
            state.isLoading = false
            console.log('case rejected')
            if(action.payload?.status > 300) state.error = action.payload
            // if(action.meta.arg?.isLoading) console.log('Already loading')
        })
    }
})


export const { setTypes, setSubTypes, setSuperTypes, setFormats} = filterSlice.actions

export default filterSlice.reducer