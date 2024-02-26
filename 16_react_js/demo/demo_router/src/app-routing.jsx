import {createBrowserRouter} from 'react-router-dom'
import HomePage from './components/HomePage.jsx'
import FormPage from './components/FormPage.jsx'
import ErrorPage from './components/ErrorPage.jsx'
import Navbar from './components/Navbar.jsx'

const router = createBrowserRouter([
    {
        path: '/', 
        element: <Navbar/>, 
        errorElement: <ErrorPage/>, 
        children:[
            {path: '/', element: <HomePage />},
            {path: '/form', element: <FormPage />}
        ]
    }
])

export default router