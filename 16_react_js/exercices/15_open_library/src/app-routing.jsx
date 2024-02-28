import { createBrowserRouter } from 'react-router-dom'
import App from './App'
import BookListDisplay from './components/BookListDisplay'
import BookDetail from './components/BookDetail'

const router = createBrowserRouter([
    {path: '/', element: <App/>, children: [
        {path: '/', element: <BookListDisplay/>},
        {path: '/works/:olid', element: <BookDetail/>}
    ]}
])

export default router