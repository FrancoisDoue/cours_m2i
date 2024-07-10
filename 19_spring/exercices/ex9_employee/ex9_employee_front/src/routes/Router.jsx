import { createBrowserRouter } from "react-router-dom";
import { HomeView } from "../views/HomeView";
import Layout from "../components/shared/Layout";
import EmployeeListView from "../views/EmployeeListView";
import EmployeeFormView from "../views/EmployeeFormView";
import EmployeeDetailView from "../views/EmployeeDetailView";

export default createBrowserRouter([
    {path: '/', element: <Layout />, children: [
        {path: '/', element: <HomeView/>},
        {path: '/new-employee', element: <EmployeeFormView />},
        {path: '/employees', element: <EmployeeListView />},
        {path: '/employees/:id', element: <EmployeeDetailView />},
    ]}
])