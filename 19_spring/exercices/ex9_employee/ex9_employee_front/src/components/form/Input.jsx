import React from 'react'

export const Input = ({type = "text", name, givenRef, label, isRequired = false}) => {
    return (
        <div className="form-floating mb-3">
            <input 
                type={type} 
                className="form-control" 
                id={name} 
                name={name} 
                placeholder="" 
                ref={givenRef} 
                required={isRequired} 
                style={{appearance: "textfield"}} 
            />
            <label htmlFor={name}>{label}</label>
        </div>
    )
}
