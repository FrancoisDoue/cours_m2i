<script setup>
import { ref } from 'vue';
import { useTodoListStore } from '@/stores/todoListStore'
import TodoItem from '@/components/todo/TodoItem.vue';

const todoStore = useTodoListStore();

const todoText = ref('')
const isFilterTodo = ref(false)

const createTodo = () => {
    if(!todoText.value) return;
    todoStore.addTodo(todoText.value)
    todoText.value = ''
}
</script>

<template>
    <header class="bg-dark bg-gradient bg-opacity-75 d-flex flex-column align-items-center py-4 shadow-sm">
        <h1 class="text-light mb-4 fw-bolder">To Duh</h1>
        <img src="../assets/logo-2-1-1.png" alt="" class="position-absolute mt-3" style="height: 80px;">
        <form @submit.prevent="createTodo()" class="w-25" style="z-index: 10;">
            <div class="d-flex ">
                <input v-model="todoText" type="text" class="form-control me-2 shadow">
                <button type="submit" class="btn btn-warning text-dark fw-bold px-4 shadow">Add</button>
            </div>
        </form>
    </header>
    <div class="container d-flex justify-content-center">
        <div class="w-50 d-flex justify-content-end mt-2">
            <button @click="() => isFilterTodo = false" class="btn btn-outline-dark m-1">All tasks</button>
            <button @click="() => isFilterTodo = true" class="btn btn-outline-dark m-1">Favourite tasks</button>
        </div>
        
    </div>
    <div 
        class="container d-flex flex-column align-items-center"
        v-for="todo in isFilterTodo ? 
            todoStore.todoList.filter(e => e.isFavourite) : 
            todoStore.todoList /*à mes souhaits.*/" 
    >
       <TodoItem :key="todo.id" :todo="todo"/>
    </div>
</template>
