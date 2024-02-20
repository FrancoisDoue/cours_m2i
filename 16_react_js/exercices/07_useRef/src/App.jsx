import reactLogo from './assets/react.svg'
import './App.css'
import LoginForm from './components/LoginForm'

function App() {

  const handleLogin = (login, password) => {
    console.log({ login, password })
  }

  return (
    <>
      <h1><span><img src={reactLogo} alt="react" /></span>Exercice 07</h1>
      <LoginForm handleSubmit={handleLogin} />
    </>
  )
}

export default App
