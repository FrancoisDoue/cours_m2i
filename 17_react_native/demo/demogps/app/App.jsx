import { StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import Geolocation from '@react-native-community/geolocation'

// npm install @react-native-community/geolocation --save
// add
// <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
// in ..\android\app\src\main\AndroidManifest.xml

const App = () => {

    const [latitude, setLatitude] = useState(null)
    const [longitude, setLongitude] = useState(null)

    useEffect(() => {
        Geolocation.requestAuthorization()
        Geolocation.getCurrentPosition(
            ({coords}) => {
                setLatitude(coords.latitude)
                setLongitude(coords.longitude)
            },
            (err) => console.error(err),
            {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000}
        )
    }, [])

    return (
        <View>
            <Text>Latitude : {latitude}</Text>
            <Text>Longitude : {longitude}</Text>
        </View>
    )
}

export default App

const styles = StyleSheet.create({})