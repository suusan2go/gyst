<template>
  <div class="document-container" v-loading="loading">
    <h1 class="display-3">{{document.title}} <small>#{{document.id}}</small></h1>
    <hr class="my-4">
    <p class="lead" v-html="document.bodyHtml"></p>
  </div>
</template>

<script>
import DocumentsLayout from '@/components/DocumentsLayout';
import ApiClient from '@/api';

const client = new ApiClient();

export default {
  name: 'hello',
  props: ['id'],
  components: {
    DocumentsLayout,
  },
  created() {
    this.fetchData();
  },
  data() {
    return {
      document: {
        title: '職務経歴書',
        body: 'ほげほげほげががががが<br>はおががががが',
      },
      loading: false,
    };
  },
  methods: {
    async fetchData() {
      this.loading = true;
      this.document = await client.getDocument(this.$route.params.id);
      setTimeout(() => {
        this.loading = false;
      }, 300);
    },
  },
  watch: {
    async $route() {
      this.fetchData();
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.document-container {
  padding: 0 20px
}
</style>
