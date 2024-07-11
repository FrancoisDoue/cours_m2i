import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Link, useNavigate } from 'react-router-dom'
import { deleteCandidate } from '../service/candidates.service'

const CandidateListView = () => {

  const dispatch = useDispatch()
  const {candidateList} = useSelector(state => state.candidate)
  return (
    <>
    <div className='px-4 row'>
      <h4 className='col-2'>Prénom</h4>
      <h4 className='col-2'>Nom</h4>
      <h4 className='col-2'>Compétences</h4>
      <h4 className='col-2'>Domaine</h4>
      <h4 className='col-4 text-center'>Actions</h4>

    </div>
    {candidateList && candidateList.map(c => 
      <div key={c.id} className='card p-4 m-1'>
        <div className='row'>
          <div className='col-2'>
            <p className='fs-5'>{c?.firstname}</p>
          </div>
          <div className='col-2'>
            <p className='fs-5'>{c?.lastname}</p>
          </div>
          <div className='col-2'>
            <p className='fs-5'>{c?.skill}</p>
          </div>
          <div className='col-2'>
            <p className='fs-5'>{c?.technicalArea}</p>
          </div>
          <div className='col-4 d-flex justify-content-end'>
            <Link to={`/candidates/${c.id}`} className='btn btn-outline-primary my-auto mx-2' >Détails</Link>
            <a onClick={() => dispatch(deleteCandidate(c.id))} className='btn btn-outline-danger my-auto mx-2' >Supprimer la candidature</a>
          </div>
        </div>
        
      </div>
    )}
    <div className='d-flex justify-content-end p-4'>
      <Link to={"/new-candidate"} className='btn btn-outline-primary'>Enregistrer un candidat</Link>      
    </div>
    </>
  )
}

export default CandidateListView