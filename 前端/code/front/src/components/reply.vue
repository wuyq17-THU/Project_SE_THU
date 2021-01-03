<template>
    <div class="reply">       
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
                        this.$router.go(0);            
                    }
                });
        },
        
    },
    data () {
      return {
        
        comments: [],
        textarea: '',
        num_comments: 0,     
      }
    },    
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