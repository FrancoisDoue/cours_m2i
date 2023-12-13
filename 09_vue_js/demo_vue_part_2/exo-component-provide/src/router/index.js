import { createRouter, createWebHistory } from "vue-router"
import ClientListView from '../views/ClientListView.vue'
import ClientDetailView from '../views/ClientDetailView.vue'

export default createRouter({
    history : createWebHistory(),
    routes: [
        {path: '/', redirect: '/clients'},
        {path: '/clients', component: ClientListView},
        {path: '/clients/:id', component: ClientDetailView}
    ]
})