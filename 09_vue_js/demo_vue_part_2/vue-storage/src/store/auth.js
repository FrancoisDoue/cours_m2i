import { computed, reactive, ref } from "vue";
import { defineStore } from "pinia";

export const useAuthStore = defineStore('auth', () => {
    // const auth = ref({identifier: 'moi', password: 'motdepasse'})
    const auth = ref(null)

    // const isLogged = computed(() => !!auth.value)
    const isLogged = computed(() => !!auth.value )

    const login = ({identifier, psw}) => auth.value = {"identifier": identifier, "password": psw}

    const logout = () => auth.value = null;

    return {auth, isLogged, login, logout}
})