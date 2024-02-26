import {createBrowserRouter} from 'react-router-dom'
import App from '../App'
import ContactDisplay from '../components/ContactDisplay'
import ContactForm from '../components/ContactForm'
import Contact from '../components/Contact'


const router = createBrowserRouter([
    {path: '/', element: <App />},
    {path: '/contact', element: <Contact />, children: [
        {path: '/contact/', element: <ContactDisplay />},
        {path: '/contact/edit/', element: <ContactForm />},
        {path: '/contact/edit/:id', element: <ContactForm />}
    ]}
])

export default router