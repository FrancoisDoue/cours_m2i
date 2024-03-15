import { StyleSheet } from "react-native"

export const colors = {
    bgColor : '#f2f2f2',
    bgSoftColor: '#e1b497',
    textSoftColor: '#371400',
}

export default StyleSheet.create({
    main: {
        backgroundColor: colors.bgColor,
        flex: 1
    },
    radiusSm: {
        borderRadius: 5
    },
    radiusMd: {
        borderRadius: 20
    },
    itemsCenter: {
        alignItems: 'center',
        justifyContent: 'center'
    },
    textEmphasis1: {
        fontSize: 25,
        fontWeight: '700',
    },
    textEmphasis2: {
        fontSize: 20,
        fontWeight: '600',
    },
    descriptionText: {
        color: 'black',
        margin: 7
    },
})