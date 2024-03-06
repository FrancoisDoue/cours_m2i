import React from 'react';

const SortTool = ({actions}) => {
    return (
        <select className='form-control rounded-pill bg-dark text-light'>
            <option autoFocus disabled> Trier par ... </option>
            <option onClick={actions.sortByTitle}>Titre</option>
            <option onClick={actions.sortByScore}>Score</option>
        </select>
    );
}

export default SortTool;
