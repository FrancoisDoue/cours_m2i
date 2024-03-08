import { createSlice, } from '@reduxjs/toolkit'
import { fetchCards } from '../../services/cardServices'


const cardSlice = createSlice({
    name: 'card',
    initialState: {
        cardList: [],
        currentPage: null,
        maxPage: 0,
        currentCard: null,
        isLoading: false,
        error: null
    },
    reducers: {
        clearCardList: (state) => {
            state.cardList = []
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchCards.fulfilled, (state, action) => {
            const {headers} = action.payload
            state.cardList.push(action.payload)
            state.currentPage = action.payload
            state.maxPage = Math.ceil(headers['total-count'] / headers['page-size'])
            state.isLoading = false
            state.error = null
        })
        builder.addCase(fetchCards.pending, (state) => {
            state.isLoading = true
        })
        builder.addCase(fetchCards.rejected, (state, action) => {
            if (action.payload?.status) {
                state.error = action.payload
            } else {
                // Une page a été trouvée dans le store avant que l'api ne soit interrogée
                state.currentPage = action.meta.arg.findedInStore
            }
            state.isLoading = false
        })
    }
})

export const { clearCardList } = cardSlice.actions

export default cardSlice.reducer