import {createBrowserRouter} from 'react-router-dom'
import App from './App'
import TaskDisplay from './components/TaskDisplay'

const router = createBrowserRouter([
    {path: '/', element: <App />, children: [
        {path:'/', element: <TaskDisplay />},
        // {path '/add', element: </>}
    ]}
])
export default router