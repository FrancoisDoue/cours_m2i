import React from 'react';
import { useNavigate, useOutletContext } from 'react-router-dom';

const TaskDisplay = () => {
    const navigate = useNavigate()
    const {todos, deleteTodo} = useOutletContext()

    return (
        <div>
            <div>
                <button onClick={() => navigate('/add')}>Ajouter une tâche</button>
            </div>
            <ul style={{listStyle: 'none'}}>
            {!!todos.length && todos.map(e =>
                <li key={e.id} style={{border: '1px solid #fff', borderRadius: '4px', margin : '.5em'}}>
                    <div style={{textAlign: 'center'}}>
                        <h4>{e.title}</h4>
                        <hr />
                        <div>
                            <button onClick={() => navigate(`/edit?id=${e.id}`)}>Editer</button>
                            <button onClick={() => deleteTodo(e.id)}>Supprimer</button>
                        </div>
                    </div>
                </li>
            )}

            </ul>
        </div>
    );
};

export default TaskDisplay;