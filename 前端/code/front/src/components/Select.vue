<template>
    <div class="select">
    <el-row type="flex" justify="center">
        <el-col :span="4">
            <el-card :body-style="{ padding: '0px' }">
            <img src="../assets/tennis.jpeg" class="image">
            <div style="padding: 14px;">
                <span>网球场</span>
                <div class="bottom clearfix">
                <el-button type="text" class="button" @click="orderT">预约</el-button>
                </div>
            </div>
            </el-card>
          </el-col>
          
          <el-col :span="4" :offset="4">
            <el-card :body-style="{ padding: '0px' }">
            <img src="../assets/yumaoqiu.jpeg" class="image">
            <div style="padding: 14px;">
                <span>羽毛球场</span>
                <div class="bottom clearfix">
                <el-button type="text" class="button" @click="orderB">预约</el-button>
                </div>
            </div>
            </el-card>
          </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    name: 'Select',
    methods:{
        orderT(){
            this.$router.push('/ordert')
        },
        orderB(){
            this.$router.push('/orderb')
        }
    }
}
</script>

<style scoped>
  .select {
      margin-top: 240px;
  }

  .select span {
      font-size: 24px;
  }

  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
    font-size: 24px;
  }

  .image {
    height: 250px;
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>