<script setup>
import { computed, reactive, ref } from 'vue';
let task = ref('');
let taskList = ref([]);

const pushAndClear = () => {
  if (task !== ''){
    const thisTask = reactive({
        task: task,
        isDone: false,
        deleteThisTask: () => taskList.value = taskList.value.filter(e => e !== thisTask)
      })
    computed(taskList.value.push(thisTask))
    task = ''
  }
}
// // let isEnabledFilters = ref(false)
// // let showList = ref(false)
// const filter = ref((bool) => {
//   isEnabledFilters = true
//   showList = bool
// })

</script>

<template>
  <form @submit.prevent>
    <label for="form-task">Task:</label>
    <input type="text" name="task" id="form-task" v-model="task">
    <button @click="pushAndClear">Add task</button>

  </form>
  <div>
    <label for="sort-select"> Sorting :</label>
    <select>
      <option selected v-on:click.prevent></option>
      <option @click="taskList.sort(e => !e.isDone)" >Sort by done tasks</option>
      <option @click="taskList.sort(e => e.isDone)">sort by undone tasks</option>
    </select>

  </div>
  <div>
    <ul v-for="element in taskList">
      <li :key="element.task">
        <span :style="{color: element.isDone ? 'green': 'black'}">
          {{ element.task }}
        </span>
        <input type="checkbox" v-model="element.isDone">
        <button @click="element.deleteThisTask">Delete</button>
      </li>
    </ul>
  </div>
</template>

<style scoped>

</style>
<!-- <li :key="element.task" v-show="isEnabledFilters? (element.isDone == showList) : true"> -->
    <!-- <label for="filter-select"> Filters : </label>
    <select>
      <option  @click="isEnabledFilters = false" selected>Disabled</option>
      <option @click="() => filter(true)" >Filter by done tasks</option>
      <option @click="() => filter(false)" >Filter by undone tasks</option>
    </select> -->