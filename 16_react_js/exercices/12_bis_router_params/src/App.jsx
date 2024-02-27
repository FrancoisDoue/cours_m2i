import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Link, Outlet} from 'react-router-dom'

function App() {

  const [contactList, setContactList] = useState([])

  console.log(contactList)

  return (
    <>
      <nav>
        <h1>Exercice 11 (bis) - router params</h1>
        <hr />
        <ul>
          <li>
            <Link to={'/'}>Home</Link>
          </li>
          <li>
            <Link to={'/contacts'}>contacts</Link>
          </li>
        </ul>
        <hr />
      </nav>

      <Outlet context={[contactList, setContactList]} />
    </>
  )
}

export default App
