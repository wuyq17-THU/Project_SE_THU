<template>
  <div class="step">
    <el-steps :active="msg" finish-status="success" simple style="margin-top: 0px">
        <el-step title="1 选择场馆" ></el-step>
        <el-step title="2 预约场地" ></el-step>
        <el-step title="3 支付" ></el-step>
        <el-step title="4 使用" ></el-step>
    </el-steps>
    <!-- 下方按钮为选择场地按钮 -->
    <!--<el-button style="margin-top: 12px;" @click="next">下一步</el-button>-->
  </div>
</template>

<script>
export default {
    name: 'Step',
    data() {
        return {
            active: 1
        };
    },
    props: {
        msg : String
    },
    methods: {
      next() {
        if (this.active++ > 3) this.active = 0;
      }
    }
}

</script>

<style scoped>

</style>