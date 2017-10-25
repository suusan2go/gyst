declare module "*.vue" {
  import Vue from "vue";
  export default typeof Vue;
}

declare module 'element-ui' {
  const x: any;
  export = x;
}