import React, { useState } from 'react'
// import './App.css'

const FizzBuzzComponent =  () => {

  const [max, setMax] = useState(50)
  const [count, setCount] = useState(1)
  
  const isFizzBuzz = () => {
    let msg = ''
    if (!(count % 3)) msg += 'Fizz'
    if (!(count % 5)) msg += 'Buzz'
    if (msg === '') msg = count 
    return msg
  }

  const maxValueHandler = (event) => setMax(event.target.value)

  return (
    <>
      <div>
        <label htmlFor="maxValue"></label>
        <input name='maxValue' id='maxValue' type="number" value={max} onInput={maxValueHandler}/>
      </div>
      <button onClick={() => setCount(count + 1)} disabled={!(count < max)}>+</button>
      <h2>{ isFizzBuzz() }</h2>
      <button onClick={() => setCount(count - 1)} disabled={!(count > 0)}>-</button>
    </>
  )
}

export default FizzBuzzComponent