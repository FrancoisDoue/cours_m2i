import React, { useRef } from 'react';
import '../assets/style/formtodo.css'
import { v4 } from 'uuid';

const FormTodo = ({emitSubmit}) => {

    const formRef = {
        title: useRef(),
        description: useRef(),
        dueDate: useRef(),
    }
    
    const handleSubmit = (e) => {
        e.preventDefault()

        const title = formRef.title.current.value;
        const dueDate = formRef.dueDate.current.value;

        if (!title) return
        const values = {
            title: title,
            description: formRef.description.current.value,
            dueDate: (new Date(dueDate || Date.now())).toLocaleDateString(),
            id: v4()
        }
        emitSubmit(values)
        formRef.title.current.value = ''
        formRef.description.current.value = ''
        formRef.dueDate.current.value = ''
    }
    return (
        <div className="sideForm" >
            <h3>To do form</h3>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="title">Title :</label>
                    <input type="text" name="title" id="title" ref={formRef.title} />
                </div>
                <div>
                    <label htmlFor="description">Description :</label>
                    <textarea name="description" id="description"ref={formRef.description} >

                    </textarea>
                </div>
                <div>
                    <label htmlFor="dueDate">Due date: </label>
                    <input type="date" name="dueDate" id="dueDate"ref={formRef.dueDate} pattern='dd/mm/yyyy' />
                </div>
                <div>
                    <button type="submit">Add a task</button>
                </div>
            </form>
        </div>
    );
}

export default FormTodo;
