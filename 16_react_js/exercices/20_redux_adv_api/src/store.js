import { configureStore } from '@reduxjs/toolkit'
import cardSlice from './components/cards/cardSlice'
import filterSlice from './components/filterTools/filterSlice'

export default configureStore({
    reducer: {
        card: cardSlice,
        filter: filterSlice,
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false
    })
})