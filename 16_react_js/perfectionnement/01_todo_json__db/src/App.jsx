import { useDispatch, useSelector } from 'react-redux'
import DefaultLayer from './views/DefaultLayer'
import { Outlet, useNavigate } from 'react-router-dom'
import { useEffect } from 'react'
import api from './services/apiService'
import { setTodos, setError } from './components/todosSlice'

function App() {
  const todos = useSelector((state) => state.todos)
  const dispatch = useDispatch()
  const navigate = useNavigate()

  useEffect(() => {
    if(!todos.todoList.length) {
      api.get('/todos')
        .then((res) => res.data && dispatch(setTodos(res.data)))
        .catch((err) => dispatch(setError({error: err})))
    }
    // if(todos.error) navigate('/') 
  }, [])

  return (
    <>
      <DefaultLayer>
        <Outlet context={{todos, dispatch}}/>
      </DefaultLayer>
    </>
  )
}

export default App
