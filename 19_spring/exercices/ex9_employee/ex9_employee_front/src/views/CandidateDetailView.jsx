import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import { Link, useParams } from 'react-router-dom'
import CandidateEvaluationForm from '../components/form/CandidateEvaluationForm'
import CandidateInterviewCardForm from '../components/form/CandidateInterviewCardForm'
import CandidateCard from '../components/card/CandidateCard'

const CandidateDetailView = () => {
  const { id } = useParams()
  const {candidateList } = useSelector(state => state.candidate)
  const [candidate, setCandidate] = useState(candidateList.find(c => c.id == id))
  const [isEditNotation, setEditNotation] = useState(false)

  const toggleNotation = () => setEditNotation(!isEditNotation)

  useEffect(() => {
    console.log(candidate)
    setCandidate(candidateList.find(e => e.id == id))
  }, [candidateList])

  return (
    <>
      <div>
        <Link to={"/candidates"}><i className="bi bi-caret-left"></i> Retour à la liste</Link>
      </div>
      {candidate && <>

      <div className="row">
        <CandidateCard candidate={candidate} />
        <div className="col-5 p-2-md mt-2">
          <CandidateInterviewCardForm candidate={candidate} />
          {isEditNotation ?
            <CandidateEvaluationForm candidate={candidate} action={{toggleNotation}} />
            :
            <div className='card mt-4 shadow-sm'>
              <div className='card-header'>
                <h4 className='card-title'>Evaluation</h4>
              </div>
              <ul className='list-group list-group-flush'>
                {(candidate.rating || candidate.observation) ? <>
                  <li className="list-group-item d-flex justify-content-between">
                    <span className='w-50 fw-light'>Note :</span>
                    <span className='w-50'>{candidate.rating}</span>
                  </li>
                  <li className="list-group-item d-flex justify-content-between">
                    <span className='w-50 fw-light'>Observations :</span>
                    <span className='w-50 text-wrap'>{candidate.observation}</span>
                  </li></>
                  : <div className='card-body'>
                    <p className='card-text'>N'a pas encore été évalué</p>
                  </div>
                }
              </ul>
              <div className='card-footer d-flex justify-content-end'>
                <button className='btn btn-outline-primary' onClick={toggleNotation}>Editer</button>
              </div>
            </div>
          }

        </div>
      </div>
      <div className='mt-4 p-2 card shadow-sm'>
        <Link to={"/recruit/"+candidate.id} className='btn btn-outline-primary w-25 ms-auto'>Accepter la candidature</Link>
      </div>

      </>}
      
      </>
  )
}

      export default CandidateDetailView