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
          
          <h1>历史预约记录</h1>
          <el-row>
            <el-col :span="16" :offset="4">
            <el-table
              height="250"
              stripe
              :data="history"
              style="width: 100%">
              <el-table-column
                prop="gymId"
                label="场馆"
                width="180">
              </el-table-column>
              <el-table-column
                prop="courtId"
                label="场地"
                width="180">
              </el-table-column>
              <el-table-column
                prop="weekNum"
                label="星期">
              </el-table-column>
              <el-table-column
                prop="timeNum"
                label="时间段">
              </el-table-column>
          </el-table>
            </el-col>
          </el-row>
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
  data(){
    return{
      history: [{        
                    'gymId':0,
                    'courtId':1,          
                    'weekNum':3,
                    'timeNum':8
                },{        
                    'gymId':0,
                    'courtId':1,          
                    'weekNum':3,
                    'timeNum':8
                },{        
                    'gymId':0,
                    'courtId':1,          
                    'weekNum':3,
                    'timeNum':8
                },]
    
    }
  },
  mounted(){
    this.axios.get('/api/user/rent/history',
      {
          headers:{'Authorization':localStorage.getItem('token')},          
      }).then((response) => {
            console.log(response.data);
            this.history=response.data.orders;            
      });     
  },
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