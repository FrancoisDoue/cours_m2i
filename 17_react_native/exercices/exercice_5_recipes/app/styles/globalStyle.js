import { StyleSheet } from "react-native"

export const colors = {
    bgColor : '#f2f2f2'
}

export default StyleSheet.create({
    main: {
        backgroundColor: colors.bgColor,
        flex: 1
    },
    radiusSm: {
        borderRadius: 10
    },
    radiusMd: {
        borderRadius: 20
    },
    itemsCenter: {
        alignItems: 'center',
        justifyContent: 'center'
    },
    textEmphasis: {
        fontSize: 25,
        fontWeight: '700',
    }
})