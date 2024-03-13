import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import Home from './screens/Home'
import SecondPage from './screens/SecondPage'
import ThirdPage from './screens/ThirdPage'

// npm i @react-navigation/native
// npm i react-native-screens react-native-safe-area-context
// npm i @react-navigation/native-stack

const Stack = createNativeStackNavigator()

const App = () => {
  return (
    <NavigationContainer >
      <Stack.Navigator initialRouteName='Home' >
        <Stack.Screen name='Home' component={Home} options={{headerShown : true}} />
        <Stack.Screen name='Page 2' component={SecondPage} options={{title: "Superbe page 2"}}/>
        <Stack.Screen name='Page 3' component={ThirdPage} options={{title: "Page 3 correcte"}}/>
      </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App