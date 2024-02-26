import { createBrowserRouter } from 'react-router-dom'
import HomeView from '../views/HomeView'
import ErrorView from '../views/ErrorView'
import FormView from '../views/FormView'
import AboutView from '../views/AboutView'
import App from '../App'

const routes = createBrowserRouter([
  {path: '/', element: <App/>, errorElement: <ErrorView />, children:[
    {path: '/', element: <HomeView/>},
    {path: '/form', element: <FormView/>},
    {path: '/about', element: <AboutView/>},
  ]}
])

export default routes