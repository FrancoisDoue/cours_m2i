import { View, Text } from 'react-native'
import React, { useState } from 'react'
import styles from '../../styles/defaultStyle'
import CalculatorButton from './CalculatorButton'

const Calculator = () => {

  const [value, setValue] = useState('')
  const [memory, setMemory] = useState('')
  const [callBack, setCallBack] = useState([])

  const handleSetValue = (value) => setValue((prev) => prev + value)

  // pov: à sec de café
  const handleOperation = (cb) => {
    if(!!callBack[0] && typeof callBack[0] === 'function'){
      setMemory(`${callBack[0](memory, value)}`)
    } else {
      setMemory(`${+value}`)
    }
    setValue('')
    setCallBack([cb])
  }
  const handleResult = () => {
    if(!!callBack[0] && typeof callBack[0] === 'function'){
      const tempValues = [memory, value]
      const tempOperation = callBack[0]
      handleClear()
      setValue( tempOperation(...tempValues) )
    } else return
  }

  const handleClear = () => {
    setMemory('')
    setValue('')
    setCallBack([])
  }

  const backAction = () => setValue((prev) => prev.substring(0, prev.length -1))
  
  const addition = (a, b) => (+a) + (+b)

  const substraction = (a, b) => (+a) - (+b)

  const division = (a, b) =>  (+a) / (+b)

  const multiplication = (a, b) => (+a) * (+b)

  const modulo = (a, b) => (+a) % (+b)

  const exponentiation = (a, b) => (+a) ** (+b)
    
  return (
    <View style={[styles.hFull, styles.bgDarkPrimary, styles.roundedSM]}>
      <View style={[styles.hSmall, styles.paddingMD, styles.endAroundContent]}>
        <Text style={[styles.textLight, styles.subTitle]}> {+memory || 0} </Text>
        <Text style={[styles.textLight, styles.mainTitle]}> {+value || 0} </Text>
        
      </View>
      <View style={[styles.hLarge, styles.wrapContent]}>

        <CalculatorButton action={handleClear} style={'operation'}>AC</CalculatorButton>
        <CalculatorButton action={handleOperation} value={exponentiation} style={'operation'}>^</CalculatorButton>
        <CalculatorButton action={handleOperation} value={modulo} style={'operation'}>%</CalculatorButton>
        <CalculatorButton action={handleOperation} value={division} style={'operation'}>/</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'7'} style={'number'}>7</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'8'} style={'number'}>8</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'9'} style={'number'}>9</CalculatorButton>

        <CalculatorButton action={handleOperation} value={multiplication} style={'operation'}>x</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'4'} style={'number'}>4</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'5'} style={'number'}>5</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'6'} style={'number'}>6</CalculatorButton>

        <CalculatorButton action={handleOperation} value={substraction} style={'operation'}>-</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'1'} style={'number'}>1</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'2'} style={'number'}>2</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'3'} style={'number'}>3</CalculatorButton>

        <CalculatorButton action={handleOperation} value={addition} style={'operation'}>+</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'.'} style={'number'}>.</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'0'} style={'number'}>0</CalculatorButton>
        <CalculatorButton action={backAction} style={'number'}>Del</CalculatorButton>
        <CalculatorButton action={handleResult} style={'operation'}>=</CalculatorButton>

      </View>
    </View>
  )
}

export default Calculator