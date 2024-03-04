import { useState } from 'react'
import reactLogo from './assets/react.svg'
import Layout from './components/Layout'
import RecipeList from './components/recipes/RecipeList'



function App() {


  return (
    <>
      <Layout >
        <RecipeList />
      </Layout>

    </>
  )
}

export default App
