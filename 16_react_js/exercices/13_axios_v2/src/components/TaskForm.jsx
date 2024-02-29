import React, { useEffect } from 'react';
import { useRef } from 'react';
import { useNavigate, useOutletContext, useSearchParams } from 'react-router-dom';

const TaskForm = () => {
    
    const {addTodo, editTodo} = useOutletContext()
    const navigate = useNavigate()
    const [params] = useSearchParams()
    const id = params.get('id') ?? null

    console.log(id)

    const title = useRef()    

    const handleSubmit = (e) => {
        e.preventDefault()
        const value = {title: title.current.value}
        if (!value.title) return;
        (!!id) ? editTodo(id, value) : addTodo(value)
        return navigate('/')
    }

    return (
        <>
        <h4></h4>
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="title">Libellé de la tâche : </label>
                <input type="text" name="title" id="title" ref={title}/>
            </div>
            <button>{!!id ? 'Modifier' : 'Ajouter'}</button>
            
        </form>
        <button onClick={() => navigate('/')}>
            Annuler
        </button>
        </>
    );
};

export default TaskForm;