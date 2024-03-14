import { Image, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import globalStyle from '../styles/globalStyle'

const CardRecipe = ({recipe}) => {
  
  return (
    <View style={styles.card}>
        <Image source={{uri: recipe?.imageUrl}} width={'100%'} height={200} />
        <Text>{recipe.title}</Text>
    </View>
  )
}

export default CardRecipe
const styles = StyleSheet.create({
  card: {
    margin: 40,
    minHeight: 150,
    borderWidth: 2,
    ...globalStyle.radiusMd
  }
})