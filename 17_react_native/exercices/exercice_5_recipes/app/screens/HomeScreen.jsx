import { FlatList, View } from 'react-native'
import React, { useContext, useLayoutEffect } from 'react'
import globalStyle from '../styles/globalStyle'
import CategoryCube from '../components/CategoryCube'
import RecipeContext from '../context/RecipeContext'
import FavButton from '../components/FavButton'

const HomeScreen = ({navigation}) => {

    const {CATEGORIES, favorites} = useContext(RecipeContext)

    useLayoutEffect(() => {
        // s'il y a des recettes en favoris, affiche le bouton des favoris dans le header
        if (!!favorites.length) {
            navigation.setOptions({
                headerRight: () => (
                    // FavButton renvoit vers le screen 'MealsList', comme pour n'importe quelle category pressed
                    // donc envoi d'un paramètre 'favContext' pour l'affichage des favoris
                    <FavButton onPress={() => navigation.navigate('MealsList', {favContext: true})}/>
                )
            })  
        } else navigation.setOptions({headerRight: null}) 
        // une fois le header set, il reste en l'état, donc je force la suppression du bouton
    }, [favorites])

    const handleMealListNavigation = (item) => {
        // vers le screen 'MealsList', avec pour paramètre une catégorie
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
