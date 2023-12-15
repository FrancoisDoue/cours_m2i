import { createRouter, createWebHistory } from 'vue-router'
import TodoView from '@/views/TodoView.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {path: '/', name: 'To Duh', redirect: '/todo'},
    {path: '/todo', name: 'To Duh', component: TodoView}
  ]
})

export default router
