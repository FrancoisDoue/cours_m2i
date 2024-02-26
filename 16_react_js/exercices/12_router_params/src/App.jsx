import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Link } from 'react-router-dom'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <h1>Exercice 11 - router params</h1>
    <div>
      <Link to={'/contact'}>Afficher les contacts</Link>
    </div>
    </>
  )
}

export default App
