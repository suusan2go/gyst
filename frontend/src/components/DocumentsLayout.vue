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
    <main>
      <aside>
        <documents-list></documents-list>
      </aside>
      <slot></slot>
    </main>
  </div>
</template>

<script>
import DocumentsList from './DocumentsList';

export default {
  components: {
    DocumentsList,
  },
  data() {
    return {
      msg: 'Welcome to Your Vue.js App',
    };
  },
};
</script>

<style scoped>
a {
  text-decoration: none;
}

.header {
  align-items: center;
  background-color: #eef1f6;
  display: flex;
  justify-content: flex-end;
  padding: 0 20px;
}

aside {
  border-right: 1px solid rgba(0,0,0,.07);
  height: 100%;
  left: 0;
  max-width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  padding: 0 0 100px;
  pointer-events: auto;
  position: fixed;
  transition: .3s cubic-bezier(.25,.8,.25,1);
  width: 300px;
  will-change: transform;
  z-index: 3;
}

main {
  padding-left: 300px;
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
