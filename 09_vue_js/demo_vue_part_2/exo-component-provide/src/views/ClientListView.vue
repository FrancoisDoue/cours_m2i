<script setup>
import { inject } from 'vue';
import { RouterLink } from 'vue-router';

const { customerlist } = inject('customerList')
console.log(customerlist);

</script>

<template>
    <div class="container text-center">
        <h2>Cette page affiche la liste des clients</h2>
    </div>
    <div class="d-flex flex-column align-items-center"
    v-for="customer in customerlist">
    <div class="card w-25 my-2">
        <div class="card-body text-center">
            <h4>
                {{ customer.name }}
            </h4>
            <p>
                {{ customer.email }}
            </p>
            <p>
                {{ customer.phone }}
            </p>
        </div>
        <div class="card-footer text-center">
            <RouterLink :to="`/clients/${customer.id}`" class="btn btn-outline-primary"> Cliquez pour plus de détail </RouterLink>
        </div>
    </div>
    </div>
    
</template>

<style scoped>

</style>
