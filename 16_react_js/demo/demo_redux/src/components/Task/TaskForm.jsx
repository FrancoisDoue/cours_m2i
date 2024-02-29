import React from 'react';
import { useRef } from 'react';
import { useDispatch } from 'react-redux';
import { addTask } from './TaskSlice';

const TaskForm = () => {
    const textRef = useRef()
    const dispatch = useDispatch()

    const handleSubmit = (e) => {
        e.preventDefault()
        dispatch(addTask(textRef.current.value))
        textRef.current.value = ''
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" ref={textRef}/>
            <button>Ajouter une tâche</button>
        </form>
    );
}

export default TaskForm;
