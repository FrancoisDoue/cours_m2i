import { FlatList, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { CATEGORIES, MEALS } from '../../datas/data/data'
import globalStyle from '../styles/globalStyle'
import CategoryCube from '../components/CategoryCube'

const HomeScreen = ({navigation}) => {
    // console.log(CATEGORIES, MEALS)

    const handleNavigation = (item) => {
        console.log(item);
        navigation.navigate('MealsList', item)
    }

    return (
        <View style={[globalStyle.main]}>
            <FlatList
                data={CATEGORIES}
                numColumns={2}
                columnWrapperStyle={{ justifyContent: 'center' }}
                keyExtractor={item => item.id}
                renderItem={({ item }) =>
                    <CategoryCube
                        category={item}
                        onPress={() => handleNavigation(item)}
                    />
                }
            />
        </View>
    )
}

export default HomeScreen

const styles = StyleSheet.create({

})