import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import { Outlet } from 'react-router-dom'
import axios from 'axios'

// const api = axios.create({baseUrl: 'https://openlibrary.org'})

function App() {
  const [bookList, setBookList] = useState([])

  useEffect(() => {
    axios.get('https://openlibrary.org/subjects/cats.json?limit=100')
      .then(res => setBookList(res.data.works))
  }, [])

  return (
    <>
        <header className='p-3 bg-dark text-light mb-4'>
            <div className='container'>
                <h1>Exercice 15 <span><img src={reactLogo} alt="logo-bootstrap" /></span> OPENLIBRARY</h1>
            </div>
        </header>
        <Outlet context={{bookList}} />
    </>
  )
}

export default App
