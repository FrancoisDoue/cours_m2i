<script setup>
import { ref } from 'vue';
const inputText = ref('');
const emit = defineEmits(['add-todo']);

const emitAddTodo = () => {
    if(!inputText.value) return;
    emit('add-todo', {todo: inputText.value, isDone: false});
    inputText.value = '';
}
</script>

<template>
  <div class="d-flex flex-row">
    <input type="text" name="" id="" placeholder="Saisir une tâche" class="form-control mx-2" v-model="inputText" @keyup.enter="emitAddTodo">
    <button class="btn btn-primary" @click="emitAddTodo"> Ajouter </button>
  </div>
</template>

<style scoped>

</style>
