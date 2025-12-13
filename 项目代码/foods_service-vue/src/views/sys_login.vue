

<template>
	<div class="login-body-class">
		<div class="content">
			<div class="bidTitle">饮食健康服务平台-登录</div>
			<div class="logCon">
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">登录名</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入登录名" name="name" v-model="name" class="bt_input"  id="name">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">密码</label></div>
					<div style="margin-top:5px;">
						<input type="password"  placeholder="请输入密码" name="password" v-model="password" class="bt_input"  id="password">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 10px;">
					<div><label style="color:#FFFFFF;">验证码</label></div>
					<div style="margin-top:5px;display:flex">
						<input type="text" class="bt_input"  id="imgCode" name="imgCode" placeholder="验证码" v-model="imgCode" style="width:70%">
						<img id="codeImg1"  name="codeImg" @click="changeCode" :src="codeImg1" alt="点击更换" title="点击更换"    style="height:36px;width:30%;">
						</div>
					</div>
					<div   style="width:70%;margin-left:15%;margin-bottom: 10px;">
						<input name="loginType" type="radio" value="1" v-model="loginType" id="loginType1" style="margin-left:10px;"/>
						<label for="loginType1"  style="color:#FFFFFF;">管理员</label>
						<input name="loginType" type="radio" value="2" v-model="loginType" id="loginType2" style="margin-left:10px;"/>
						<label for="loginType2"  style="color:#FFFFFF;">用户</label>
					</div>
					<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
						<a href="javascript:void(0)"   @click="submitForm" id="submitBtn" class="submitBtn" style="color:white" >
							<div style="margin-top:5px;text-align: center;"   class="logingBut">
								登录
							</div>
						</a>
					</div>
					<div style="margin-top:8px;">
						<a  style="margin-left:10px;float:right;color:#FFFFFF"   data-href="/user_msg_regist" data-params="" @click="goToPage">注册用户</a>
					</div>
				</div>
			</div>
		</div>
	</template>
	
<script>
import $ from 'jquery'
import {utils} from '../assets/listutils.js'
export default {
	components: {
	},
	data() {
		return {
			name:'',
			password:'',
			imgCode:'',
			codeImg1:'',
			codeToken:'',
			loginType:'',
		};
	},
	mounted() {
		this.changeCode();
	},
	methods:{
		changeCode(){
			var that = this;
			$.ajax({
				type: 'post',
				url: this.REQUEST_URL+"/"+'/validCode/code',
				data: {
				},
				success: function(result) {
					that.codeToken = result.codeToken;
					that.codeImg1 = result.imgUrl;
				}
			});
		},
		submitForm(){
			var that = this;
			$.ajax({
				type: 'post',
				url: this.REQUEST_URL+'/login/sysSubmit',
				data: {
					'imgCode':that.imgCode,
					'imgCodeToken':that.codeToken,
					'name':that.name,
					'password':that.password,
					'loginType':that.loginType
				},
				success: function(result) {
					if(result.code==1){
						utils.setCookie('loginId',result.loginId,1);
						utils.setCookie('loginType',result.loginType,1);
						utils.setCookie('loginName',result.loginName,1);
						utils.setCookie('loginToken',result.loginToken,1);
						var lt = that.loginType;
						if(lt=='1'){
							that.goToPageJS('/admin/index','');
						}
						if(lt=='2'){
							that.goToPageJS('/index','');
						}
						}else{
						alert(result.msg);
					}
				}
			});
		},
	}
};

</script>
	<style scoped>
		body {
		height: 100%;
		}
		.bgImg {
		position: absolute;
		top: 0px;
		left: 0px;
		bottom: 0px;
		right: 0px;
		width: 100%;
		height: 100%;
		}
		.logo {
		width: 800px;
		}
		.bidTitle {
		color: white;
		font-size: 28px;
		font-weight: 600;
		text-align: center;
		}
		.logCon {
		margin-top: 40px;
		}
		.line {}
		.content {
		width: 30%;
		background: #b0c7bbc2;
		margin-left: 35%;
		padding: 5% 1%;
		border-radius: 5px;
		}
		.logingBut {
		background: #f79a15;
		border: none;
		padding: 12px 0px;
		color: #edefee;
		border-radius: 2px;
		width: 100%;
		margin-top: 5px;
		}
		.submitBtn{
		text-align:center;
		text-decoration: none;
		}
		.bt_input {
		border-radius: 2px;
		border: none;
		height:35px;
		width: 100%;
		color: #333;
		background: #ffffff;
		}
		.logCon span {
		font-size: 18px;
		height: 40px;
		line-height: 40px;
		}
		.login-body-class{
		min-height:950px;
		background-image:url(../assets/login_bg.jpg);
		background-size:100% 100%;
		padding: 6%;
		}
		.text-select{
		width:100%;
		height:35px;
		}
		a:-webkit-any-link {
		color: -webkit-link;
		cursor: pointer;
		text-decoration: none;
		}
	</style>



