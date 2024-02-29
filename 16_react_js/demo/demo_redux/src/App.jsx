import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import TaskList from './components/Task/TaskList'
import TaskForm from './components/Task/TaskForm'
import HeaderTask from './components/Task/HeaderTask'
import './App.css'

function App() {

  return (
    <>
      <HeaderTask />
      <TaskForm />
      <TaskList />
      
    </>
  )
}

export default App
