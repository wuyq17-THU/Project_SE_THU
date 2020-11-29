<template>
  <div id="app">
    <Head msg="head test"></Head>
    <Navi></Navi>
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Head from './components/Head.vue'
import Navi from './components/Navi.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Head,
    Navi
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
