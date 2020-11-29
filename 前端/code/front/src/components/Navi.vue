<template>
  <div class="navigator">
    <div id="navi">
        <a>场地管理</a>
        <a>个人中心</a>
        <a>退出系统</a>
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
#navi{
    position: fixed;
    top: 140px;
    background-color: rgb(201, 201, 201);
    width: 1440px;
    height: 30px;
}

#navi p{
    float: left;
}
</style>