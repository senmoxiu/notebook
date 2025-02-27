import { createApp } from 'vue'
import App from './App.vue'
import { createPinia } from 'pinia'
import router from './router/index.ts'
import './assets/common.css'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

createApp(App).mount('#app')
const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)
const app = createApp(App)

app.use(router)
app.use(pinia)
app.mount('#app')
