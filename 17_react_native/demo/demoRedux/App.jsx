import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Provider } from 'react-redux'
import { store } from './store/redux/store'
import MyId from './component/MyId'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { NavigationContainer } from '@react-navigation/native'
import Form from './component/Form'


// Pour l'utilisation de redux :
// npm i @reduxjs/toolkit react-redux
const Tab = createBottomTabNavigator()


export default function App() {
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Tab.Navigator>
          <Tab.Screen name='my_id' component={MyId}/>
          <Tab.Screen name='form_id' component={Form}/>
        </Tab.Navigator>
      </NavigationContainer>
    </Provider>
  )
}

const styles = StyleSheet.create({})