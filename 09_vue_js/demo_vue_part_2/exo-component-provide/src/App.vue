<script setup>
import { RouterView } from 'vue-router';
import { onMounted, provide, ref } from 'vue';
import axios from 'axios'

const customerlist = ref([]);

onMounted( async() => {
    try{
        const response = await axios.get('/src/datas/customerlist.json')
        customerlist.value = response.data;
    }catch(e){
        console.error(e);
    }
})

provide('customerList', {
    customerlist,
})

</script>

<template>
    <header class="container-fluid bg-dark">
        
    </header>
    <RouterView />
</template>

<style scoped>
header{
    height: 75px;
}

</style>
