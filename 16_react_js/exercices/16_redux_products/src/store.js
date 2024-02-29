import {configureStore} from '@reduxjs/toolkit'
import productsSlice from './components/productsSlice'

export default configureStore({
    reducer: {
        products: productsSlice
    }
})