import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import HomeScreen from './screens/HomeScreen'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import RecipesListScreen from './screens/RecipesListScreen'

const Stack = createNativeStackNavigator()

const App = () => {
  return (
    <NavigationContainer>
        <Stack.Navigator initialRouteName='home'>
            <Stack.Screen name={'home'} component={HomeScreen} options={{title: 'All Categories'}} />
            <Stack.Screen name={'MealsList'} component={RecipesListScreen} options={{title: 'Meals Overview'}} />
        </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App