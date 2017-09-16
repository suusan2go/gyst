<template>
  <div class="documents-list-container" v-loading="loading">
    <ul class="documents-list">
      <li class="document-item" v-for="document in documents">
        <router-link :to="{ name: 'DocumentsOne', params: { id: document.id }}" class="document-item-link">
          <div class="document-item-container" v-bind:class="{ active: isCurrentItem(document.id) }">
            <h3 class="document-title">{{document.title}}</h3>
            <p class="document-body">{{document.body}}</p>
          </div>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<style scoped>

.documents-list {
  margin-top: 0px;
  padding-left: 0;
}

.document-item-link {
  color: #555;
  text-decoration: none;
  width: 100%;
  height: 100%;
}

.document-item-container {
  box-sizing: border-box;
  min-width: 0;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 10px;
  padding-bottom: 10px;
  text-overflow: ellipsis;
}
.document-item-container:hover, .document-item-container.active {
  background-color: rgb(209, 229, 221);
}
.document-title {
  font-size: 18px;
  margin-top: 10px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.document-body {
  font-size: 14px;
  color: #aaa;
  margin-bottom: 0px;
}
</style>

<script>
import ApiClient from '@/api';

const client = new ApiClient();

export default {
  data() {
    return {
      documents: [],
      loading: false,
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    async fetchData() {
      this.loading = true;
      this.documents = await client.getDocuments();
      this.loading = false;
    },
    isCurrentItem(id) {
      return id === parseInt(this.$route.params.id, 10);
    },
  },
};
</script>
