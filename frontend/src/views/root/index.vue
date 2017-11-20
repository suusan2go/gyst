<template>
  <layout>
    <div class="login">
      <el-card class="box-card">
        <div slot="header" class="clearfix header-logo">
          <icon name="file-text-o" scale="1.5" color="black"></icon>
          Gyst
        </div>
        <div class="login-button-group">
          <a href="/login/google">
            <el-button type="default" size="large">
              Sign in With Google
            </el-button>
          </a>
        </div>
      </el-card>
    </div>
  </layout>
</template>

<script>
import Layout from '@/components/Layout';

export default {
  name: 'hello',
  components: {
    Layout,
  },
  data() {
    return {
      msg: 'Welcome to Your Vue.js App',
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login {
  position: absolute;
  top: 50%;
  left: 50%;
  height: 200px;
  width: 400px;
  margin-top: -100px;
  margin-left: -200px;

  &-button-group {
    text-align: center;
  }
}

.header-logo {
  background-color: transparent;
  font-size: 32px;
  /* color: #4fba83; */
  margin: 0;
  margin-right: auto;
  text-align: center;
}
@media screen and (max-width: 480px) {
  .login {
    left: 0%;
    width: 90%;
    margin-left: 5%;
    margin-right: 5%;
  }
}
</style>
