import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import { Link, useParams } from 'react-router-dom'



const EmployeeDetailView = () => {

  const {id} = useParams()
  const {employeeList} = useSelector(state => state.employee)
  const [employee, setEmployee] = useState(employeeList.find(e => e.id == id))

  useEffect(() => {
    console.log(employee)
    setEmployee(employeeList.find(e => e.id == id))
  }, [employeeList])

  return (
  <>
    <div>
      <Link to={"/employees"}><i className="bi bi-caret-left"></i> Retour à la liste</Link>
    </div>
    <div className='row'>
      <div className="col-lg-6 p-2-md mt-2">

        <div className='card shadow-sm'>
          {employee && <>
            <div className='card-header'>
              <h4 className='card-title text-center'> {employee.firstname + " " + employee.lastname} </h4>
            </div>
            <ul className='list-group list-group-flush'>
              <li className="list-group-item d-flex justify-content-between bg-light">
                <span className='w-50 fw-light'>Poste occupé:</span>
                <span className='w-50 fw-semibold'>{employee.occupation}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>ID employé:</span>
                <span className='w-50'>{employee.identificationNumber}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Téléphone:</span>
                <span className='w-50'>{employee.phone}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Email:</span>
                <span className='w-50'>{employee.email}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Adresse postale:</span>
                <span className='w-50'>{employee.address}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Date de naissance:</span>
                <span className='w-50'>{employee.birthDate}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Salaire mensuel : </span>
                <span className='w-50'>{employee.salary} €</span>
              </li>
              <li className="list-group-item d-flex justify-content-between bg-light">
                <span className='w-50 fw-light'>Prise de poste le </span>
                <span className='w-50 fw-semibold'>{employee.contractStart}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between bg-light">
                <span className='w-50 fw-light'>Fin de contrat le </span>
                <span className='w-50 fw-semibold'>{employee.contractEnd}</span>
              </li>
              {employee?.observation && <li className="list-group-item d-flex flex-column">
                <span className='fw-light'>Observations notables : </span>
                <span className='text-wrap'>{employee.observation}</span>
              </li>
              }
              {employee.admin && 
                <li className="list-group-item bg-warning-subtle text-center fw-semibold">
                  Cet employé dispose des droits Administrateur
                </li>
              }
            </ul>
            <div className='card-footer d-flex justify-content-between'>
              <Link className='link' to={"/"}>Editer les informations</Link>
            </div>
            </>}
        </div>

      </div>
      <div className="col-lg-6 p-2-md mt-2">
          <div className='card'>
            {(employee && employee.absences) ? 
            <> 
            <div className='card-header'>
              <h4>Absences et congés</h4>
            </div> 
            <ul className='list-group list-group-flush'>
              {employee.absences.map((e, i)=> 
                <li key={i} className="list-group-item d-flex justify-content-between">
                  <span className={`${ e.holiday ? "text-success" : "text-warning"}`}>{e.holiday? "Vacances" : "Absence"}</span>
                  <span className='fw-semibold'>{e.holiday? `du ${e.absenceStart} au ${e.absenceEnd}` : e.absenceStart}</span>
                </li>
              )}
            </ul>
            </> :
            <div className='card-body'>
              <h4 className='card-title'>Aucune absence notifiée</h4>
            </div>
            }
            <div className='card-footer d-flex justify-content-end'>
              <a className='btn btn-outline-primary btn-sm'>Notifier une absence</a>
            </div>

          </div>
      </div>
    </div>
  </>
  )
}

export default EmployeeDetailView