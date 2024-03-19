import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Gradient from '../components/Gradient'

const HomeScreen = () => {
  return (
    
      <Gradient>
        <Text style={styles.colorLight}>HomeScreen</Text>
      </Gradient>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  main: {
    width: '100%',
    height: '100%',
    position: 'absolute'
  },
  colorLight: {
    color: 'white'
  }
})