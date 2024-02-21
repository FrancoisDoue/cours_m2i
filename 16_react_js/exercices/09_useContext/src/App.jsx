import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import GameContext from './context/GameContext'
import FormGame from './components/FormGame'
import GameList from './components/GameList'

function App() {
  const [gameList, setGameList] = useState([])

  return (
    <>
      <h1><span><img src={reactLogo} alt="react" /></span>Exercice context</h1>
      
      <GameContext.Provider value={{gameList, setGameList}}>
        <FormGame/>
        <hr />
        <GameList/>

      </GameContext.Provider>
    </>
  )
}

export default App
