import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { RadialGradient } from 'react-native-gradients'
import { gradientColors } from '../styles/globalStyle'

const GradientView = ({style, children}) => {
  return (
    <View style={styles.main}>
      <View styles={styles.gradientBg}>
        <RadialGradient x='20%' y='20%' rx='100%' ry='50%' colorList={gradientColors.main} />
      </View>
      <View style={[styles.gradientBg, style]}>
        {children}
      </View>
    </View>
  )
}

export default GradientView

const styles = StyleSheet.create({
  main: {
    position: 'relative'
  },
  gradientBg: {
    position: 'absolute',
    width: '100%',
    height: '100%',
  }
})