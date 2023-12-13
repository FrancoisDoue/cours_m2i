<script setup>
import { RouterLink, RouterView } from 'vue-router';
import customerlistJson from './datas/customerlist.json';
import { provide } from 'vue';

const customerlist = customerlistJson

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
