import Vue from 'vue';
import Router from 'vue-router';
import Root from '@/views/root/index';
import DocumentsIndex from '@/views/documents/index';
import DocumentsOne from '@/views/documents/one';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Root',
      component: Root,
    },
    {
      path: '/documents',
      name: 'Documents',
      component: DocumentsIndex,
    },
    {
      path: '/documents/:id',
      name: 'DocumentsOne',
      component: DocumentsOne,
    },
  ],
  mode: 'history',
});
