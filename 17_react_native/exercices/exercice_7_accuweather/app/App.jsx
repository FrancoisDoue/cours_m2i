import { ActivityIndicator, Button, Image, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import Geolocation from '@react-native-community/geolocation'
import {apiLocation, weather} from './api/api.backend'

const App = () => {


    const [locationInfo, setLocationInfo] = useState(null)
    const [weatherInfo, setWeatherInfo] = useState(null)
    const [error, setError] = useState(false)

    const getLocationInfo = (lat, lon) => {
        apiLocation.get('', {params: { q: `${lat},${lon}`, details: true, toplevel: true}})
            .then((data) => {
                setLocationInfo(data)
                setError(false)
                getWeather(data?.locationKey)
            })
            .catch((error) => {
                console.log(error)
                setError(true)
            })
    }

    const getWeather = (locationKey) => {
        weather.get(`/${locationKey}`)
                .then(datas => {
                    setWeatherInfo(datas)
                    setError(false)
                })
                .catch(() => setError(true))
    }

    const updateLocation = () => {
        setLocationInfo(null)

        Geolocation.requestAuthorization()
        Geolocation.getCurrentPosition(
            (res) => {
                setError(false)
                const {latitude, longitude} = res.coords
                // console.log(res)
                getLocationInfo(latitude, longitude)
            },
            (error) => {
                console.error(error)
                setError(true)
            },
            {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000}
        )
    }

    useEffect(() => { updateLocation() }, [null])

    console.log(weatherInfo)

    return (
        <View style={styles.main}>
            {!error ?
                (!!locationInfo ? 
                    <View style={styles.activityContainer}>
                        <View style={styles.resultBox}>
                            <Text style={styles.label}>
                                Ville : <Text style={styles.resultText}>{locationInfo?.LocalizedName}</Text>
                            </Text>
                            <Text style={styles.label}>
                                Pays : <Text style={styles.resultText}>{locationInfo?.Country.LocalizedName}</Text>
                            </Text>
                            <Text style={[styles.label, styles.textCenter]}> {weatherInfo?.Day?.IconPhrase} </Text>
                            <Text style={[styles.label, styles.textCenter, styles.smallText]}> 
                                Minimale : {weatherInfo?.Temperature?.Minimum.Value}°C | Maximale: {weatherInfo?.Temperature?.Maximum.Value}°C
                            </Text>
                            <Image source={{uri: `https://flagcdn.com/h80/${locationInfo?.Country.ID.toLowerCase()}.png`}} height={100}/>
                            <Button title='update location' onPress={updateLocation} />
                        </View>
                    </View>
                    :
                    <View style={styles.activityContainer}>
                        <ActivityIndicator size={100} color={'#CCEEFF'}/>
                    </View>
                )
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
        height: '40%',
        width: '70%',
        justifyContent: 'space-around',
    },
    label: {
        color: 'white',
        width: '100%',
        fontSize: 25,
    },
    resultText: {
        fontWeight: '700',
        fontSize: 30,
        textDecorationLine: 'underline'
    },
    textCenter: {
        textAlign: 'center'
    },
    smallText: {
        fontSize: 18
    }
})