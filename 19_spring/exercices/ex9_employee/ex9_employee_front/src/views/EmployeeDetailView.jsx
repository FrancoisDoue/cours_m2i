import React from 'react'
import { useParams } from 'react-router-dom'

const EmployeeDetailView = () => {

    const {id} = useParams()
  return (
    <div>EmployeeDetailView {id}</div>
  )
}

export default EmployeeDetailView