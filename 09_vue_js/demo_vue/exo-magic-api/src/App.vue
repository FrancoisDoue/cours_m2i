<script setup>
import {ref, reactive, watch, watchEffect, onMounted} from 'vue';



const id = ref(1);
const txt = ref("Ankh of Mishra");
const data = ref({});

watch(id, async(id) =>{
  try {
    const res = await fetch(`https://api.magicthegathering.io/v1/cards/${id}`)
    data.value = await res.json();
  } catch (error) {
    console.error(error)
  }
})

watch( data, (newData) => {
  console.log(newData)
})


onMounted(async() => {
  try {
    const res = await fetch(`https://api.magicthegathering.io/v1/cards/1`)
    const response = await res.json();
    magicMap(response)
  } catch (error) {
    console.error(error)
  }
})

const magicMap = (response) => {
  console.log(response)
  data.value = response;
}

</script>

<template>
  <button @click="() => {if(id > 0 ) id--}" :disabled="id <= 1">previous</button>
  <button @click="() => id++">next</button>

</template>

<style scoped>

</style>
