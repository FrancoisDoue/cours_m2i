import React from 'react';
import { useDispatch } from 'react-redux';
import { deleteTask, toggleTask } from './TaskSlice';

const TaskItem = ({task}) => {

    const dispatch = useDispatch()

    return (
        <div>
            <p>{task.text} - {task.done ? "Terminé": "A faire"}</p>
            <input type="checkbox" onClick={() => dispatch(toggleTask(task.id))} checked={task.done} readOnly={true}/>
            <button onClick={() => dispatch(deleteTask(task.id))}>Supprimer</button>
        </div>
    );
}

export default TaskItem;
