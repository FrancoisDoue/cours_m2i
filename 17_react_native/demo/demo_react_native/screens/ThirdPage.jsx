import { View, Text } from 'react-native'
import React from 'react'

const ThirdPage = ({navigation, route}) => {
    const {params} = route
  return (
    <View>
      <Text>ThirdPage</Text>
      <Text>Bonjour, {params?.name || 'undefined user n°0693'}</Text>
    </View>
  )
}

export default ThirdPage