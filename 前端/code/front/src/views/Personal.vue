<template>
  <div class="First">
    <el-container>
      <el-header>
        <div id="head">
            <Head></Head>
            <Navi></Navi>
            <Step msg="3"></Step>
        </div>
      </el-header>
      <el-container>
        <el-main>
          <h1>您当前预约的场地如下：</h1>
          <p>场地一 星期三 08:00-09:00</p>
          <p>场地二 星期三 08:00-09:00</p>
          <p>场地三 星期三 08:00-09:00</p><br>
          <h1>历史预约记录</h1>
          <p>场地一 星期三 08:00-09:00</p>
          <p>场地二 星期三 08:00-09:00</p>
          <p>场地三 星期三 08:00-09:00</p><br>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import Head from '@/components/Head.vue'
import Navi from '@/components/Navi.vue'
import Step from '@/components/Step.vue'

export default {
  name: 'First',
  components: {
    Head,
    Navi,
    Step,
  },
  methods:{
    pay(){
        this.$router.push('/')
    },
  }
}
</script>

<style scoped>
#head { 
    margin: 0px;
    padding: 0px;
}
.el-main {
    margin-top: 180px;
}
</style>