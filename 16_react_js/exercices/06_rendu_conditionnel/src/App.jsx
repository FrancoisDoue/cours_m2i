import { useState } from 'react'
import './App.css'
import FormContact from './component/FormContact'
import RowContact from './component/RowContact'

function App() {

  const [contactList, setContactList] = useState([])

  const addContact = (contactObj) => {
    const rowContact = <RowContact contact={contactObj} key={contactList.length}/>
    setContactList([...contactList, rowContact])
  }

  return (
    <>
      <div>
        <FormContact cb={addContact}  />
      </div>
      {!!contactList.length && 
        <table>
          <thead>
            <tr>
              <th>Nom</th>
              <th>Prenom</th>
              <th>Téléphone</th>
            </tr>
          </thead>
          <tbody>
            {contactList}
          </tbody>
        </table>
      }
    </>
  )
}

export default App
