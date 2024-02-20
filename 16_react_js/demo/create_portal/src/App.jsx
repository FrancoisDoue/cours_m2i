import { useState } from 'react'
import Modal from './components/Modals/Modal'
import './App.css'
import DemoRef from './components/DemoRef'

function App() {
  const [isOpen, setIsOpen] = useState(false)

  return (
    <>
      <div>
        <DemoRef />
      </div>
      <button onClick={() => setIsOpen(!isOpen)}>Ouvrir modal</button>
      {isOpen &&
        <Modal close={() => setIsOpen(!isOpen)}>Hello world</Modal>
      }
    </>
  )
}

export default App
