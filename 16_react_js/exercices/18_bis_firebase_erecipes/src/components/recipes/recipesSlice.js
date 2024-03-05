import { createSlice } from "@reduxjs/toolkit";
import { ingredients } from "../../data/ingredients";

const recipesSlice = createSlice({
    name: 'recipes',
    initialState: {
        recipes: [],
        ingredients: ingredients,
    },
    reducers: {
        setRecipes: (state, action) => {
            state.recipes = action.payload
        },
        addRecipe: (state, action) => {
            state.recipes.push(action.payload)
        },
        replaceRecipe: (state, action) => {
            const i = state.recipes.findIndex(element => element.id === action.payload.id)
            state.recipes[i] = action.payload
        },
        removeRecipe: (state, action) => {
            state.recipes = state.recipes.filter(recipe => recipe.id != action.payload.id)
        }
    }
})

export const selectAllRecipes = (state) => state.recipes.recipes

export const { setRecipes, addRecipe, replaceRecipe, removeRecipe } = recipesSlice.actions

export default recipesSlice.reducer