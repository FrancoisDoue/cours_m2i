import {createBrowserRouter} from 'react-router-dom'
import App from './App'
import Form from './components/Form'
import ProtectedRoute from './components/ProtectedRoute'
import Compte from './components/Compte'

const router = createBrowserRouter([
    {path: '/', element: <App />},
    {path: '/login', element: <Form />},
    {path: '/account', element: (
        <ProtectedRoute> 
            <Compte /> 
        </ProtectedRoute>
    )}
])

export default router