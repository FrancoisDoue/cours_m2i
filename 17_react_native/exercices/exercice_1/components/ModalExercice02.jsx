import { Modal, StyleSheet, Text, Image, Button, View, TextInput } from 'react-native'
import React, { useState } from 'react'
import cart from '../assets/img/cart.png'

const ModalExercice02 = ({visible, actions}) => {
  const [inputValue, setInputValue] = useState('')
  const [quantity, setQuantity] = useState(1)

  const submitArticle = () => {
    setQuantity(1)
    actions.addArticle(inputValue, quantity)
    actions.closeModal()
  }
  const handleQuantityBtns = (isAddContext) => {
    if (!isAddContext && quantity > 1) setQuantity(prev => prev - 1)
    else setQuantity(prev => prev + 1)
  }

  return (
    <Modal visible={visible}>
      <View style={styles.container}>
        <View style={styles.inputContainer}>
          <View  style={styles.centerContainer}>
            <Image style={styles.cartStyle} source={cart} />
          </View>
          <TextInput 
            placeholder='Ajoutez votre article'
            onChangeText={setInputValue}
            style={styles.inputModal} 
          />
          <View style={[styles.centerContainer, styles.hCenter]}>
            <Text>Quantité : </Text>
            <Button title=' - ' onPress={() => handleQuantityBtns(false)}/>
            <Text>{quantity}</Text>
            <Button title=' + ' onPress={() => handleQuantityBtns(true)}/>
          </View>
        </View>
        <View style={styles.centerContainer}>
          <Button onPress={submitArticle} color={'orange'} title='ajouter'/>
          <Button onPress={actions.closeModal} color={'red'} title='Annuler'/>
        </View>
      </View>


    </Modal>
  )
}

export default ModalExercice02

const styles = StyleSheet.create({
  container: {
    flex:1,
    justifyContent: 'center',
  },
  inputContainer: {
    paddingHorizontal: 80,
    marginBottom: 20,
  },
  centerContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    margin: 10
  },
  hCenter: {
    alignItems: 'center'
  },
  textModal: {
    textAlign: 'center'
  },
  inputModal: {
    borderWidth: 1,
    borderRadius: 10
  },
  cartStyle: {
    height: 120,
    width: 125,
  }
})