import { createRouter, createWebHistory } from 'vue-router'
import TodoView from '@/views/TodoView.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {path: '/', redirect: '/todo'},
    {path: '/todo', component: TodoView}
  ]
})

export default router
