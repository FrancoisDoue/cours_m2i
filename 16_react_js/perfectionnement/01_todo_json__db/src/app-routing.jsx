import { createBrowserRouter } from 'react-router-dom'
import App from './App'
import TodosViews from './views/TodosViews'

const router = createBrowserRouter([
    {path: '/', element: <App />, children: [
        {path: '/', element: <TodosViews />}
    ]}
])

export default router