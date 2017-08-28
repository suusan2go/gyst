<template>
  <documents-layout>
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-3">{{document.title}}</h1>
        <hr class="my-4">
        <p>{{msg}}</p>
        <p class="lead" v-html="document.body">
          {{document.body}}
        </p>
      </div>
    </div>
  </documents-layout>
</template>

<script>
import DocumentsLayout from '@/components/DocumentsLayout';

export default {
  name: 'hello',
  components: {
    DocumentsLayout,
  },
  data() {
    return {
      document: {
        title: '職務経歴書',
        body: 'ほげほげほげががががが<br>はおががががが',
      },
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
