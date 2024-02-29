import { configureStore } from '@reduxjs/toolkit'
import taskSlice from './components/Task/TaskSlice'

// ici on rassemble les slices de l'applications

export default configureStore({
    reducer: {
        task: taskSlice,
    }
})