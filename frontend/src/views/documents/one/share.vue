<template>
  <el-dialog
  title="Tips"
  :visible="true"
  size="tiny"
  :before-close="handleClose">
  <span>This is a message</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="handleClose">Cancel</el-button>
    <el-button type="primary" @click="handleClose">Confirm</el-button>
  </span>
</el-dialog>
</template>

<script>
export default {
  props: ['id'],
  data() {
    return {
      dialogVisible: false,
    };
  },
  methods: {
    handleClose() {
      this.$router.push({ name: 'DocumentsOne', params: { id: this.id } });
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
}
>>> ul {
  list-style: initial;
}
>>> ol {
  list-style: decimal;
}
</style>
