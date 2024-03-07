import { createAsyncThunk } from "@reduxjs/toolkit"
import api from './api.backend'
import { CARDS_URI } from "../constants/backendUrl"

export const fetchCards = createAsyncThunk(
    "card/fetchCards",
    async (request) => api.get(CARDS_URI, {
        params: {
            contains: 'imageUrl',
            page: request?.page || 1, 
            pageSize: 20
        }
    })
    .then(res => res.cards)
    .catch(console.error)
)