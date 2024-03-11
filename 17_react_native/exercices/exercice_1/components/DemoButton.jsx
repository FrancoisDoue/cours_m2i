import { StyleSheet, Text, View, Button, FlatList, TextInput} from 'react-native'
import React, { useState } from 'react'
import TestModal from './TestModal'

const DemoButton = () => {
    const [counter, setCounter] = useState(1)
    const [input, setInput] = useState('')
    const [openModal, setOpenModal] = useState(false)

    // const handleInput = (value) => setInput(value)
    


    return (
        <View style={styles.container}>
            
            <Text style={styles.textNormal}>Compteur :</Text>
            <Text style={[styles.textNormal, styles.textBold]}>{counter}</Text>
            <View>
                <Button title={'Ajouter 1'} onPress={() => setCounter(counter + 1)} />
            </View>
            <View>
                <Button title={'Ouvrir modal'} onPress={() => setOpenModal(true)} />
            </View>
            <TestModal visible={openModal} closeModal={setOpenModal} />
            {/* <FlatList 
                data={datas} 
                keyExtractor={(_item, index) => index}
                renderItem={({item}) =>
                <View>
                    <Text style={styles.textNormal} > {item.text}, id: {item.id} </Text>    
                </View>
                }
            /> */}
            <TextInput onChangeText={setInput} value={input}/>
        </View>
    )
}

export default DemoButton

const datas = [
    {text: 'Test1', id: 0},
    {text: 'Test2', id: 1},
    {text: 'Test3', id: 2},
    {text: 'Test4', id: 3},
    {text: 'Test5', id: 4},
]
const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    },
    textNormal: {
        color: '#000000',
        fontSize: 20
    },
    textBold: {
        fontWeight: 'bold'
    }
})