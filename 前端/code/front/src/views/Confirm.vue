<template>
  <div class="First">
    <el-container>
      <el-header>
        <div id="head">
            <Head></Head>
            <Navi></Navi>
            <Step msg="2"></Step>
        </div>
      </el-header>
      <el-container>
        <el-main>
          <h1>您要预约的场地如下：</h1>
          <p>场地一 星期三 08:00-09:00</p>
          <p>场地二 星期三 08:00-09:00</p>
          <p>场地三 星期三 08:00-09:00</p><br>
          <h1>请扫描下方二维码支付订金</h1>
          <img src="../assets/qrcode.jpg" class="image">
          <el-button type="primary" @click="pay">验证支付</el-button>
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
        this.$router.push('/personal')
    },
  }
}
</script>

<style scoped>
.el-button{
    margin-top: 20px;
}
#head { 
    margin: 0px;
    padding: 0px;
}
.el-main {
    margin-top: 180px;
}
.image {
    height: 360px;
    width: 240px;
    display: block;
}
</style>