import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import SignForm from './component/auth/SignForm'
import TaskForm from './component/task/TaskForm'
import './App.css'
import { useSelector } from 'react-redux'

function App() {
  const user = useSelector(state => state.auth.user)
  const [count, setCount] = useState(0)

  return (
    <>
      {!user && <SignForm/>}
      {user && <TaskForm/>}
    </>
  )
}

export default App
