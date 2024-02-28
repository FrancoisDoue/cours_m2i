import { useEffect, useState } from 'react'
import axios from 'axios'
import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import { Outlet } from 'react-router-dom'
// import './App.css'

const api = axios.create({baseURL: 'http://localhost:3000/todos/'})

function App() {

  const [todos, setTodos] = useState([])
  const [update, setUpdate] = useState(true)
  const rerender = () => setUpdate(update => !update)

  useEffect(() => {
    api.get()
      .then(res => setTodos(res.data))
      .catch(err => console.error(err.config))
  },[update])

  const addTodo = (values) => {
    api.post('', values)
      .then(rerender)
      .catch(err => console.error(err.config))
  }


  console.log(todos)
  return (
    <>
      <header>
        <h1>Exercice 13 (bis) <span><img src={reactLogo} alt="logo" /></span>crud Axios</h1>
      </header>
      <main>
        <Outlet context={{todos, setTodos, addTodo}}/>
      </main>
    </>
  )
}

export default App
