import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import styles from '../../styles/defaultStyle'
import CalculatorButton from './CalculatorButton'

const Calculator = () => {

  const [value, setValue] = useState('')
  const handleSetValue = (value) => setValue(prev => prev + value)
  
  const addition = () => {
    console.log('add')
  }
  const substraction = () => {
    console.log('sub')
  }
  const division = () => {
    console.log('divide')
  }
  const modulo = () => {
    console.log('mod')
  }

  useEffect(() => {console.log(value)}, [value])

  const logTest = (value) => console.log(value)
    
  return (
    <View style={[styles.hFull, styles.bgDarkPrimary, styles.roundedSM]}>
      <View style={[styles.hSmall]}>
        <Text style={[styles.textLight, styles.subTitle]}> Test </Text>
        <Text style={[styles.textLight, styles.mainTitle]}> {+value || 0} </Text>
        
      </View>
      <View style={[styles.hLarge, styles.wrapContent]}>

        <CalculatorButton action={logTest} type={'operation'}>AC</CalculatorButton>
        <CalculatorButton action={logTest} type={'operation'}>^</CalculatorButton>
        <CalculatorButton action={logTest} type={'operation'}>%</CalculatorButton>
        <CalculatorButton action={logTest} type={'operation'}>/</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'7'} type={'number'}>7</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'8'} type={'number'}>8</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'9'} type={'number'}>9</CalculatorButton>

        <CalculatorButton type={'operation'}>x</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'4'} type={'number'}>4</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'5'} type={'number'}>5</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'6'} type={'number'}>6</CalculatorButton>

        <CalculatorButton type={'operation'}>-</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'1'} type={'number'}>1</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'2'} type={'number'}>2</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'3'} type={'number'}>3</CalculatorButton>

        <CalculatorButton type={'operation'}>+</CalculatorButton>

        <CalculatorButton type={'number'}>.</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'0'} type={'number'}>0</CalculatorButton>
        <CalculatorButton type={'number'}>Del</CalculatorButton>
        <CalculatorButton type={'operation'}>=</CalculatorButton>

      </View>
    </View>
  )
}

export default Calculator