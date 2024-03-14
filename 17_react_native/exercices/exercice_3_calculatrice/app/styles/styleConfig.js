import { Dimensions, PixelRatio } from "react-native";

console.log(Dimensions.get('window'))
const dim = Dimensions.get('window')
console.log(((85/3)*dim.scale))
console.log(dim.width*dim.scale)
export const toPixelRatio = (num) => {
    // const convert =  PixelRatio.getPixelSizeForLayoutSize((num*100) / dim.width)
    // return PixelRatio.roundToNearestPixel((num/3)*dim.scale)
    return num
}