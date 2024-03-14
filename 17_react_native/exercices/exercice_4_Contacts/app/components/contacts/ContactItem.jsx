import { View, Text, Pressable, StyleSheet } from 'react-native'
import React from 'react'
import defaultStyle from '../../styles/defaultStyle'
import colors from '../../styles/base/colors'

const ContactItem = ( {contact, navigation} ) => {

    const handleNavigation = () => {
        navigation.navigate('ContactDetail', {contact: contact})
    }

  return (
    <Pressable 
        onPress={handleNavigation} 
        style={({pressed}) => [defaultStyle.centerContent, styles.button(pressed)]
    }>
        <Text 
            style={[defaultStyle.subTitle, defaultStyle.textLight]}
        >
            {contact?.firstname} {contact?.lastname}
        </Text>
    </Pressable>
  )
}
const styles = StyleSheet.create({
    button: (pressed) => ({
        height: 50,
        margin: 5,
        backgroundColor: (pressed) ? colors.bgLight: colors.bgColorDarkAccent,
        ...defaultStyle.roundedSM,
    })
}) 

export default ContactItem