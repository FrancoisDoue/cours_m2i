import { View, FlatList, Text } from 'react-native'
import React, { useState } from 'react'
import contacts from '../tempDatas/contactList.js'
import ContactItem from '../components/contacts/ContactItem.jsx'
import defaultStyle from '../styles/defaultStyle.js'

console.log(contacts)

const ContactListScreen = ({navigation}) => {
    // const [contactList, setContactList] = useState(contacts)

    return (
        <View style={[defaultStyle.main]}> 
            <FlatList
                style={{marginTop: 70}}
                data={contacts}
                keyExtractor={(contact, i) => contact.id}
                renderItem={ ({item}) => 
                    <ContactItem contact={item} navigation={navigation}/>
                }
            />
        </View>
    )
}

export default ContactListScreen