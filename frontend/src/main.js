// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import ElementUI from 'element-ui';
import Icon from 'vue-awesome/components/Icon';
import 'vue-awesome/icons';
import 'normalize.css';
import '@/assets/element-custom-theme/index.css';

import App from './App';
import router from './router';

Vue.use(ElementUI);
Vue.component('icon', Icon);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
});
