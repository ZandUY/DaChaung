

<template>
	<div class="detail-page">
		<div class="detail-page-div">
			<h2 class="detail-page-name">帖子</h2>
			<div  class="detail-page-div2">
				<div  class="detail-page-div3">
					<div  class="detail-page-div4">
						<div class="admin-ibox-content">
							<div   class="detail-page-div5">
								<div  class="detail-page-div6">
									<div class="admin-table">
										<div id="detailBody">
											<div class="admin-table-div">
												<div class="col1">标题</div>
												<div class="col2" v-html="title==null?'':title"></div>
											</div>
											<div class="admin-table-div">
												<div class="col1">副标题</div>
												<div class="col2" v-html="subtitle==null?'':subtitle"></div>
											</div>
											<div class="admin-table-div">
												<div class="col1">帖子详情</div>
												<div class="col2" v-html="postDetail==null?'':postDetail"></div>
											</div>
											<div  class="admin-table-div">
												<div class="col1">用户ID</div>
												<div class="col2" >
													<div class="author-div">
														<img :src="userIdImg" class="author-img"/>
													</div>
													<div v-html="userIdStr" class="author-name">
													</div>
												</div>
											</div>
											<div class="admin-table-div">
												<div class="col1">发布时间</div>
												<div class="col2" v-html="fbTime==null?'':fbTime"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="detail-page-btn-area">
									<el-button href="javascript:void(0)"  onclick="javascript:history.back(-1);" type="default">返回</el-button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import $ from 'jquery'
import {utils} from '../../../assets/listutils.js'
import {admin_utils} from '../../../assets/admin/admin_utils.js'
export default {
	components: {
	},
	data() {
		return {
			id:'',
			currentLoginToken:'',
			currentLoginId:'',
			currentLoginType:'',
			title:'',
			subtitle:'',
			postDetail:'',
			userIdImg:'',
			userIdStr:'',
			fbTime:'',
			detail:{},
		};
	},
	mounted() {
		this.id= this.$route.query.id;
		this.currentLoginToken=utils.getCookie('loginToken');
		this.currentLoginId=utils.getCookie('loginId');
		this.currentLoginType=utils.getCookie('loginType');
		this.queryDataDetail();
	},
	methods:{
		queryDataDetail(){
			var that = this;
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+"/admin/post_msg/getDetailData",
				async: false,
				data : {
					'id':that.id,
					'loginToken':that.currentLoginToken,
				},
				success : function(result) {
					that.title = (result.detail.postMsg.title==null?'':result.detail.postMsg.title);
					that.subtitle = (result.detail.postMsg.subtitle==null?'':result.detail.postMsg.subtitle);
					that.postDetail = (result.detail.postMsg.postDetail==null?'':result.detail.postMsg.postDetail);
					that.userIdImg = (result.detail.userIdImg==null?'':result.detail.userIdImg);
					that.userIdStr = (result.detail.userIdStr==null?'':result.detail.userIdStr);
					that.fbTime = (result.detail.postMsg.fbTime==null?'':result.detail.postMsg.fbTime);
				}
			});
		},
	}
};

</script>
<style scoped>
	/* 全局容器样式 */
	.detail-page {
	background: #f8fafc;
	min-height: 100vh;
	padding: 30px;
	}
	/* 主内容容器 */
	.detail-page-div {
	max-width: 1200px;
	margin: 0 auto;
	background: #ffffff;
	border-radius: 12px;
	box-shadow: 0 10px 30px rgba(0,0,0,0.08);
	overflow: hidden;
	}
	/* 标题样式 */
	.detail-page-name {
	font-size: 26px;
	color: #2d3441;
	text-align: center;
	padding: 30px 0;
	margin: 0;
	background: linear-gradient(135deg, #f9fbfd 0%, #ffffff 100%);
	border-bottom: 1px solid #f0f2f7;
	position: relative;
	}
	.detail-page-name::after {
	content: '';
	display: block;
	width: 60px;
	height: 3px;
	background: #409EFF;
	margin: 15px auto 0;
	border-radius: 2px;
	}
	/* 内容区域布局 */
	.admin-table {
	padding: 35px 50px;
	max-width:90%;
	}
	/* 表格行样式 */
	.admin-table-div {
	display: flex;
	align-items: flex-start;
	padding: 20px 0;
	border-bottom: 1px solid #f0f2f7;
	transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
	}
	.admin-table-div:hover {
	background: #f8fafc;
	transform: translateX(10px);
	}
	/* 标签列样式 */
	.col1 {
	flex: 0 0 200px;
	color: #606266;
	font-weight: 500;
	padding-right: 35px;
	text-align: right;
	font-size: 15px;
	position: relative;
	}
	.col1::after {
	content: ':';
	position: absolute;
	right: 15px;
	color: #c0c4cc;
	}
	/* 内容列样式 */
	.col2 {
	flex: 1;
	color: #303133;
	line-height: 1.8;
	min-height: 24px;
	}
	/* 图片展示样式 */
	.div-img {
	width: 140px;
	height: 140px;
	object-fit: cover;
	border-radius: 10px;
	margin: 8px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
	transition: all 0.3s;
	cursor: zoom-in;
	border: 2px solid #fff;
	}
	.div-img:hover {
	transform: scale(1.08);
	box-shadow: 0 6px 20px rgba(0, 0, 0, 0.12);
	}
	/* 视频样式 */
	.div-video {
	width: 360px;
	max-width: 100%;
	border-radius: 12px;
	margin: 10px 0;
	}
	/* 音频控件 */
	.div-audio {
	width: 320px;
	max-width: 100%;
	margin: 10px 0;
	border-radius: 25px;
	}
	/* 文件链接样式 */
	.div-file {
	display: inline-flex;
	align-items: center;
	padding: 10px 20px;
	background: #f5f7fa;
	border-radius: 8px;
	color: #409EFF;
	text-decoration: none;
	margin: 6px;
	transition: all 0.3s;
	border: 1px solid #e4e7ed;
	}
	.div-file::before {
	content: '📎';
	margin-right: 10px;
	font-size: 18px;
	filter: drop-shadow(0 2px 2px rgba(0,0,0,0.1));
	}
	.div-file:hover {
	background: #ecf5ff;
	transform: translateY(-2px);
	box-shadow: 0 4px 12px rgba(64, 158, 255, 0.15);
	}
	/* 管理员信息 */
	.author-div {
	display: flex;
	align-items: center;
	gap: 15px;
	margin: 10px 0;
	}
	.author-img {
	width: 56px;
	height: 56px;
	border-radius: 50%;
	border: 3px solid #e4e7ed;
	box-shadow: 0 4px 12px rgba(0,0,0,0.08);
	transition: all 0.3s;
	}
	.author-img:hover {
	transform: rotate(8deg);
	}
	.author-name {
	font-weight: 500;
	color: #303133;
	font-size: 16px;
	}
	/* 星级评分 */
	.evalStar {
	display: flex;
	gap: 6px;
	padding: 5px 0;
	}
	.evalStar img {
	width: 30px;
	height: 30px;
	transition: all 0.3s;
	cursor: pointer;
	}
	.evalStar img:hover {
	transform: scale(1.15);
	}
	/* 按钮容器 */
	.detail-page-btn-area {
	text-align: center;
	padding: 35px 0 25px;
	margin-top: 25px;
	background: linear-gradient(to right, #f9fbfd 0%, #ffffff 100%);
	border-top: 1px solid #f0f2f7;
	}
	/* 响应式设计 */
	@media (max-width: 992px) {
	.admin-table {
	padding: 25px;
	}
	.col1 {
	flex: 0 0 160px;
	padding-right: 25px;
	}
	.div-img {
	width: 120px;
	height: 120px;
	}
	}
	@media (max-width: 768px) {
	.detail-page {
	padding: 20px;
	}
	.admin-table-div {
	flex-direction: column;
	gap: 10px;
	padding: 18px 0;
	}
	.col1 {
	flex: none;
	width: 100%;
	text-align: left;
	padding-right: 0;
	color: #409EFF;
	font-weight: 600;
	font-size: 15px;
	}
	.col1::after {
	display: none;
	}
	.div-video {
	width: 100%;
	}
	}
	@media (max-width: 480px) {
	.detail-page-name {
	font-size: 22px;
	padding: 25px 0;
	}
	.div-file {
	width: 100%;
	justify-content: center;
	}
	.evalStar img {
	width: 26px;
	height: 26px;
	}
	}
</style>



