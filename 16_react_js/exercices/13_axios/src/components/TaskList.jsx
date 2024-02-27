import React from 'react';

const TaskList = ({items, actions}) => {
    console.log(items)
    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Description</th>
                        <th colSpan={2}>Actions</th>
                    </tr>
                </thead>
                <tbody>
                {!!items.length && items.map(item => 
                <tr key={item.id}>
                    <td><h3>{item.title}</h3></td>
                    <td>{item.description}</td>
                    <td>
                        <button onClick={() => actions.setEditTask(item)}>Editer</button>
                        <button onClick={() => actions.removeTodo(item.id)}>Supprimer</button>
                    </td>
                </tr>
                )}
                </tbody>
            </table>
        </div>
    );
}

export default TaskList;
