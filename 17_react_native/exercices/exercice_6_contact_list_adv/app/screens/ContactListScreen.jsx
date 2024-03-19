import { StyleSheet, Text, View, FlatList } from 'react-native'
import React, { useEffect, useState } from 'react'
import users from '../services/api.backend'
import ContactItem from '../components/ContactItem'

const ContactListScreen = ({navigation}) => {

    const [contactList, setContactList] = useState([])

    useEffect(() => {
        if (!contactList?.length) {
            users.get()
                .then(setContactList)
        }
    }, [])

    const handleContactNavigation = (id) => navigation.navigate('contact', {idContact: id})

    return (
        <View style={styles.main}>
            <FlatList 
                data={contactList}
                keyExtractor={(item) => item.id}
                renderItem={({item}) => 
                    <ContactItem contact={item} onPress={() => handleContactNavigation(item.id)} />
                }
                ListEmptyComponent={<Text> Contacts not found </Text>}
            />

        </View>
    )
}

export default ContactListScreen

const styles = StyleSheet.create({
    main: {
        flex: 1
    }
})