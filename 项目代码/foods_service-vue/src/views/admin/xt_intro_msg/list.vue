

<template>
	<div class="admin-modal admin-inmodal admin-in" id="bodyModal" tabindex="-1" role="dialog" aria-hidden="false" style="top: 80px; left: -200px; ">
		<div class="admin-modal-dialog">
			<div class="admin-modal-content">
				<div class="admin-modal-header">
					<button type="button" class="admin-close" @click="handleExportJsMethod"  data-methodtype="hideModal"><span aria-hidden="true">×</span><span class="admin-sr-only">关闭</span>
					</button>
					<h4 class="admin-modal-title" id="bodyModalTile"></h4>
				</div>
				<div class="admin-modal-body" id="bodyModalContent" style="padding:30px;"></div>
				<div class="admin-modal-footer">
					<button type="button" class="admin-btn admin-btn-white" @click="handleExportJsMethod"  data-methodtype="hideModal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<el-card class="box-card"  style="margin-left:2%;width:95%;margin-top:20px;">
		<template #header>
			<div class="card-header">
				<span>系统介绍</span>
			</div>
		</template>
		<div>
			<el-form :inline="true" :model="formInline" class="demo-form-inline">
				<el-form-item label="标题" style="min-width:250px;">
					<el-input type="text"  placeholder="请输入标题" name="title" v-model="title" class="" id="title"></el-input>
				</el-form-item>
				<el-form-item label="联系电话" style="min-width:250px;">
					<el-input type="text"  placeholder="请输入联系电话" name="celphone" v-model="celphone" class="" id="celphone"></el-input>
				</el-form-item>
				<el-form-item label="地址" style="min-width:250px;">
					<el-input type="text"  placeholder="请输入地址" name="address" v-model="address" class="" id="address"></el-input>
				</el-form-item>
				<el-form-item label="邮箱" style="min-width:250px;">
					<el-input type="text"  placeholder="请输入邮箱" name="email" v-model="email" class="" id="email"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="ajaxList(1)" >查询</el-button>
				</el-form-item>
			</el-form>
			<div style="margin-top:5px;padding-left: 15px;">
			</div>
			<div style="margin-top:5px;margin-bottom:5px;padding-left: 15px;">
			</div>
			<div >
				<el-table
					ref="multipleTable"
					border
					:data="dataList"
					tooltip-effect="dark"
					style="width: 100%"
					:row-style="{backgroundColor: 'rgba(255,255,255,0.9)'}"
					:header-row-style="{backgroundColor: '#f8f8f8'}"
					>
					<el-table-column
						label="标题">
						<template v-slot="{ row }">
							<div v-html="''+(row.xtIntroMsg.title==null?'':row.xtIntroMsg.title)+''"></div>
						</template>
					</el-table-column>
					<el-table-column label="封面图"  width="200px">
						<template v-slot="{ row }">
							<template v-for="item4 in row.fmImgList">
								<img :src="item4"  style="width:80px;height:80px;display:inline;margin-left:4px;" @click="handleExportJsMethod"  data-methodtype="maxImg">
								</template>
							</template>
						</el-table-column>
						<el-table-column
							label="联系电话">
							<template v-slot="{ row }">
								<div v-html="''+(row.xtIntroMsg.celphone==null?'':row.xtIntroMsg.celphone)+''"></div>
							</template>
						</el-table-column>
						<el-table-column
							label="地址">
							<template v-slot="{ row }">
								<div v-html="''+(row.xtIntroMsg.address==null?'':row.xtIntroMsg.address)+''"></div>
							</template>
						</el-table-column>
						<el-table-column
							label="邮箱">
							<template v-slot="{ row }">
								<div v-html="''+(row.xtIntroMsg.email==null?'':row.xtIntroMsg.email)+''"></div>
							</template>
						</el-table-column>
						<el-table-column
							fixed="right"
							label="操作"
							width="240">
							<template v-slot="{ row }">
								<el-button
									href="javascript:void(0)" :data-params="'id='+row.xtIntroMsg.id+''" data-href="/admin/xt_intro_msg/update_page" @click="goToPage"
									type="warning" style="margin-left:5px;margin-top:5px;"
									>
									修改
								</el-button>
							</template>
						</el-table-column>
					</el-table>
					<div>
						<div id="xt_intro_msg_bar" class="pagination" style="margin-top:20px;"></div>
					</div>
				</div>
			</div>
		</el-card>
	</template>
	
<script>
import $ from 'jquery'
import {utils} from '../../../assets/listutils.js'
import {admin_utils} from '../../../assets/admin/admin_utils.js'
import {myPagination} from '../../../assets/page/myPagination.js'
export default {
	components: {
	},
	data() {
		return {
			currentLoginToken:'',
			currentLoginId:'',
			currentLoginType:'',
			title:'',
			celphone:'',
			address:'',
			email:'',
			dataList:[],
		};
	},
	mounted() {
		var that = this;
		that.currentLoginToken=utils.getCookie('loginToken');
		that.currentLoginId=utils.getCookie('loginId');
		that.currentLoginType=utils.getCookie('loginType');
		that.ajaxList(1);
	},
	methods:{
		ajaxCount(){
			var that = this;
			var rs = null;
			var title = that.title;
			var celphone = that.celphone;
			var address = that.address;
			var email = that.email;
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+'/admin/xt_intro_msg/queryCount',
				async: false,
				data : {
					"loginToken":that.currentLoginToken,
					"title":title,
					"celphone":celphone,
					"address":address,
					"email":email,
				},
				success : function(result) {
					rs = result;
				}
			});
			return rs;
		},
		ajaxList(page){
			var that = this;
			if(page==undefined||page==null){
				page=1;
			}
			var title = that.title;
			var celphone = that.celphone;
			var address = that.address;
			var email = that.email;
			var countRs = that.ajaxCount();
			if(countRs.totalPage<page){
				page = countRs.totalPage;
			}
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+'/admin/xt_intro_msg/queryList',
				async: false,
				data : {
					"page":page,
					"loginToken":that.currentLoginToken,
					"title":title,
					"celphone":celphone,
					"address":address,
					"email":email,
				},
				success : function(result) {
					admin_utils.hideLoading();
					var rows = result.list;
					var total = countRs.count;//得到数据总数
					var totalPage=countRs.totalPage;
					that.dataList=rows;
					new myPagination({
						id: 'xt_intro_msg_bar',
						curPage:page, //初始页码
						pageTotal:totalPage, //总页数
						pageAmount: 10,  //每页多少条
						dataTotal: total, //总共多少条数据
						pageSize: 10, //可选,分页个数
						showPageTotalFlag:true, //是否显示数据统计
						showSkipInputFlag:false, //是否支持跳转
						getPage: function (page) {
							that.ajaxList(page)
						}
					})
				}
			});
		},
		handleExportJsMethod(e){
			var div = e.currentTarget;
			var methodtype = div.dataset.methodtype;
			if(methodtype=='maxImg'){
				admin_utils.maxImg(div);
			}
			if(methodtype=='hideModal'){
				admin_utils.hideModal(div);
			}
		},
	}
};

</script>
	<style type="text/css" src="../../../assets/page/myPagination.css?t=44" scoped></style>
	<style type="text/css" src="../../../assets/admin/style.css?t=44" scoped></style>
	<style scoped>
		/* 全局滚动条美化 */
		::-webkit-scrollbar {
		width: 8px;
		height: 8px;
		background-color: #f5f5f5;
		}
		::-webkit-scrollbar-thumb {
		border-radius: 4px;
		background: linear-gradient(135deg, #409EFF 0%, #3375b9 100%);
		}
		/* 卡片容器样式 */
		.el-card {
		border-radius: 8px;
		box-shadow: 0 2px 12px 0 rgba(0,0,0,0.08);
		}
		.card-header {
		padding: 18px 20px;
		background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
		border-bottom: 1px solid #dee2e6;
		}
		.card-header span {
		font-size: 1.2rem;
		color: #2c3e50;
		font-weight: 600;
		}
		/* 表单增强样式 */
		.el-form--inline .el-form-item {
		margin-right: 28px;
		margin-bottom: 18px;
		}
		.el-form-item__label {
		font-weight: 500;
		color: #5a5e66;
		}
		.el-input__inner {
		border-radius: 4px;
		transition: border-color 0.3s cubic-bezier(0.645, 0.045, 0.355, 1);
		}
		.el-input__inner:focus {
		border-color: #409EFF;
		box-shadow: 0 0 4px rgba(64, 158, 255, 0.2);
		}
		/* 表格视觉优化 */
		.el-table {
		--el-table-header-bg-color: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
		--el-table-row-hover-bg-color: #f5f7fa;
		}
		.el-table__header th {
		font-weight: 600;
		color: #303133;
		}
		.el-table__body td {
		padding: 12px 0;
		}
		/* 图片预览样式 */
		.el-table img {
		border: 2px solid #ebeef5;
		transition: transform 0.2s;
		cursor: zoom-in;
		}
		.el-table img:hover {
		transform: scale(1.05);
		box-shadow: 0 2px 8px rgba(0,0,0,0.12);
		}
		/* 分页组件美化 */
		.pagination {
		--active-bg: #409EFF;
		--hover-bg: #ecf5ff;
		}
		.pagination a,
		.pagination span {
		border-radius: 4px;
		transition: all 0.3s;
		}
		.pagination .current {
		background: var(--active-bg);
		border-color: var(--active-bg);
		}
		.pagination a:hover {
		background: var(--hover-bg);
		color: var(--active-bg);
		}
		/* 模态框视觉优化 */
		.admin-modal-content {
		border-radius: 8px;
		overflow: hidden;
		}
		.admin-modal-header {
		padding: 16px 20px;
		background: #f8f9fa;
		border-bottom: 1px solid #dee2e6;
		}
		.admin-modal-title {
		font-size: 1.1rem;
		color: #2c3e50;
		}
		.admin-modal-footer {
		padding: 16px 20px;
		background: #f8f9fa;
		border-top: 1px solid #dee2e6;
		}
		select{
		height:30px;
		}
		/* 固定列容器不透明处理 */
		::v-deep .el-table__fixed-right {
		background: #FFFFFF !important;
		box-shadow: -5px 0 15px -5px rgba(0,0,0,0.1);
		}
		/* 单元格背景色覆盖 */
		::v-deep .el-table__fixed-body-wrapper .el-table__body td {
		background: #FFFFFF !important;
		}
		/* 去除底部边框干扰 */
		::v-deep .el-table__fixed-right::before {
		background-color: transparent !important;
		}
	</style>



