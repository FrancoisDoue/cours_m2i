<script setup>
import { computed, ref } from 'vue';

const getRandomNbr = (max, min = 0) => Math.floor(Math.random() * (max - min) + min)
let list = ref([1,3,15,69,1,52,54,23])
let showList = ref(false)
/* ----------------------------------- */
let toggleFirstP = ref(false)
let toggleSecondP = ref(false)
let classes = computed(() => {
  return {'p-toggle-red': toggleFirstP.value}
})

const sayHello = () => alert('Hello');
let inputValue = ref('');
const enterInputHandler = () => console.log()

</script>

<template>
  <p v-if="list?.length && !showList">List is hidden</p>
  <div v-show="showList" v-if="list?.length">
    <ul  v-for="element in list">
      <li>{{ element }}</li>
    </ul>
  </div>
  <div v-else>
    <p class="alert-msg"> Empty list!</p>
  </div>

  <div>
    <button @click="() => showList = !showList">Toggle list</button>
    <button @click="() => list.push(getRandomNbr(100))">Add element</button>
    <button @click="() => list.pop() ">Delete last element</button>
    <button @click="() => list.reverse()">Reverse list</button>
  </div>
  <!-- ------------------------------------------------------------------ -->
  <div>
    <p 
      @click="() => toggleFirstP = !toggleFirstP"
      :class="classes"
    >
      This is a paragraphe
    </p>
    <p :style="{color: toggleSecondP ? 'blue': 'red'}"
      @click="() => toggleSecondP = !toggleSecondP">
      This is another paragraphe!
    </p>
  </div>
  <div>
    <button v-on:click="sayHello">Hello</button>
    <button @click="sayHello">shortcut '@' version</button>
    <button @click="(e) => console.log('hello' + e.target.toString())">version code inline</button>
    <div>
      <a href="#" @click.prevent="console.error('aie')">Un lien</a>
      <a href="#" @click.once="console.log('once')">Un lien</a>
    </div>
    <div>
      <p>{{ inputValue }}</p>
      <input ref="myInput" type="text" v-model=inputValue @keyup.enter="enterInputHandler">
      <button @click="()=> console.log($refs.myInput.value)">BTN</button>
    </div>
  </div>

</template>

<style scoped>
  .alert-msg{
    color: red;
  }
  .p-toggle-red{
    color: red;
  }

</style>
