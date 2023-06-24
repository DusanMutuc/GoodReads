import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import cookies from 'vue-cookies'

const app = createApp(App)

app.config.globalProperties.$admin = false;

app.use(router).use(cookies).mount('#app')
