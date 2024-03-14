import { StyleSheet } from "react-native"
import { toPixelRatio } from "../styleConfig"


export default StyleSheet.create({
    hFull: {
        flex: 1
    },
    hXSmall: {
        flex: 1/12
    },
    hSmall: {
        flex: 2/6
    },
    hMedium: {
        flex: 1/2
    },
    hLarge: {
        flex: 4/6
    },
    hXLarge: {
        flex: 11/12
    },
    
    paddingSM: {
        padding: toPixelRatio(10)
    },
    paddingMD: {
        padding: toPixelRatio(20)
    },
    paddingBottomMD: {
        paddingBottom: toPixelRatio(20)
    }
})