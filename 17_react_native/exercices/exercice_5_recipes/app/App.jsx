import React, { useState } from 'react'
import { NavigationContainer } from '@react-navigation/native'
import HomeScreen from './screens/HomeScreen'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import RecipesListScreen from './screens/RecipesListScreen'
import RecipeScreen from './screens/RecipeScreen'
import RecipeContext from './context/RecipeContext'
import { CATEGORIES, MEALS } from '../datas/data/data'

const Stack = createNativeStackNavigator()

const App = () => {

  const [favorites, setFavorites] = useState([])

  return (
    // Utilisation du contexte pour les favorites
    <RecipeContext.Provider value={{CATEGORIES, MEALS, favorites, setFavorites}}>
      <NavigationContainer>
        <Stack.Navigator initialRouteName='home'>
          <Stack.Screen name={'home'} component={HomeScreen} options={{title: 'All Categories'}} />
          <Stack.Screen name={'MealsList'} component={RecipesListScreen} options={{title: 'Meals Overview'}} />
          <Stack.Screen name={'Meal'} component={RecipeScreen} options={{title: 'About the Meal'}} />
        </Stack.Navigator>
      </NavigationContainer>
    </RecipeContext.Provider>
  )
}

export default App