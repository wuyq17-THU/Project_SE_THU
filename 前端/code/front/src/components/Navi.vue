<template>
  <div class="navigator">
    <div id="navi">
        <router-link to='/' id="admin">场地管理</router-link> 
        <router-link to='/' id="per">个人中心</router-link>
        <router-link to='/' id="exit">退出系统</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Navi',
  props: {
    msg: String
  }
}
</script>

<style>
.navigator{
    padding: 0px;
    margin: 0px;
    
}
#navi{
    position: relative;
    background-color: rgba(228, 228, 228, 0.863);
    height: 30px;
    padding-top: 5px;
}

#admin {
    position: relative;
    float: left;
    margin-left: 20px;
}
#exit {
    position: relative;
    float: right;
    margin-right: 20px;
    margin-left: 20px;
}
#per {
    position: relative;
    float: right;
    margin-right: 40px;
}

#navi a {
  font-weight: bold;
  color: #2c3e50;
}



#navi a.router-link-exact-active {
  color: rgb(102, 17, 151);
}
</style>