<template>
  <div class="orderT">
      <el-container>
        <el-header>
          <div id="head">
            <Head></Head>
            <Navi></Navi>
          </div>
        </el-header>
        <el-container id="main">
          <el-main>
              <h1>网球场</h1>
              <div class="table"><ManageTable></ManageTable></div>
              <h1>羽毛球场</h1>
              <div class="table"><ManageTable></ManageTable></div> 
              <el-button type="primary" @click="manage">确认设置</el-button>                      
          </el-main>
        </el-container>
      </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import Head from '@/components/Head.vue'
import Navi from '@/components/Navi.vue'

import ManageTable from '@/components/ManageTable.vue'

export default {
  name: 'First',
  data() {
    return{
        active: 2,
        activeName:'first',
      }
    },
  components: {
    Head,
    Navi,
    ManageTable,
    
    
  },
  methods: {
    manage(){
        this.$router.push('/');
        this.$message({
          message: '场地管理设置成功！',
          type: 'success'
        });
    }

  }
}
</script>

<style scoped>
.el-button{
    margin-top: 20px;
}
.table{
    width: 1130px;
    left: 0;
    margin: auto;
}
#info p{
  text-align: left;
  padding: 2px;
}
#head{
    margin: 0px;
    padding: 0px;
}

#main{
  margin-top: 180px;
}
#main .el-aside{
  text-align: center;
  line-height:0px;
  margin-left: 20px;
  background-color: #f3f5f7;
  
}

#main h1{
  font-size: 30px;
}
#title h1{
  font-size: 36px;
}
#title p{
  font-size: 20px;
  margin-left: -280px;
}
.image {
    height: 300px;
    width: 80%;
    display: block;
    margin: auto;
    left: 0px;
  }
</style>

