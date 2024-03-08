import { createBrowserRouter } from 'react-router-dom'
import HomeView from './views/HomeView'
import CardsMain from './components/cards/CardsMain'


const router = createBrowserRouter([
    {path: '/', element: <HomeView />, children: [
        {path: '/', element: <CardsMain /> },
        {path: '/cards/:page', element: <CardsMain /> },
    ]}
])

export default router