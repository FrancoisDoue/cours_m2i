import React, { useRef } from 'react'
import { Input } from "./Input"
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { postCandidate } from '../../service/candidates.service'
import dateStringConverter from '../../util/dateStringConverter'


const CandidateForm = () => {

    const dispatch = useDispatch()
    const navigate = useNavigate()


    const schemaRef = {
        firstname: useRef(),
        lastname: useRef(),
        identificationNumber: useRef(),
        address: useRef(),
        phone: useRef(),
        email: useRef(),
        birthDate: useRef(),
        skill: useRef(),
        technicalArea: useRef(),
    }

    const handleCandidateForm = (e) => {
        e.preventDefault()

        const formResult = {
            firstname: schemaRef.firstname.current.value,
            lastname: schemaRef.lastname.current?.value,
            identificationNumber: schemaRef.identificationNumber.current?.value,
            address: schemaRef.address.current?.value,
            phone: schemaRef.phone.current?.value,
            email: schemaRef.email.current?.value,
            birthDate: dateStringConverter(schemaRef.birthDate.current?.value),
            skill: schemaRef.skill.current?.value,
            technicalArea: schemaRef.technicalArea.current?.value
        }
        dispatch(postCandidate({body: formResult}))
        navigate("/candidates")
        console.log(formResult)
    }

  return (
    <form onSubmit={handleCandidateForm} className='w-75 p-3 bg-body border border-light-subtle shadow-sm rounded-1 mx-auto row'>
            <h3 className='mb-4'>Nouveau candidat</h3>

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
            
            <div>
                <Input name={"skill"} givenRef={schemaRef.skill} label={"Compétences"} isRequired />
            </div>
            <div>
                <Input name={"technicalArea"} givenRef={schemaRef.technicalArea} label={"Domaine technique"} isRequired />
            </div>

            <hr className='border border-light-subtle' />

            <div className='d-flex justify-content-end p-4'>
                <button type='submit' className='btn btn-primary px-5'>Enregistrer le candidat</button>
            </div>
    </form>
  )
}

export default CandidateForm