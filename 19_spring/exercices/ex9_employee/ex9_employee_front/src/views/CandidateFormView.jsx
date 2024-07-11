import React from 'react'
import CandidateForm from '../components/form/CandidateForm'
import { Link } from 'react-router-dom'

const CandidateFormView = () => {
  return (
    <>
    <div>
      <Link to={"/candidates"}><i className="bi bi-caret-left"></i> Retour à la liste</Link>
    </div>
    <CandidateForm />
    </>
  )
}

export default CandidateFormView