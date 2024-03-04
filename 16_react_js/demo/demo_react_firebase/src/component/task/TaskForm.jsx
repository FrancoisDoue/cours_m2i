import React, { useEffect, useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addTask } from './taskSlice';
import axios from 'axios';
import { BASE_DB_URL } from '../../firebaseConfig';

const TaskForm = () => {
    const textRef = useRef()
    const user = useSelector(state => state.auth.user)
    const taskList = useSelector((state) => state.task.tasks)
    const dispatch = useDispatch()

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log(user)

        const newTask = {
            id: Date.now(),
            text : textRef.current.value,
            isDone: false
        }
        if(user.idToken) {
            axios.post(`${BASE_DB_URL}todolist.json?auth=${user.idToken}`, newTask)
                .then(res => {
                    console.log(res)
                    dispatch(addTask(newTask))
                })
                .catch(err => console.log(err))
        }
    }

    useEffect(() => console.log(taskList), [taskList])


    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="task">nouvelle tâche</label>
                <input type="text" name="task" id="task" ref={textRef} />
                <button>Ajouter une tâche</button>
            </form>
        </>
            
    );
}

export default TaskForm;
