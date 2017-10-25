<template>
  <div class="container">
    <el-row>
      <el-col :span="12">
        <div class="grid-content">
          <el-form ref="form" :model="form" label-width="120px">
            <div class="label">your gist title here</div>
            <el-input v-model="form.title"></el-input>
            <div class="label">your gist body here</div>
            <el-input
              type="textarea" v-model="form.body" class="form-textare"
               :autosize="{ minRows: 15 }"
            >
            </el-input>
            <div class="btn-actions">
              <el-button type="default" icon="arrow-left" class="btn-circle" @click="goBack()">
                Back
              </el-button>
              <el-button type="primary" icon="check" class="btn-circle" @click="submit()">
                Save
              </el-button>
            </div>
          </el-form>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="preview-container">
          <markdown :title="form.title" :body="markdownHtml"></markdown>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import commonmark from 'commonmark';
import Markdown from '@/components/Markdown';
import ApiClient from '@/api/index';

const client = new ApiClient();

export default {
  components: {
    Markdown,
  },
  computed: {
    markdownHtml() {
      const reader = new commonmark.Parser();
      const writer = new commonmark.HtmlRenderer();
      const parsed = reader.parse(this.form.body); // parsed is a 'Node' tree
      // transform parsed if you like...
      return writer.render(parsed); // result is a String
    },
  },
  data() {
    return {
      form: {
        title: '',
        body: '',
      },
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    async submit() {
      const document = await client.createDocument(this.form);
      this.$router.push({ name: 'DocumentsOne', params: { id: document.id } });
    },
  },
  created() {
    this.$emit('hideSidemenu');
  },
  beforeDestroy() {
    this.$emit('showSidemenu');
  },
};
</script>

<style scoped>
.el-textarea__inner {
  min-height: 98vh;
}

.label {
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 14px;
  color: #8492a6;
}

.button-group {
  position: fixed;
  bottom: 0;
  width: 100%;
}

.preview-container {
  padding-left: 20px;
}

.btn-actions {
  position: fixed;
  bottom: 20px;
  right: 30px;
}

.btn-circle {
  padding: 10px 16px;
  font-size: 14px;
  line-height: 1.33;
}

</style>
