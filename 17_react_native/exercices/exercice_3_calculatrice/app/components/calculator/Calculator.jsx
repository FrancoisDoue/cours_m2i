import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import styles from '../../styles/defaultStyle'
import CalculatorButton from './CalculatorButton'

const Calculator = () => {

  const [value, setValue] = useState('')
  const [memory, setMemory] = useState('')
  const [history, setHistory] = useState('')
  const [callBack, setCallBack] = useState({})

  const handleSetValue = (value) => setValue((prev) => prev + value)

  // pov: après le café
  const handleOperation = (operatingObj) => {
    if(!!callBack?.operation){
      setHistory((prev) => prev + callBack.symbol + value )
      setMemory(`${callBack.operation(memory, value)}`)
    } else {
      setHistory(`${+value}`)
      setMemory(`${+value}`)
    }
    setValue('')
    setCallBack(operatingObj)
  }
  const handleResult = () => {
    if(!!callBack?.operation){
      const tempValues = [+memory, +value]
      const tempOperation = callBack
      handleClear()
      setHistory((prev) => prev + tempOperation.symbol + value )
      setValue( `${tempOperation.operation(...tempValues)}` )
    } else return
  }

  const handleClear = () => {
    setMemory('')
    setValue('')
    setCallBack({})
  }

  const backAction = () => setValue((prev) => prev.substring(0, prev.length -1))
  
  const addition = {
    symbol: '+',
    operation: (a, b) => (+a) + (+b)
  }
  const substraction = {
    symbol: '\u2212',
    operation: (a, b) => (+a) - (+b)
  } 
  const division ={
    symbol: '\u00f7',
    operation: (a, b) =>  (+a) / (+b)
  } 
  const multiplication = {
    symbol: '\u00D7',
    operation: (a, b) => (+a) * (+b)
  }
  const modulo = {
    symbol: '%',
    operation: (a, b) => (+a) % (+b)
  }
  const exponentiation = {
    symbol: '\u207F',
    operation: (a, b) => (+a) ** (+b)
  }
    
  return (
    <View style={[styles.hFull, styles.bgDarkPrimary, styles.roundedSM]}>
      <View style={[styles.hSmall, styles.paddingBottomMD, styles.endAroundContent]}>
          <Text style={[styles.textLightSubtle, styles.selfStart, styles.paddingMD, styles.subTitle]}> {history} </Text>
          <Text style={[styles.textLight, styles.subTitle, styles.textEnd]}> {+memory || ''} </Text>

        <Text style={[styles.textLight, styles.mainTitle]}> {callBack?.symbol || ''} </Text>
        <Text style={[styles.textLight, styles.mainTitle]}> {+value || 0} </Text>
        
      </View>
      <View style={[styles.hLarge, styles.wrapContent]}>

        <CalculatorButton action={handleClear} square>AC</CalculatorButton>
        <CalculatorButton action={handleOperation} value={exponentiation} square>x{exponentiation.symbol}</CalculatorButton>
        <CalculatorButton action={handleOperation} value={modulo} square>{modulo.symbol}</CalculatorButton>
        <CalculatorButton action={handleOperation} value={division} square>{division.symbol}</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'7'}>7</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'8'}>8</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'9'}>9</CalculatorButton>

        <CalculatorButton action={handleOperation} value={multiplication} square>{multiplication.symbol}</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'4'}>4</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'5'}>5</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'6'}>6</CalculatorButton>

        <CalculatorButton action={handleOperation} value={substraction} square>{substraction.symbol}</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'1'}>1</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'2'}>2</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'3'}>3</CalculatorButton>

        <CalculatorButton action={handleOperation} value={addition} square>{addition.symbol}</CalculatorButton>

        <CalculatorButton action={handleSetValue} value={'.'}>.</CalculatorButton>
        <CalculatorButton action={handleSetValue} value={'0'}>0</CalculatorButton>
        <CalculatorButton action={backAction}>Del</CalculatorButton>
        <CalculatorButton action={handleResult} square>=</CalculatorButton>

      </View>
    </View>
  )
}

export default Calculator