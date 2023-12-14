<script setup>
import { RouterView } from 'vue-router';
import customerlistJson from './datas/customerlist.json';
import { Suspense, provide } from 'vue';

const customerlist = customerlistJson

provide('customerList', {
    customerlist,
})

</script>

<template>
    <header class="container-fluid bg-dark">
        
    </header>
     <!-- je vote pour un point sur l'async en vue.js -->
    <Suspense>
        <RouterView />
    </Suspense>
    

</template>

<style scoped>
header{
    height: 75px;
}

</style>
