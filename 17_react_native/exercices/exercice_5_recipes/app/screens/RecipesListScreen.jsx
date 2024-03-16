import { FlatList, View } from 'react-native'
import React, { useContext, useEffect, useLayoutEffect, useState } from 'react'
import globalStyle from '../styles/globalStyle'
import CardRecipe from '../components/CardRecipe'
import RecipeContext from '../context/RecipeContext'

const RecipesListScreen = ({navigation, route}) => {
  
  const {id, favContext} = route.params
  const {MEALS, favorites} = useContext(RecipeContext)
  const [recipeList, setRecipeList] = useState(MEALS)

  useLayoutEffect(() => {
    // s'il n'y a pas de favContext et qu'un id de catégorie est présent dans les params, 
    // filtre les recettes correspondantes à la catégorie
    if(!favContext && id){
      const recipes = recipeList.filter((recipe) => !!recipe.categoryIds.find(cat => cat == id))
      setRecipeList(recipes)
    } else {
      // sinon, on affiche les favoris et on change de titre
      setRecipeList(favorites)
      navigation.setOptions({title: 'My Loved Recipes'})
    }
  }, [favorites])

  const handleRecipeNavigation = (recipe) => {
    navigation.navigate('Meal', recipe)
  }

  return (
    <View style={[globalStyle.main]}>
      <FlatList
        data={recipeList}
        keyExtractor={item => item.id}
        renderItem={({item}) => 
          <CardRecipe recipe={item} onPress={() => handleRecipeNavigation(item)}/>
        }
      />
    </View>
  )
}

export default RecipesListScreen
