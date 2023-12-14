<script setup>

import axios from 'axios';
import { onMounted, ref } from 'vue';
import { RouterLink, useRoute } from 'vue-router';

const route = useRoute()
let customer = ref([]);

onMounted( async() => {
    try{
        const response = await axios.get(`/src/datas/customer${route.params.id}.json`)
        customer.value = response.data;
    }catch(e){
        console.error(e);
    }
})
</script>

<template>
    <div class="container-fluid text-center bg-light py-2 shadow-sm">
        <h2>Détails Clients</h2>
    </div>
    <div v-if="customer" class="container-fluid shadow-sm text-center py-2">
        <h4>{{ customer?.name }}</h4>
        <p>Name : {{ customer?.name }}</p>
        <p>Email : {{ customer?.email }}</p>
        <p>Phone : {{ customer?.phone }}</p>
        <p>City : {{ customer?.city }}</p>
        <p>State : {{ customer?.state }}</p>
        <p>Country : {{ customer?.country }}</p>
        <p>Organization : {{ customer?.organization }}</p>
        <p>Job Profile : {{ customer?.jobProfile }}</p>
        <p>Additional informations : {{ customer?.additionalInfo }}</p>
    </div>
    <div v-else class="text-center py-4">
        <h4>Client introuvable</h4>
    </div>
    <div class="text-center py-4">
        <RouterLink to="/clients" class="btn btn-outline-primary">Retour à la liste des clients</RouterLink>
    </div>
</template>

<style scoped>

</style>
