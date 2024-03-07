import { createAsyncThunk } from "@reduxjs/toolkit"
import api from './api.backend'
import { CARDS_URI } from "../constants/backendUrl"

export const fetchCards = createAsyncThunk(
    "card/fetchCards", async (request, {getState, rejectWithValue}) => {
        const {card} = getState()
        console.log(card)
        const storeResult = card.cardList.find(c => c.page == request.page)
        console.log('store res', storeResult)
        // console.log(card.cardList.find(c => c.page == request.page))
        if (!!storeResult) return {inStore: true, result: storeResult}

        return api.get(CARDS_URI, {
            params: {
                contains: 'imageUrl',
                page: request?.page || 1, 
                pageSize: 20
            }
        })
        .then(res => {
            const result = {
                inStore: false,
                result: {
                    page: request.page || 1, 
                    cards: res.cards
                }
            }
            console.log(result)
            return result
        })
        .catch(rejectWithValue)
})