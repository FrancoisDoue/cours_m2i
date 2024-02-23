import { useState } from 'react'
import './App.css'
import FizzBuzzComponent from './components/FizzBuzzComponent'
import FormComponent from './components/FormComponent'
import MutliplicatorComponent from './components/MutliplicatorComponent'

function App() {

  return (
    <>
    <div>
      <FizzBuzzComponent />

    </div>
    <div>
      <FormComponent/>
    </div>
    <div>
      <MutliplicatorComponent />
    </div>
    </>
  )
}

export default App
