import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { useEffect } from 'react'
import axios from 'axios'

function App() {
  const [data, setData] = useState()

  useEffect(() => {
    axios
      .get('http://localhost:3000/personnes')
      .then((response) => setData(response.data))
      .catch((err) => console.error(err))
  }, [])

  const addPerson = () => {
    axios
      .post('http://localhost:3000/personnes', {nom: "Bernard"})
      .then((res) => setData([...data, res.data]))
      .catch((err) => console.error(err)) 
  }
  const deletePerson = (id) => {
    // const dataResult = [...data.filter(e => e != res.data)]
    axios
      .delete('http://localhost:3000/personnes/'+id)
      .then(res => setData(prev => prev.filter(e => e != res.data)))
      .catch(err => console.error(err))
  }

  console.log(data)

  return (
    <>
    <ul>
      {(!!data && !!data.length) && data.map((e) => 
        <li key={e.id}>{e.nom} <span><a onClick={() => deletePerson(e.id)}>Supprimer</a></span></li>
      )}
    </ul>
    <button onClick={addPerson}>Add a personne</button>
    </>
  )
}

export default App
