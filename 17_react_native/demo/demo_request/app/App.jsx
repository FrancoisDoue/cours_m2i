import { View, Text, Button } from 'react-native'
import React, { useEffect } from 'react'
import axios from 'axios'

const App = () => {

    const getApiWithFetch = () => {
        fetch(`https://jsonplaceholder.typicode.com/users/3`)
            .then(data => data.json())
            .then(console.log)
            .catch(console.error)
    }

    const getApiWithAxios = () => {
        axios.get(`https://jsonplaceholder.typicode.com/users/2`)
            .then(({data}) => console.log(data))
            .catch(console.error)
    }

    return (
        <View>
            <Text>App</Text>
            <Button title={"Fetch with fetch (duh)"} onPress={getApiWithFetch} />
            <Button title={"Fetch with Axios"} onPress={getApiWithAxios} />
        </View>
    )
}

export default App