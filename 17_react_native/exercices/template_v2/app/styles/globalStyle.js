import { Appearance, Dimensions, StyleSheet } from "react-native"

const theme = Appearance.getColorScheme()
const window = Dimensions.get('screen')
console.log(window)

export const colors = (theme == 'dark') ? {
    bgPrimary: '#3B194D',
    bgSecondary: '#100317',
    bgTertiary: '#EAD9F2',
    colorPrimary: '#EAD9F2',
    colorSecondary: '#BA9CC9',
    colorTertiary: '#F9F1FD',
} : {
    bgPrimary: '#C47DE8',
    bgSecondary: '#F6E8FC',
    bgTertiary: '#3B194D',
    colorPrimary: '#3B194D',
    colorSecondary: '#8C59A6',
    colorTertiary: '#1E0D26',
}

export const gradientColors = {
    main: [
        {offset: '0%', color: colors.bgPrimary, opacity: '1'},
        {offset: '100%', color: colors.bgSecondary, opacity: '1'},
    ]
}

export default StyleSheet.create({

})