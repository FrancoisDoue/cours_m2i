<script setup>
import { computed, reactive, ref } from 'vue';


  let task = ref('')
  let taskList = ref([])
  let actualList = taskList;

  const pushAndClear = () => {
    const newTask = reactive({
        task: task,
        isDone: false,
        deleteThis: () => taskList.value = taskList.value.filter(e => e !== newTask)
      })
    taskList.value.push(newTask)
    task = ''
  }
  // const filterItems = (toggle) => {
  //   actualList = taskList;
  //   if(toggle === undefined) return actualList;
  //   return actualList.value.filter(e => toggle ? e.isDone : !e.isDone)
  // }

</script>

<template>
  <form @submit.prevent>
    <label for="form-task">Task:</label>
    <input type="text" name="task" id="form-task" v-model="task">
    <button @click="pushAndClear">Add task</button>

  </form>
  <div>
    <label > Filter :</label>
    <!-- pas fonctionnel -->
    <select name="" id="">
      <option @click="actualList = taskList">All / reset</option>
      <option @click="() => actualList = actualList.filter(e => e.isDone)" >Done tasks</option>
      <option @click="() => actualList = actualList.filter(e => !e.isDone)">To do tasks</option>
    </select>
  </div>
  <div>
    <ul v-for="element in actualList">
      <li>
        <span >{{ element.task }}</span>
        <input type="checkbox" v-model="element.isDone">
        <button @click="element.deleteThis(element.id)">Delete</button>
      </li>
    </ul>

  </div>

</template>

<style scoped>

</style>
