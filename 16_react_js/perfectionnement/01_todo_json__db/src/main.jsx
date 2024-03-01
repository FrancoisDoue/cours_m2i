import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import router from './app-routing.jsx'
import { Provider } from 'react-redux'
import store from './store.js'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Provider store={store}>
      <RouterProvider router={router}/>
    </Provider>
  </React.StrictMode>,
)
