import React, { useEffect, useRef } from 'react'
import { Input } from "./Input"
import { useDispatch, useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { postEmployee } from '../../service/employee.service'
import dateStringConverter from '../../util/dateStringConverter'

const EmployeeForm = () => {

    const navigate = useNavigate()
    const dispatch = useDispatch()
    const {currentEmployee, error} = useSelector(state => state.employee)
    
    const schemaRef = {
        firstname: useRef(),
        lastname: useRef(),
        identificationNumber: useRef(),
        address: useRef(),
        phone: useRef(),
        email: useRef(),
        birthDate: useRef(),
        // observation: useRef(),
        contractStart: useRef(),
        contractEnd: useRef(),
        occupation: useRef(),
        salary: useRef(),
    }

    const handleEmployeeForm = (e) => {
        e.preventDefault()
        const formResult = {
            firstname: schemaRef.firstname.current.value,
            lastname: schemaRef.lastname.current?.value,
            identificationNumber: schemaRef.identificationNumber.current?.value,
            address: schemaRef.address.current?.value,
            phone: schemaRef.phone.current?.value,
            email: schemaRef.email.current?.value,
            birthDate: dateStringConverter(schemaRef.birthDate.current?.value),
            contractStart: dateStringConverter(schemaRef.contractStart.current?.value),
            contractEnd: dateStringConverter(schemaRef.contractEnd.current?.value),
            occupation: schemaRef.occupation.current?.value,
            salary: schemaRef.salary.current?.value,
        }

        console.log(formResult)
        dispatch(postEmployee({body: formResult}))
        navigate("/employees")
    }

    return (
        <form onSubmit={handleEmployeeForm} className='w-75 p-3 bg-body border border-light-subtle shadow-sm rounded-1 mx-auto row'>
            <h3 className='mb-4'>Nouvel employé</h3>

            <div>
                <Input name={"identification"} givenRef={schemaRef.identificationNumber} label={"Numéro d'identification"} isRequired />
            </div>
            <div className='col-6'>
                <Input name={"lastname"} givenRef={schemaRef.lastname} label={"Nom"} isRequired />
            </div>
            <div className='col-6'>
                <Input name={"firstname"} givenRef={schemaRef.firstname} label={"Prénom"} isRequired />
            </div>
            <div className='col-6'>
                <Input type={"date"} name={"birthDate"} givenRef={schemaRef.birthDate} label={"Date de naissance"} isRequired />
            </div>
            <div className='col-6'>
                <Input name={"phone"} givenRef={schemaRef.phone} label={"Numéro de téléphone"} isRequired />
            </div>
            <div className='col-6' >
                <Input name={"address"} givenRef={schemaRef.address} label={"Adresse"} isRequired />
            </div>
            <div className='col-6' >
                <Input name={"email"} type={"email"} givenRef={schemaRef.email} label={"Adresse email"} isRequired />
            </div>

            <hr className='border border-light-subtle' />

            <div className='col-6'>
                <Input name={"occupation"} givenRef={schemaRef.occupation} label={"Poste"} isRequired />
            </div>
            <div className='col-6'>
                <Input name={"salary"} type={"number"} givenRef={schemaRef.salary} label={"Salaire"} isRequired />
            </div>
            <div className='col-6'>
                <Input type={"date"} name={"contractStart"} givenRef={schemaRef.contractStart} label={"Début du contrat"} isRequired />
            </div>
            <div className='col-6'>
                <Input type={"date"} name={"contractEnd"} givenRef={schemaRef.contractEnd} label={"Fin du contrat"} isRequired />
            </div>

            <hr className='border border-light-subtle' />

            <div className='d-flex justify-content-end p-4'>
                <button type='submit' className='btn btn-primary px-5'>Enregistrer l'employé</button>
            </div>

        </form>
    )
}

export default EmployeeForm