import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { NavigationContainer } from '@react-navigation/native'
import Icon from 'react-native-vector-icons/Foundation'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import HomeScreen from './screens/HomeScreen'
import { colors } from './styles/globalStyle'
import { StyleSheet } from 'react-native'

const Tab = createBottomTabNavigator()
const Stack = createNativeStackNavigator()

const HomeStack = () => {
  return (
    <Stack.Navigator
      initialRouteName='home'
      screenOptions={{
        headerStyle: {backgroundColor: colors.bgPrimary, color: colors.colorSecondary},
        headerTitleStyle: {color: colors.colorPrimary}
      }}
    >
      <Stack.Screen name='home' component={HomeScreen} />
    </Stack.Navigator>
  )
}

const App = () => {
  return (
    <NavigationContainer>
      <Tab.Navigator 
        initialRouteName='home_navigation'
        screenOptions={tabScreenOptions}
      >
        <Tab.Screen name='home_navigation' component={HomeStack} options={{
          tabBarLabel: 'Home', 
          tabBarIcon: ({color}) => <Icon name='home' color={color} size={40} />
        }}/>
      </Tab.Navigator>
    </NavigationContainer>
  )
}

export default App

const navStyles = StyleSheet.create({
  tabBarStyle: {
    height: 80, 
    paddingBottom: 9, 
    backgroundColor: colors.bgPrimary, 
    borderTopColor: colors.bgSecondary
  },
  tabBarLabelStyle: {
    color: colors.colorSecondary, 
    fontSize: 20,
  }
})


const tabScreenOptions = {
  headerShown: false,
  tabBarStyle: navStyles.tabBarStyle,
  tabBarLabelStyle: navStyles.tabBarLabelStyle,
  tabBarInactiveTintColor: colors.colorSecondary,
  tabBarActiveTintColor: colors.colorPrimary,
}