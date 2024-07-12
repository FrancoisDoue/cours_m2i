import React, { useRef, useState } from 'react';
import { Input } from './Input';
import dateStringConverter from "../../util/dateStringConverter"
import { useDispatch } from 'react-redux';
import { postAbsence } from '../../service/employee.service';

const AbsenceForm = ({employee, action}) => {

    const dispatch = useDispatch()

    const schemaRef = {
        absenceStart: useRef(),
        absenceEnd: useRef(),
    }

    const handleAbsenceSubmit = (e) => {
        e.preventDefault()
        if (schemaRef.absenceStart.current.value) {
            const formResult = {
                absenceStart: dateStringConverter(schemaRef.absenceStart.current.value),
                absenceEnd: !!schemaRef.absenceEnd.current.value 
                    ? dateStringConverter(schemaRef.absenceEnd.current.value)
                    : null
            }
            dispatch(postAbsence({id: employee.id, body: formResult}))
            console.log(formResult)
        }
        action.toggleAbsenceForm()
    }

    return ( <>
            <form className='card-body' onSubmit={handleAbsenceSubmit}>
                <Input type='date' label="Date de début" givenRef={schemaRef.absenceStart} isRequired />
                <Input type='date' label="Date de fin" givenRef={schemaRef.absenceEnd} />
                <button className='btn btn-primary w-100'>Ajouter absence</button>
            </form>
        </>
    );
};

export default AbsenceForm;