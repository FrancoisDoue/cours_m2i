import { createApp } from 'vue'
import './assets/style/style.css'
import App from './App.vue'
import { createPinia } from 'pinia'
import router from './src/router'

const app = createApp(App)

app
    .use(router)
    .use(createPinia())
    .mount('#app')
