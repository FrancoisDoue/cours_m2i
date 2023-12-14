<script setup>
import { useGameStore } from '@/store/games'
import { useAuthStore } from '@/store/auth';

const gameStore = useGameStore()
const authStore = useAuthStore()
console.log(authStore.isLogged)
</script>

<template>
    <h2>Games List</h2>
</template>

<style scoped>

</style>
