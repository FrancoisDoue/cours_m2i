import {Text, Pressable, StyleSheet } from 'react-native'
import colors from '../../styles/base/colors'
import React from 'react'

const CalculatorButton = ({children, style, action, value = null}) => {
    const localStyle = StyleSheet.create({
        bgButton: {
            backgroundColor: (style === "operation") ? colors.bgColorDark: colors.bgLight,
            borderRadius: (style === "operation") ? 10: 45,
            width: 85,
            height: 85,
            alignItems: 'center',
            justifyContent: 'center',
            margin: 8
            
        },
        textColor: {
            color: (style === "operation") ? colors.textColorLight : colors.textColorDark,
            fontWeight: '600',
            fontSize: 25
        },
        pressedEffect: {
            backgroundColor: (style === "operation") ? colors.bgLight : colors.bgColorDark,
            color: (style === "operation") ? colors.textColorDark : colors.textColorLight
        }
    })

  return (
    <Pressable 
        style={
            ({pressed}) => [localStyle.bgButton, (pressed) && localStyle.pressedEffect]
        } 
        onPress={() => action(value)}
    >
        <Text style={localStyle.textColor}>{children}</Text>
    </Pressable>
  )
}

export default CalculatorButton