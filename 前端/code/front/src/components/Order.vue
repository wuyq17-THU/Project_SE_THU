<template>
<div>
    
    <div class="select">
    <p>志愿一</p>
    <el-select v-model="court_value1" placeholder="请选择场地">
    <el-option
      v-for="item in court_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="week_value1" placeholder="请选择星期">
    <el-option
      v-for="item in week_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="time_value1" placeholder="请选择时间段">
    <el-option
      v-for="item in time_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-button type="primary" id="confirm" plain @click="check1">检查预约</el-button>
  </div>
  <div class="select">
    <p>志愿二</p>
    <el-select v-model="court_value2" placeholder="请选择场地">
    <el-option
      v-for="item in court_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="week_value2" placeholder="请选择星期">
    <el-option
      v-for="item in week_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="time_value2" placeholder="请选择时间段">
    <el-option
      v-for="item in time_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-button type="primary" id="confirm" plain @click="check2">检查预约</el-button>
  </div>
  <div class="select">
    <p>志愿三</p>
    <el-select v-model="court_value3" placeholder="请选择场地">
    <el-option
      v-for="item in court_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="week_value3" placeholder="请选择星期">
    <el-option
      v-for="item in week_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-select v-model="time_value3" placeholder="请选择时间段">
    <el-option
      v-for="item in time_options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <el-button type="primary" id="confirm" plain @click="check3">检查预约</el-button>
  </div>
  <el-button type="primary" id="confirm" plain @click="order">确认预约</el-button>
</div>
</template>

<script>
export default {
    props: {
        gymId: Number,
    },
    methods: {
    check1(){
        this.axios.post('api/user/court',
        {
            'gymId':this.gymId,
            'courtId':this.court_value1,    
        },
        {
            headers:{'Authorization':localStorage.getItem('token')}
        }).then((response) => {
            this.courts_array = response.data.courts;
            if(response.data.success === true && this.courts_array[this.week_value1][this.time_value1]===0)
            {
                this.$message({
								type: 'success',
								message: '可以预约'
                });
            }
            else if(response.data.success === true && this.courts_array[this.week_value1][this.time_value1]===1)
            {
                this.$message({
								type: 'warning',
								message: '已被预约'
                });
            }
            else if(response.data.success === true && this.courts_array[this.week_value1][this.time_value1]===-1)
            {
                this.$message({
								type: 'error',
								message: '不可预约'
                });
            }
        });
    },
    check2(){
        this.axios.post('api/user/court',
        {
            'gymId':this.gymId,
            'courtId':this.court_value2,    
        },
        {
            headers:{'Authorization':localStorage.getItem('token')}
        }).then((response) => {
            this.courts_array = response.data.courts;
            if(response.data.success === true && this.courts_array[this.week_value2][this.time_value2]===0)
            {
                this.$message({
								type: 'success',
								message: '可以预约'
                });
            }
            else if(response.data.success === true && this.courts_array[this.week_value2][this.time_value2]===1)
            {
                this.$message({
								type: 'warning',
								message: '已被预约'
                });
            }
            else if(response.data.success === true && this.courts_array[this.week_value2][this.time_value2]===-1)
            {
                this.$message({
								type: 'error',
								message: '不可预约'
                });
            }
        });
    },
    check3(){
        this.axios.post('api/user/court',
        {
            'gymId':this.gymId,
            'courtId':this.court_value1,    
        },
        {
            headers:{'Authorization':localStorage.getItem('token')}
        }).then((response) => {
            this.courts_array = response.data.courts;
            if(response.data.success === true && this.courts_array[this.week_value3][this.time_value3]===0)
            {
                this.$message({
								type: 'success',
								message: '可以预约'
                });
            }
            else if(response.data.success === true && this.courts_array[this.week_value3][this.time_value3]===1)
            {
                this.$message({
								type: 'warning',
								message: '已被预约'
                });
            }
            else if(response.data.success === true && this.courts_array[this.week_value3][this.time_value3]===-1)
            {
                this.$message({
								type: 'error',
								message: '不可预约'
                });
            }
        });
    },
    order(){
      this.$confirm('', 
      '您确定预约吗？', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info',
          dangerouslyUseHTMLString: true
        }).then(() => {
            this.axios.post('/api/user/rent/apply',
                {        
                    'gymId':this.gymId,
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
                          type:'success',
                          message:'志愿一预约成功'                            
                        });
                        this.$router.push('/confirm');
                    }                    
                });
                this.axios.post('/api/user/rent/apply',
                {        
                    'gymId':this.gymId,
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
                          type:'success',
                          message:'志愿二预约成功'                            
                        });
                        this.$router.push('/confirm');
                    }                    
                });
                this.axios.post('/api/user/rent/apply',
                {        
                    'gymId':this.gymId,
                    'courtId':this.court_value3,          
                    'weekNum':this.week_value3,
                    'timeNum':this.time_value3
                },
                {
                    headers:{'Authorization':localStorage.getItem('token')}
                }
                ).then((response) => {
                    if(response.data.success === true){                        
                        this.$message({
                          type:'success',
                          message:'志愿三预约成功'                            
                        });
                        this.$router.push('/confirm');
                    }                    
                });
            
            
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消预约'
          });          
        });
    }

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
        week_value1: 0,
        time_value1: 0,
        court_value2: 0,
        week_value2: 0,
        time_value2: 0,
        court_value3: 0,
        week_value3: 0,
        time_value3: 0,
        order_result: 0,
        courts_array: [[]]
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
}
</style>