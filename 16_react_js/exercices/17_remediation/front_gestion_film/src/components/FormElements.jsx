export const Input = ({type, label, setRef, setFor, defaultValue}) => {

    if(type === 'date' && typeof defaultValue == 'string'){
        defaultValue = new Date(defaultValue).toLocaleDateString('en-CA')
    }

    return(
        <>
        {!!label && <label htmlFor={setFor}>{label}</label>}
        <div className='input-group'>
        <input type={type} className='form-control' id={setFor} name={setFor}
            ref={setRef}
            defaultValue={!!defaultValue ? defaultValue : ''}
        />
        </div>
        </>
    )
}
export const TextArea = ({type, label, setRef, setFor, defaultValue}) => {

    return(
        <>
        {!!label && <label htmlFor={setFor}>{label}</label>}
        <div className='input-group'>
            <textarea type={type} className='form-control' id={setFor} name={setFor}
                ref={setRef}
                defaultValue={!!defaultValue ? defaultValue : ''}
            >
            </textarea>
        </div>
        </>
    )
}