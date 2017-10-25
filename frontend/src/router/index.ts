import Vue from 'vue';
import Router, { RouteConfig } from 'vue-router';
import Root from '@/views/root/index.vue';
import DocumentsLayout from '@/components/DocumentsLayout.vue';
import DocumentsIndex from '@/views/documents/index.vue';
import DocumentsOne from '@/views/documents/one.vue';
import DocumentsOneShare from '@/views/documents/one/share.vue';
import DocumentsNew from '@/views/documents/new.vue';
import DocumentsOneEdit from '@/views/documents/one/edit.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Root',
      component: Root,
    } as RouteConfig,
    {
      path: '/documents',
      component: DocumentsLayout,
      children: [
        {
          path: '',
          name: 'DocumentsIndex',
          component: DocumentsIndex,
        },
        {
          path: 'new',
          name: 'DocumentsNew',
          component: DocumentsNew,
        },
        {
          path: ':id/edit',
          name: 'DocumentsOneEdit',
          component: DocumentsOneEdit,
          props: true,
        },
        {
          path: ':id',
          name: 'DocumentsOne',
          component: DocumentsOne,
          props: true,
          children: [
            {
              path: 'share',
              name: 'DocumentsOneShare',
              component: DocumentsOneShare,
              props: true,
            },
          ],
        },
      ],
    } as RouteConfig,
  ],
  mode: 'history',
});
