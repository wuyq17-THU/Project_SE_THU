<template>
<div>
    <el-row>
      <el-col :span="12" :offset="6">
          <h1>场地管理说明：</h1>
        <p>
          所有场地默认为可以预定。使用下方选择器选择要设置的场地和相应时间段，时间段可以多选，场地为单选。提交后变为不可预定，再次提交相同场地时间段，即可变为可以预定。
        </p>
      </el-col>
    </el-row>
    <div class="select">    
    <h1>网球场</h1>
    <el-select v-model="court_value1" placeholder="请选择场地">
    <el-option
      v-for="item in court_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="week_value1" placeholder="请选择星期" multiple collapse-tags>
    <el-option
      v-for="item in week_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="time_value1" placeholder="请选择时间段" multiple collapse-tags>
    <el-option
      v-for="item in time_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
     </div>
  <div class="select">
    <h1>羽毛球场</h1>
    <el-select v-model="court_value2" placeholder="请选择场地">
    <el-option
      v-for="item in court_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="week_value2" placeholder="请选择星期" multiple collapse-tags>
    <el-option
      v-for="item in week_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="time_value2" placeholder="请选择时间段" multiple collapse-tags>
    <el-option
      v-for="item in time_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
   </div>
   <el-button type="primary" @click="manage">确认设置</el-button> 
  </div>
  
</template>

<script>
export default {
    props: {
        gymId: Number,
        userType:String
    },
    methods: {
    
      manage(){
          console.log({
            'gymId':'网球',
            'courtId':this.court_value1,
            'weekNum':this.week_value1,
            'timeNum':this.time_value1,
          });
          console.log({
            'gymId':'羽毛球',
            'courtId':this.court_value2,
            'weekNum':this.week_value2,
            'timeNum':this.time_value2,
          });
          this.axios.post('/api/manager/set',
          {        
              'gymId':0,
              'courtId':this.court_value1,          
              'weekNum':this.week_value1,
              'timeNum':this.time_value1
          },
          {
              headers:{'Authorization':localStorage.getItem('token')}
          }
          ).then((response) => {
              if(response.data.success === true){                        
                  this.$message({
                      type: 'success',
                      message: '网球场设置成功'
                  });                  
              }                    
          });
          this.axios.post('/api/manager/set',
          {        
              'gymId':1,
              'courtId':this.court_value2,          
              'weekNum':this.week_value2,
              'timeNum':this.time_value2
          },
          {
              headers:{'Authorization':localStorage.getItem('token')}
          }
          ).then((response) => {
              if(response.data.success === true){                        
                  this.$message({
                      type: 'success',
                      message: '羽毛球场设置成功'
                  });                  
              }                    
          });
          
      },  
    

  },
    data() {
      return {
          
        court_options: [{
          value: 0,
          label: '场地一'
        }, {
          value: 1,
          label: '场地二'
        }, {
          value: 2,
          label: '场地三'
        }],

        week_options: [{
          value: 0,
          label: '星期一'
        }, {
          value: 1,
          label: '星期二'
        }, {
          value: 2,
          label: '星期三'
        }, {
          value: 3,
          label: '星期四'
        }, {
          value: 4,
          label: '星期五'
        },{
          value: 5,
          label: '星期六'
        },{
          value: 6,
          label: '星期日'
        },],

        time_options: [{
            value: 0,
            label: '8:00-9:00'
        },{
            value: 1,
            label: '9:00-10:00'
        },{
            value: 2,
            label: '10:00-11:00'
        },{
            value: 3,
            label: '11:00-12:00'
        },{
            value: 4,
            label: '12:00-13:00'
        },{
            value: 5,
            label: '13:00-14:00'
        },{
            value: 6,
            label: '14:00-15:00'
        },{
            value: 7,
            label: '15:00-16:00'
        },{
            value: 8,
            label: '16:00-17:00'
        },{
            value: 9,
            label: '17:00-18:00'
        },{
            value: 10,
            label: '18:00-19:00'
        },{
            value: 11,
            label: '19:00-20:00'
        },{
            value: 12,
            label: '20:00-21:00'
        },{
            value: 13,
            label: '21:00-22:00'
        },],
        court_value1: 0,
        week_value1: [],
        time_value1: [],
        court_value2: 0,
        week_value2: [],
        time_value2: [],                
      }
    }
}
</script>

<style scoped>
.el-select{
    margin-left: 20px;
}
.el-button{
    margin: 10px;
    margin-top: 40px;
}
</style>