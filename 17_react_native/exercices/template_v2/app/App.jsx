import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { NavigationContainer } from '@react-navigation/native'
import HomeScreen from './screens/HomeScreen'
import Icon from 'react-native-vector-icons/FontAwesome'

const Tab = createBottomTabNavigator()


const App = () => {
  return (
    <NavigationContainer>
      <Tab.Navigator>
        <Tab.Screen name='home' component={HomeScreen} options={{
          tabBarLabel: 'Home', 
          headerShown: false,
          tabBarIcon: ({color, size}) => <Icon name='home' color={color} size={size} />
          }}/>
      </Tab.Navigator>
    </NavigationContainer>
  )
}

export default App