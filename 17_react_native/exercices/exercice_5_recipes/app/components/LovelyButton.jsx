import { Pressable, StyleSheet } from 'react-native'
import React from 'react'
import Icon from 'react-native-vector-icons/FontAwesome'

const LovelyButton = ({onPress, isLoved}) => {

  const styles = StyleSheet.create({
    lovelyButton: ({pressed}) => ({
      padding: 9,
      elevation: (pressed) ? ((isLoved) ? 1 : 2) : 6,
      alignItems: 'center',
      borderWidth: 2,
      borderColor: (isLoved) ? '#ffc7ff' : ((pressed) ? '#f4428c' : 'white' ),
      backgroundColor: 'white',
      transform: [{ rotate: (isLoved) ? '-5deg' : ((pressed) ? '-5deg' : '0deg') }],
      borderRadius: isLoved? 50 : 10
    })
  })

  return (
    <Pressable style={styles.lovelyButton} onPress={onPress}>
      <Icon 
        name={isLoved ? 'heart' :'heart-o'} 
        size={21}
        color={isLoved ? '#ffc7ff' : '#f4428c'} 
      />
    </Pressable>
  )
}

export default LovelyButton

