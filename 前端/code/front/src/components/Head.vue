<template>
  <div class="hello">
    <div id="head">
        <h1>叮咚</h1>
        <p>清华大学工会场馆预约系统</p>
    </div>
    <h1>{{ msg }}</h1>
    <p>点击下方登录进入，如已经登录请点击上方home链接</p>    
  </div>
</template>

<script>
export default {
  name: 'Head',
  props: {
    msg: String
  }
}
</script>

<style>
#head{
    background-color: blueviolet;
    width: 1440px;
    height: 100px;
}
</style>