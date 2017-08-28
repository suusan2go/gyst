<template>
  <documents-layout>
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-3">Hello, world!</h1>
        <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
        <hr class="my-4">
        <p>{{msg}}</p>
        <p class="lead">
          <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
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
      msg: 'Documents',
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
