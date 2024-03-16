import { Pressable, StyleSheet, Text } from 'react-native'
import React from 'react'
import globalStyle from '../styles/globalStyle'

const LovelyButton = ({onPress, isLoved}) => {

  const styles = StyleSheet.create({
    lovelyButton: ({pressed}) => ({
      padding: 8,
      elevation: (pressed) ? ((isLoved) ? 1 : 2) : 6,
      width: 70,
      alignItems: 'center',
      borderWidth: 2,
      borderColor: (isLoved) ? '#ffc7ff' : ((pressed) ? '#f4428c' : 'white' ),
      backgroundColor: 'white',
      transform: [{ rotate: (isLoved) ? '-5deg' : ((pressed) ? '-5deg' : '0deg') }],
      ...globalStyle.radiusSm,
    }),
    lovelyText: {
        color: isLoved ? '#ffc7ff':'#f4428c',
        fontWeight: '500'
    }
  })

  return (
    <Pressable style={styles.lovelyButton} onPress={onPress}>
      <Text style={styles.lovelyText}>{isLoved ? 'Loved' : 'Love it!'}</Text>
    </Pressable>
  )
}

export default LovelyButton

