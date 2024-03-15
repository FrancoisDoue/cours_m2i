import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import globalStyle from '../styles/globalStyle'

const LovelyButton = ({onPress, isLoved}) => {

  const styles = StyleSheet.create({
    lovelyButton: ({pressed}) => ({
      padding: 8,
      elevation: 6,
      width: 70,
      alignItems: 'center',
      borderWidth: 2,
      borderColor: 'white',
      backgroundColor: 'white',
      ...globalStyle.radiusSm,
      // je vais refacto ça, c'est pas très illisible.
      ...(!isLoved) ? {
        ...(pressed) && {
          elevation: 2,
          borderColor: '#f4428c',
          transform: [{rotate: '-5deg'}]
        }
      } : {
        elevation: 1,
        borderColor: '#ffc7ff',
        transform: [{rotate: '-5deg'}]
      }
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

