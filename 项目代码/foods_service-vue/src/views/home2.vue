

<template>
	<div class="bodyClass">
		<el-card class="box-card" >
			<template #header>
				<div class="card-header">
					<span>首页</span>
				</div>
			</template>
			<div  class="home-div1">
				<div  class="home-div2">
					<div  class="home-div3">
						<div  class="home-div4">
							<div  class="home-div5">
								<div  class="home-div6">
									<hr style="margin-top:20px">
									</div>
									<div class="home-list-div1">
										<div  class="home-list-div5">
											<div  class="home-list-div6">
												<div  class="home-list-div7">
													<h3  class="home-list-div8">运动日统计</h3>
												</div>
												<div id="dataDiv1" style="width:96%;margin-left:2%;min-height:300px;"></div>
											</div>
										</div>
										<template v-for="item in data.data1">
											<div style="display:none" class="dataDiv1" :data-title="item.title" :data-zr-num="item.value" >
											</div>
										</template>
										<div  class="home-list-div5">
											<div  class="home-list-div6">
												<div  class="home-list-div7">
													<h3  class="home-list-div8">运动类型统计</h3>
												</div>
												<div id="dataDiv2" style="width:96%;margin-left:2%;min-height:300px;"></div>
											</div>
										</div>
										<template v-for="item in data.data2">
											<div style="display:none" class="dataDiv2" :data-title="item.title" :data-id="item.value" >
											</div>
										</template>
										<div  class="home-list-div5">
											<div  class="home-list-div6">
												<div  class="home-list-div7">
													<h3  class="home-list-div8">饮食类型统计</h3>
												</div>
												<div id="dataDiv3" style="width:96%;margin-left:2%;min-height:300px;"></div>
											</div>
										</div>
										<template v-for="item in data.data3">
											<div style="display:none" class="dataDiv3" :data-title="item.title" :data-id="item.value" >
											</div>
										</template>
										<div  class="home-list-div5">
											<div  class="home-list-div6">
												<div  class="home-list-div7">
													<h3  class="home-list-div8">饮食热量日统计</h3>
												</div>
												<div id="dataDiv4" style="width:96%;margin-left:2%;min-height:300px;"></div>
											</div>
										</div>
										<template v-for="item in data.data4">
											<div style="display:none" class="dataDiv4" :data-title="item.title" :data-zrl="item.value" >
											</div>
										</template>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</el-card>
		</div>
	</template>
	
<script>
import $ from 'jquery'
import {utils} from '../assets/listutils.js'
import {admin_utils} from '../assets/admin/admin_utils.js'
import echarts from '../assets/echarts/echarts.min.js'
export default {
	components: {
	},
	data() {
		return {
			currentLoginToken:'',
			currentLoginId:'',
			currentLoginType:'',
			data:{},
		};
	},
	mounted() {
		this.currentLoginToken=utils.getCookie('loginToken');
		this.currentLoginId=utils.getCookie('loginId');
		this.currentLoginType=utils.getCookie('loginType');
		this.initData();
		this.$nextTick(() => {
			this.initEcharts();
		})
	},
	methods:{
		initData(){
			var that = this;
			$.ajax({
				type : 'get',
				url : this.REQUEST_URL+"/home/getHome2Msg",
				async: false,
				data : {
					'loginToken':that.currentLoginToken,
				},
				success : function(result) {
					that.data = result;
				}
			});
		},
		initEcharts(){
			var that = this;
			var myChart1 = echarts.init(document.getElementById('dataDiv1'));
			var option1 = {
				title : {
					text: '',
					subtext: ''
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[
					'总热量'
					]
				},
				toolbox: {
					show : false,
					feature : {
						mark : {show: true},
						magicType : {
							show: true,
							type: ['line', 'bar'],
							title:['转为折线图','转为柱状图']
						},
						saveAsImage : {
							show: true,
							title :'保存为图片'
						}
					}
				},
				calculable : true,
				xAxis : [
				{
					type : 'category',
					boundaryGap : false
				}
				],
				yAxis : [
				{
					type : 'value',
					axisLabel : {
						formatter: '{value} '
					}
				}
				],
				series : [
				{
					name:'总热量',
					type:'line',
					markPoint : {
						data : [
						{type : 'max', name: '最大值'},
						{type : 'min', name: '最小值'}
						]
					},
					markLine : {
						data : [
						{type : 'average', name: '平均值'}
						]
					}
				}
				]
			};
			var gatherDiv1 = $(".dataDiv1");
			var x1 = [];
			var yzrNum1 = [];
			for(var i=0;i<gatherDiv1.length;i++){
				var title = $(gatherDiv1[i]).attr("data-title");
				x1.push(title);
				var zrNum1 = $(gatherDiv1[i]).attr("data-zr-num");
				yzrNum1.push(zrNum1);
			}
			option1.xAxis[0].data=x1;
			option1.series[0].data=yzrNum1;
			myChart1.setOption(option1);
			window.addEventListener('resize', function () {
				myChart1.resize();
			});
			var myChart2 = echarts.init(document.getElementById('dataDiv2'));
			var option2 = {
				title : {
					text: '',
					subtext: ''
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[
					'数量'
					]
				},
				toolbox: {
					show : false,
					feature : {
						mark : {show: true},
						magicType : {
							show: true,
							type: ['line', 'bar'],
							title:['转为折线图','转为柱状图']
						},
						saveAsImage : {
							show: true,
							title :'保存为图片'
						}
					}
				},
				calculable : true,
				xAxis : [
				{
					type : 'category'
				}
				],
				yAxis : [
				{
					type : 'value',
					axisLabel : {
						formatter: '{value} '
					}
				}
				],
				series : [
				{
					name:'数量',
					type:'bar',
					markPoint : {
						data : [
						{type : 'max', name: '最大值'},
						{type : 'min', name: '最小值'}
						]
					},
					markLine : {
						data : [
						{type : 'average', name: '平均值'}
						]
					}
				}
				]
			};
			var gatherDiv2 = $(".dataDiv2");
			var x2 = [];
			var yid2 = [];
			for(var i=0;i<gatherDiv2.length;i++){
				var title = $(gatherDiv2[i]).attr("data-title");
				x2.push(title);
				var id2 = $(gatherDiv2[i]).attr("data-id");
				yid2.push(id2);
			}
			option2.xAxis[0].data=x2;
			option2.series[0].data=yid2;
			myChart2.setOption(option2);
			window.addEventListener('resize', function () {
				myChart2.resize();
			});
			var myChart3 = echarts.init(document.getElementById('dataDiv3'));
			var option3 = {
				title : {
					text: '',
					subtext: ''
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[
					'数量'
					]
				},
				toolbox: {
					show : false,
					feature : {
						mark : {show: true},
						magicType : {
							show: true,
							type: ['line', 'bar'],
							title:['转为折线图','转为柱状图']
						},
						saveAsImage : {
							show: true,
							title :'保存为图片'
						}
					}
				},
				calculable : true,
				xAxis : [
				{
					type : 'category'
				}
				],
				yAxis : [
				{
					type : 'value',
					axisLabel : {
						formatter: '{value} '
					}
				}
				],
				series : [
				{
					name:'数量',
					type:'bar',
					markPoint : {
						data : [
						{type : 'max', name: '最大值'},
						{type : 'min', name: '最小值'}
						]
					},
					markLine : {
						data : [
						{type : 'average', name: '平均值'}
						]
					}
				}
				]
			};
			var gatherDiv3 = $(".dataDiv3");
			var x3 = [];
			var yid3 = [];
			for(var i=0;i<gatherDiv3.length;i++){
				var title = $(gatherDiv3[i]).attr("data-title");
				x3.push(title);
				var id3 = $(gatherDiv3[i]).attr("data-id");
				yid3.push(id3);
			}
			option3.xAxis[0].data=x3;
			option3.series[0].data=yid3;
			myChart3.setOption(option3);
			window.addEventListener('resize', function () {
				myChart3.resize();
			});
			var myChart4 = echarts.init(document.getElementById('dataDiv4'));
			var option4 = {
				title : {
					text: '',
					subtext: ''
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:[
					'总热量'
					]
				},
				toolbox: {
					show : false,
					feature : {
						mark : {show: true},
						magicType : {
							show: true,
							type: ['line', 'bar'],
							title:['转为折线图','转为柱状图']
						},
						saveAsImage : {
							show: true,
							title :'保存为图片'
						}
					}
				},
				calculable : true,
				xAxis : [
				{
					type : 'category',
					boundaryGap : false
				}
				],
				yAxis : [
				{
					type : 'value',
					axisLabel : {
						formatter: '{value} '
					}
				}
				],
				series : [
				{
					name:'总热量',
					type:'line',
					markPoint : {
						data : [
						{type : 'max', name: '最大值'},
						{type : 'min', name: '最小值'}
						]
					},
					markLine : {
						data : [
						{type : 'average', name: '平均值'}
						]
					}
				}
				]
			};
			var gatherDiv4 = $(".dataDiv4");
			var x4 = [];
			var yzrl4 = [];
			for(var i=0;i<gatherDiv4.length;i++){
				var title = $(gatherDiv4[i]).attr("data-title");
				x4.push(title);
				var zrl4 = $(gatherDiv4[i]).attr("data-zrl");
				yzrl4.push(zrl4);
			}
			option4.xAxis[0].data=x4;
			option4.series[0].data=yzrl4;
			myChart4.setOption(option4);
			window.addEventListener('resize', function () {
				myChart4.resize();
			});
		},
	}
};

</script>
	<style scoped>
		.bodyClass {
		background-color: #f5f7fa;
		min-height: 100vh;
		padding: 20px;
		}
		.box-card {
		max-width: 1600px;
		margin: 10px auto;
		border-radius: 12px;
		box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
		}
		.card-header {
		padding: 20px 0;
		border-bottom: 1px solid #ebeef5;
		}
		.card-header span {
		font-size: 24px;
		font-weight: 600;
		color: #303133;
		}
		.home-div2 {
		display: grid;
		gap: 20px;
		padding: 20px 0;
		}
		.home-div3 {
		display: grid;
		grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
		gap: 20px;
		}
		.home-div6{
		display:flex
		}
		.home-div7 {
		display: grid;
		grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
		gap: 20px;
		padding: 20px;
		background: #ccdbf8;
		text-align: center;
		border-radius: 8px;
		box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
		margin-left:10px;
		}
		.home-div8 {
		color: #409eff;
		font-size: 32px;
		margin-bottom: 8px;
		font-weight: 700;
		}
		.home-div9 {
		color: #909399;
		font-size: 14px;
		margin: 0;
		}
		.home-list-div1 {
		display: grid;
		grid-template-columns: repeat(auto-fit, minmax(380px, 1fr));
		gap: 24px;
		margin-top: 30px;
		}
		.home-list-div5 {
		background: #fff;
		border-radius: 8px;
		padding: 15px;
		box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
		}
		.home-list-div7 {
		border-bottom: 1px solid #ebeef5;
		padding-bottom: 12px;
		margin-bottom: 15px;
		}
		.home-list-div8 {
		color: #303133;
		margin: 0;
		font-size: 18px;
		}
		#dataDiv5,
		#dataDiv6,
		#dataDiv7 {
		height: 300px;
		}
		hr {
		border: 0;
		height: 1px;
		background: #ebeef5;
		margin: 25px 0;
		}
		@media (max-width: 768px) {
		.home-div3 {
		grid-template-columns: 1fr;
		}
		.home-list-div1 {
		grid-template-columns: 1fr;
		}
		.home-div8 {
		font-size: 28px;
		}
		.card-header span {
		font-size: 20px;
		}
		}
		@media (max-width: 480px) {
		.bodyClass {
		padding: 10px;
		}
		.home-div7 {
		padding: 15px;
		}
		.home-div8 {
		font-size: 24px;
		}
		}
	</style>



