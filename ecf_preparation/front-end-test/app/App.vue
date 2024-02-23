<script setup>
import { RouterView } from 'vue-router'
import HeaderComponent from './src/components/HeaderComponent.vue';

</script>

<template>
  <div id="main-content">
    <HeaderComponent />
    <RouterView/>

  </div>

</template>

<style scoped>
#main-content{
  @apply h-full w-full
}

</style>
