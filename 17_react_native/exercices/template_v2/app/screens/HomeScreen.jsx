import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import GradientView from '../components/GradientView'

const HomeScreen = () => {
  return (
      <GradientView style={styles.test}>
        <Text style={styles.colorLight}>HomeScreen</Text>
      </GradientView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  test: {
    justifyContent: 'center',
    alignItems: 'center'
  },
  colorLight: {
    color: 'white'
  }
})