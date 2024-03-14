import { View, Text, Button, Linking } from 'react-native'
import React, {useLayoutEffect} from 'react'
import defaultStyle from '../styles/defaultStyle'

const DetailContactScreen = ({navigation, route}) => {

    const {contact} = route.params

    useLayoutEffect(() => {
        navigation.setOptions({title: contact.firstname || contact.lastname})
    })
    
    const handleCallPress = () => {
        Linking.openURL(`tel:${contact.phone}`)
    }

  return (
    <View>
        {contact?.firstname && <Text>Prénom: {contact?.firstname} </Text>}
        {contact?.lastname && <Text>Nom: {contact?.lastname} </Text>}
        <Text>Téléphone: {contact.phone}</Text>
        <Button title={'appeler'} onPress={handleCallPress}/>
    </View>
  )
}

export default DetailContactScreen