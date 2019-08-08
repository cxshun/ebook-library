import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import Axios from 'axios'
import VueRouter from 'vue-router'
import Privilege from "./components/privilege/Privilege";
import Role from "./components/role/Role";
import User from "./components/user/User";

Vue.use(ElementUI);
Vue.use(VueRouter);

Vue.prototype.$http = Axios;

const router = new VueRouter({
    routes: [
        { path: '/roles', component: Role},
        { path: '/users', component: User},
        { path: '/privileges', component: Privilege}
    ]
});

new Vue({
  router: router,
  el: '#app',
  render: h => h(App)
});
