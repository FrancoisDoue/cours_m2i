import { RouterProvider } from 'react-router-dom'
import router from './routes/Router'
import { useLayoutEffect } from 'react'
import { useDispatch } from 'react-redux'
import { getAllEmployees } from './service/employee.service'
import { getAllCandidates } from './service/candidates.service'

const App = () => {
  const dispatch = useDispatch()

  useLayoutEffect(() => {
    dispatch(getAllEmployees())
    dispatch(getAllCandidates())
  }, [])

  return (
    <RouterProvider router={router}/>
  )
}

export default App
