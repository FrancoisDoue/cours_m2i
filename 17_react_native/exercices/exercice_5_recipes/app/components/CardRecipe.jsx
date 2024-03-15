import { Image, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import globalStyle, { colors } from '../styles/globalStyle'

const CardRecipe = ({recipe, onPress}) => {
  
  return (
    <Pressable style={styles.card} onPress={onPress}>
        <Image source={{uri: recipe.imageUrl}} style={styles.img} />

        <View style={styles.cardBody}>

          <Text style={globalStyle.textEmphasis2} >{recipe.title}</Text>

          <View style={styles.cardContent}>
            <Text style={globalStyle.descriptionText}>
              {recipe.duration}m
            </Text>
            <Text style={globalStyle.descriptionText}>
              {recipe.complexity.toUpperCase()}
            </Text>
            <Text style={globalStyle.descriptionText}>
              {recipe.affordability.toUpperCase()}
            </Text>
            
          </View>

        </View>
    </Pressable>
  )
}

export default CardRecipe
const styles = StyleSheet.create({
  card: ({pressed}) => ({
    marginVertical: 20,
    marginHorizontal: 40,
    minHeight: 280,
    elevation: (pressed) ? 3 : 10,
    backgroundColor: colors.bgColor,
    transform:  [{rotate: (pressed) ? '5deg': '0deg'}],  
    ...globalStyle.radiusMd
  }),
  img: {
    height: 200,
    borderTopLeftRadius: 20,
    borderTopRightRadius: 20,
  },
  cardBody: {
    alignItems: 'center',
    justifyContent: 'space-around',
    margin: 10
  },
  cardContent: {
    marginTop: 10,
    flexDirection: 'row',
  },

})