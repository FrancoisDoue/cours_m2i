import {createBrowserRouter} from 'react-router-dom'
import ErrorComonent from './components/ErrorComonent'
import App from './App'
import ContactView from './views/ContactView'
import ContactEditView from './views/ContactEditView'

const router = createBrowserRouter([
    {path: '/', errorElement: <ErrorComonent />, children: [
        {path: '/', element: <App />, children: [
            {path: '/contacts', element: <ContactView />},
            {path: '/contacts/edit', element: <ContactEditView />}
        ]}
    ]}
])

export default router