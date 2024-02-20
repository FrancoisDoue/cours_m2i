import React, { useEffect, useState } from 'react';

const InputMultiplicatorComponent = ({number}) => {

    console.log(number)
    
    const [a, setA] = useState(0)
    const [b, setB] = useState(0)
    const [isCorrect, setIsCorrect] = useState(false)

    useEffect(() => {
        setIsCorrect(a*b === number)
    }, [a, b, number])


    return (
        <div>
            <div>
                <label htmlFor="a">Nombre 'a' : </label>
                <input type="number" value={+a} onChange={(e) => setA(+e.target.value)} />
            </div>
            <div>
                <label htmlFor="b">Nombre 'b' : </label>
                <input type="number" value={+b} onChange={(e) => setB(+e.target.value)} />
            </div>
            <div>
                <p>
                    {isCorrect? 
                        `${a} x ${b} est égal à ${number}` :
                        `${a} x ${b} ne fait pas ${number}`}
                </p>
            </div>
        </div>
    );
}

export default InputMultiplicatorComponent;
