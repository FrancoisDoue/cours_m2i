import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import FormTodo from './components/TodoForm'
import './App.css'
import { useDispatch, useSelector } from 'react-redux'
import { fetchTodos } from './components/todoSlice'

function App() {
  const dispatch = useDispatch()
  const todos = useSelector(state => state.todo.todos)

  useEffect(() => {
    dispatch(fetchTodos())
   
  }, [])
  console.log( 'on app', todos)


  return (
    <>
    
    {/* {todos.map(e => <p>{e.title}</p>)} */}
      <FormTodo/>
    </>
  )
}

export default App
