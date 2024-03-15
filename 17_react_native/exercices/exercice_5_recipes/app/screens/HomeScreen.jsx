import { FlatList, View } from 'react-native'
import React, { useContext, useLayoutEffect } from 'react'
import globalStyle from '../styles/globalStyle'
import CategoryCube from '../components/CategoryCube'
import RecipeContext from '../context/RecipeContext'
import FavButton from '../components/FavButton'

const HomeScreen = ({navigation}) => {

    const {CATEGORIES, favorites} = useContext(RecipeContext)

    useLayoutEffect(() => {
        if (!!favorites.length) {
            navigation.setOptions({
                headerRight: () => (
                    <FavButton onPress={() => navigation.navigate('MealsList', {favContext: true})}/>
                )
            })
        } 
    }, [favorites])

    const handleMealListNavigation = (item) => {
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
                        onPress={() => handleMealListNavigation(item)}
                    />
                }
            />
        </View>
    )
}

export default HomeScreen
