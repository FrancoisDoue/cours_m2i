import { createSlice } from '@reduxjs/toolkit'

// ici on centralise toutes les variables d'état et methodes associées aux fonctionnalités Task
const taskSlice = createSlice({
    name: 'task',
    initialState: {
        // variables d'états à leur état initial
        tasks: [
            { id: 1, text: "faire des courses", done: false},
            { id: 2, text: "faire du ménage", done: true},
        ],
        counterTask: 2,
    },
    reducers: {
        // state: donne accès à l'initialState
        // action: élément envoyé à notre store {type : "task/addTask", payload}
        // action.payload: un objet contenant les paramètres de la fonction
        addTask: (state, action) => {
            const newTask = {
                text: action.payload,
                id: Date.now(),
                done: false,
            }
            state.tasks.push(newTask)
            state.counterTask ++
        },
        deleteTask: (state, action) => {
            state.tasks = state.tasks.filter(task => task.id !== action.payload)
            state.counterTask -- 
        },
        toggleTask: (state, action) => {
            const task = state.tasks.find(task => task.id === action.payload)
            task.done = !task.done
        }
    }
})

// export des methodes de taskSlices
export const { addTask, deleteTask, toggleTask } = taskSlice.actions
export default taskSlice.reducer