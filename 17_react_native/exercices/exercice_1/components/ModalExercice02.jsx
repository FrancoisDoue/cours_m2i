import { Modal, StyleSheet, Text, Button, View, TextInput } from 'react-native'
import React, { useState } from 'react'

const ModalExercice02 = ({visible, actions}) => {
  const [inputValue, setInputValue] = useState('')

  const submitArticle = () => {
    actions.addArticle(inputValue)
    actions.closeModal()
  }

  return (
    <Modal visible={visible}>
      <View style={styles.container}>
        <Text style={styles.textAlign}>Ajouter votre article</Text>
        <TextInput 
          onChangeText={setInputValue}
          style={styles.inputModal} 
        />
        <Button onPress={submitArticle} title='ajouter'/>
      </View>


    </Modal>
  )
}

export default ModalExercice02

const styles = StyleSheet.create({
  container: {
    flex:1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  textModal: {
    textAlign: 'center'
  },
  inputModal: {
    width: 100,
    borderStyle: 'solid',
    borderColor: 'black'
  }
})