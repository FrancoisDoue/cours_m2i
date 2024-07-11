import React, { useRef } from 'react'
import { Input } from './Input'
import { useDispatch } from 'react-redux'
import { updateCandidate } from '../../service/candidates.service'

const CandidateEvaluationForm = ({candidate, action}) => {

    const dispatch = useDispatch()

    const schemaRef = {
        rating: useRef(),
        observation: useRef(),
    }

    const handleEvaluationSubmit = (e) => {
        e.preventDefault()
        const result = {
            rating: parseInt(schemaRef.rating.current.value),
            observation: schemaRef.observation.current.value,
        }
        const formResult = {...candidate, ...result}
        dispatch(updateCandidate({id: formResult.id, body: formResult}))
        action.toggleNotation()
        console.log(formResult)
    }

    return (
        <form onSubmit={handleEvaluationSubmit} className='card shadow-sm'>
            <div className='card-header'>
                <h4 className='card-title'>Evaluation</h4>
            </div>
            <div className='card-body'>
                <Input label='Note' type='number' givenRef={schemaRef.rating} value={candidate.rating} />
                <Input label="Observations complémentaires" givenRef={schemaRef.observation} value={candidate.observation} />
            </div>
            <div className='card-footer d-flex justify-content-between'>
                <a className='btn btn-outline-danger' onClick={action.toggleNotation}>Annuler</a>
                <button className='btn btn-primary' type="submit">Modifier</button>
            </div>
        </form>
    )
}

export default CandidateEvaluationForm