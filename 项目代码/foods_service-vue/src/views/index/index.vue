

<template>
	<div class="content content-nav-base commodity-content"   style="min-height:850px">
		<div class="commod-cont-wrap" >
			<div class="commod-cont w1200 layui-clear"  style="width:80%;margin-left:10%;margin: 0 auto;">
				<div>
					<el-carousel :interval="4000" style="height:300px;" type="card" arrow="always">
						<template v-for="(item,index) in bl">
							<el-carousel-item>
								<a href="javascript:void(0)"> <img :src="''+item.banner+''"  style="width:100%;height:300px;"></a>
								</el-carousel-item>
							</template>
							<template v-if="bl&&bl.length==0">
							</template>
						</el-carousel>
					</div>
					<div style="display:flex;margin-top:10px;">
						<div style="flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
							<div style="margin-top:10px;padding:10px;">
								<div>
									<div style="margin-bottom:20px;width:100%;margin-top:20px">
										<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">推荐饮食计划</h3>
									</div>
									<el-divider></el-divider>
									<div style="margin-top:10px;"  id="yl"  >
										<template v-for="(item,index) in yl">
											<a data-href="/index/ysjh_detail" :data-params="'id='+item.model.id+''" @click="goToPage">
												<div class="dtwDiv" style="margin-top:10px;display: inline-block;margin-left:10px">
													<div style="width:200px;border:1px solid rgb(218, 217, 217) ;padding:1px;border-radius: 6px;;">
														<img :src="''+item.model.fmImg+''"  style="height:160px;width:200px;">
															<div style="margin-top:4px;padding:4px;">
																<h4 style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;text-align:center;color:#f1bc6c"><span v-html="item.model.jhName"></span></h4>
																<div style="margin-top:5px;text-align: center;font-size:24px;font-weight: bold;color:rgb(240, 93, 93)">
																	{{item.bmifw}}
																</div>
																<div style="margin-top:5px;height:20px;">
																	<span style="float:right;color:gray">{{item.ynumFw}}</span>
																</div>
															</div>
														</div>
													</div>
												</a>
											</template>
											<template v-if="yl&&yl.length==0">
												<el-empty description="暂无饮食计划数据" />
											</template>
										</div>
										<div style="text-align:center"></div>
									</div>
								</div>
							</div>
							<div style="margin-left:10px;flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
								<div style="margin-top:10px;padding:10px;">
									<div>
										<div style="margin-bottom:20px;width:100%;margin-top:20px">
											<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">饮食计划</h3>
										</div>
										<el-divider></el-divider>
										<div style="margin-top:10px;"  id="yl1"  >
											<template v-for="(item,index) in yl1">
												<a data-href="/index/ysjh_detail" :data-params="'id='+item.model.id+''" @click="goToPage">
													<div class="dtwDiv" style="margin-top:10px;display: inline-block;margin-left:10px">
														<div style="width:200px;border:1px solid rgb(218, 217, 217) ;padding:1px;border-radius: 6px;;">
															<img :src="''+item.model.fmImg+''"  style="height:160px;width:200px;">
																<div style="margin-top:4px;padding:4px;">
																	<h4 style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;text-align:center;color:#f1bc6c">{{item.model.jhName}}</h4>
																	<div style="margin-top:5px;text-align: center;font-size:24px;font-weight: bold;color:rgb(240, 93, 93)">
																		{{item.bmifw}}
																	</div>
																	<div style="margin-top:5px;height:20px;">
																		<span style="float:right;color:gray">{{item.ynumFw}}</span>
																	</div>
																</div>
															</div>
														</div>
													</a>
												</template>
												<template v-if="yl1&&yl1.length==0">
													<el-empty description="暂无饮食计划数据" />
												</template>
											</div>
											<div style="text-align:center"></div>
										</div>
									</div>
								</div>
							</div>
							<div style="display:flex;margin-top:10px;">
								<div style="flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
									<div style="margin-top:10px;padding:10px;">
										<div>
											<div style="margin-bottom:20px;width:100%;margin-top:20px">
												<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">推荐运动计划</h3>
											</div>
											<el-divider></el-divider>
											<div style="margin-top:10px;"  id="yl2"  >
												<template v-for="(item,index) in yl2">
													<a data-href="/index/ydjh_detail" :data-params="'id='+item.model.id+''" @click="goToPage">
														<div class="dtwDiv" style="margin-top:10px;display: inline-block;margin-left:10px">
															<div style="width:200px;border:1px solid rgb(218, 217, 217) ;padding:1px;border-radius: 6px;;">
																<img :src="''+item.model.fmImg+''"  style="height:160px;width:200px;">
																	<div style="margin-top:4px;padding:4px;">
																		<h4 style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;text-align:center;color:#f1bc6c"><span v-html="item.model.jhName"></span></h4>
																		<div style="margin-top:5px;text-align: center;font-size:24px;font-weight: bold;color:rgb(240, 93, 93)">
																			{{item.bmifw}}
																		</div>
																		<div style="margin-top:5px;height:20px;">
																			<span style="float:right;color:gray">{{item.ydxhfw}}</span>
																		</div>
																	</div>
																</div>
															</div>
														</a>
													</template>
													<template v-if="yl2&&yl2.length==0">
														<el-empty description="暂无运动计划数据" />
													</template>
												</div>
												<div style="text-align:center"></div>
											</div>
										</div>
									</div>
									<div style="margin-left:10px;flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
										<div style="margin-top:10px;padding:10px;">
											<div>
												<div style="margin-bottom:20px;width:100%;margin-top:20px">
													<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">运动计划</h3>
												</div>
												<el-divider></el-divider>
												<div style="margin-top:10px;"  id="yl3"  >
													<template v-for="(item,index) in yl3">
														<a data-href="/index/ydjh_detail" :data-params="'id='+item.model.id+''" @click="goToPage">
															<div class="dtwDiv" style="margin-top:10px;display: inline-block;margin-left:10px">
																<div style="width:200px;border:1px solid rgb(218, 217, 217) ;padding:1px;border-radius: 6px;;">
																	<img :src="''+item.model.fmImg+''"  style="height:160px;width:200px;">
																		<div style="margin-top:4px;padding:4px;">
																			<h4 style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;text-align:center;color:#f1bc6c">{{item.model.jhName}}</h4>
																			<div style="margin-top:5px;text-align: center;font-size:24px;font-weight: bold;color:rgb(240, 93, 93)">
																				{{item.bmifw}}
																			</div>
																			<div style="margin-top:5px;height:20px;">
																				<span style="float:right;color:gray">{{item.ydxhfw}}</span>
																			</div>
																		</div>
																	</div>
																</div>
															</a>
														</template>
														<template v-if="yl3&&yl3.length==0">
															<el-empty description="暂无运动计划数据" />
														</template>
													</div>
													<div style="text-align:center"></div>
												</div>
											</div>
										</div>
									</div>
									<div style="display:flex;margin-top:10px;">
										<div style="flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
											<div style="margin-top:10px;padding:10px;">
												<div>
													<div style="margin-bottom:20px;width:100%;margin-top:20px">
														<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">帖子</h3>
													</div>
													<el-divider></el-divider>
													<div style="margin-top:10px;"  id="pl"  >
														<template v-for="(item,index) in pl">
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
														<template v-if="pl&&pl.length==0">
															<el-empty description="暂无帖子数据" />
														</template>
													</div>
													<div style="text-align:center"></div>
												</div>
											</div>
										</div>
										<div style="margin-left:10px;flex:5;margin-top:10px;padding:20px;background-color:white;border-radius: 10px;min-height:550px;">
											<div style="margin-top:10px;padding:10px;">
												<div>
													<div style="margin-bottom:20px;width:100%;margin-top:20px">
														<h3 style="margin-bottom:10px;color:#f1bc6c;text-align:left">营养小常识</h3>
													</div>
													<el-divider></el-divider>
													<div style="margin-top:10px;"  id="yl4"  >
														<template v-for="(item,index) in yl4">
															<a data-href="/index/yyxcs_detail" :data-params="'id='+item.id+''" @click="goToPage">
																<div class="dtwDiv" style="margin-top:10px;display: inline-block;margin-left:10px">
																	<div style="width:200px;border:1px solid rgb(218, 217, 217) ;padding:1px;border-radius: 6px;;">
																		<img :src="''+item.fmImg+''"  style="height:160px;width:200px;">
																			<div style="margin-top:4px;padding:4px;">
																				<h4 style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;text-align:center;color:#f1bc6c">{{item.title}}</h4>
																				<div style="margin-top:5px;height:20px;">
																				</div>
																			</div>
																		</div>
																	</div>
																</a>
															</template>
															<template v-if="yl4&&yl4.length==0">
																<el-empty description="暂无营养小常识数据" />
															</template>
														</div>
														<div style="text-align:center"></div>
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
export default {
	components: {
	},
	data() {
		return {
			currentLoginToken:'',
			bl:[],
			yl:[],
			yl1:[],
			yl2:[],
			yl3:[],
			pl:[],
			yl4:[],
		};
	},
	mounted() {
		var that = this;
		that.currentLoginToken = utils.getCookie('loginToken');
		this.initData();
	},
	methods:{
		initData(){
			var that = this;
			$.ajax({
				type : 'get',
				url : that.REQUEST_URL+"/index/index/getData",
				async: false,
				data : {
					"loginToken":that.currentLoginToken,
				},
				success : function(result) {
					that.bl = result.bl;
					that.yl = result.yl;
					that.yl1 = result.yl1;
					that.yl2 = result.yl2;
					that.yl3 = result.yl3;
					that.pl = result.pl;
					that.yl4 = result.yl4;
				}
			});
		},
	}
};

</script>
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



