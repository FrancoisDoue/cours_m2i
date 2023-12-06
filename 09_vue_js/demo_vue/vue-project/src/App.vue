<script setup>
import { reactive, ref } from 'vue';

  let messageHtml = "<p>Un message.</p>";
  let message = 'Hello world!';
  let redcss = 'background-red';
  let isDisabled = true;
  let myLink = 'https://www.google.com/';
  let attributes = {class: 'bold', href: 'https://www.google.com/'};
  let count = ref(0);
  count.value = 3
  const addCount = (/*e*/) => {
    // console.log(e.target.dataset);
    count.value++;
  }
  let count1 = reactive({count: 0});
  const addCount1 = () => {
    count1.count++;
  }
</script>

<template>
  <h1>{{ message }}</h1>
  <div v-html="messageHtml"></div>
  <p v-bind:class="redcss">Lorem ipsum dolor sit amet.</p>
  <button :disabled="isDisabled">Bouton</button>
  <a v-bind:href="myLink" target="_blank">Google</a>
  <a v-bind="attributes">Mon lien gras</a>
  <div>
    <p>La taille de h1 est de : {{ message.length }} lettres</p>
    <p>h1 est {{ message.length % 2 ? 'impair' : 'pair' }}</p>
  </div>
  <div>
    <p>{{ count }}</p>
    <button v-on:click="addCount">Vas-y, clique.</button>
  </div>
  <div>
    <p>{{ count1.count }}</p>
    <button v-on:click="addCount1">Vas-y, clique.</button>
  </div>
</template>

<style scoped>
  h1{
    color: #7fff00  
  }
  .background-red{
    background-color: red;
  }
  .bold{
    font-weight: bold;
  }
</style>
