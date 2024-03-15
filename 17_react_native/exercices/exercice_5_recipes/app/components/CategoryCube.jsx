import { Pressable, StyleSheet, Text } from 'react-native'
import React from 'react'
import globalStyle, {colors} from '../styles/globalStyle'

const CategoryCube = ({category, onPress}) => {
    const styles = StyleSheet.create({
        cube: ({pressed}) => ({
            width: 177,
            height: 177,
            backgroundColor: (pressed) ? colors.bgColor : category.color,
            borderWidth: 3,
            borderColor: category.color,
            margin: 15,
            elevation: (pressed) ? 2 : 10,
            transform:  [{rotate: (pressed) ? '5deg': '0deg'}],
            ...globalStyle.radiusSm,
            ...globalStyle.itemsCenter
        }),
    })
    
  return (
    <Pressable style={styles.cube} onPress={onPress}>
      <Text style={globalStyle.textEmphasis1}>{category.title}</Text>
    </Pressable>
  )
}

export default CategoryCube

