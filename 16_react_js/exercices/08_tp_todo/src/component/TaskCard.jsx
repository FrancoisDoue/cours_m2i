import React, { useState } from 'react';
import '../assets/style/cardtodo.css';


const TaskCard = ({values, emitDelete}) => {
    
    const [isDone, setIsDone] = useState(false)

    return (
        <div className='card'>
            <div className='card-header'>
                <h4>{values.title}</h4>
                <span>{values.dueDate}</span>
            </div>
            <hr />
            <div className='card-body'>
                <p>{values.description || 'Pas de description'}</p>
            </div>
            <hr />
            <div className='card-btn'>
                <button 
                    className={isDone? 'success': 'warning'} 
                    onClick={() => setIsDone(!isDone)}
                >
                    {isDone? 'Done': 'To do'}
                </button>
                <button className='delete' onClick={()=> emitDelete(values.id)}>Delete</button>
            </div>
        </div>
    );
}

export default TaskCard;
