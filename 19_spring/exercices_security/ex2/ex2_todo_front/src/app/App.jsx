import { useLayoutEffect } from 'react'
import { RouterProvider } from 'react-router-dom'
import router from './router'
import { useDispatch } from 'react-redux'
import { initializeLogin } from './store/authSlice'
// import ToastContainer from './shared/ToastContainer'

function App() {
  const dispatch = useDispatch()
  const {isLogged} = useDispatch(state => state.auth) 

  useLayoutEffect(() => {
    console.log("on layout effect")
    dispatch(initializeLogin(localStorage.getItem("user_token")))
  }, [isLogged])

  return (
    <>
      <RouterProvider router={router} />
      {/* <ToastContainer /> */}
    </>
  )
}

export default App
