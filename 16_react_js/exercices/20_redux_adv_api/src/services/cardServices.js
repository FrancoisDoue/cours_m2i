import { createAsyncThunk } from "@reduxjs/toolkit"
import api from './api.backend'
import { CARDS_URI } from "../constants/backendUrl"

export const fetchCards = createAsyncThunk(
    "card/fetchCards", async (request, {rejectWithValue}) => api.get(CARDS_URI, {
            params: { contains: 'imageUrl', ...request }
        })
        .then((res) => ( { page: request.page, cards: res.cards, headers: {...res.headers} } ))
        .catch((err) => {
            throw rejectWithValue(err)
        }),
    {
        // Si la condition est validée, fetchCards ne sera pas exécutée
        // ici, si une page est dans le store, elle sera traitée dans en .rejected dans les extraReducers et la requête ne sera pas envoyée
        condition: (request, {getState}) => {
            const {card} = getState()
            const storeResult = card.cardList.find(c => c.page == request.page)
            if (!!storeResult) {
                request.findedInStore = storeResult
            }
            return !storeResult
        },
        dispatchConditionRejection: true
    }
)