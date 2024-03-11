import { Modal, StyleSheet, Text, Button } from 'react-native'
import React from 'react'

const ModalExercice02 = ({visible, actions}) => {
  return (
    <Modal visible={visible}>
      <Text>ModalExercice02</Text>
      <Button onPress={actions.closeModal} title='ajouter'/>
    </Modal>
  )
}

export default ModalExercice02

const styles = StyleSheet.create({})