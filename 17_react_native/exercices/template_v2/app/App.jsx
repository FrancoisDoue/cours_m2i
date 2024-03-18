import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { NavigationContainer } from '@react-navigation/native'
import Icon from 'react-native-vector-icons/FontAwesome'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import HomeScreen from './screens/HomeScreen'

const Tab = createBottomTabNavigator()
const Stack = createNativeStackNavigator()

const HomeStack = () => {
  return (
    <Stack.Navigator>
      <Stack.Screen name='home' component={HomeScreen} />
    </Stack.Navigator>
  )
}

const App = () => {
  return (
    <NavigationContainer>
      <Tab.Navigator screenOptions={{
        headerShown: false,
        // tabBarStyle: {
        //   height: 60
        // }
      }}>
        <Tab.Screen name='home_navigation' component={HomeStack} options={{
          tabBarLabel: 'Home', 
          tabBarIcon: ({color, size}) => <Icon name='home' color={color} size={size} />
        }}/>
      </Tab.Navigator>
    </NavigationContainer>
  )
}

export default App