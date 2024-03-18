import { Image, ScrollView, StyleSheet, Text, View } from 'react-native'
import React, { useLayoutEffect } from 'react'
import globalStyle from '../styles/globalStyle'
import Article from '../components/Article'
import LovelyButton from '../components/LovelyButton'
import { useDispatch, useSelector } from 'react-redux'
import { addToFavorites, removeFromFavorites, selectIsInFavorites } from '../slices/recipeSlice'

const RecipeScreen = ({ navigation, route }) => {    
    // récupération de la recette dans les params
    const recipe = route.params
    const dispatch = useDispatch()
    const favorites = useSelector(({recipe}) => recipe.favorites )
    const isInFavorites = () => !!favorites.find(fav => fav.id == recipe.id)

    const toggleAddToFavorites = () => {
        if (!isInFavorites()) dispatch(addToFavorites(recipe))
        else dispatch(removeFromFavorites(recipe.id))
    }

    useLayoutEffect(() => {
        navigation.setOptions({
            // ajout d'un toggle dans le header pour set en favorites les recettes
            headerRight: () => (
                <LovelyButton 
                    onPress={toggleAddToFavorites}
                    isLoved={isInFavorites()}
                />
            )
        })
    }, [favorites])

    return (
        <View style={[globalStyle.main]}>
            <ScrollView>
                <View>
                    <Image source={{uri: recipe.imageUrl}} style={styles.img} />
                </View>
                <View style={styles.centerItems}>
                    <Text style={styles.title}>{recipe.title}</Text>
                    <View style={[styles.centerItems, styles.smallDescription]}>
                        <Text style={globalStyle.descriptionText}>
                            {recipe.duration}m
                        </Text>
                        <Text style={globalStyle.descriptionText}>
                            {recipe.complexity.toUpperCase()}
                        </Text>
                        <Text style={globalStyle.descriptionText}>
                            {recipe.affordability.toUpperCase()}
                        </Text>
                    </View>
                    <Article title={'Ingredients'} list={recipe.ingredients} />
                    <Article title={'Steps'} list={recipe.steps} />
                </View>
            </ScrollView>
        </View>
    )
}

export default RecipeScreen

const styles = StyleSheet.create({
    centerItems: {
        marginTop: 10,
        alignItems: 'center',
    },
    smallDescription: {
        marginVertical: 10,
        flexDirection: 'row'
    },
    img: {
        height: 380,
    },
    title: {
        fontSize: 28,
        color: 'black',
        fontWeight: 'bold'
    }
})