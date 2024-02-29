import {createBrowserRouter} from 'react-router-dom'
import App from './App'
import TaskDisplay from './components/TaskDisplay'
import TaskForm from './components/TaskForm'

const router = createBrowserRouter([
    {path: '/', element: <App />, children: [
        {path:'/', element: <TaskDisplay />},
        {path: '/add', element: <TaskForm />},
        {path: '/edit', element: <TaskForm />}
    ]}
])
export default router