import Layout from './components/Layout'
import RecipeList from './components/recipes/RecipeList'
import AuthContext from './context/AuthContext'
import RecipeContext from './context/RecipeContext'
import * as auth from './components/auth/authSlice'
import * as recipes from './components/recipes/recipesSlice'
import { useDispatch, useSelector } from 'react-redux'
import { useEffect } from 'react'
import axios from 'axios'

function App() {

  const dispatch = useDispatch()

  const isLogged = useSelector(auth.selectIsLogged)
  const token = useSelector(auth.selectToken)
  const recipesList = useSelector(recipes.selectAllRecipes)

  useEffect(() => {
    console.log('useEffect on app.jsx')
    
  }, [])

  return (
    <>
      <AuthContext.Provider value={{...auth, isLogged, token}}>
        <Layout >
          <RecipeContext.Provider value={recipes}>
            <RecipeList />
          </RecipeContext.Provider>
        </Layout>
      </AuthContext.Provider>
    </>
  )
}

export default App
