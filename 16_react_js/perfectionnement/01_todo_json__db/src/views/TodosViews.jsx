import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { useSelector } from 'react-redux';
import { setTodos } from '../components/todosSlice';
import api from '../services/apiService';
import { useOutletContext } from 'react-router-dom';

const TodosViews = () => {
    const {todos} = useOutletContext()

    console.log(todos)
    
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