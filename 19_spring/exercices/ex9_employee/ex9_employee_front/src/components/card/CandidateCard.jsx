import React from 'react';

const CandidateCard = ({candidate}) => {
    return (
        <div className="col-7 p-2-md mt-2">
          <div className='card shadow-sm'>
            <div className='card-header'>
              <h4 className='card-title text-center'> {candidate.firstname + " " + candidate.lastname} </h4>
            </div>
            <ul className='list-group list-group-flush'>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>ID Candidat:</span>
                <span className='w-50'>{candidate.identificationNumber}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Téléphone:</span>
                <span className='w-50'>{candidate.phone}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Email:</span>
                <span className='w-50'>{candidate.email}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Adresse postale:</span>
                <span className='w-50'>{candidate.address}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <span className='w-50 fw-light'>Date de naissance:</span>
                <span className='w-50'>{candidate.birthDate}</span>
              </li>
              {candidate.skill && <>
                <li className="list-group-item bg-light">
                  <h5 className='card-title'>Compétences:</h5>
                </li>
                <li className="list-group-item text-center">
                  {candidate.skill}
                </li></>
              }
              {candidate.technicalArea && <>
                <li className="list-group-item bg-light">
                  <h5 className='card-title'>Domaine d'expertise:</h5>
                </li>
                <li className="list-group-item text-center">
                  {candidate.technicalArea}
                </li></>
              }
              {candidate?.observation && <li className="list-group-item d-flex flex-column">
                <span className='fw-light'>Observations notables : </span>
                <span className='text-wrap'>{candidate.observation}</span>
              </li>
              }
            </ul>
          </div>
        </div>
    );
};

export default CandidateCard;