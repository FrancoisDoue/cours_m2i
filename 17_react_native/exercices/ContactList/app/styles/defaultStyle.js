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
    textLightSubtle: {
        color: colors.textColorLightSubtle
    },
    mainTitle: {
        fontSize: 50
    },
    title: {
        fontSize: 40
    },
    subTitle: {
        fontSize: 30
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
    endAroundContent:{
        alignItems: 'flex-end',
        justifyContent: 'space-around'
    },
    selfStart: {
        alignSelf: 'flex-start'
    },
    roundedSM: {
        borderRadius: 5
    },
    roundedMD: {
        borderRadius: 15
    },
    roundedLG: {
        borderRadius: 40
    },
    textEnd: {
        textAlign: 'right'
    }
})