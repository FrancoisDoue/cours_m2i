import React, { useContext, useState } from 'react';
import RecipeModal from './RecipeModal';
import RecipeContext from '../../context/RecipeContext';
import AuthContext from '../../context/AuthContext';

const RecipeItem = ({recipe}) => {

    const [editModal, setEditModal] = useState(false)
    const {deleteRecipe} = useContext(RecipeContext)
    const {isLogged} = useContext(AuthContext)
    
    return (
        <>
        <div className='card bg-dark border-light text-light mb-4 col-8'>
            <div className='card-header border-light d-flex justify-content-between'>
                <h3>{recipe.title}</h3>
                <div>
                    <span className='px-2 py-1 mx-1 rounded-pill border border-warning'>
                        {recipe.prepTime}"
                    </span>
                    <span className='px-2 py-1 mx-1 rounded-pill border border-danger'>

                        {recipe.cookTime}"
                    </span>
                </div>
            </div>
            <div className='card-content'>
                <div className='row p-4'>
                    <div className='col-6'>
                        <h5>Ingredients</h5>
                        <ul>
                            {!!recipe?.ingredients && recipe.ingredients.map(ing => 
                                <li key={ing.id}>{ing.name}</li>
                            )}
                        </ul>
                    </div>
                    <div className='col-6'>
                        <h5>Instructions</h5>
                        <p className='card-text p-2'>{recipe.instruction}</p>
                    </div>      
                </div>
            </div>
            {isLogged && 
            <div className='card-footer d-flex justify-content-end border-light'>
                <button 
                    className='btn btn-warning text-light mx-1 text-dark'
                    onClick={() => setEditModal(true)}
                >Editer</button>
                <button 
                    className='btn btn-danger text-light mx-1'
                    onClick={() => deleteRecipe(recipe)}
                >Supprimer</button>
            </div>
            }
        </div>
        {editModal && <RecipeModal editRecipe={recipe} closeAction={setEditModal}/>}
        
        </>
    );
}

export default RecipeItem;
