import { createBrowserRouter } from "react-router-dom"
import DefaultLayout from "./views/DefaultLayout"
import HomeView from "./views/HomeView"
import FormView from "./views/FormView"

const router = createBrowserRouter([
    {path: '/', element:  <DefaultLayout />, children: [
        {path: '/', element: <HomeView />},
        {path: '/add', element: <FormView />},
        {path: '/edit/:id', element: <FormView />}
    ]}
])

export default router