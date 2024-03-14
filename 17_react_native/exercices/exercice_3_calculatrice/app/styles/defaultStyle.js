import { StyleSheet } from "react-native"
import colors from "./base/colors"
import sizing from "./base/sizing"
import { toPixelRatio } from "./styleConfig"

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
    mainTitle: {
        fontSize: toPixelRatio(50)
    },
    title: {
        fontSize: toPixelRatio(40)
    },
    subTitle: {
        fontSize: toPixelRatio(30)
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

    roundedSM: {
        borderRadius: 5
    },
})