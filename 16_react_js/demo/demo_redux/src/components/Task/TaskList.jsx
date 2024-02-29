import React from 'react';
import { useSelector } from 'react-redux';
import TaskItem from './TaskItem';

const TaskList = () => {

    const tasks = useSelector(state => state.task.tasks)

    return (
        <>
        {tasks.map((t) => <TaskItem key={t.id} task={t} /> )}
        </>
    );
}

export default TaskList;
