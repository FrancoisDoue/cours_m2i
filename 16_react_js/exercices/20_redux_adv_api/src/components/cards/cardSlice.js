import { createSlice } from '@reduxjs/toolkit'
import { fetchCards } from '../../services/cardServices'

const cardSlice = createSlice({
    name: 'card',
    initialState: {
        cardList: [],
        currentPage: null,
        currentCard: null,
        isLoading: false,
        error: null
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchCards.fulfilled, (state, action) => {
            console.log('on extra reducer success')
            const {inStore, result} = action.payload
            if (!inStore) {
                state.cardList.push(result)
                state.currentPage = result.cards
            }else{
                console.log('already in store!')
                state.currentPage = result
            }
            state.isLoading = false
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