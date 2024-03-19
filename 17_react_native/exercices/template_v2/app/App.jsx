import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { NavigationContainer } from '@react-navigation/native'
import Icon from 'react-native-vector-icons/Foundation'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import HomeScreen from './screens/HomeScreen'
import { colors } from './styles/globalStyle'
import { StatusBar, StyleSheet } from 'react-native'

const Tab = createBottomTabNavigator()
const Stack = createNativeStackNavigator()

const HomeStack = () => {
  return (
    <Stack.Navigator
      initialRouteName='home'
      screenOptions={stackScreenOptions}
    >
      <Stack.Screen name='home' component={HomeScreen} />
    </Stack.Navigator>
  )
}

const App = () => {

  return (
    <>
    <StatusBar backgroundColor={colors.bgPrimary} />
    <NavigationContainer>
      <Tab.Navigator 
        initialRouteName='home_navigation'
        screenOptions={{
          headerShown: false,
          tabBarStyle: navStyles.tabBarStyle,
          tabBarLabelStyle: navStyles.tabBarLabelStyle,
          tabBarInactiveTintColor: colors.colorSecondary,
          tabBarActiveTintColor: colors.colorPrimary,
        }}
      >

        <Tab.Screen name='home_navigation' component={HomeStack} options={{
          tabBarLabel: 'Home',
          tabBarIcon: ({focused, color}) => <Icon name='home' color={color} size={focused? 40 : 30} />
        }}/>

      </Tab.Navigator>
    </NavigationContainer>
    </>
  )
}

export default App

const navStyles = StyleSheet.create({
  tabBarStyle: {
    height: 90, 
    paddingBottom: 9, 
    backgroundColor: colors.bgPrimary, 
    borderTopColor: colors.bgSecondary
  },
  tabBarLabelStyle: {
    fontSize: 20,
  }
})

const stackScreenOptions = {
  headerTransparent: true,
  headerStyle: {backgroundColor: colors.bgPrimary},
  headerTintColor: colors.colorPrimary
}
