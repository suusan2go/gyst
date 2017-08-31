import Vue from 'vue';
import Router from 'vue-router';
import Root from '@/views/root/index';
import DocumentsIndex from '@/views/documents/index';
import DocumentsOne from '@/views/documents/one';
import DocumentsNew from '@/views/documents/new';

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
      props: {
        showDefault: true,
      },
      children: [
        {
          path: '/documents/:id',
          name: 'DocumentsOne',
          component: DocumentsOne,
        },
        {
          path: '/documents/new',
          name: 'DocumentsNew',
          component: DocumentsNew,
          props: { showAside: false },
        },
      ],
    },
  ],
  mode: 'history',
});
