import { createSlice } from '@reduxjs/toolkit'
import { fetchCards } from '../../services/cardServices'

const cardSlice = createSlice({
    name: 'card',
    initialState: {
        cardList: [],
        currentCard: null,
        isLoading: false,
        error: null
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchCards.fulfilled, (state, action) => {
            state.isLoading = false
            state.cardList = action.payload
            console.log(action.payload)
        })
        builder.addCase(fetchCards.pending, (state) => {
            state.isLoading = true
        })
        builder.addCase(fetchCards.rejected, (state) => {
            state.isLoading = false
            state.error = action.payload
            state.cardList = [...state.cardList]
        })
    }
})


export default cardSlice.reducer