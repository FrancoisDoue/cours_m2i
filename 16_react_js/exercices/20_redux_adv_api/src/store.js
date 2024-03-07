import { configureStore } from '@reduxjs/toolkit'
import cardSlice from './components/cards/cardSlice'

export default configureStore({
    reducer: {
        card: cardSlice,
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false
    })
})