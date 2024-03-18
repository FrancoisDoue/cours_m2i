import { FlatList, View } from 'react-native'
import React, { useLayoutEffect } from 'react'
import globalStyle from '../styles/globalStyle'
import CardRecipe from '../components/CardRecipe'
import { useDispatch, useSelector } from 'react-redux'
import { setRecipeByCategorie } from '../slices/recipeSlice'

const RecipesListScreen = ({navigation, route}) => {
  
  const {id, favContext} = route.params

  const dispatch = useDispatch()
  const {recipeByCategorie, favorites} = useSelector(({recipe}) => recipe)

  useLayoutEffect(() => {
    // s'il n'y a pas de favContext et qu'un id de catégorie est présent dans les params, 
    // filtre les recettes correspondantes à la catégorie
    if (!favContext && id) dispatch(setRecipeByCategorie(id))
    else navigation.setOptions({title: 'My Loved Recipes'})
      // sinon, on affiche les favoris et on change de titre
  }, [favorites])

  const handleRecipeNavigation = (recipe) => {
    navigation.navigate('Meal', recipe)
  }

  return (
    <View style={[globalStyle.main]}>
      <FlatList
        data={(id) ? recipeByCategorie : favorites} 
        keyExtractor={item => item.id}
        renderItem={({item}) => 
          <CardRecipe recipe={item} onPress={() => handleRecipeNavigation(item)}/>
        }
      />
    </View>
  )
}

export default RecipesListScreen
