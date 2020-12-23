<template>
    <div class="orderTable">                
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="场地一" name="first">
            <el-table
            :data="tableData"
            stripe
            border
            style="width: 96%">
            <el-table-column
                fixed
                prop="date"
                label="星期/时间段"
                width="100">
            </el-table-column>
            <el-table-column
                width="70"
                prop="num"
                label="08:00-09:00">                      
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                width="70"
                prop="num"
                label="09:00-10:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>            
            <el-table-column
                prop="num"
                width="70"
                label="10:00-11:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="11:00-12:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="12:00-13:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="13:00-14:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="14:00-15:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="15:00-16:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="16:00-17:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="17:00-18:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="18:00-19:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="19:00-20:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="20:00-21:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="21:00-22:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            </el-table>
            </el-tab-pane>
            <el-tab-pane label="场地二" name="second">
            <el-table
            :data="tableData"
            stripe
            border
            style="width: 96%">
            <el-table-column
                fixed
                prop="date"
                label="星期/时间段"
                width="100">
            </el-table-column>
            <el-table-column
                width="70"
                prop="num"
                label="08:00-09:00">                      
                <el-checkbox v-model="checked"></el-checkbox>           
            </el-table-column>
            <el-table-column
                width="70"
                prop="num"
                label="09:00-10:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>            
            <el-table-column
                prop="num"
                width="70"
                label="10:00-11:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="11:00-12:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="12:00-13:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="13:00-14:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="14:00-15:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="15:00-16:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="16:00-17:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="17:00-18:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="18:00-19:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="19:00-20:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="20:00-21:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="21:00-22:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            </el-table>
            </el-tab-pane>
            <el-tab-pane label="场地三" name="third">
            <el-table
            :data="tableData"
            stripe
            border
            style="width: 96%">
            <el-table-column
                fixed
                prop="date"
                label="星期/时间段"
                width="100">
            </el-table-column>
            <el-table-column
                width="70"
                prop="num"
                label="08:00-09:00">                      
                <el-checkbox v-model="checked"></el-checkbox>                                         
            </el-table-column>
            <el-table-column
                width="70"
                prop="num"
                label="09:00-10:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>            
            <el-table-column
                prop="num"
                width="70"
                label="10:00-11:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="11:00-12:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="12:00-13:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="13:00-14:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="14:00-15:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="15:00-16:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="16:00-17:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="17:00-18:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="18:00-19:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="19:00-20:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="20:00-21:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            <el-table-column
                prop="num"
                width="70"
                label="21:00-22:00">
                <el-checkbox v-model="checked"></el-checkbox>
            </el-table-column>
            </el-table>
            </el-tab-pane>
        </el-tabs>
        <el-row>
            
            <el-button type="primary" @click="checkall">全选</el-button>
            
            <el-button type="danger" @click="cancel">取消全选</el-button>
        </el-row>
        
    </div>
</template>

<script>
export default {
    data(){
        return {
            checked: true,
            tableData: [{
              date: '星期一',

            }, {
              date: '星期二',
              
            }, {
              date: '星期三',
              
            }, {
              date: '星期四',
              
            },{
              date: '星期五',
              
            },{
              date: '星期六',
              
            },{
              date: '星期日',
              
            }]
        };
    },
    methods:{
        checkall(){
            this.checked = true;
        },
        cancel(){
            this.checked = false;
        }
    }
}
</script>

<style scoped>
.orderTable{
  background-color: #f3f5f7;
}
.el-table {
  margin: 20px;
}
</style>