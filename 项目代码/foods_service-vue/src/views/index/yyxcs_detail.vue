

<template>
	<div style="padding:20px;width:80%;margin-left:10%">
		<div style="padding:20px;padding-left:50px;padding-right:50px;border-radius: 10px;margin-top:10px;background-color: white;min-height:350px;">
			<div style="margin-top:20px;">
				<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">详情</h3>
			</div>
			<el-divider></el-divider>
			<div style="display:flex">
				<div style="flex:2">
					<div style="margin-top:20px;">
						<img :src="''+yyxcsMsgDetail.fmImg+''" style="width: 250px; height: 250px;border-radius: 10px;">
						</div>
					</div>
					<div style="flex:10;margin-left:20px;">
						<div style="margin-top:20px;margin-left:30px;">
							<h2 style="margin-bottom:20px;">{{yyxcsMsgDetail.title}}</h2>
							<div style="display:flex;margin-top:20px;">
								<div style="flex:3;color:gray">发布时间：</div>
								<div style="flex:11;color:gray">
									{{yyxcsMsgDetail.fbTime}}
								</div>
							</div>
						</div>
						<div style="margin-top:20px;">
							<div style="margin-left:30px;">
								<div style="margin-top:20px">
								</div>
								<div style="margin-top:20px;">
									<div style="margin-bottom:20px;margin-top:20px;width:100%">
										<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">常识内容</h3>
										<el-divider></el-divider>
										<div style="padding:20px;" v-html="''+yyxcsMsgDetail.csContent+''">
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
			</div>
			<div style="margin-top:20px;">
			</div>
			<div style="height:50px;"></div>
		</div>
	</template>
	
<script>
import $ from 'jquery'
import {utils} from '../../assets/listutils.js'
export default {
	components: {
	},
	data() {
		return {
			currentLoginToken:'',
			id:'',
			yyxcsMsgDetail:{
				model:{},
			},
		};
	},
	mounted() {
		var that = this;
		that.currentLoginToken = utils.getCookie('loginToken');
		that.id=that.$route.query.id;
		this.initData();
		that.initAllTab()
	},
	methods:{
		initData(){
			var that = this;
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/yyxcs_detail/getData",
				async: false,
				data : {
					id:that.id,
					"loginToken":that.currentLoginToken,
				},
				success : function(result) {
					that.yyxcsMsgDetail = result.yyxcsMsgDetail;
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



