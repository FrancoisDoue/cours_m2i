import React, { useEffect, useState } from 'react';
import InputMultiplicatorComponent from './InputMultiplicatorComponent';

const MutliplicatorComponent = () => {
    const getRandomInt = () =>  Math.floor(Math.random() * (10 - 1) + 1)


    const [randNumber, setRandNumber] = useState(getRandomInt()*getRandomInt()) 
    // const [counter, setCounter] = useState(60);

    // useEffect(() => {
    //     setInterval((i) => {        
    //         setCounter(counter-1)
    //         if(counter < 1) clearInterval(i)
    //     }, 1000)
    // }, [counter])

    // console.log(counter)


    return (
        <>
        <hr />
            <h4>{randNumber}</h4>
        <div>
            <InputMultiplicatorComponent 
                number={randNumber}
            />
        </div>
        <button onClick={() => setRandNumber(getRandomInt()*getRandomInt())}>
            Nouveau nombre
        </button>
        <hr />
        </>
    );
}

export default MutliplicatorComponent;
