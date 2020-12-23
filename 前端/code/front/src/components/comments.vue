<template>
    <div class="comments">
        <el-row :gutter="20">
            <el-col :span="3">
                <el-avatar :size="large" :src="circleUrl"></el-avatar>
                <div class="userid">USER_1</div>
            </el-col>
            <el-col :span="18">                
                <div class="comment">场地很好，五星好评</div>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="3">
                <el-avatar :size="large" :src="circleUrl"></el-avatar>
                <div class="userid">USER_2</div>
            </el-col>
            <el-col :span="18">                
                <div class="comment">和朋友打网球很开心，五星好评</div>
            </el-col>
        </el-row>
        <el-pagination
        background
        layout="prev, pager, next"
        :total="30">
        </el-pagination>
    </div>
</template>

<script>
export default {
    name:'comments',
    data () {
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",        
      }
    }
}
</script>

<style scoped>
.el-row{
    height: 200px;
}
.comment {
    text-align: left;
    background-color: rgb(255, 255, 255);
    height: 180px;
}
</style>