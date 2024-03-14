import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { NavigationContainer } from '@react-navigation/native'
import HomeScreen from './screens/HomeScreen'
import AboutScreen from './screens/AboutScreen'
import ContactScreen from './screens/ContactScreen'
import Icon from 'react-native-vector-icons/FontAwesome'


const Tab = createBottomTabNavigator()

const App = () => {

  return (
    <NavigationContainer>
        <Tab.Navigator screenOptions={{
                tabBarActiveTintColor: '#E9F1FC',
                tabBarInactiveTintColor: '#A6C6F2',
                tabBarActiveBackgroundColor: '#0A2C5C',
                tabBarInactiveBackgroundColor: '#174482',
                headerShown: false
            }}
        >
            <Tab.Screen name='Home' component={HomeScreen} options={{
                title: 'Accueil', 
                tabBarIcon: ({color, size}) => <Icon name='home' color={color} size={size} />
            }}/>
            <Tab.Screen name='About' component={AboutScreen} options={{
                title: 'A propos',
                tabBarIcon: ({color, size}) => <Icon name='plus' color={color} size={size} />

            }}/>
            <Tab.Screen name='Contact' component={ContactScreen} options={{
                title: 'Contact',
                tabBarIcon: ({color, size}) => <Icon name='send-o' color={color} size={size} />
            }}/>
        </Tab.Navigator>
    </NavigationContainer>
  )
}

export default App

const styles = StyleSheet.create({})