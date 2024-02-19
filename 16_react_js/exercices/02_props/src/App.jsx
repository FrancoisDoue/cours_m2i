import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import TableLine from './components/TableLine';

function App() {
  const [rows, setRows] = useState([])

  const addARow = () => {
    const index = rows.length+1
    setRows([...rows, { index: index, val1: 'valeur '+index, val2: 'valeur '+index}])
  }

  return (
    <>
      <h2>Super tableau</h2>
      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>col 2</th>
            <th>col 3</th>
          </tr>
        </thead>
        <tbody>
          {rows.map((r) => <TableLine key={r.index} rowValue={r}/>)}
        </tbody>
      </table>
      <button onClick={addARow}>Add a row</button>
    </>
  )
}

export default App
