<template>
  <div>
    <header class="header">
      <router-link :to="{ name: 'Root' }" class="header-logo">
        <icon name="file-text-o" scale="1.5" color="black"></icon>
        Gisty
      </router-link>
      <el-menu theme="light" :default-active="activeIndex" router="true" mode="horizontal" @select="handleSelect">
        <el-menu-item>
          <a href="/login/google">
            <icon name="google"></icon>
            Login
          </a>
        </el-menu-item>
      </el-menu>
    </header>
    <slot></slot>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: 'Welcome to Your Vue.js App',
    };
  },
};
</script>

<style scoped>
.header {
  align-items: center;
  background-color: #eef1f6;
  display: flex;
  justify-content: flex-end;
  padding: 0 20px;
}

.header-logo {
  align-self: center;
  background-color: transparent;
  color: black;
  font-size: 32px;
  margin: 0;
  margin-right: auto;
  text-decoration: none;
}
</style>
