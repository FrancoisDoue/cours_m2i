import { View, FlatList } from 'react-native'
import React from 'react'
import {contacts} from '../tempDatas/contactList.json'
import ContactItem from '../components/contacts/ContactItem.jsx'
import defaultStyle from '../styles/defaultStyle.js'

const ContactListScreen = ({navigation}) => {

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