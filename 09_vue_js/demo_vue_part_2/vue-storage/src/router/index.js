import { createRouter, createWebHistory } from "vue-router";
import HomeView from '../components/home/HomeView.vue'
import GamesListView from '../components/games/GamesListView.vue'

export default createRouter({
    history : createWebHistory(),
    routes: [
        {path: '/', component: HomeView},
        {path: '/games', component: GamesListView}
    ]
})