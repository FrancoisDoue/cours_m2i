import { View, Text, Pressable } from 'react-native'
import React from 'react'

const ContactItem = ( {contact, navigation} ) => {

    const handleNavigation = () => {
        navigation.navigate('ContactDetail', {contact: contact})
    }

  return (
    <Pressable onPress={handleNavigation}>
      <Text>{contact?.firstname} {contact?.lastname}</Text>
    </Pressable>
  )
}

export default ContactItem