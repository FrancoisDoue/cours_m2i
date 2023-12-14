import { defineStore } from "pinia";
import { computed, ref } from "vue";

export const useGameStore = defineStore('games', () => {
    const games = ref([])

    const gameForId = computed((id) => games.value.find(e => e.id === id))

    const addGame = (game) => games.value.push(game)

    const removeGame = (game) => games.value = games.value.filter(e => e !== game)

    return {games, gameForId, addGame, removeGame}
})