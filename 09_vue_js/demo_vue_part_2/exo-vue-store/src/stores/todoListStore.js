import { defineStore } from 'pinia'
import { computed, ref } from 'vue'
import { v4 } from 'uuid'

export const useTodoListStore = defineStore('todo', () => {
  const todoList = ref([])

  const getTodoById = (id) => todoList.value.find(t => t.id === id)

  const addTodo = (todo) => computed(todoList.value.push({
      id: v4(),
      "todoText": todo,
      isFavourite: false, 
      // isDone: false // pour plus tard ..?
  }))

  const removeTodo = (id) => todoList.value = todoList.value.filter(t => t.id !== id)

  return {todoList, getTodoById, addTodo, removeTodo}
})
