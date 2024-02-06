import { createRouter, createWebHistory } from "vue-router"
import HomeView from '../components/HomeView.vue'

export default createRouter({
    history: createWebHistory(),

    routes: [
        {path: '/', component: HomeView}
    ]
})