import { FlatList, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import globalStyle, { colors } from '../styles/globalStyle'

const Article = ({title, list}) => {

  return (
    <View style={[styles.articleMain]}>
        <View style={styles.articleHeader}>
            <Text style={styles.articleTitle}>{title}</Text>
        </View>
        <View style={styles.instructionList}>
            <FlatList
                data={list}
                keyExtractor={(_item, index) => index}
                scrollEnabled={false} // désactive le scroll, permet l'affichage dans une ScrollView
                renderItem={({item}) => 
                    <View style={styles.instructionItem}>
                        <Text style={styles.instructionText}>{item}</Text>
                    </View>
                }
            />
        </View>
    </View>
  )
}

export default Article

const styles = StyleSheet.create({
    articleMain: {
        width: '75%',
        marginVertical: 10,
        alignItems: 'center'
    },
    articleHeader: {
        width: '100%',
        alignItems: 'center',
        padding: 10,
        borderBottomWidth: 2,
        borderColor: colors.bgSoftColor,
    },
    articleTitle: {
        color: colors.bgSoftColor,
        fontSize: 23,
        fontWeight: '600'
    },
    instructionList: {
        width: '100%'
    },
    instructionItem: {
        width: '100%',
        backgroundColor: colors.bgSoftColor,
        marginTop: 8,
        padding: 5,
        elevation: 2,
        ...globalStyle.radiusSm,
        ...globalStyle.itemsCenter
    },
    instructionText: {
        fontSize: 17,
        color: colors.textSoftColor,
        fontWeight: '500',
        textAlign: 'center',
    }
})