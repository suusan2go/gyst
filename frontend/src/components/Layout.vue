<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <router-link :to="{ name: 'Root' }" class="navbar-brand">Gisty</router-link>
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>
      <b-collapse is-nav id="nav_collapse">
        <b-nav is-nav-bar class="mr-auto">
          <b-nav-item href="#">Link</b-nav-item>
          <b-nav-item href="#" disabled>Disabled</b-nav-item>
        </b-nav>
        <b-nav-form class="my-2">
          <b-form-input size="md" class="mr-sm-2" type="text" placeholder="Search"/>
          <b-button size="md" class="my-2 my-sm-0 btn-outline-success" type="submit">Search</b-button>
        </b-nav-form>
      </b-collapse>
    </nav>
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
</style>
