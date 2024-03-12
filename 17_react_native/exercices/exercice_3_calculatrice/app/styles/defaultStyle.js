import { StyleSheet } from "react-native"
import colors from "./base/colors"
import sizing from "./base/sizing"

export default StyleSheet.create({
    ...sizing,
    main: {
        ...sizing.hFull,
        backgroundColor: colors.bgColorDefault
    },
    bgDarkPrimary:{
        backgroundColor: colors.bgColorDarkAccent,
    },
    bgDarkSecondary:{
        backgroundColor: colors.bgColorDark
    },
    textDark: {
        color: colors.textColorDark
    },
    textLight: {
        color: colors.textColorLight
    },
    title: {
        fontSize: 40
    },
    centerContent: {
        justifyContent: 'center',
        alignItems: 'center'
    },
    wrapContent: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        alignItems: 'stretch'
    },

    roundedSM: {
        borderRadius: 5
    },
})