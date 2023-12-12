<script setup>
import { ref } from 'vue';
import TodoForm from './TodoForm.vue';
import TodoListItem from './TodoListItem.vue';

const todos = ref([]);
const addTodoList = (obj) => {
  todos.value.push(obj);
}
const deleteItem = (index) => {
    todos.value.splice(index, 1);
}
const editItem = (str, index) => {  
    todos.value[index].todo = str
}


</script>

<template>
  <TodoForm @add-todo="addTodoList"></TodoForm>
  <div v-if="todos.length">
      <h3 >Liste des tâches : </h3>
      <ul v-for="(item, index) in todos">
        <TodoListItem :todo="item.todo" :index="index" :key="index" @delete-item="deleteItem" @edit-item="editItem"/>
      </ul>
  </div>
</template>

<style scoped>

</style>
