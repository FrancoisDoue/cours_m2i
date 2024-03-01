import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { useSelector } from 'react-redux';
import { setTodos } from '../components/todosSlice';
import api from '../services/apiService';

const TodosViews = () => {
    const todoList = useSelector(state => state.todos.todoList)
    const dispatch = useDispatch()

    useEffect(() => {
        if(!todoList.length) {
            api.get('/todos')
                .then((res) => res.data && dispatch(setTodos(res.data)))
                .catch(err => console.log(err))
        }
    }, [])
    
    console.log(todoList)
    
    return (
        <div className='d-flex'>
            <div>
            TodoView

            </div>
            <div>
            TodosViews
            </div>
        </div>
    );
};

export default TodosViews;