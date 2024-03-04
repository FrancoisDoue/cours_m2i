import React, { useRef, useState } from 'react';
import { createPortal } from 'react-dom';
import {modal, modalContent} from '../auth/Modal.module.css'
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios'
import { BASE_DB_URL } from '../../firebaseConfig';
import { addRecipe, replaceRecipe } from './recipesSlice';

const RecipeModal = ({ editRecipe, closeAction}) => {

    console.log(editRecipe)

    const ingredientList = useSelector(state => state.recipes.ingredients)
    const idToken = useSelector(state => state.auth.user?.idToken) || null
    const dispatch = useDispatch()

    const titleRef = useRef()
    const instructionRef = useRef()
    const preptimeRef = useRef()
    const cooktimeRef = useRef()
    const [ingredients, setIngredients] = useState(editRecipe?.ingredients || [])

    const handleCheck = (e, ingredient) => {
        if (e.target.checked) setIngredients([...ingredients, ingredient])
        else setIngredients(ingredients.filter(i => i != ingredient))
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        const newRecipe = {
            id: editRecipe?.id || Date.now(),
            title: titleRef.current.value,
            instruction: instructionRef.current.value,
            prepTime: +preptimeRef.current.value,
            cookTime: +cooktimeRef.current.value,
            ingredients: ingredients
        }
        if(!editRecipe) sendNewRecipe(newRecipe)
        else updateRecipe(newRecipe)
    }

    const sendNewRecipe = (recipe) => {
        axios.post(`${BASE_DB_URL}recipes.json?auth=${idToken}`, recipe)
            .then(() => {
                dispatch(addRecipe(recipe))
                closeAction(false)
            })
            .catch(err => console.log(err))
    }
    const updateRecipe = (recipe) => {
        console.log(editRecipe.key)
        axios.put(`${BASE_DB_URL}recipes/${editRecipe.key}.json?auth=${idToken}`, recipe)
            .then(() => {
                dispatch(replaceRecipe(recipe))
                closeAction(false)
            })
            .catch(err => console.log(err))
    }

    return createPortal(
        <div className={modal}>
            <div className={modalContent + ' card bg-dark text-white'}>
                <div className='card-header border-light'>
                    <h3 className='card-title text-center'>
                        {!!editRecipe? 'Editer la recette' : 'Nouvelle recette'}
                    </h3>
                </div>
                <form onSubmit={handleSubmit} className='card-content'>
                    <div className="p-4">
                        <label htmlFor="recipe-title" className='p-2'>Titre de la recette</label>
                        <div className='input-group'>
                            <input type="text" className='form-control' id='recipe-title' name='recipe-title' 
                                defaultValue={editRecipe?.title || ''}
                                ref={titleRef}
                            />
                        </div>
                        <label htmlFor="recipe-instruction" className='p-2'>Instructions</label>
                        <div className='input-group'>
                            <textarea 
                                className='form-control' name="recipe-instruction" id="recipe-instruction" style={{resize: 'none'}}
                                defaultValue={editRecipe?.instruction || ''}
                                ref={instructionRef}
                            ></textarea>
                        </div>
                        <div className='row mt-2'>
                            <div className='col-6 border-end border-light'>
                                <label className='p-2'>Déterminez les ingrédients</label>
                                <div>
                                {ingredientList.map(i => (
                                    <div className='form-check' key={i.id}>
                                        <input
                                            className='form-check-input' type="checkbox" name={`check-${i.name}`} id={`check-${i.name}`}
                                            defaultChecked={!!editRecipe?.ingredients.find(item => i.id == item.id)}
                                            onChange={(e) => handleCheck(e, i)} 
                                        />
                                        <label htmlFor={`check-${i.name.toLowerCase()}`} className='form-check-label'  >{i.name}</label>
                                    </div>
                                ))}
                                </div>
                            </div>
                            <div className='col-6'>
                                <label htmlFor="recipe-preptime" className='p-2'>Temps de préparation</label>
                                <div className='input-group'>
                                    <input type="number" className='form-control' id='recipe-preptime' name='recipe-preptime' 
                                        defaultValue={editRecipe?.prepTime || ''}
                                        ref={preptimeRef}
                                    />
                                </div>
                                <label htmlFor="recipe-cooktime" className='p-2'>Temps de cuisson</label>
                                <div className='input-group'>
                                    <input type="number" className='form-control' id='recipe-cooktime' name='recipe-cooktime' 
                                        defaultValue={editRecipe?.cookTime || ''}
                                        ref={cooktimeRef}
                                    />
                                </div>
                            </div>
                        </div>
                        <div className='p-3 text-center'>
                            <button className='btn btn-outline-light w-50'>
                                {!!editRecipe? 'Editer' : 'Ajouter'}
                            </button>
                        </div>
                    </div>
                </form>
                <div className='card-footer border-light text-center pb-1'>
                    <p className='text-end text-light p-0'>
                        <button 
                            onClick={() => closeAction(false)} 
                            className='btn btn-outline-light p-1 ml-auto mt-1'
                        > Retour </button>
                    </p>

                </div>
            </div>
        </div>,
        document.body
    );
}

export default RecipeModal;
