import { createBrowserRouter } from "react-router-dom";
import Layout from "../components/shared/Layout";
import EmployeeListView from "../views/EmployeeListView";
import EmployeeFormView from "../views/EmployeeFormView";
import EmployeeDetailView from "../views/EmployeeDetailView";
import CandidateListView from "../views/CandidateListView";
import CandidateFormView from "../views/CandidateFormView";
import CandidateDetailView from "../views/CandidateDetailView";
import CandidateToEmployeeView from "../views/CandidateToEmployeeView";
import LoginView from "../views/LoginView";
import ProtectedRoute from "./ProtectedRoute";

export default createBrowserRouter([
    {path: '/', element: <Layout />, children: [
        {path: '/', element: <LoginView/>},
        {path: '/new-employee', element: <ProtectedRoute><EmployeeFormView /></ProtectedRoute>},
        {path: '/employees', element: <ProtectedRoute><EmployeeListView /></ProtectedRoute>},
        {path: '/employees/:id', element: <ProtectedRoute><EmployeeDetailView /></ProtectedRoute>},
        {path: '/candidates', element: <ProtectedRoute><CandidateListView /></ProtectedRoute>},
        {path: '/new-candidate', element: <ProtectedRoute><CandidateFormView /></ProtectedRoute>},
        {path: '/candidates/:id', element: <ProtectedRoute><CandidateDetailView /></ProtectedRoute>},
        {path: '/recruit/:id', element: <ProtectedRoute><CandidateToEmployeeView /></ProtectedRoute>},
    ]}
])