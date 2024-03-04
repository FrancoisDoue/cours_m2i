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
            console.log(i)
            state.recipes[i] = action.payload
        }
    }
})

export const { setRecipes, addRecipe, replaceRecipe } = recipesSlice.actions

export default recipesSlice.reducer