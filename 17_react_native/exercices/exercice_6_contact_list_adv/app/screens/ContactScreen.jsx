import { Linking, Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useLayoutEffect, useState } from 'react'
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

    useEffect(() => {
        if (contact?.phone) {
            setContact({
                ...contact, 
                phone: contact.phone.replaceAll(/[\.\-\(\)]/g, '').split(' ')[0]
            })
        }
    }, [contact?.phone])

    const handleCall = () => Linking.openURL(`tel:${contact.phone}`)

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
            <Pressable onPress={handleCall}>
                <Text>{contact.phone}</Text>
            </Pressable>
        </View>
    )
}

export default ContactScreen

const styles = StyleSheet.create({})