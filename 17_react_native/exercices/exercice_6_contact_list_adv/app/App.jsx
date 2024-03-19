import { View, Text } from 'react-native'
import React from 'react'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { NavigationContainer } from '@react-navigation/native'
import ContactListScreen from './screens/ContactListScreen'
import ContactScreen from './screens/ContactScreen'

const Stack = createNativeStackNavigator()


const App = () => {
  return (
    <NavigationContainer>
        <Stack.Navigator>
            <Stack.Screen name='contact_list' component={ContactListScreen} options={{headerShown: false}} />
            <Stack.Screen name='contact' component={ContactScreen} />
        </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App