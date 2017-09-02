<template>
  <div>
    <header class="header">
      <router-link :to="{ name: 'DocumentsIndex' }" class="header-logo">
        <icon name="file-text" scale="1.5" color=""></icon>
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
    <main class="layout" v-bind:class='{ "layout-sidemenu": showAside }'>
      <transition name="slide-fade">
        <aside v-if="showAside">
          <documents-list></documents-list>
        </aside>
      </transition>
      <router-view @hideSidemenu="hideSidemenu()" @showSidemenu="showSidemenu()">
      </router-view>
      <router-link :to="{ name: 'DocumentsNew' }" class="header-logo">
        <el-button type="primary" icon="edit" size="large" class="btn-circle">
        </el-button>
      </router-link>
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
      showAside: true,
    };
  },
  methods: {
    hideSidemenu() {
      this.showAside = false;
    },
    showSidemenu() {
      this.showAside = true;
    },
  },
};
</script>

<style scoped>
a {
  text-decoration: none;
}

.btn-circle {
  width: 60px;
  height: 60px;
  padding: 10px 16px;
  font-size: 24px;
  line-height: 1.33;
  border-radius: 30px;
  position: absolute;
  bottom: 20px;
  right: 30px;
}

.header {
  align-items: center;
  border-bottom: 2px solid #4fba83;
  background-color: white;
  display: flex;
  justify-content: flex-end;
  padding: 0 20px;
}

.el-menu {
  background-color: transparent;
}

.el-menu--horizontal .el-menu-item:hover, .el-menu--horizontal .el-submenu__title:hover {
  background-color: transparent;
}

aside {
  background-color: rgb(238, 246, 244);
  border-right: 1px solid rgba(0,0,0,.07);
  height: 100%;
  left: 0;
  max-width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  padding: 0 0 100px;
  pointer-events: auto;
  position: fixed;
  top: 62px;
  transition: .3s cubic-bezier(.25,.8,.25,1);
  width: 300px;
  will-change: transform;
  z-index: 3;
}

.layout {
  padding-left: 0px;
  transition: all .3s ease;
}

.layout-sidemenu {
  padding-left: 300px;
  transition: all .3s ease;
}

.header-logo {
  align-self: center;
  background-color: transparent;
  color: #4fba83;
  font-size: 32px;
  margin: 0;
  margin-right: auto;
  text-decoration: none;
}

/* enter、 leave アニメーションで異なる間隔やタイミング関数を利用することができます */
.slide-fade-enter-active {
  transition: all .3s ease;
}
.slide-fade-leave-active {
  transition: all .3s ease;
}
.slide-fade-enter, .slide-fade-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}
</style>
