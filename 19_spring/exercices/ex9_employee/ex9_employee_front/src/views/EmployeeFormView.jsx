import React from 'react'
import EmployeeForm from '../components/form/EmployeeForm'
import { NavLink, Link } from 'react-router-dom'

const EmployeeFormView = () => {
  return (
    <>
    <div>
      <Link to={"/employees"}><i class="bi bi-caret-left"></i> Retour à la liste</Link>
    </div>
    <EmployeeForm />
    </>
  )
}

export default EmployeeFormView