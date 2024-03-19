import { ActivityIndicator, Button, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import Geolocation from '@react-native-community/geolocation'
import api from './api/api.backend'

const App = () => {


    const [locationInfo, setLocationInfo] = useState(null)
    const [error, setError] = useState(false)

    const getLocationInfo = (lat, lon) => {
        api.get('', {params: { q: `${lat},${lon}` }})
            .then((data) => {
                setLocationInfo(data)
                setError(false)
            })
            .catch((error) => {
                console.log(error)
                setError(true)
            })
    }

    const updateLocation = () => {
        setLocationInfo(null)

        // Geolocation.requestAuthorization()
        // Geolocation.getCurrentPosition(
        //     (res) => {
        //         setError(false)
        //         const {latitude, longitude} = res.coords
        //         getLocationInfo(latitude, longitude)
        //     },
        //     (error) => {
        //         console.error(error)
        //         setError(true)
        //     },
        //     {enableHighAccuracy: false, timeout: 20000, maximumAge: 60000}
        // )
    }

    useEffect(() => { updateLocation() }, [])

    return (
        <View style={styles.main}>
            {!error ?
                // (!!locationInfo ? 
                    <View style={styles.activityContainer}>
                        <View style={styles.resultBox}>
                            <Text >Vous êtes: </Text>
                            <Text style={styles.label}>
                                Ville : <Text>{locationInfo?.LocalizedName || 'Quekqupart'}</Text>
                            </Text>
                            <Text style={styles.label}>
                                Pays : <Text>{locationInfo?.Country.LocalizedName || 'Fronce'}</Text>
                            </Text>
                            <Button title='update location' onPress={updateLocation} />

                        </View>
                    </View>
                    // :
                    // <View style={styles.activityContainer}>
                    //     <ActivityIndicator size={100} color={'#CCEEFF'}/>
                    // </View>
                // )
                :
                <Text>Error</Text>
            }
        </View>
    )
}

export default App

const styles = StyleSheet.create({
    main: {
        flex: 1,
        backgroundColor : '#80D4FF'
    },
    activityContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    resultBox: {
        height: '30%',
        width: '70%',
        justifyContent: 'space-around'
    }

})