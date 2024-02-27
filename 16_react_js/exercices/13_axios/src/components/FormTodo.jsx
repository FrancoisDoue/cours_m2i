import React, { useRef } from 'react';
import classes from '../assets/form.module.css'

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
    return (
        <div className={classes.formContainer}>
            <h2>{!!editTask ? 'Modifier' :'Ajouter une tâche'}</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="title">Titre</label>
                    <input 
                        type="text" 
                        defaultValue={editTask?.title || ''}
                        // name="title" 
                        id="title" 
                        ref={title}
                    />
                </div>
                <div>
                    <label htmlFor="description">Description</label>
                    <input 
                        type="text" 
                        defaultValue={editTask?.description || ''}
                        // name="description" 
                        id="description" 
                        ref={description}
                    />
                </div>
                <button className={classes.btn} type='submit'>{editTask?'modifier':'Ajouter'}</button>
            </form>
            <button className={classes.btn} onClick={resetForm}>Annuler</button>
        </div>
    );
}

export default FormTodo;
