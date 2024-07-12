import React, { useEffect, useRef, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link, useNavigate, useParams } from 'react-router-dom';
import CandidateCard from '../components/card/CandidateCard';
import { Input } from '../components/form/Input';
import dateStringConverter from '../util/dateStringConverter';
import { postEmployeeFromCandidate } from '../service/employee.service';

const CandidateToEmployeeView = () => {
    const { id } = useParams()
    const dispatch = useDispatch()
    const navigate = useNavigate()

    const { candidateList } = useSelector(state => state.candidate)
    const [candidate, setCandidate] = useState(candidateList.find(c => c.id == id))

    useEffect(() => {
        console.log(candidate)
        setCandidate(candidateList.find(e => e.id == id))
    }, [candidateList])

    const schemaRef = {
        contractStart: useRef(),
        contractEnd: useRef(),
        occupation: useRef(),
        password: useRef(),
        salary: useRef(),
    }

    const handleRecruitmentSubmit = (e) => {
        const resultDateEnd = schemaRef.contractEnd.current.value
        e.preventDefault()
        const formResult = {
            contractStart: dateStringConverter(schemaRef.contractStart.current.value),
            contractEnd: (!!resultDateEnd) ? dateStringConverter(schemaRef.contractEnd.current.value) : null,
            occupation: schemaRef.occupation.current.value,
            password: schemaRef.password.current.value,
            salary: parseFloat(schemaRef.salary.current.value)
        }
        dispatch(postEmployeeFromCandidate({id: candidate.id, body: formResult}))
        navigate("/employees")
    }

    return (
        <>
        <div>
            <Link to={"/candidates"}><i className="bi bi-caret-left"></i> Retour à la liste</Link>
        </div>
        {candidate && <>
        <div className='row'>
            <CandidateCard candidate={candidate} />
            <div className='col-5'>
                <form className='card mt-2 shadow-sm h-100 d-flex flex-column justify-content-between' onSubmit={handleRecruitmentSubmit}>
                    <div className='card-header bg-primary'>
                        <h5 className='card-title text-light'>Informations nécessaires</h5>
                    </div>
                    <div className='card-body'  >
                        <Input label={"Début du contrat"} type='date' givenRef={schemaRef.contractStart} isRequired />
                        <Input label="Fin du contrat" type='date' givenRef={schemaRef.contractEnd} />
                        <Input label={"Poste occupé"} givenRef={schemaRef.occupation} isRequired />
                        <Input label={"Salaire mensuel"} type='number' givenRef={schemaRef.salary} isRequired />
                        <Input label={"Mot de passe"} givenRef={schemaRef.password} />
                    </div>
                    <div className='card-footer bg-primary'>
                        <button className='btn btn-outline-light w-100'>Valider</button>
                    </div>
                </form>
            </div>
        </div>
        </>}
        </>
    );
};

export default CandidateToEmployeeView;