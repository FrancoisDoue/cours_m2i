import { FlatList, StyleSheet, Text, View } from 'react-native'
import React, { useLayoutEffect, useState } from 'react'
import globalStyle from '../styles/globalStyle'
import { MEALS } from '../../datas/data/data'
import CardRecipe from '../components/CardRecipe'

const RecipesListScreen = ({navigation, route}) => {
  const {id} = route.params
  const [recipeList, setRecipeList] = useState(MEALS)

  useLayoutEffect(() => {
    const recipes = recipeList.filter(recipe => {
      return !!recipe.categoryIds.find(cat => cat == id)
    })
    setRecipeList(recipes)
    console.log(recipes)
  }, [])

  const handleRecipeNavigation = (recipe) => {
    navigation.navigate('Meal', recipe)
  }

  console.log(route.params)
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