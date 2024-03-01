import { createSlice } from "@reduxjs/toolkit";

const todosSlice = createSlice({
    name: 'todos',
    initialState: {
        todoList: []
    },
    reducers:{
        getTodos: (state, action) => {
            console.log('on todos/getTodos')
        }
    }
})

export const {getTodos} = todosSlice.actions

export default todosSlice.reducer