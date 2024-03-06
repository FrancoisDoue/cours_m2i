import { createBrowserRouter } from 'react-router-dom'
import App from './App'
import Login from './components/auth/Login'
import AlbumListDisplay from './components/albums/AlbumListDisplay'
import ProtectedRoute from './components/ProtectedRoute'
import AlbumForm from './components/albums/AlbumForm'

const router = createBrowserRouter([
    { path: '/', element: <App />, children: [
        { path: '/login', element: <Login /> },
        { path: '/', element: <AlbumListDisplay />},
        { path: '/album/edition', element: <ProtectedRoute> <AlbumForm /> </ProtectedRoute>},
        { path: '/album/edition/:id', element: <ProtectedRoute> <AlbumForm /> </ProtectedRoute>}
    ]}
])

export default router