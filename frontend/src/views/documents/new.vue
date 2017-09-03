<template>
  <div class="container">
    <el-row>
      <el-col :span="12">
        <div class="grid-content">
          <el-form ref="form" :model="form" label-width="120px">
            <div class="label">your gist title here</div>
            <el-input v-model="form.name"></el-input>
            <div class="label">your gist body here</div>
            <el-input
              type="textarea" v-model="form.desc" class="form-textare"
              rows="18"
            >
            </el-input>
            <el-form-item class="button-group">
              <el-button type="primary" @click="onSubmit" size="large">Submit This Gist!</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="preview-container">
          <markdown :title="form.name" :body="markdownHtml"></markdown>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import commonmark from 'commonmark';
import Markdown from '@/components/Markdown';

export default {
  components: {
    Markdown,
  },
  computed: {
    markdownHtml() {
      const reader = new commonmark.Parser();
      const writer = new commonmark.HtmlRenderer();
      const parsed = reader.parse(this.form.desc); // parsed is a 'Node' tree
      // transform parsed if you like...
      return writer.render(parsed); // result is a String
    },
  },
  data() {
    return {
      form: {
        name: '',
        desc: '',
      },
    };
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
.label {
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 14px;
  color: #8492a6;
}

.button-group {
  margin-top: 30px;
}

.preview-container {
  padding-left: 20px;
}

</style>
