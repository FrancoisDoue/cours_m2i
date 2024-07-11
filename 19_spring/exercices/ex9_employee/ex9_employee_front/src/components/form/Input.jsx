import React, { useState } from 'react'

export const Input = ({type = "text", name, givenRef, label, isRequired = false, value, readonly}) => {
    console.log(value)
    const [inputValue, setInputValue] = useState(value || "")
    const handleInputChange = ({target}) => setInputValue(target.value)

    return (
        <div className="form-floating mb-3">
            <input 
                type={type} 
                className="form-control" 
                id={name} 
                name={name} 
                placeholder="" 
                ref={givenRef} 
                value={inputValue}
                onChange={handleInputChange}
                required={isRequired} 
                readOnly={readonly}
                style={{appearance: "textfield"}} 
            />
            <label htmlFor={name}>{label}</label>
        </div>
    )
}
