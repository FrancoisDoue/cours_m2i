import { FlatList, StyleSheet, Text, View } from 'react-native'
import React, { useContext, useLayoutEffect, useState } from 'react'
import globalStyle from '../styles/globalStyle'
import CardRecipe from '../components/CardRecipe'
import RecipeContext from '../context/RecipeContext'

const RecipesListScreen = ({navigation, route}) => {
  const {id, favContext} = route.params
  const {MEALS, favorites} = useContext(RecipeContext)
  const [recipeList, setRecipeList] = useState(MEALS)

  useLayoutEffect(() => {
    if(!favContext && id){
      const recipes = recipeList.filter(recipe => {
        return !!recipe.categoryIds.find(cat => cat == id)
      })
      setRecipeList(recipes)
    } else {
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

const styles = StyleSheet.create({
  recipeListMain: {
    justifyContent: 'center',
  }
})