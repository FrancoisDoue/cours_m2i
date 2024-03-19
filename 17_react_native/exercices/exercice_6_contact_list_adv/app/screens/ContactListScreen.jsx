import { StyleSheet, Text, View, FlatList, ActivityIndicator } from 'react-native'
import React, { useEffect, useState } from 'react'
import users from '../services/api.backend'
import ContactItem from '../components/ContactItem'

const ContactListScreen = ({navigation}) => {

    const [contactList, setContactList] = useState([])
    const [error, setError] = useState(false)


    useEffect(() => {
        if (!contactList?.length) {
            users.get()
                .then((data) => {
                    setContactList(data)
                    setError(false)
                })
                .catch(setError(true))
        }
    }, [])

    const handleContactNavigation = (id) => navigation.navigate('contact', {idContact: id})

    return (
        <View style={styles.main}>
            {!error ? 
            <FlatList 
                style={styles.list}
                data={contactList}
                keyExtractor={(item) => item.id}
                renderItem={({item}) => 
                    <ContactItem contact={item} onPress={() => handleContactNavigation(item.id)} />
                }
                ListEmptyComponent={<ActivityIndicator size={'large'} />}
            />
            : 
            <Text>Error</Text>
            }
        </View>
    )
}

export default ContactListScreen

const styles = StyleSheet.create({
    main: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    list: {
        width: '100%',
        height: '100%'
    }
})