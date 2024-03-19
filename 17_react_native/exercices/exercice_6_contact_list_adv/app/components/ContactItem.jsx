import { StyleSheet, Text, Pressable } from 'react-native'
import React from 'react'

const ContactItem = ({contact, onPress}) => {
  return (
    <Pressable onPress={onPress} style={styles.itemMain}>
      <Text>{contact?.username || contact?.name}</Text>
    </Pressable>
  )
}

export default ContactItem

const styles = StyleSheet.create({
    itemMain: {
        width: '80%',
        alignSelf: 'center',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 6,
        padding: 6,
        height: 50,
        elevation: 4,
        marginVertical: 15,
        backgroundColor: 'lightblue',
    }
})