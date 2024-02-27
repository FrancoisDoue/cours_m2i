import React from 'react';
import { useRef } from 'react';

const FormTodo = ({actions, editTask}) => {

    const title = useRef()
    const description = useRef()

    const handleSubmit = (e) => {
        e.preventDefault()
        if (!title.current.value) return
        const newTask = {
            title: title.current.value,
            description: description.current.value
        }
        resetForm()
        if (!!editTask){
            actions.setEditTask(null)
            return actions.editTodo(editTask.id, newTask)
        } 
        return actions.addTodo(newTask)
    }

    const resetForm = () => {
        title.current.value = ''
        description.current.value = ''
        if(!!editTask) actions.setEditTask(null)
    }
    console.log(editTask)

    return (
        <div>
            <h2>{!!editTask ? 'Modifier' :'Ajouter une tâche'}</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="title">Titre</label>
                    <input 
                        type="text" 
                        name="title" 
                        id="title" 
                        ref={title}
                        defaultValue={!!editTask ? editTask.title : ''}
                    />
                </div>
                <div>
                    <label htmlFor="description">Description</label>
                    <input 
                        type="text" 
                        name="description" 
                        id="description" 
                        ref={description}
                        defaultValue={!!editTask ? editTask.description : ''}
                    />
                </div>
                <button onClick={resetForm}>Annuler</button>
                <button type='submit'>{!!editTask?'modifier':'Ajouter'}</button>

            </form>
        </div>
    );
}

export default FormTodo;
