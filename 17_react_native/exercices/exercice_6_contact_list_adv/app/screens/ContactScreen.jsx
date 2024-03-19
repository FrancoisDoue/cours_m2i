import { StyleSheet, Text, View } from 'react-native'
import React, { useLayoutEffect, useState } from 'react'
import users from '../services/api.backend'

const ContactScreen = ({navigation, route}) => {
    const {idContact} = route.params

    const [contact, setContact] = useState({})

    useLayoutEffect(() => {
        if (!contact?.name) {
            users.get(`/${idContact}`)
                .then(setContact)
        }
        navigation.setOptions({title: contact?.username || contact?.name})
    }, [contact])

    console.log(contact)

    return (
        <View>
            <Text>{contact?.name}</Text>
            {contact?.username && <Text>{contact.username}</Text>}
            <View>
                <Text>{contact?.address?.suite}</Text>
                <Text>{contact?.address?.street}</Text>
                <Text>{contact?.address?.city}</Text>
                <Text>{contact?.address?.zipcode}</Text>
            </View>
            <Text>{contact?.phone.replaceAll(/[-.]/gi, '')}</Text>
        </View>
    )
}

export default ContactScreen

const styles = StyleSheet.create({})