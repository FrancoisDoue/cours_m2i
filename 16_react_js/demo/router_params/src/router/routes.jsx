import {createBrowserRouter} from 'react-router-dom'
import HomeView from '../views/HomeView'
import ProductView from '../views/ProductView'

const routes = createBrowserRouter([
    {path: '/', element: <HomeView/>},
    {path: '/product/:productId', element: <ProductView />}
])

export default routes