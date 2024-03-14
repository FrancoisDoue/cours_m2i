import { View, Text, Linking, Pressable, StyleSheet } from 'react-native'
import React, { useLayoutEffect } from 'react'
import defaultStyle from '../styles/defaultStyle'
import colors from '../styles/base/colors'

const DetailContactScreen = ({ navigation, route }) => {

    const { contact } = route.params

    useLayoutEffect(() => {
        navigation.setOptions({ title: contact.firstname || contact.lastname })
    })

    const handleCallPress = () => {
        Linking.openURL(`tel:${contact.phone}`)
    }

    return (
        <View style={[defaultStyle.main, defaultStyle.centerContent]}>
            {contact?.firstname &&
                <Text style={[defaultStyle.subTitle, defaultStyle.textLightSubtle]}>
                    Prénom: <Text style={[defaultStyle.title, defaultStyle.textLight]}>
                        {contact?.firstname}
                    </Text>
                </Text>
            }
            {contact?.lastname &&
                <Text style={[defaultStyle.subTitle, defaultStyle.textLightSubtle]}>
                    Nom: <Text style={[defaultStyle.title, defaultStyle.textLight]}>
                        {contact?.lastname}
                    </Text>
                </Text>
            }
            <Text style={[defaultStyle.subTitle, defaultStyle.textLightSubtle]}>
                Téléphone: <Text style={[defaultStyle.title, defaultStyle.textLight]}>
                    {contact?.phone}
                </Text>
            </Text>
            <Pressable 
                onPress={handleCallPress}
                style={(e) => [styles.callButton(e)]}
            >
                <Text style={[defaultStyle.textLight, defaultStyle.subTitle]}>
                    Appeler
                </Text>
            </Pressable>
        </View>
    )
}
const styles = StyleSheet.create({
    callButton: ({pressed}) => ({
        backgroundColor: pressed? colors.bgColorDark: colors.bgColorDarkAccent,
        marginTop: 30,
        paddingVertical: 10,
        paddingHorizontal: 60,
        borderWidth: 2,
        borderColor: (pressed) ? colors.bgLight: colors.bgColorDarkAccent,
        ...defaultStyle.roundedSM,
    })
})

export default DetailContactScreen