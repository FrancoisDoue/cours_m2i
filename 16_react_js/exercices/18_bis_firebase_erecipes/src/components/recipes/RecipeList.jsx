import React, { useContext, useEffect, useState } from 'react';
import RecipeModal from './RecipeModal';
import RecipeItem from './RecipeItem';
import RecipeContext from '../../context/RecipeContext';
import AuthContext from '../../context/AuthContext';

const RecipeList = () => {

    const { recipesList } = useContext(RecipeContext)
    const { isLogged } = useContext(AuthContext)
    const [recipeModal, setRecipeModal] = useState(false)

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
                {!!recipesList.length && recipesList.map(r => 
                    <RecipeItem key={r.key} recipe={r} />
                )}
                
            </div>
        </div>

        {recipeModal && <RecipeModal closeAction={setRecipeModal}/>}
        </>
    );
}

export default RecipeList;
