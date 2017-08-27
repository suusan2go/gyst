<template>
  <div>
    <header class="header">
      <router-link :to="{ name: 'Root' }" class="header-logo">
        <icon name="file-text" scale="1.5"></icon>
        Gisty
      </router-link>
      <el-menu theme="light" :default-active="activeIndex" class="" mode="horizontal" @select="handleSelect">
        <el-menu-item index="1">Processing Center</el-menu-item>
        <el-submenu index="2">
          <template slot="title">Workspace</template>
          <el-menu-item index="2-1">item one</el-menu-item>
          <el-menu-item index="2-2">item two</el-menu-item>
          <el-menu-item index="2-3">item three</el-menu-item>
        </el-submenu>
        <el-menu-item index="3"><a href="https://www.ele.me" target="_blank">Orders</a></el-menu-item>
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

<style>
.header {
  align-items: center;
  background-color: #eef1f6;
  display: flex;
  justify-content: flex-end;
  padding: 0 20px;
}

.header-logo {
  font-size: 21px;
  margin: 0;
  margin-right: auto;
  text-decoration: none;
  background-color: transparent;
}
</style>
