import {configureStore} from '@reduxjs/toolkit'
import authSlice from './components/auth/authSlice'
import albumSlice from './components/albums/albumSlice'

export default configureStore({
    reducer:{
        auth: authSlice,
        album: albumSlice,
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false
    })
})