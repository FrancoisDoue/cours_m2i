import { View, Text, Pressable, StyleSheet } from 'react-native'
import colors from '../../styles/base/colors'
import React from 'react'

const CalculatorButton = ({value = null, type, children}) => {
    const localStyle = StyleSheet.create({
        bgButton: {
            backgroundColor: (type === "operation") ? colors.bgColorDark: colors.bgLight,
            borderRadius: (type === "operation") ? 10: 45,
            width: 85,
            height: 85,
            alignItems: 'center',
            justifyContent: 'center',
            margin: 8
            
        },
        textColor: {
            color: (type === "operation") ? colors.textColorLight : colors.textColorDark,
            fontWeight: '600',
            fontSize: 25
        }
    })

  return (
    <Pressable style={localStyle.bgButton}>
        <Text style={localStyle.textColor}>{children}</Text>
    </Pressable>
  )
}

export default CalculatorButton