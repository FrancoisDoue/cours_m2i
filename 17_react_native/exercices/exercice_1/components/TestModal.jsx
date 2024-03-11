import { Modal, StyleSheet, Text, View, Button } from 'react-native'
import React from 'react'

const TestModal = (props) => {
    return (
        <Modal visible={props.visible} >
            <Text>Ceci est une modale react native</Text>
            <Button title='Close modal' onPress={() => props.closeModal(false)} />
        </Modal>
    )
}

export default TestModal

const styles = StyleSheet.create({})