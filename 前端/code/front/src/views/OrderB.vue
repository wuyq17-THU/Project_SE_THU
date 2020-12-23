<template>
  <div class="orderT">
      <el-container>
        <el-header>
          <div id="head">
            <Head></Head>
            <Navi></Navi>
            <Step msg="1"></Step>
          </div>
        </el-header>
        <el-container id="main">
          <el-aside width="450px">
            <div id="title">
              <h1>羽毛球场</h1>
              <p>地理位置</p>
            </div>
            <img src="../assets/map_badminton.jpg" class="image">
            <div id="info">
              <h1>具体信息</h1>
              <p>1．活动中心门口有“清华紫荆”门码，进入活动中心实行“体</p><p>温检测+清华紫荆扫码”。</p>
              <p>2．进入活动中心人员须凭学校有效证件。进入羽毛球场地须</p><p>与预约结果进行核对。</p>
              <p>3、活动中心室内人数达到乒乓球场地与羽毛球场地的合计上</p><p>限人数，将限制人员进入。</p>
              <p>4．请按照预约时间到场使用，活动完毕应尽快离开场地。</p>
              <p>5．按学校“减少聚集”的疫情防控要求，只允许该时段使用者进</p><p>入，非该时段的使用者和其他人员请勿进入。</p>
              <p>6．所有在场人员应保持一米以上距离。</p>
              <p>7．场地使用者应遵守场地管理人员的管理。不遵守现场</p><p>管理者，场地管理人员及时劝阻，必要时予以劝离。</p>
              <p>联系电话：84868。</p>
            </div>
          </el-aside>
          <el-main>
            <OrderTable></OrderTable>
            <el-button type="primary" id="confirm" plain @click="order">确认预约</el-button>
            <div class="comments">
              <h1>评论</h1>
              <Comments></Comments>
            </div>
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
import OrderTable from '@/components/OrderTable.vue'
import Comments from '../components/comments.vue'

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
    Step,
    OrderTable,
    Comments,
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    order(){
      this.$confirm('<p>场地一 星期三 08:00-09:00</p><p>场地二 星期三 08:00-09:00</p><p>场地三 星期三 08:00-09:00</p>', 
      '您确定预约吗？', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info',
          dangerouslyUseHTMLString: true
        }).then(() => {          
          this.$router.push('/test');
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消预约'
          });          
        });
    }

  }
}
</script>

<style >
#confirm{
  margin-top: 40px;
}

.comments{
  background-color: #f3f5f7;
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

