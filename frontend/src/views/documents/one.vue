<template>
  <div class="document-container">
    <div class="container">
      <h1 class="display-3">{{document.title}} <small>#{{document.id}}</small></h1>
      <hr class="my-4">
      <p class="lead" v-html="document.body">
        {{document.body}}
      </p>
    </div>
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
    };
  },
  methods: {
    async fetchData() {
      this.document = await client.getDocument(this.props.id);
    },
  },
  watch: {
    async $route(to) {
      console.log(to);
      this.document = await client.getDocument(this.$route.params.id);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.document-container {
  padding: 20px
}
</style>
