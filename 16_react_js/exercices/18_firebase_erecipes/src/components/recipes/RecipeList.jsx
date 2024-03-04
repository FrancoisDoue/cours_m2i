import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import RecipeModal from './RecipeModal';
import axios from 'axios';
import { BASE_DB_URL } from '../../firebaseConfig';
import { setRecipes } from './recipesSlice';
import RecipeItem from './RecipeItem';

const RecipeList = () => {

    const recipes = useSelector(state => state.recipes.recipes)
    const isLogged = useSelector(state => !!state.auth.user )
    const dispatch = useDispatch()
    const [recipeModal, setRecipeModal] = useState(false)

    useEffect(() => {
        axios.get(`${BASE_DB_URL}recipes.json`)
            .then(res => {
                const resMap = []
                for(const key in res.data) {
                    resMap.push({...res.data[key], key: key})
                }
                dispatch(setRecipes(resMap))
            })
            .catch(err => console.log(err))
    }, [])

    console.log(recipes)

    return (
        <>
        <div className='card bg-dark text-light'>
            <div className='card-header border-light d-flex justify-content-between'>
                <h3>Recettes</h3>
                {isLogged &&
                    <button 
                        onClick={() => setRecipeModal(true)}
                        className='btn btn-outline-success text-light'
                    >
                        <i className="bi bi-plus-circle"> </i>
                        Ajouter
                    </button>
                }
            </div>
            <div className='card-content p-4 d-flex flex-wrap justify-content-center'>
                {!!recipes.length && recipes.map(r => 
                    <RecipeItem key={r.id} recipe={r} />
                )}
                
            </div>
        </div>

        {recipeModal && <RecipeModal closeAction={setRecipeModal}/>}
        </>
    );
}

export default RecipeList;
