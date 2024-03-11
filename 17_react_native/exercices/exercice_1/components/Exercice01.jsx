import { View, Text, Image, StyleSheet, SafeAreaView} from 'react-native'
import React from 'react'

const Exercice01 = () => {
  return (

    <SafeAreaView style={styles.main}>
        <Image 
            style={styles.imageStyle} 
            source={{uri: 'https://images.rtl.fr/~c/2000v2000/rtl/www/1313193-jacques-chirac-le-9-mars-1981.jpg'}}
        />
        <View style={styles.mainTextView} >
            <Text style={styles.textNormal}>
                Nom: <Text style={styles.textBold}>Chirac</Text>
            </Text>
            <Text style={styles.textNormal}>
                Prénom: <Text style={styles.textBold}>Jacques</Text>
            </Text>
            <Text style={styles.textNormal}>
                Téléphone: <Text style={styles.textBold}>01.50.60.06.66</Text>
            </Text>
            <Text style={styles.textNormal}>
                Adresse: <Text style={styles.textBold}>35 rue des Pias, 59200 Tourcoing</Text>
            </Text>
        </View>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
    main : {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f9ecd7'
    },
    mainTextView: {
        width: 380,
        paddingBottom: 100
    },
    imageStyle : {
        height: 150,
        width: 150,
        borderRadius: 75,
        margin: 50
    },
    textNormal : {
        fontSize: 25,
        color: '#000000'
    },
    textBold : {
        fontWeight: 'bold'
    }
})

export default Exercice01