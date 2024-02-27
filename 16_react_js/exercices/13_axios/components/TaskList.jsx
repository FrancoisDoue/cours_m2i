import React from 'react';

const TaskList = ({items, actions}) => {
    console.log(items)
    return (
        <div>
            {!!items.length && items.map(i => 
                <div key={i.id}>
                    <h3>{i.title}</h3>
                    <div>{i.description}</div>
                    <div>
                        <button onClick={() => actions.setEditTask(i)}>Editer</button>
                        <button onClick={() => actions.removeTodo(i.id)}>Supprimer</button>
                    </div>
                </div>
            )}
        </div>
    );
}

export default TaskList;
