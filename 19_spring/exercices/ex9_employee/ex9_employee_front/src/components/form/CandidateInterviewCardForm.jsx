import React, { useRef, useState } from "react";
import { Input } from "./Input";
import dateTimeStringConverter from "../../util/dateTimeStringConverter";
import { useDispatch } from "react-redux";
import { updateCandidate } from "../../service/candidates.service";

const CandidateInterviewCardForm = ({ candidate }) => {
    const dispatch = useDispatch()
    const [isEditInterview, setEditInterview] = useState(false);
    const toggleInterview = () => setEditInterview(!isEditInterview);

    const schemaRef = {
        jobInterviewDate : useRef()
    }

    const handleSubmitInterview = (e) => {
        e.preventDefault()
        const interviewValue = schemaRef.jobInterviewDate.current.value
        if (isEditInterview && interviewValue.length) {
            const candidateUpdated = {...candidate}
            candidateUpdated.jobInterviewDate = dateTimeStringConverter(interviewValue)
            console.log(candidateUpdated);
            dispatch(updateCandidate({
                id: candidateUpdated.id,
                body: candidateUpdated
            }))
        }
        setEditInterview(false)
    }

    return (
        <div className='card shadow-sm'>
            <div className='card-header'>
                <h4 className='card-title'>Entretien le</h4>
            </div>
            <form className='card-body'>
                {(!candidate.jobInterviewDate && !isEditInterview) && <h5 className='card-title'>Aucun entretien proposé</h5>}
                <Input type={isEditInterview ? 'datetime-local': 'text'}
                    value={candidate.jobInterviewDate}
                    givenRef={schemaRef.jobInterviewDate}
                    readonly={!isEditInterview} />
                {isEditInterview && <button className='btn btn-primary w-100' onClick={handleSubmitInterview}>Valider</button>}
            </form>
            {!isEditInterview &&
                <div className='card-footer d-flex justify-content-end'>
                    <button className='btn btn-outline-primary' onClick={toggleInterview}>{candidate.jobInterviewDate ? "Modifier" : "Programmer"}</button>
                </div>
            }
        </div>
    );
};

export default CandidateInterviewCardForm;
