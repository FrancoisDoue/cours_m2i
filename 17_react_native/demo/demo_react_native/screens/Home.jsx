import { View, Text, Button } from 'react-native'
import React from 'react'
import { useNavigation } from '@react-navigation/native'

// const navigation = useNavigation

const Home = () => {
    const navigation = useNavigation()
    return (
        <View>
            <Text>Home</Text>
            <Button title={'to page 2'} onPress={() => navigation.navigate('Page 2')}/>
        </View>
    )
}

export default Home