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
        }
    }
})

export const { setRecipes, addRecipe } = recipesSlice.actions

export default recipesSlice.reducer