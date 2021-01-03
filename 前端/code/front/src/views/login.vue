<template>
<div>
	<Head></Head>
	<Navi></Navi>
	<p class="login">
		<el-tabs v-model="activeName" @tab-click="handleClick">
			<el-tab-pane label="登录" name="first">
				<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
					<el-form-item label="名称" prop="name"><el-input v-model="ruleForm.name"></el-input></el-form-item>
 
					<el-form-item label="密码" prop="pass"><el-input type="password" v-model="ruleForm.pass" auto-complete="off"></el-input></el-form-item>
 
					<el-form-item>
						<el-button type="primary" @click="submitForm('ruleForm', ruleForm.name, ruleForm.pass)">登录</el-button>
 
						<el-button @click="resetForm('ruleForm')">重置</el-button>
					</el-form-item>
				</el-form>
			</el-tab-pane>			
		</el-tabs>
	</p>
</div>
</template>
 
<script>
import Head from '@/components/Head.vue'


export default {
	
	data() {
		var validatePass = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入密码'));
			} else {
				if (this.ruleForm.checkPass !== '') {
					this.$refs.ruleForm.validateField('checkPass');
				} 
				callback();
			}
		};
 
		return {
			activeName: 'first',
			ruleForm: {
				name: '',
				pass: '',
				checkPass: ''
			},
			rules: {
				name: [{ required: true, message: '请输入您的名称', trigger: 'blur' }, { min: 2, max: 20, message: '长度在 2 到 20 个字符', trigger: 'blur' }],
				pass: [{ required: true, validator: validatePass, trigger: 'blur' }]
			}
		};
	},
 
	methods: {
		
		//重置表单
		resetForm(formName) {
			this.$refs[formName].resetFields();
		},
        //提交表单
        
		submitForm(formName,username,pass) {
			this.$refs[formName].validate(valid => {
				if (valid) {
                    this.axios.patch('/api/user/login',{
                        'username':username,
                        'password':pass
                    }).then((response) => {
						console.log(response.data);
						if(response.data.success === 'true'){
							console.log(response.data.success);
							localStorage.setItem('token',response.data.msg);
							this.$message({
								type: 'success',
								message: '登录成功'
							});
							this.$router.push('/first');
						}
                    });
					
				} else {
					console.log('error submit!!');
					return false;
				}
            });
            
		}
	},
	components: {
    Head,
    
  },
}
</script>
 
<style>
.login {
	width: 400px;
	margin: 0 auto;
	margin-top: 100px;
}
 
.el-tabsitem {
	text-align: center;
	width: 60px;
}
</style>