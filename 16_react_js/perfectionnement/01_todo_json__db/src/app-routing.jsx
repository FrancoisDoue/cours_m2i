import { createBrowserRouter } from 'react-router-dom'
import App from './App'
import TodosViews from './views/TodosViews'
import ErrorView from './views/ErrorView'

const router = createBrowserRouter([
    {path: '/', element: <App />, errorElement: <ErrorView />, children: [
        {path: '/', element: <TodosViews />}
    ]}
])

export default router