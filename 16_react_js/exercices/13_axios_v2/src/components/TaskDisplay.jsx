import React from 'react';
import { useOutletContext } from 'react-router-dom';

const TaskDisplay = () => {
    const {todos} = useOutletContext()

    return (
        <div>
            <ul>
            {/* {!!todos.length && todos.map(e =>)

            } */}

            </ul>
        </div>
    );
};

export default TaskDisplay;