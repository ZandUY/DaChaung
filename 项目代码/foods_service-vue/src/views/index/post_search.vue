

<template>
	<div class="content content-nav-base commodity-content"   style="min-height:850px">
		<div class="commod-cont-wrap" >
			<div class="commod-cont w1200 layui-clear"  style="width:80%;margin-left:10%;margin: 0 auto;">
				<div style="display:flex;margin-top:10px;">
					<div style="flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
						<div style="margin-top:10px;padding:10px;">
							<div style="height:40px;margin-top:20px;">
								<div style="float:right;margin-right:40px;">
									<div class="el-input" style="width: 240px;">
										<div class="el-input__wrapper" tabindex="-1">
											<input class="el-input__inner" id="titleClick" type="text"  style="padding:5px;height:40px;" autocomplete="off" tabindex="0" placeholder="请输入标题搜索" >
										</div>
									</div>
									<a href="javascript:void(0)" @click="queryPostMsgList(1)"><span class="el-button el-button--warning" style="height:40px;">搜索</span></a>
								</div>
							</div>
							<div>
								<div style="margin-bottom:20px;width:100%;margin-top:20px">
									<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">帖子</h3>
								</div>
								<el-divider></el-divider>
								<div style="margin-top:10px;"  id="dataQl"  >
									<template v-for="(item,index) in ql">
										<div style="display:inline-block;margin-top:10px;padding:10px;width:44%;max-width:400px;margin-left:2%;border:1px solid rgb(218, 217, 217);border-radius: 10px;background-color: white;">
											<div style="margin-bottom:15px">
												<div style="float:right">
												</div>
												<div><a data-href="/index/post_detail" :data-params="'id='+item.model.id+''" @click="goToPage"><h3 style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;color:rgb(75, 74, 74)">{{item.model.title}}</h3>
												</a></div>
											</div>
											<el-divider></el-divider>
											<div style="padding:10px;">
												<div style="padding-right:10px;">
													<a data-href="/index/post_detail" :data-params="'id='+item.model.id+''" @click="goToPage">
														<div style="width:100%;display:flex">
															<div style="flex:10;padding-left:10px;">
																<p style="color:gray;margin-top:8px;"><span style="color:rgb(129, 128, 128);font-weight: bold;">副标题：</span>{{item.model.subtitle}}</P>
																<p style="color:gray;margin-top:8px;"><span style="color:rgb(129, 128, 128);font-weight: bold;">用户ID：</span>{{item.userId}}</P>
																<p style="color:gray;margin-top:8px;"><span style="color:rgb(129, 128, 128);font-weight: bold;">发布时间：</span>{{item.model.fbTime}}</P>
															</div>
														</div>
													</a>
												</div>
											</div>
										</div>
									</template>
									<template v-if="ql&&ql.length==0">
										<el-empty description="暂无帖子数据" />
									</template>
								</div>
								<div style="text-align:center">
									<div id="qlBar" class="pagination" style="margin-top:20px;"></div>
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
import {utils} from '../../assets/listutils.js'
import {myPagination} from '../../assets/page/myPagination.js'
export default {
	components: {
	},
	data() {
		return {
			currentLoginToken:'',
			ql:[],
		};
	},
	mounted() {
		var that = this;
		that.currentLoginToken = utils.getCookie('loginToken');
		that.queryPostMsgList(1);
	},
	methods:{
		queryPostMsgList(page){
			var that = this;
			var  title= $("#titleClick").val();
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/post_search/queryPostMsgList",
				async: false,
				data : {
					'title':title,
					"page":page,
					"loginToken":that.currentLoginToken,
				},
				success : function(result) {
					var count = result.count;
					var totalPage = result.totalPage;
					var pageSize = result.pageSize;
					that.ql = result.list;
					new myPagination({
						id: 'qlBar',
						curPage:page, //初始页码
						pageTotal:totalPage, //总页数
						pageAmount: pageSize,  //每页多少条
						dataTotal: count, //总共多少条数据
						pageSize: pageSize, //可选,分页个数
						showPageTotalFlag:true, //是否显示数据统计
						showSkipInputFlag:false, //是否支持跳转
						getPage: function (page) {
							that.queryPostMsgList(page)
						}
					})
				}
			});
		},
	}
};

</script>
<style type="text/css" src="../../assets/page/myPagination.css?t=44" scoped></style>
<style scoped>
	a {
	text-decoration: none;
	}
	.layui-btn{
	color:#fff;
	border: none;
	cursor: pointer;
	box-sizing: border-box;
	}
	.layui-clear {
	clear: both;
	}
	.type-select{
	margin-left:18px;
	color:rgb(97, 97, 97);
	}
	.select-active{
	color:#ff4229;
	}
	.left-type-selected{
	color:red !important;
	}
	.content{
	overflow-x: hidden !important;
	}
	blockquote, dd, div, dl, dt, form, h1, h2, h3, h4, h5, h6, input, li, ol, p, pre, td, textarea, th, ul {
	margin: 0;
	padding: 0;
	-webkit-tap-highlight-color: rgba(0,0,0,0);
	}
	.dtwDiv:hover{
	border:2px solid rgb(238, 49, 49);
	border-radius: 6px;
	}
</style>



