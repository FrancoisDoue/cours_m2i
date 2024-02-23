import React, { useRef } from 'react';

const DemoRef = () => {

    const firstnameRef = useRef()
    const getFirstname = () => {
        console.log(firstnameRef.current.value)
    }

    return (
        <>
        <div>
            <label htmlFor="firstname">Firstname</label>
            <input type="text" name="firstname" id="firstname" ref={firstnameRef} />

        </div>
            <button onClick={getFirstname}>Submit</button>
        </>
    );
}

export default DemoRef;
