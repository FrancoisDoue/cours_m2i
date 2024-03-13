import { Button, View, Text } from 'react-native'
import React from 'react'

const SecondPage = ({navigation}) => {
    
  return (
    <View>
      <Text>SecondPage</Text>
        <Button title='Back To Home' onPress={() => navigation.navigate('Home')}/>
        <Text>Vers page toto</Text>
          <Button title='To page 3' onPress={() => navigation.navigate('Page 3', {name: 'toto'})}/>
        <Text>Vers page tata</Text>
          <Button title='To page 3' onPress={() => navigation.navigate('Page 3', {name: 'tata'})}/>
        <Text>Vers page undefinded</Text>
          <Button title='To page 3' onPress={() => navigation.navigate('Page 3')}/>
    </View>
  )
}

export default SecondPage