import { View, Text } from 'react-native'
import React from 'react'
import Icon from 'react-native-vector-icons/FontAwesome'


const HomeScreen = () => {
  return (
    <View>
      <Icon name='home' size={150} color={'#0A2C5C'}/>
      <Text>HomeScreen</Text>
    </View>
  )
}

export default HomeScreen