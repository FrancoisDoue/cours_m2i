import { createSlice, createAsyncThunk } from '@reduxjs/toolkit'
import { BASE_DB_URL } from '../firebaseConfig'
import axios from 'axios'

export const fetchTodos = createAsyncThunk(
    "todo/fetchTodos", 
    async () => axios.get(`${BASE_DB_URL}todolist.json`)
        .then((res) => {
            const todos = []
            for (const key in res.data) {
                todos.push({id: key, ... res.data[key]})
            }
            return todos
        })
)

export const postTodo = createAsyncThunk(
    "todo/postTodo",
    async (todo) => {
        axios.post(`${BASE_DB_URL}todolist.json`, todo)
        .then((res) => {
            return {id: res.data.name, ...todo}
        })
    }
)
console.log(fetchTodos)

const todoSlice = createSlice({
    name: "todo",
    initialState: {
        todos : []
    },
    reducers: {

    }, 
    /**
     * Trois états possibles: 
     * .fulfilled, quand la requête se termine
     * .rejected, quand la requête échoue
     * .pending => quand la requête est en cours est en cours
     */
    extraReducers: (builder) => {
        builder.addCase(fetchTodos.fulfilled, (state, action) => {
            state.todos = action.payload
            // console.log('on extra reducer', action.payload );
            console.log('log todos reducer',state.todos)
        });
        builder.addCase(postTodo.fulfilled, (state, action) => {
            const result = action.payload
            state.todos.push(result)
            console.log('on push extra reducer', result );

        });
    }
})


export default todoSlice.reducer