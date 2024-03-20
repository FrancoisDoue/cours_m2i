import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import GradientView from '../components/GradientView'
import { colors } from '../styles/globalStyle'

const HomeScreen = () => {
  return (
      <GradientView style={styles.test}>
        <Text style={styles.textColor}>HomeScreen</Text>
      </GradientView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  test: {
    justifyContent: 'center',
    alignItems: 'center'
  },
  textColor: {
    color: colors.colorTertiary,
  }
})