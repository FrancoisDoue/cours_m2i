import DefaultLayer from './views/DefaultLayer'
import { Outlet } from 'react-router-dom'

function App() {

  return (
    <>
      <DefaultLayer>
        <Outlet />
      </DefaultLayer>
    </>
  )
}

export default App
