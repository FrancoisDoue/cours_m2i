import { createSlice } from "@reduxjs/toolkit";

const SLICE_NAME = 'candidate'

const candidateSlice = createSlice({
    name: SLICE_NAME,
    initialState: {
        candidateList: [],
        isLoading: false,
        error: null
    },
    reducers: {
        setCandidateList: (state, {payload}) => {
            console.log("on setCandidateList")
            console.log(payload)
            state.candidateList = payload
        },
        replaceCandidate: (state, {payload}) => {
            console.log("on replaceCandidate")
            console.log(payload)
            state.candidateList = state.candidateList.map(e => (e.id == payload.id) ? payload : e)
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

export const {
    setCandidateList,
    replaceCandidate,
} = candidateSlice.actions

export default candidateSlice.reducer
