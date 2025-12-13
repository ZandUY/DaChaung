

<template>
	<div>
		<el-container class="layout-container-demo">
			<el-aside>
				<el-scrollbar>
					<h4><a  href="javascript:void(0)" >饮食健康服务平台</a></h4>
					<hr>
						<el-menu  @select="gotoIframePage">
							<el-menu-item :index="'/home'">
								首页
							</el-menu-item>
							<el-menu-item :index="'/admin/user_msg/list'">
								用户管理
							</el-menu-item>
							<el-menu-item :index="'/admin/yd_type_msg/list'">
								运动类型
							</el-menu-item>
							<el-menu-item :index="'/admin/ys_type_msg/list'">
								饮食类型
							</el-menu-item>
							<el-menu-item :index="'/admin/bmifw_msg/list'">
								BMI范围
							</el-menu-item>
							<el-menu-item :index="'/admin/ynum_fw_msg/list'">
								饮食热量范围
							</el-menu-item>
							<el-menu-item :index="'/admin/ydxhfw_msg/list'">
								运动消耗范围
							</el-menu-item>
							<el-menu-item :index="'/admin/ysjh_msg/list'">
								饮食计划
							</el-menu-item>
							<el-menu-item :index="'/admin/ydjh_msg/list'">
								运动计划
							</el-menu-item>
							<el-menu-item :index="'/admin/post_msg/list'">
								帖子管理
							</el-menu-item>
							<el-menu-item :index="'/admin/dis_msg/list'">
								评论管理
							</el-menu-item>
							<el-menu-item :index="'/admin/reply_msg/list'">
								回复管理
							</el-menu-item>
							<el-menu-item :index="'/admin/lmsg_suggest_msg/list'">
								留言反馈
							</el-menu-item>
							<el-menu-item :index="'/admin/yyxcs_msg/list'">
								营养小常识
							</el-menu-item>
							<el-menu-item :index="'/admin/xt_intro_msg/list'">
								系统介绍
							</el-menu-item>
							<el-menu-item :index="'/admin/banner_msg/list'">
								轮播图管理
							</el-menu-item>
						</el-menu>
					</el-scrollbar>
				</el-aside>
				<el-container>
					<el-header>
						<div class="toolbar">
							<h3 style="flex:8">欢迎您，{{loginName}}！</h3>
							<h3 style="flex:1">
								<a href="javascript:void(0)" @click="alterPassword">
									修改密码
								</a>
							</h3>
							<h3 style="flex:1">
								<a href="javascript:void(0)" @click="logout">
									退出
								</a>
							</h3>
						</div>
					</el-header>
					<el-main>
						<el-scrollbar>
							<iframe  id="iframeDom"   src="/home"></iframe>
						</el-scrollbar>
					</el-main>
				</el-container>
			</el-container>
		</div>
	</template>
	
<script>
import $ from 'jquery'
import {utils} from '../../assets/listutils.js'
import {admin_utils} from '../../assets/admin/admin_utils.js'
export default {
	components: {
	},
	data() {
		return {
			loginId:'',
			loginName:'',
			loginToken:'',
			loginType:'',
			user:{},
		};
	},
	mounted() {
		this.loginId=utils.getCookie('loginId');
		this.loginName=utils.getCookie('loginName');
		this.loginToken=utils.getCookie('loginToken');
		this.loginType=utils.getCookie('loginType');
		this.getInitData();
		this.checkIsLogin();
	},
	methods:{
		handleExportJsMethod(e){
			var div = e.currentTarget;
			var methodtype = div.dataset.methodtype;
			if(methodtype=='clickMenu'){
				admin_utils.clickMenu(div);
			}
		},
		gotoIframePage(index, indexPath){
			var that = this;
			$('#iframeDom').attr('src', index);
			$("#page-container").removeClass("sidebar-o-xs");
		},
		alterPassword(){
			var that = this;
			$('#iframeDom').attr('src', '/alter_password');
			$("#page-container").removeClass("sidebar-o-xs");
		},
		goPageFunc(e){
			var that = this;
			var url =e.currentTarget.dataset.url;
			$('#iframeDom').attr('src', url);
		},
		logout(){
			var that = this;
			$.ajax({
				type: 'post',
				url: this.REQUEST_URL+"/login/sys_logout",
				data: {
					"token":that.loginToken
				},
				success: function(result) {
					if(result.code==1){
						that.goToPageJS('/sys_login','');
						}else{
						alert(result.msg);
					}
				}
			});
		},
		getInitData(){
			var that = this;
			$.ajax({
				dataType:"json",
				type:"post",
				url:this.REQUEST_URL+"/admin/index/getInitData",
				data:{
					"loginToken":that.loginToken
				},
				success:function (data,textStatus, jqXHR)  {
					var statusCode = jqXHR.status;
					if(statusCode!=200){
						that.goToPageJS('/sys_login','');
					}
					if(data.code!=undefined&&data.code==0){
						alert(data.msg);
						that.goToPageJS('/sys_login','');
					}
					that.user = data.user;
				},
				error: function(jqXHR, textStatus, errorThrown) {
					that.goToPageJS('/sys_login','');
				}
			})
		},
		checkIsLogin(){
			var that = this;
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+"/login/checkIsLogin",
				async: false,
				data : {
					"loginToken":that.loginToken,
				},
				success : function(result) {
					if(result.code==0) {
						that.goToPageJS('/sys_login','');
					}
				}
			});
		},
	}
};

</script>
	<style scoped>
		/* 全局布局容器 */
		.layout-container-demo {
		height: 100vh;
		background: #35495e;
		display: flex;
		}
		/* 侧边栏区域 */
		.el-aside {
		width: 200px !important;
		background: linear-gradient(180deg, #304156 0%, #2b3441 100%);
		box-shadow: 4px 0 6px -4px rgba(0,0,0,0.1);
		transition: width 0.3s;
		}
		/* 侧边栏标题样式 */
		.el-aside h4 {
		color: #fff;
		padding: 18px 20px;
		margin: 0;
		font-size: 18px;
		background: rgba(255,255,255,0.05);
		}
		.el-aside h4 a {
		color: #fff;
		text-decoration: none;
		transition: opacity 0.3s;
		}
		.el-aside h4 a:hover {
		opacity: 0.8;
		}
		/* 菜单项样式 */
		.el-menu {
		border-right: none !important;
		background-color: transparent;
		}
		.el-menu-item {
		color: #bfcbd9 !important;
		transition: all 0.3s !important;
		}
		.el-menu-item:hover {
		background: rgba(255,255,255,0.08) !important;
		color: #fff !important;
		}
		.el-menu-item.is-active {
		background: #409eff !important;
		color: #fff !important;
		}
		/* 头部容器 */
		.el-header {
		height: 64px !important;
		padding: 0 24px !important;
		background: #fff;
		box-shadow: 0 2px 8px rgba(0,0,0,0.05);
		z-index: 1;
		}
		/* 工具栏布局 */
		.toolbar {
		height: 100%;
		display: flex;
		align-items: center;
		justify-content: space-between;
		}
		.toolbar h3 {
		margin: 0;
		font-weight: 500;
		color: #606266;
		}
		/* 操作按钮区域 */
		.toolbar h3:not(:first-child) {
		margin-left: 20px;
		}
		.toolbar a {
		color: #409eff;
		text-decoration: none;
		transition: color 0.3s;
		cursor: pointer;
		padding: 8px 12px;
		border-radius: 4px;
		}
		.toolbar a:hover {
		color: #66b1ff;
		background: rgba(64,158,255,0.1);
		}
		.toolbar a[onclick*="logout"] {
		color: #f56c6c;
		}
		.toolbar a[onclick*="logout"]:hover {
		color: #f78989;
		background: rgba(245,108,108,0.1);
		}
		/* 主内容区 */
		.el-main {
		padding: 20px !important;
		background: #f6f8fa;
		}
		/* iframe容器 */
		#iframeDom {
		width: 100%;
		height: calc(100vh - 84px);
		border: none;
		border-radius: 8px;
		background: #fff;
		box-shadow: 0 2px 12px rgba(0,0,0,0.05);
		}
		/* 滚动条样式 */
		.el-scrollbar__view {
		height: 100%;
		}
		.el-scrollbar__bar.is-vertical {
		right: 2px;
		}
		.el-menu {
		background-color: #1f2d3d !important;  /* 主菜单背景色（深蓝灰） */
		border-right: none;
		}
		/* 菜单项交互状态 */
		.el-menu-item {
		color: #c0ccda !important;            /* 默认文字色 */
		transition: all 0.3s cubic-bezier(.25,.8,.25,1);
		}
		.el-menu-item:hover {
		background-color: #263445 !important; /* 悬停背景色（加深10%） */
		}
		.el-menu-item.is-active {
		background-color: #2d8cf0 !important; /* 激活项背景色（品牌蓝） */
		color: #ffffff !important;
		}
		/* 强制显示子菜单容器 */
		.el-sub-menu .el-menu {
		display: block !important;
		background-color: #2d3a4b !important; /* 设置子菜单背景 */
		}
		/* 修复子菜单项隐藏问题 */
		.el-sub-menu .el-menu-item {
		display: flex !important;
		opacity: 1 !important;
		height: 56px !important;
		}
		/* 修复箭头图标颜色 */
		.el-sub-menu__icon-arrow {
		color: rgba(255,255,255,0.8) !important;
		}
		/* 修复文字颜色 */
		.el-sub-menu__title{
		color: #c0ccda !important;
		}
		.el-sub-menu .el-menu-item {
		color: #c0ccda !important;
		}
		/* 强制覆盖标题文字颜色 */
		.el-sub-menu__title {
		color: #c0ccda !important; /* 浅灰色 */
		}
		/* 鼠标悬停时的颜色 */
		.el-sub-menu__title:hover {
		color: #ffffff !important; /* 纯白色 */
		background: rgba(255,255,255,0.08) !important;
		}
		/* 激活状态的标题颜色 */
		.el-sub-menu.is-active > .el-sub-menu__title {
		color: #409eff !important; /* 品牌蓝色 */
		}
		/* 箭头图标颜色 */
		.el-sub-menu__icon-arrow {
		color: rgba(192, 204, 218, 0.8) !important; /* 半透明白色 */
		}
		/* 展开后的箭头方向 */
		.el-sub-menu.is-opened .el-sub-menu__icon-arrow {
		transform: rotate(180deg); /* 正确显示展开状态 */
		}
		/* 深度选择器写法 */
		::v-deep(.el-sub-menu__title) {
		color: #c0ccda !important;
		}
		/* 主菜单交互效果 */
		::v-deep(.el-menu-item:hover),
		::v-deep(.el-menu-item.is-active),
		::v-deep(.el-sub-menu__title:hover),
		::v-deep(.el-sub-menu.is-active > .el-sub-menu__title) {
		background: linear-gradient(
		90deg,
		rgba(64, 158, 255, 0.1) 0%,
		rgba(64, 158, 255, 0.05) 100%
		) !important;
		color: #66b1ff !important;
		}
		/* 子菜单容器背景 */
		::v-deep(.el-sub-menu .el-menu) {
		background: #1f2d3d !important;
		border-left: 2px solid rgba(64, 158, 255, 0.1) !important;
		}
		/* 子菜单项交互 */
		::v-deep(.el-sub-menu .el-menu-item:hover) {
		background: rgba(64, 158, 255, 0.05) !important;
		padding-left: 52px !important; /* 增加悬停动画效果 */
		transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
		}
	</style>



