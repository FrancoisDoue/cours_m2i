import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useDispatch } from 'react-redux'
import { addIds } from '../store/redux/data'

export default function Form() {

  const dispatch = useDispatch()

  function getRandom(){
    return Math.floor(Math.random()*100)
  }

  return (
    <View>
      <Button title="Ajout d'un id random" onPress={() => dispatch(addIds({ id : getRandom()}))} />
    </View>
  )
}

const styles = StyleSheet.create({})