<script setup>

import { RouterLink, useRoute, useRouter } from 'vue-router';
const getCustomer = (id) => {
    const customer = import(`../datas/customer${id}.json`);
    return customer
}
const route = useRoute()
const router = useRouter()

const paramId = route.params.id
let customer;
try{
    customer = await getCustomer(paramId)
}catch(e) {
    customer = false;
}

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
