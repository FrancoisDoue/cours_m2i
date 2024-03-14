import React from 'react';
import {View, Text, Pressable, StyleSheet} from 'react-native';
import styles from '../../styles/defaultStyle'
import colors from '../../styles/base/colors';
import Plus from '../../assets/svg/Plus.svg'

const ContactMain = () => {
    return (
        <View style={localStyle.mainContainer}>
            <View style={[styles.hFull]}>
                <View style={styles.hSmall}>
                    <Pressable 
                        onPress={() => console.log('test')}
                        style={({pressed}) => (pressed) ? localStyle.pressedButton : localStyle.button}
                    >
                        <Plus width={50} height={50}/>
                        <Text style={[styles.textLight, styles.subTitle]}>Nouveau contact</Text>
                    </Pressable>
                </View>
                <View style={localStyle.contactContainer}>
                    <Text style={localStyle.contactTitle}> 
                        Vos contact
                    </Text>
                </View>
                
            </View>
        </View>
    );
}

const localStyle = StyleSheet.create({
    mainContainer: {
        ...styles.hFull, 
        ...styles.paddingSM
    },
    contactContainer: {
        ...styles.hLarge, 
        ...styles.bgDarkPrimary, 
        ...styles.roundedSM, 
        ...styles.marginBottomSM,
        ...styles.paddingSM
    },
    contactTitle: {
        ...styles.textLightSubtle, 
        ...styles.subTitle, 
        ...styles.textEnd, 
        ...styles.marginHorizontalMD
    },
    button: {
        ...styles.roundedLG,
        ...styles.bgDarkPrimary,
        ...styles.centerContent,
        height: 50,
    },
    pressedButton: {
        ...styles.roundedLG,
        ...styles.centerContent,
        borderWidth: 4,
        borderColor: colors.textColorLightSubtle,
        height: 50,
    }
})

// const styles = StyleSheet.create({})

export default ContactMain;
