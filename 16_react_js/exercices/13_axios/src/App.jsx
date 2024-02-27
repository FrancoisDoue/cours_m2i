// import { useState } from 'react'
import reactLogo from './assets/react.svg'
import { useState, useEffect } from 'react'
import axios from 'axios'
import FormTodo from './components/FormTodo'
import TaskList from './components/TaskList'

const api = axios.create({baseURL: 'http://localhost:3000/todo'})

function App() {

  const [taskList, setTaskList] = useState([])
  const [update, setUpdate] = useState(true)
  const [editTask, setEditTask] = useState(null)

  const rerender = () => setUpdate(update => !update)

  useEffect(()=> {
    api.get()
      .then(res => setTaskList(res.data))
      .catch(err => console.error(err))
  },[update])

  const addTodo = (value) => {
    api.post('', value)
      .then(rerender)
      .catch(err => console.error(err.data))
  }

  const removeTodo = (id) => {
    api.delete('/'+id)
      .then(rerender)
      .catch(err => console.error(err.data))
  }
  
  const editTodo = (id, value) => {
    api.put('/'+id, value)
      .then(rerender)
      .catch(err => console.log(err))
  }

  return (
    <>
      <header>
        <h1>Exercice 13 <span><img src={reactLogo} alt="logo" /></span> Axios & api request</h1>
      </header>
      <main>
        {/* Welcome to (prop's) Hell */}
        <FormTodo 
          actions={{addTodo, editTodo, setEditTask}} 
          editTask={editTask} 
        />
        <TaskList 
          actions={{removeTodo, setEditTask}}
          items={taskList} 
        />

      </main>
    </>
  )
}

export default App
