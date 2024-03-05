import { createSlice } from "@reduxjs/toolkit";

const todosSlice = createSlice({
    name: 'todos',
    initialState: {
        todoList: [],
        isError: false,
        error: {},
    },
    reducers: {
        setTodos: (state, action) => {
            state.todoList = action.payload
        },
        setError: (state, action) => {
            state.isError = true
            // console.log(action.payload)
            // state.error ={... action.payload.error}
        }
    }
})

export const {setTodos, setError} = todosSlice.actions

export default todosSlice.reducer