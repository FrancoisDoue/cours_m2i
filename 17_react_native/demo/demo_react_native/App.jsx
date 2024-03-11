import React from 'react';
import {View, Image, StyleSheet, Text, SafeAreaView} from 'react-native';
import FirstComponent from './FirstComponent'



const App = () => {
    return (
        <SafeAreaView style={styles.container}>
            <Text style={[styles.chartreuse, styles.titleBig]} >Hello world!</Text>
            <Text style={styles.cyan}>Aled.</Text>
            <Image 
                style={styles.img}
                source={{uri: 'https://i.ytimg.com/vi/x7Li_heZiiw/maxresdefault.jpg'}}
            />
            <FirstComponent />
        </SafeAreaView>
    );
}

// mauvaise pratique
const container = {
    backgroundColor: 'chartreuse',
    flex: 1,

}

// bonne pratique ('fin meilleure, quoi.)
const styles = StyleSheet.create({
    container: {
        backgroundColor: 'darkred',
        flex: 1,
        padding: 20
    },
    chartreuse: {
        color: 'chartreuse',
    },
    cyan: {
        color: 'cyan'
    },
    titleBig: {
        fontSize: 70,
    },
    img: {
        width: 400,
        height: 250,
        alignItems: 'center'
        // flex: 'align-item-center'
    }
})

export default App;
