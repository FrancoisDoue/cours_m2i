import { useSelector } from 'react-redux'
import Layout from './components/Layout'
import { Outlet } from 'react-router-dom'
import { useEffect } from 'react'
import { selectIsLogged, selectUserStayLogged } from './components/auth/authSlice'

function App() {
  const user = useSelector(state => state.auth.user)
  const isLogged = useSelector(selectIsLogged)
  const userStayLogged = useSelector(selectUserStayLogged)

  useEffect(() => {
    console.log('trigger user useEffect => ', user)
    console.log('user is logged => ',isLogged)
    console.log('user stay logged =>', userStayLogged)
  }, [user])

  return (
    <>
      <Layout>
        <Outlet />
      </Layout>
    </>
  )
}

export default App
