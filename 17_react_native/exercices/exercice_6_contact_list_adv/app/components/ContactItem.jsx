import { StyleSheet, Text, Pressable } from 'react-native'
import React from 'react'

const ContactItem = ({contact, onPress}) => {
  return (
    <Pressable onPress={onPress}>
      <Text>{contact?.username || contact?.name}</Text>
    </Pressable>
  )
}

export default ContactItem

const styles = StyleSheet.create({})