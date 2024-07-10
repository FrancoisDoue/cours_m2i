import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { deleteEmployee } from '../service/employee.service'

const EmployeeListView = () => {

    const navigate = useNavigate()
    const dispatch = useDispatch()
    const {employeeList} = useSelector(state => state.employee)

    return (
        <>
        {employeeList.map(e => 
            <div key={e.id} className='card p-4 m-1'>
                <div className='row'>
                    <div className='col-3'>
                        <p className='fs-5'>{e?.firstname}</p>
                    </div>
                    <div className='col-3'>
                        <p className='fs-5'>{e?.lastname}</p>
                    </div>
                    <div className='col-3'>
                        <p className='fs-5'>{e?.occupation}</p>
                    </div>
                    <div className='col-3 d-flex justify-content-end'>
                        <a onClick={() => navigate(`/employees/${e.id}`)} className='btn btn-outline-primary my-auto mx-2'>Détails</a>
                        <a onClick={() => dispatch(deleteEmployee(e.id))} className='btn btn-outline-danger my-auto mx-2'>Plan social</a>
                    </div>
                </div>
            </div>
        )}
        <div className='d-flex justify-content-end p-4'>
            <button onClick={() => navigate(`/new-employee`)} className='btn btn-outline-primary'>Enregistrer un nouvel employé</button>
        </div>
        </>
    )
}

export default EmployeeListView