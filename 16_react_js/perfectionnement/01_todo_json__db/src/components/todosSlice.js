import { createSlice } from "@reduxjs/toolkit";

const todosSlice = createSlice({
    name: 'todos',
    initialState: {
        todoList: [],
        isError: false
    },
    reducers: {
        setTodos: (state, action) => {
            state.todoList = action.payload
        },
        setError: (state) => {
            state.isError = true
        }
    }
})

export const {setTodos} = todosSlice.actions

export default todosSlice.reducer