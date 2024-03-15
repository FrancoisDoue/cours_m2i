import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import globalStyle from '../styles/globalStyle'


const FavButton = ({onPress}) => {
  return (
    <Pressable style={styles.favBtn} onPress={onPress}>
      <Text style={styles.lovelyText}>Loved recipes</Text>
    </Pressable>
  )
}

export default FavButton

const styles = StyleSheet.create({
    favBtn: ({pressed}) => ({
        padding: 8, 
        elevation: 6,
        width: 120,
        alignItems: 'center',
        borderWidth: 2,
        borderColor: 'white',
        backgroundColor: 'white',
        ...globalStyle.radiusSm,
        ...pressed && {
            transform: [{rotate: '-5deg'}],
            borderColor: '#f4428c',
            elevation: 2,
        }
    }),
    lovelyText: {
        color: '#f4428c',
        fontWeight: '500'
    }
})