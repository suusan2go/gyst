<template>
  <div class="document-container" v-loading="loading">
    <el-row type="flex" :gutter="20" align="middle">
      <el-col :span="20">
        <h1 class="display-3">{{document.title}} <small>#{{document.id}}</small></h1>
      </el-col>
      <el-col :span="4">
        <div class="button-group">
          <router-link :to="{ name: 'DocumentsOneShare' }">
            <el-button type="primary" icon="share">Share</el-button>
          </router-link>
          <router-link :to="{ name: 'DocumentsOneEdit', id: document.id }">
            <el-button type="default" icon="edit">Edit</el-button>
          </router-link>
        </div>
      </el-col>
    </el-row>
    <hr class="my-4">
    <p class="lead" v-html="document.bodyHtml"></p>
    <router-view></router-view>
  </div>
</template>

<script>
import DocumentsLayout from '@/components/DocumentsLayout';
import ApiClient from '@/api/index';

const client = new ApiClient();

export default {
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
      if (parseInt(this.id, 10) === this.document.id) return;
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
.button-group {
  float: right;
  width: 200px;
  >>> a {
    margin-right: 10px;
  }
}
>>> ul {
  list-style: initial;
}
>>> ol {
  list-style: decimal;
}
</style>
