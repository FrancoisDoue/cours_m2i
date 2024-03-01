import {configureStore} from '@reduxjs/toolkit'
import todosSlice from './components/todosSlice'

export default configureStore({
    reducer: {
        todos: todosSlice
    }
})