<script setup>
  import { ref } from 'vue';
  
  let title = ref('Ceci est un titre');
  
  const reverseTitle = () => {
    title.value = [...title.value].reverse().join('');
  }
  const itsATrap = () => {
    alert('Ceci est un lien. (qui ne fonctionne pas.)')
  }

</script>

<template>
  <div>
    <h1>{{title}}</h1>
    <button v-on:click="reverseTitle">Inverser le titre</button>
    <button v-on:click="title += '!'">Ajouter un " ! "</button>
  </div>
  <div>
    <a href="./" v-on:click.prevent.click="itsATrap">Un lien</a>
  </div>

</template>

<style scoped>
  h1{
    color: red;
  }
</style>
