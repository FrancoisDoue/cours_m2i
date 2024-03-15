import { Image, ScrollView, StyleSheet, Text, View } from 'react-native'
import React, { useContext, useLayoutEffect } from 'react'
import globalStyle from '../styles/globalStyle'
import Article from '../components/Article'
import LovelyButton from '../components/LovelyButton'
import RecipeContext from '../context/RecipeContext'

const RecipeScreen = ({ navigation, route }) => {

    const recipe = route.params
    const {favorites, setFavorites} = useContext(RecipeContext)

    const isInFavorites = (id) => !!favorites.find(fav => fav.id == id)

    const toggleAddToFavorites = () => {
        if (!isInFavorites(recipe.id)) setFavorites([...favorites, recipe])
        else setFavorites([...favorites.filter(fav => fav.id != recipe.id)])
    }

    useLayoutEffect(() => {
        navigation.setOptions({
            headerRight: () => (
                <LovelyButton 
                    onPress={toggleAddToFavorites}
                    isLoved={isInFavorites(recipe.id)}
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