import { Dimensions, PixelRatio } from "react-native";

console.log(Dimensions.get('window'))
const dimensions = Dimensions.get('window')

export const toPixelRatio = (num) => {
    const convert =  PixelRatio.getPixelSizeForLayoutSize( num / 3 )
    return PixelRatio.roundToNearestPixel(convert)
}