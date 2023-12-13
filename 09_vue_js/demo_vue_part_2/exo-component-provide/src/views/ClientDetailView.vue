<script setup>
// import { inject } from 'vue';
import { useRoute, useRouter } from 'vue-router';
const getCustomer = (id) => {
    const customer = import(`../datas/customer${id}.json`);
    return customer
}

const route = useRoute()
const router = useRouter()
const paramId = route.params.id

const customer = await getCustomer(paramId)
console.log(customer)
</script>

<template>

</template>

<style scoped>

</style>
