import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';

const ToastError = ({error, title, autoClose = 5000, closeAction}) => {
    useEffect(() => {

    }, [])
    return (
        <div className='card position-absolute bg-danger-subtle' style={{pointerEvents: "all", width: "18rem", minHeight: "7rem", top: "8rem", right: "4rem"}} >
            <div className='card-body'>
                <div className='d-flex justify-content-between'>
                    <h6 className='card-title'>{title || "error"}</h6>
                    <button className='btn btn-outline-danger border-0 btn-sm rounded-pill'
                        onClick={closeAction()}>
                        <i className="bi bi-x"></i>
                    </button>
                </div>
            </div>
        </div>
    )
}

const ToastContainer = () => {

    const authError = useSelector(state => state.auth.error)
    const taskError = useSelector(state => state.task.error)
    const [isError, setError] = useState(false)

    useEffect(() => {
        if (authError) setError(true)
        console.log(isError)
    }, [authError])


    return (
        <div className='vh-100 vw-100 position-absolute top-0 left-0' style={{pointerEvents: "none"}}>
            {(authError && isError )&& 
                <ToastError error={authError} title="Email ou mot de passe invalide" closeAction={() => setError(false)}/>
            }
        </div>
    );
};

export default ToastContainer;