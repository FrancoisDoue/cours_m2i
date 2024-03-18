import { createSlice } from "@reduxjs/toolkit";
import { CATEGORIES, MEALS } from "../../datas/data/data";

const recipeSlice = createSlice({
    name: 'recipe',
    initialState: {
        categories: CATEGORIES || [],
        recipes: MEALS || [],
        recipeByCategorie: [],
        favorites: [],
    },
    reducers: {
        addToFavorites: (state, action) => {
            state.favorites.push(action.payload)
        },
        removeFromFavorites: (state, action) => {
            state.favorites = state.favorites.filter(
                recipe => recipe.id != action.payload
            )
        },
        setRecipeByCategorie: (state, action) => {
            state.recipeByCategorie = state.recipes.filter(
                (r) => !!r.categoryIds.includes(action.payload)
            )
        }
    }
})


export const { addToFavorites, removeFromFavorites, setRecipeByCategorie } = recipeSlice.actions

export default recipeSlice.reducer