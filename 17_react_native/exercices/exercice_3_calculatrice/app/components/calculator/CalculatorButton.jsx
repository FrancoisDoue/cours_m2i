import {Text, Pressable, StyleSheet } from 'react-native'
import colors from '../../styles/base/colors'
import React from 'react'

const CalculatorButton = ({children, square, action, value = null}) => {
    const localStyle = StyleSheet.create({
        bgButton: {
            backgroundColor: (square) ? colors.bgColorDark: colors.bgLight,
            borderRadius: (square) ? 10: 45,
            width: 85,
            height: 85,
            alignItems: 'center',
            justifyContent: 'center',
            margin: 8
            
        },
        textColor: {
            color: (square) ? colors.textColorLight : colors.textColorDark,
            fontWeight: '600',
            fontSize: 25
        },
        pressedEffect: {
            backgroundColor: (square) ? colors.bgLight : colors.bgColorDark,
            color: (square) ? colors.textColorDark : colors.textColorLight
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