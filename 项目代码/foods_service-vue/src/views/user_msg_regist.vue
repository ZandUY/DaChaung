

<template>
	<div class="login-body-class">
		<div class="content">
			<div class="bidTitle">饮食健康服务平台-用户-注册</div>
			<div class="logCon">
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">登录名</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入登录名" name="loginName" v-model="loginName" class="bt_input" id="loginName">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">密码</label></div>
					<div style="margin-top:5px;">
						<input type="password" name="password"  placeholder="请输入密码"  v-model="password" class="bt_input" id="password">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">姓名</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入姓名" name="name" v-model="name" class="bt_input" id="name">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">联系电话</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入联系电话" name="celphone" v-model="celphone" class="bt_input" id="celphone">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">邮箱</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入邮箱" name="email" v-model="email" class="bt_input" id="email">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">性别</label></div>
					<div style="margin-top:5px;">
						<select  class="text-select" data-id="sex"  v-model="sex"  id="sex" >
							<template v-for="item in sexList">
								<option :value="item.id">{{item.name}}</option>
							</template>
						</select>
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">身高</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入身高(请输入数字)" name="sg" v-model="sg" class="bt_input" id="sg">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">体重</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入体重(请输入数字)" name="weight" v-model="weight" class="bt_input" id="weight">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
					<div><label style="color:#FFFFFF">年龄</label></div>
					<div style="margin-top:5px;">
						<input type="text"  placeholder="请输入年龄" name="age" v-model="age" class="bt_input" id="age">
					</div>
				</div>
				<div  style="width:70%;margin-left:15%;margin-bottom: 10px;">
					<div><label style="color:#FFFFFF;">验证码</label></div>
					<div style="margin-top:5px;display:flex">
						<input type="text" class="bt_input"  id="imgCode" name="imgCode" placeholder="验证码" v-model="imgCode" style="width:70%">
						<img id="codeImg1"  name="codeImg" @click="changeCode" :src="codeImg1" alt="点击更换" title="点击更换"    style="height:36px;width:30%;">
						</div>
					</div>
					<div  style="width:70%;margin-left:15%;margin-bottom: 18px;">
						<a href="javascript:void(0)"   @click="submitForm" id="submitBtn" class="submitBtn" style="color:white" >
							<div style="margin-top:5px;text-align: center;"   class="logingBut">
								用户-注册
							</div>
						</a>
					</div>
					<div style="margin-top:8px;">
						<a  style="margin-left:10px;float:right;color:#FFFFFF"   data-href="/sys_login" data-params="" @click="goToPage">前往登录</a>
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
			loginName:'',
			password:'',
			name:'',
			celphone:'',
			email:'',
			sex:'1',
			sg:'',
			weight:'',
			age:'',
			sexList:[],
			imgCode:'',
			codeImg1:'',
			codeToken:'',
		};
	},
	mounted() {
		var that=this;
		that.getDataList();
		this.changeCode();
	},
	methods:{
		getDataList(){
			var that = this;
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+"/regist/getListData",
				async: false,
				data : {
				},
				success : function(result) {
					that.sexList = result.sexList;
				}
			});
		},
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
			var loginName = that.loginName;
			var password = that.password;
			var name = that.name;
			var celphone = that.celphone;
			var email = that.email;
			var sex = that.sex;
			var sg = that.sg;
			var weight = that.weight;
			var age = that.age;
			$.ajax({
				type: 'post',
				url: this.REQUEST_URL+'/regist/userMsgRegistSubmit',
				data: {
					'loginName':loginName,
					'password':password,
					'name':name,
					'celphone':celphone,
					'email':email,
					'sex':sex,
					'sg':sg,
					'weight':weight,
					'age':age,
					'imgCode':that.imgCode,
					'imgCodeToken':that.codeToken,
				},
				success: function(result) {
					alert(result.msg);
					if(result.code==1){
						that.goToPageJS('/sys_login','');
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



