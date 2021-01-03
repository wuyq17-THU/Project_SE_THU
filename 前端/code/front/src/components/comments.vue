<template>
    <div class="comments">
        <el-row :gutter="20">
            <el-col :span="3">
                <el-avatar :size="large" :src="circleUrl"></el-avatar>
                <div class="userid">COMMENTS_{{num_comments}}</div>
            </el-col>
            <el-col :span="18">                
                <div class="comment">{{comments[num_comments].content}}</div>
            </el-col>
        </el-row>
        
        <el-pagination
            background
            layout="prev, pager, next"
            @next-click="handleNextClick"
            @prev-click="handlePrevClick"
            @current-change="handlePageChange"
            :pager-count="5"
            :total="this.comments.length*10">
        </el-pagination>
        
        
    </div>
</template>

<script>
export default {
    name:'comments',
    props:{
        gymId: Number
    },
    methods:{
        
        handleNextClick(){
            if(this.num_comments<this.comments.length){
                this.num_comments -= 1;
            }
            
            //console.log(this.num_comments);
            //console.log(this.comments.length*10);
        },
        handlePrevClick(){
            if(this.num_comments>=0){
                this.num_comments +=1;
            }
            
            //console.log(this.num_comments);
        },
        handlePageChange(val){            
            this.num_comments = this.comments.length-val;
        }
    },
    data () {
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        comments: [],
        textarea: '',
        num_comments: 0,     
      }
    },
    mounted(){
        this.axios.post('/api/user/gym/getcomments',
                {       
                    'gymId':this.gymId,                    
                },
                {
                    headers:{'Authorization':localStorage.getItem('token')}
                }
                ).then((response) => {
                    this.comments = response.data.comments;
                    this.num_comments = this.comments.length-1;
                });
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
#textinput{
    margin-top: 40px;
    
    padding: 0px;
}
.el-button{
    margin-top: 0px;
    margin-bottom: 50px;
}
</style>