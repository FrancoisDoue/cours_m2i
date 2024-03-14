import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

const RecipesListScreen = ({navigate, route}) => {

    console.log(route.params)
  return (
    <View>
      <Text>RecipesListScreen</Text>
    </View>
  )
}

export default RecipesListScreen

const styles = StyleSheet.create({})