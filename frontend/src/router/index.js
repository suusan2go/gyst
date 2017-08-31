import Vue from 'vue';
import Router from 'vue-router';
import Root from '@/views/root/index';
import DocumentsLayout from '@/components/DocumentsLayout';
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
      component: DocumentsLayout,
      props: (route) => {
        route.path.indexOf(['new']);
      },
      children: [
        {
          path: '',
          name: 'DocumentsIndex',
          component: DocumentsIndex,
        },
        {
          path: ':id',
          name: 'DocumentsOne',
          component: DocumentsOne,
        },
        {
          path: 'new',
          name: 'DocumentsNew',
          component: DocumentsNew,
        },
      ],
    },
  ],
  mode: 'history',
});
