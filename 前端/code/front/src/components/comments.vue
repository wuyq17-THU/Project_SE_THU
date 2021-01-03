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
        <el-row :gutter="20">
            <el-col :span="3">
                <el-avatar :size="large" :src="circleUrl"></el-avatar>
                <div class="userid">COMMENTS_{{num_comments+1}}</div>
            </el-col>
            <el-col :span="18">                
                <div class="comment">{{comments[num_comments+1].content}}</div>
            </el-col>
        </el-row>
        <el-pagination
            background
            layout="prev, pager, next"
            @next-click="handleNextClick"
            @prev-click="handlePrevClick"
            @current-change="handlePageChange"
            :pager-count="5"
            :total="this.comments.length*5">
        </el-pagination>
        
        <el-row :gutter="20" id="textinput">
            <el-col :span="16" :offset="4">
                <el-input
                    type="textarea"
                    :rows="3"
                    placeholder="请输入内容"
                    v-model="textarea">
                </el-input>
            </el-col>            
        </el-row>        
        <el-button type="primary" id="confirm" plain @click="postComment">发表评论</el-button>
        
    </div>
</template>

<script>
export default {
    name:'comments',
    props:{
        gymId: Number
    },
    methods:{
        postComment(){
            this.axios.post('/api/user/rent/comment',
                {       
                    'gymId': this.gymId,
                    'comment':this.textarea,                     
                },
                {
                    headers:{'Authorization':localStorage.getItem('token')}
                }
                ).then((response) => {
                    if(response.data.success === true){
                        this.$message({
								type: 'success',
								message: '发表评价成功'
                        });
                    }
                });
        },
        handleNextClick(){
            if(this.num_comments<this.comments.length-1){
                this.num_comments += 2;
            }
            
            //console.log(this.num_comments);
            //console.log(this.comments.length*10);
        },
        handlePrevClick(){
            if(this.num_comments>0){
                this.num_comments -=2;
            }
            
            //console.log(this.num_comments);
        },
        handlePageChange(val){            
            this.num_comments = val*2-2;
        }
    },
    data () {
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        comments: [{
            'content':'场地环境好，打球很开心，五星好评0'
        },{
            'content':'朋友一起打球很开心，五星好评1'
        },{
            'content':'场地环境好，打球很开心，五星好评2'
        },{
            'content':'朋友一起打球很开心，五星好评3'
        },{
            'content':'场地环境好，打球很开心，五星好评4'
        },{
            'content':'朋友一起打球很开心，五星好评5'
        },{
            'content':'场地环境好，打球很开心，五星好评6'
        },{
            'content':'朋友一起打球很开心，五星好评7'
        },],
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
    margin-bottom: -120px;
    padding: 0px;
}
.el-button{
    margin-top: 0px;
    margin-bottom: 50px;
}
</style>