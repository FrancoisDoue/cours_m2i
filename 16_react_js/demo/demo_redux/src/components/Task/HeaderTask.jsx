import React from 'react';
import { useSelector } from 'react-redux';

const HeaderTask = () => {
    const counterTask = useSelector(state => state.task.counterTask)

    return (
        <header>
            <p>nombre de tâches : {counterTask}</p>
        </header>
    );
}

export default HeaderTask;
