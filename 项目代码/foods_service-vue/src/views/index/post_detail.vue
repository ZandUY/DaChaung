

<template>
	<div style="padding:20px;width:80%;margin-left:10%">
		<div style="padding:20px;padding-left:50px;padding-right:50px;border-radius: 10px;margin-top:10px;background-color: white;min-height:350px;">
			<div style="margin-top:20px;">
				<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">详情</h3>
			</div>
			<el-divider></el-divider>
			<div style="display:flex">
				<div style="flex:2">
				</div>
				<div style="flex:10;margin-left:20px;">
					<div style="margin-top:20px;margin-left:30px;">
						<h2 style="margin-bottom:20px;">{{postMsgDetail.model.title}}</h2>
						<div style="display:flex;margin-top:20px;">
							<div style="flex:3;color:gray">用户ID：</div>
							<div style="flex:11">
								<img :src="''+postMsgDetail.userIdT.headImg+''" alt="" style="width:45px;height:45px;;border-radius:50%">
									<cite style="color:blue">{{postMsgDetail.userIdT.loginName}}</cite>
								</div>
							</div>
							<div style="display:flex;margin-top:20px;">
								<div style="flex:3;color:gray">副标题：</div>
								<div style="flex:11;color:gray">
									{{postMsgDetail.model.subtitle}}
								</div>
							</div>
							<div style="display:flex;margin-top:20px;">
								<div style="flex:3;color:gray">发布时间：</div>
								<div style="flex:11;color:gray">
									{{postMsgDetail.model.fbTime}}
								</div>
							</div>
						</div>
						<div style="margin-top:20px;">
							<div style="margin-left:30px;">
								<div style="margin-top:20px">
								</div>
								<div style="margin-top:20px;">
									<div style="margin-bottom:20px;margin-top:20px;width:100%">
										<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">帖子详情</h3>
										<el-divider></el-divider>
										<div style="padding:20px;" v-html="''+postMsgDetail.model.postDetail+''">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div style="flex:2"></div>
				</div>
			</div>
			<div class="detail" style="margin-top:20px;">
				<div style="height:10px;"></div>
				<div  data-name="评论" class="tab-content"   style="border:1px solid #e3e3e3;min-height:500px;background-color:white;padding:40px;margin-left:0px;">
					<div  style="margin-left:0px">
						<div style="margin-bottom:20px;margin-top:20px;width:100%">
							<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">评论</h3>
						</div>
						<el-divider></el-divider>
						<div class="client-layui-field-box" >
							<ul class="jieda" id="commentList">
								<template v-for="item in disMsgList">
									<li  class="jieda-daan"  style="list-style-type: none;">
										<div class="detail-about-reply">
											<div   style="display:flex">
												<img :src="''+item.userIdT.headImg+''" alt="" style="width:45px;border-radius:50%">
													<div  style="float:left;margin-left:5px">
														<span  style="color:blue">{{item.userIdT.loginName}}</span>
													</div>
												</div>
											</div>
											<div>
												<p  style="margin-left:10%;min-height:70px;margin-top:10px;margin-bottom:10px;">
													{{item.model.disContent}}
												</p>
												<span style="margin-left:10%"><span>----{{item.model.disTime}}</span>
												</span>
												<template v-for="item2 in item.replyList">
													<div  style="background-color:#eef1f1;width:80%;margin-left:10%;margin-top:10px;">
														<p style="margin-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px">
															<p  style="margin-left:20px;background-color:#eef1f1;width:70%;padding:20px">
																{{item2.userIdT.loginName}}
																：{{item2.model.replyContent}}
																<span style="float:right">{{item2.model.replyTime}}
																</span>
															</p>
															<p style="height:20px;"></p>
														</p>
													</div>
												</template>
												<div class="jieda-reply">
													<div class="client-layui-row replyInputDiv" :data-id="item.model.id" style="display:none">
														<div style="margin-left:30%;display:flex;margin-top:10px;">
															<input type="text" style="width:300px;height:25px !important;margin-top:1px;padding:1px;border:1px solid gray" name="replyContent" :data-id="item.model.id">
															<button  class="el-button el-button--primary" @click="submitReply"  :data-id="item.model.id">回复</button>
														</div>
													</div>
													<a href="javascript:void(0)" class="tab-span" style="margin-left:90%" @click="clickReply" :data-id="item.model.id">
														回复
													</a>
												</div>
												<hr/>
											</div>
										</li>
									</template>
								</ul>
								<div style="text-align:center">
									<div id="commentBar" class="pagination" style="margin-top:20px;"></div>
								</div>
								<div class="client-layui-form client-layui-form-pane">
									<div  style="margin-left:100px;">
										<div class="client-layui-form-item client-layui-form-text">
											<div class="client-layui-input-block">
												<textarea id="cdisContent"  placeholder="请输入评论内容"  class="client-layui-textarea client-fly-editor" style="height: 150px;width:80%;padding:10px;border-radius:5px;"></textarea>
											</div>
										</div>
										<div>
											<button class="el-button el-button--primary" @click="submitDisMsg">提交评论</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div style="margin-top:20px;">
				</div>
				<div style="height:50px;"></div>
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
			id:'',
			postMsgDetail:{
				userIdT:{},
				model:{},
			},
			disMsgList:[],
		};
	},
	mounted() {
		var that = this;
		that.currentLoginToken = utils.getCookie('loginToken');
		that.id=that.$route.query.id;
		this.initData();
		that.getCommentList(1);
		that.initAllTab()
	},
	methods:{
		clickReply(e){
			var that = this;
			var id = e.currentTarget.dataset.id;
			$(".replyInputDiv").css("display","none");
			var divs = $(".replyInputDiv");
			for(var i=0;i<divs.length;i++){
				if($(divs[i]).attr("data-id")==id){
					$(divs[i]).css("display","block");
				}
			}
		},
		submitReply(e){
			var that = this;
			var id =e.currentTarget.dataset.id;
			var replyContent='';
			var inputs = $('input[name="replyContent"]');
			for(var i=0;i<inputs.length;i++){
				if($(inputs[i]).attr("data-id")==id){
					replyContent = $(inputs[i]).val();
				}
			}
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/post_detail/submitReply",
				data : {
					"id":id,
					"content":replyContent,
					"loginToken":that.currentLoginToken
				},
				success : function(result) {
					alert(result.msg);
					if(result.code==1){
						window.location.reload();
					}
				}
			})
		},
		//查询评论列表
		getCommentList(page){
			var that = this;
			var id =that.id;
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/post_detail/getDisMsg",
				async: false,
				data : {
					"page":page,
					"loginToken":that.currentLoginToken,
					"id":id,
				},
				success : function(result) {
					var count = result.count;
					var totalPage = result.totalPage;
					var pageSize = result.pageSize;
					that.disMsgList = result.list;
					new myPagination({
						id: 'commentBar',
						curPage:page, //初始页码
						pageTotal:totalPage, //总页数
						pageAmount: pageSize,  //每页多少条
						dataTotal: count, //总共多少条数据
						pageSize: pageSize, //可选,分页个数
						showPageTotalFlag:true, //是否显示数据统计
						showSkipInputFlag:false, //是否支持跳转
						getPage: function (page) {
							that.getCommentList(page)
						}
					})
				}
			});
		},
		submitDisMsg(){
			var that = this;
			var id =that.postMsgDetail.model.id;
			var cdisContent =$("#cdisContent").val();
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/post_detail/submitDisMsg",
				async: false,
				data : {
					"loginToken":that.currentLoginToken,
					"cdisContent":cdisContent,
					"id":id,
				},
				success : function(result) {
					alert(result.msg);
					if(result.code==1){
						window.location.reload();
					}
				}
			});
		},
		initData(){
			var that = this;
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/post_detail/getData",
				async: false,
				data : {
					id:that.id,
					"loginToken":that.currentLoginToken,
				},
				success : function(result) {
					that.postMsgDetail = result.postMsgDetail;
				}
			});
		},
		initAllTab(){
			var that = this;
			that.$nextTick(() => {
				var scopeId = that.$options.__scopeId;
				var contentDiv = $(".tab-content");
				var html='';
				for(var i=0;i<contentDiv.length;i++){
					if(i==0){
						$(contentDiv[i]).css("display","block");
						html+='<div '+scopeId+' class="tab-select tab-active" data-name="'+$(contentDiv[i]).attr("data-name")+'">';
						html+=$(contentDiv[i]).attr("data-name");
						html+='</div>';
						}else{
						$(contentDiv[i]).css("display","none");
						html+='<div '+scopeId+' class="tab-select"  data-name="'+$(contentDiv[i]).attr("data-name")+'">';
						html+=$(contentDiv[i]).attr("data-name");
						html+='</div>';
					}
				}
				$("#allTab").html(html);
				that.$nextTick(() => {
					$(".tab-select").click(function(){
						that.selectATab(this);
					})
				});
			});
		},
		selectATab(e){
			var that = this;
			var contentDiv = $(".tab-content");
			$(".tab-select").removeClass("tab-active");
			$(e).addClass("tab-active");
			var dataName = e.dataset.name;
			$(".tab-content").css("display","none");
			var contentDiv = $(".tab-content");
			for(var i=0;i<contentDiv.length;i++){
				if($(contentDiv[i]).attr("data-name")==dataName){
					$(contentDiv[i]).css("display","block");
				}
			}
		},
	}
};

</script>
		<style type="text/css" src="../../assets/page/myPagination.css?t=44" scoped></style>
		<style scoped>
			blockquote, dd, div, dl, dt, form, h1, h2, h3, h4, h5, h6, input, li, ol, p, pre, td, textarea, th, ul {
			margin: 0;
			padding: 0;
			-webkit-tap-highlight-color: rgba(0,0,0,0);
			}
			a {
			color: #333;
			text-decoration: none;
			}
			.mallSearch {
			float: right;
			width: 500px;
			padding-top: 30px;
			position: relative;
			}
			.layui-btn{
			display: inline-block;
			color:#fff;
			border: none;
			cursor: pointer;
			box-sizing: border-box;
			}
			.layui-btn-danger {
			background-color: #FF5722;
			}
			.layui-btn-primary {
			border: 1px solid #C9C9C9;
			background-color: #fff;
			color: #555;
			}
			.layui-clear {
			clear: both;
			}
			.type-select{
			margin-left:8px;
			background-color:white;
			color:black;
			padding-left:15px;
			padding-right:15px;
			padding-top:8px;
			padding-bottom:8px;
			border:1px solid gray;
			}
			.select-active{
			background-color:#4CAF50;
			color:white;
			}
			.tab-select{
			margin-left:10px;
			padding-left:40px;
			padding-right:40px;
			padding-top:20px;
			padding-bottom:20px;
			background-color:white;
			border: 1px solid #4e73df;
			border-bottom:none;
			color:#4e73df;
			}
			.tab-active{
			color:white;
			background-color:#4e73df
			}
			.client-form-input{
			width:350px;
			height:30px;
			border: 1px solid #e9e9e9;
			padding-left:6px
			}
			.client-form-textarea{
			width:350px;
			height:80px;
			}
			.dtwDiv:hover{
			border:2px solid rgb(238, 49, 49);
			border-radius: 6px;
			}
		</style>



