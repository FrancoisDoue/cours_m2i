import { View, Text } from 'react-native'
import React from 'react'
import styles from '../../styles/defaultStyle'
import CalculatorButton from './CalculatorButton'

const Calculator = () => {
    
  return (
    <View style={[styles.hFull, styles.bgDarkPrimary, styles.roundedSM]}>
      <View style={[styles.hSmall]}>
        
      </View>
      <View style={[styles.hLarge, styles.wrapContent]}>

        <CalculatorButton type={'operation'}>AC</CalculatorButton>
        <CalculatorButton type={'operation'}>^</CalculatorButton>
        <CalculatorButton type={'operation'}>%</CalculatorButton>
        <CalculatorButton type={'operation'}>/</CalculatorButton>

        <CalculatorButton value={7} type={'number'}>7</CalculatorButton>
        <CalculatorButton value={8} type={'number'}>8</CalculatorButton>
        <CalculatorButton value={9} type={'number'}>9</CalculatorButton>

        <CalculatorButton type={'operation'}>x</CalculatorButton>

        <CalculatorButton value={4} type={'number'}>4</CalculatorButton>
        <CalculatorButton value={5} type={'number'}>5</CalculatorButton>
        <CalculatorButton value={6} type={'number'}>6</CalculatorButton>

        <CalculatorButton type={'operation'}>-</CalculatorButton>

        <CalculatorButton value={1} type={'number'}>1</CalculatorButton>
        <CalculatorButton value={2} type={'number'}>2</CalculatorButton>
        <CalculatorButton value={3} type={'number'}>3</CalculatorButton>

        <CalculatorButton type={'operation'}>+</CalculatorButton>

        <CalculatorButton type={'number'}>.</CalculatorButton>
        <CalculatorButton value={0} type={'number'}>0</CalculatorButton>
        <CalculatorButton type={'number'}>Del</CalculatorButton>
        <CalculatorButton type={'operation'}>=</CalculatorButton>

      </View>
    </View>
  )
}

export default Calculator