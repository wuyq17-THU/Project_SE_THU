<template>
  <div class="hello">
    <div id="head">
        <h1>叮咚</h1>
        <p>清华大学工会场馆预约系统</p>
    </div>    
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
.hello{
  padding: 0px;
  margin: 0px;
  
}
#head{
    position: relative;
    background-color: rgb(102, 17, 151);
    height: 140px;
    
}
#head h1{
  color: rgb(236, 245, 245);
  margin-top: 0px;
  padding-top: 20px;
}
#head p{
  color: rgb(226, 236, 236);
}
</style>