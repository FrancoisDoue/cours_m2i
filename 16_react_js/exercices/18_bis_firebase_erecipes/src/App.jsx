import Layout from './components/Layout'
import RecipeList from './components/recipes/RecipeList'
import AuthContext from './context/AuthContext'
import RecipeContext from './context/RecipeContext'
import * as auth from './components/auth/authSlice'
import * as recipes from './components/recipes/recipesSlice'
import { useDispatch, useSelector } from 'react-redux'
import { useEffect } from 'react'
import axios from 'axios'
import { BASE_DB_URL } from './firebaseConfig'

function App() {

  const dispatch = useDispatch()

  const isLogged = useSelector(auth.selectIsLogged)
  const token = useSelector(auth.selectToken)
  const recipesList = useSelector(recipes.selectAllRecipes)

  useEffect(() => {
    // si l'objet user n'existe pas ou que son token est expiré => déconnexion
    !isLogged && dispatch(auth.removeUser())
  }, [isLogged])

  useEffect(() => {
    if (!recipesList.length) {
      axios.get(`${BASE_DB_URL}recipes.json`)
      .then((res) => {
        // firebase envoit une liste sous forme d'objet {clé : valeur} 
        // je fais donc un for in et un map pour obtenir une liste d'objets tout en conservant une clé 
        const resMap = []
        for (const key in res.data) {
          resMap.push({...res.data[key], key: key})
        }
        dispatch(recipes.setRecipes(resMap))
      })
    }
  }, [])
  console.log(recipesList)

  const addNewRecipe = (recipe) => {
    axios.post(`${BASE_DB_URL}recipes.json?auth=${token}`, recipe)
        .then((res) => {
            recipe.key = res.data.name
            dispatch(recipes.addRecipe(recipe))
        })
        .catch(err => console.log(err))
  }

  const updateRecipe = (recipe, editRecipe) => {
    axios.put(`${BASE_DB_URL}recipes/${editRecipe.key}.json?auth=${token}`, recipe)
        .then(() => {
            recipe.key = editRecipe.key
            dispatch(recipes.replaceRecipe(recipe))
        })
        .catch(err => console.log(err))
  }

  const deleteRecipe = (recipe) => {
    axios.delete(`${BASE_DB_URL}recipes/${recipe.key}.json?auth=${token}`)
      .then(() => dispatch(recipes.removeRecipe(recipe)))
      .catch(err => console.log(err))
  }

  return (
    <>
      <AuthContext.Provider 
        value={{...auth, isLogged, token}}
      >
        <Layout >
          <RecipeContext.Provider 
            value={{...recipes, recipesList, updateRecipe, addNewRecipe, deleteRecipe}}
          >
            <RecipeList />
          </RecipeContext.Provider>
        </Layout>
      </AuthContext.Provider>
    </>
  )
}

export default App
