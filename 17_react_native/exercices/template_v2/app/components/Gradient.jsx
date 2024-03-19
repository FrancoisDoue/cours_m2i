import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { RadialGradient } from 'react-native-gradients'
import { gradientColors } from '../styles/globalStyle'

const Gradient = ({style, children}) => {
  return (
    <View style={styles.main}>
        {children}
      <View styles={styles.gradientBg}>
          <RadialGradient x='50%' y='50%' rx='50%' ry='50%' colorList={gradientColors.main} />
      </View>
      {/* <View style={styles.main}> */}
      {/* </View> */}
    </View>
  )
}

export default Gradient

const styles = StyleSheet.create({
  main: {
    flex: 1,
    position: 'relative'
  },
  gradientBg: {
    position: 'absolute',
    // top: 0,
    // left: 0,
    // zIndex: '-1'
  }
})