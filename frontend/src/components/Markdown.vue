<template>
  <div class="markdown">
    <h1 class="markdown-title">{{title}}</h1>
    <hr></hr>
    <div class="grid-content bg-purple-light" v-html="body"></div>
  </div>
</template>

<script lang="ts">
export default {
  props: ['title', 'body'],
  data() {
    return {};
  },
};
</script>

<style scoped>
.markdown {
  box-sizing: border-box;
  overflow: scroll;
  padding-bottom: 10px;

  &-title {
    font-size: 2.5em;
  }

  >>> ul {
    list-style: initial;
  }

  >>> ol {
    list-style: decimal;
  }
}
</style>
