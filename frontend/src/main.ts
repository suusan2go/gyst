// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

import Vue, { ComponentOptions } from 'vue';
import ElementUI from 'element-ui';
import Icon from 'vue-awesome/components/Icon.vue';
import 'vue-awesome/icons';
import 'normalize.css';
import '@/assets/element-custom-theme/index.css';

import App from '@/App.vue';
import router from '@/router';

Vue.use(ElementUI)
Vue.component('icon', Icon as ComponentOptions<Vue>);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
} as ComponentOptions<Vue>);
