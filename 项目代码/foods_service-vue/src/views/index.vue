

<template>
	<div style="height:70px;border-bottom:1px solid rgb(209, 206, 206);background-color: #f1bc6c;">
		<a   href="#"   style="float:left;margin-right:200px;margin-left:80px;color:rgb(34, 33, 32)"><h2 style="font-size:26px;color:white">饮食健康服务平台</h2></a>
		<a style="float:left;margin-left:50px;margin-top:10px;" class="menu-tag menu-parent" href="javascript:void(0)" @click="goPage" data-href="/index/index">
			<div style="width:100%">
				<h3 style="margin-bottom:11px;color:white;text-align:center;padding-left:10px;padding-right:10px;">首页</h3>
				<div  class="menuLine menu-active" style="text-align:center"></div>
			</div>
		</a>
		<a style="float:left;margin-left:50px;margin-top:10px;" class="menu-tag menu-parent" href="javascript:void(0)" @click="goPage" data-href="/index/ysjh_search">
			<div style="width:100%">
				<h3 style="margin-bottom:11px;color:white;text-align:center;padding-left:10px;padding-right:10px;">饮食计划</h3>
				<div  class="menuLine menu-active" style="text-align:center"></div>
			</div>
		</a>
		<a style="float:left;margin-left:50px;margin-top:10px;" class="menu-tag menu-parent" href="javascript:void(0)" @click="goPage" data-href="/index/ydjh_search">
			<div style="width:100%">
				<h3 style="margin-bottom:11px;color:white;text-align:center;padding-left:10px;padding-right:10px;">运动计划</h3>
				<div  class="menuLine menu-active" style="text-align:center"></div>
			</div>
		</a>
		<a style="float:left;margin-left:50px;margin-top:10px;" class="menu-tag menu-parent" href="javascript:void(0)" @click="goPage" data-href="/index/post_search">
			<div style="width:100%">
				<h3 style="margin-bottom:11px;color:white;text-align:center;padding-left:10px;padding-right:10px;">帖子搜索</h3>
				<div  class="menuLine menu-active" style="text-align:center"></div>
			</div>
		</a>
		<a style="float:left;margin-left:50px;margin-top:10px;" class="menu-tag menu-parent" href="javascript:void(0)" @click="goPage" data-href="/index/yyxcs_search">
			<div style="width:100%">
				<h3 style="margin-bottom:11px;color:white;text-align:center;padding-left:10px;padding-right:10px;">营养小常识</h3>
				<div  class="menuLine menu-active" style="text-align:center"></div>
			</div>
		</a>
		<a style="float:left;margin-left:50px;margin-top:10px;" class="menu-tag menu-parent" href="javascript:void(0)" @click="goPage" data-href="/index/sys_intro">
			<div style="width:100%">
				<h3 style="margin-bottom:11px;color:white;text-align:center;padding-left:10px;padding-right:10px;">关于我们</h3>
				<div  class="menuLine menu-active" style="text-align:center"></div>
			</div>
		</a>
		<template v-if="loginId!=''">
			<h4 style="float:right;margin-right:20px;color:gray"><a href="javascript:void(0)" @click="logoutAct" style="color:white"  >退出</a></h4>
		</template>
		<template v-if="loginType==''">
			<h4 style="float:right;margin-right:20px;color:gray"><a href="javascript:void(0)" :data-params="''" data-href="/user_msg_regist" @click="goToPage"  style="color:white" >注册</a></h4>
		</template>
		<template v-if="loginType==''">
			<h4 style="float:right;margin-right:20px;color:gray"><a  href="javascript:void(0)" :data-params="''" data-href="/sys_login" @click="goToPage" style="color:white" >登录</a></h4>
		</template>
		<template v-if="loginType==1 && loginId!=''">
			<h4 style="float:right;margin-right:20px;color:gray"><a href="javascript:void(0)" :data-params="''" data-href="/admin/index" @click="goToPage" style="color:white" >进入后台</a></h4>
		</template>
		<template v-if="loginType==2 && loginId!=''">
			<h4 style="float:right;margin-right:20px;color:gray"><a href="javascript:void(0)" :data-params="''" data-href="/user/index" @click="goToPage" style="color:white" >个人中心</a></h4>
		</template>
	</div>
	<div class="content content-nav-base commodity-content" style="background-color:#ecf5fffa;">
		<div class="floors">
			<iframe src="/index/index" id="iframeDom" style="width:100%;min-height:850px;"  frameborder="0"></iframe>
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
			loginId:'',
			loginType:'',
			loginToken:'',
			loginName:'',
			headImg:'',
		};
	},
	mounted() {
		var childPageUrl = this.$route.query.childPageUrl;
		if(childPageUrl!=null&&childPageUrl!=''&&childPageUrl!='null'){
			childPageUrl = window.atob(childPageUrl);
			$("#iframeDom").attr("src",childPageUrl);
		}
		$('.menu-tag').removeClass("menu-parent");
		$('.menu-tag').eq(0).addClass("menu-parent");
		this.loginToken=utils.getCookie('loginToken');
		this.loginId=utils.getCookie('loginId');
		this.loginType=utils.getCookie('loginType');
		this.loginName=utils.getCookie('loginName');
		this.initData();
	},
	methods:{
		initData(){
			var that = this;
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/getData",
				async: false,
				data : {
					"loginToken":that.loginToken,
				},
				success : function(result) {
					that.headImg=result.headImg;
					if(result.login==null) {
						that.loginToken='';
						that.loginId='';
						that.loginType='';
						that.loginName='';
						that.headImg='';
					}
				}
			});
		},
		logoutAct(){
			var that = this;
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+"/login/sys_logout",
				async: false,
				data : {
					'token':that.loginToken,
				},
				success : function(result) {
					that.goToPageJS('/sys_login','');
				}
			});
		},
		goPage(e){
			var that = this;
			$('.menu-tag').removeClass("menu-parent");
			$(e.currentTarget).addClass("menu-parent");
			var href = e.currentTarget.dataset.href;
			$("#iframeDom").attr("src",href);
		},
		menuGoPage(index, indexPath){
			var that = this;
			$('#iframeDom').attr('src', index);
		},
	}
};

</script>
<style scoped>
	a {
	color: #333;
	text-decoration: none;
	}
	.site-nav-bg{
	overflow:hidden;
	}
	.menu-style{
	padding-left:350px
	}
	.menu-parent .menu-active{
	border-bottom:4px solid white;
	color:black !important;
	}
</style>



