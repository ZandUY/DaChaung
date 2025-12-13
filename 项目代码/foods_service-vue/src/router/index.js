import { createRouter, createWebHistory } from 'vue-router'
	import index1 from '../views/index.vue';
	import index_index from '../views/index/index.vue';
	import index_ysjh_search from '../views/index/ysjh_search.vue';
	import index_ydjh_search from '../views/index/ydjh_search.vue';
	import index_post_search from '../views/index/post_search.vue';
	import index_yyxcs_search from '../views/index/yyxcs_search.vue';
	import index_ysjh_detail from '../views/index/ysjh_detail.vue';
	import index_ydjh_detail from '../views/index/ydjh_detail.vue';
	import index_post_detail from '../views/index/post_detail.vue';
	import index_yyxcs_detail from '../views/index/yyxcs_detail.vue';
	import index_xt_intro_detail from '../views/index/xt_intro_detail.vue';
	import index_sys_intro from '../views/index/sys_intro.vue';
	import sys_login from '../views/sys_login.vue';
	import user_msg_regist from '../views/user_msg_regist.vue';
	import home from '../views/home.vue';
	import home2 from '../views/home2.vue';
	import admin_index from '../views/admin/index.vue';
	import user_index from '../views/user/index.vue';
	import admin_yd_type_msg_list from '../views/admin/yd_type_msg/list.vue';
	import admin_ys_type_msg_list from '../views/admin/ys_type_msg/list.vue';
	import admin_user_msg_list from '../views/admin/user_msg/list.vue';
	import user_yd_log_list from '../views/user/yd_log/list.vue';
	import user_ys_log_list from '../views/user/ys_log/list.vue';
	import admin_bmifw_msg_list from '../views/admin/bmifw_msg/list.vue';
	import admin_ynum_fw_msg_list from '../views/admin/ynum_fw_msg/list.vue';
	import admin_ydxhfw_msg_list from '../views/admin/ydxhfw_msg/list.vue';
	import admin_ysjh_msg_list from '../views/admin/ysjh_msg/list.vue';
	import user_ysjh_msg_list from '../views/user/ysjh_msg/list.vue';
	import admin_ydjh_msg_list from '../views/admin/ydjh_msg/list.vue';
	import user_ydjh_msg_list from '../views/user/ydjh_msg/list.vue';
	import user_ys_collect_msg_list from '../views/user/ys_collect_msg/list.vue';
	import user_yd_collect_msg_list from '../views/user/yd_collect_msg/list.vue';
	import admin_post_msg_list from '../views/admin/post_msg/list.vue';
	import user_post_msg_list from '../views/user/post_msg/list.vue';
	import admin_dis_msg_list from '../views/admin/dis_msg/list.vue';
	import user_dis_msg_list from '../views/user/dis_msg/list.vue';
	import admin_reply_msg_list from '../views/admin/reply_msg/list.vue';
	import user_reply_msg_list from '../views/user/reply_msg/list.vue';
	import admin_lmsg_suggest_msg_list from '../views/admin/lmsg_suggest_msg/list.vue';
	import user_lmsg_suggest_msg_list from '../views/user/lmsg_suggest_msg/list.vue';
	import admin_yyxcs_msg_list from '../views/admin/yyxcs_msg/list.vue';
	import admin_xt_intro_msg_list from '../views/admin/xt_intro_msg/list.vue';
	import admin_banner_msg_list from '../views/admin/banner_msg/list.vue';
	import user_personal from '../views/user/personal.vue';
	import admin_post_msg_detail from '../views/admin/post_msg/detail.vue';
	import user_post_msg_detail from '../views/user/post_msg/detail.vue';
	import admin_yyxcs_msg_detail from '../views/admin/yyxcs_msg/detail.vue';
	import alter_password from '../views/alter_password.vue';
	import admin_yd_type_msg_add from '../views/admin/yd_type_msg/add_page.vue';
	import admin_yd_type_msg_update from '../views/admin/yd_type_msg/update_page.vue';
	import admin_ys_type_msg_add from '../views/admin/ys_type_msg/add_page.vue';
	import admin_ys_type_msg_update from '../views/admin/ys_type_msg/update_page.vue';
	import user_user_msg_update from '../views/user/user_msg/update_page.vue';
	import user_yd_log_add from '../views/user/yd_log/add_page.vue';
	import user_yd_log_update from '../views/user/yd_log/update_page.vue';
	import user_ys_log_add from '../views/user/ys_log/add_page.vue';
	import user_ys_log_update from '../views/user/ys_log/update_page.vue';
	import admin_bmifw_msg_add from '../views/admin/bmifw_msg/add_page.vue';
	import admin_bmifw_msg_update from '../views/admin/bmifw_msg/update_page.vue';
	import admin_ynum_fw_msg_add from '../views/admin/ynum_fw_msg/add_page.vue';
	import admin_ynum_fw_msg_update from '../views/admin/ynum_fw_msg/update_page.vue';
	import admin_ydxhfw_msg_add from '../views/admin/ydxhfw_msg/add_page.vue';
	import admin_ydxhfw_msg_update from '../views/admin/ydxhfw_msg/update_page.vue';
	import admin_ysjh_msg_add from '../views/admin/ysjh_msg/add_page.vue';
	import admin_ysjh_msg_update from '../views/admin/ysjh_msg/update_page.vue';
	import admin_ydjh_msg_add from '../views/admin/ydjh_msg/add_page.vue';
	import admin_ydjh_msg_update from '../views/admin/ydjh_msg/update_page.vue';
	import user_post_msg_add from '../views/user/post_msg/add_page.vue';
	import user_post_msg_update from '../views/user/post_msg/update_page.vue';
	import admin_lmsg_suggest_msg_hf from '../views/admin/lmsg_suggest_msg/hf_page.vue';
	import user_lmsg_suggest_msg_add from '../views/user/lmsg_suggest_msg/add_page.vue';
	import user_lmsg_suggest_msg_update from '../views/user/lmsg_suggest_msg/update_page.vue';
	import admin_yyxcs_msg_add from '../views/admin/yyxcs_msg/add_page.vue';
	import admin_yyxcs_msg_update from '../views/admin/yyxcs_msg/update_page.vue';
	import admin_xt_intro_msg_update from '../views/admin/xt_intro_msg/update_page.vue';
	import admin_banner_msg_add from '../views/admin/banner_msg/add_page.vue';
	import admin_banner_msg_update from '../views/admin/banner_msg/update_page.vue';
	const  routes= [
{
	path: '/',
	component: index1,
	name:'index10',
meta:{auth:true}
},
{
	path: '/index',
	component: index1,
	name:'index1',
meta:{auth:true}
},
{
	path: '/index/index',
	component: index_index,
	name:'index_index',
meta:{auth:true}
},
{
	path: '/index/ysjh_search',
	component: index_ysjh_search,
	name:'index_ysjh_search',
meta:{auth:true}
},
{
	path: '/index/ydjh_search',
	component: index_ydjh_search,
	name:'index_ydjh_search',
meta:{auth:true}
},
{
	path: '/index/post_search',
	component: index_post_search,
	name:'index_post_search',
meta:{auth:true}
},
{
	path: '/index/yyxcs_search',
	component: index_yyxcs_search,
	name:'index_yyxcs_search',
meta:{auth:true}
},
{
	path: '/index/ysjh_detail',
	component: index_ysjh_detail,
	name:'index_ysjh_detail',
meta:{auth:true}
},
{
	path: '/index/ydjh_detail',
	component: index_ydjh_detail,
	name:'index_ydjh_detail',
meta:{auth:true}
},
{
	path: '/index/post_detail',
	component: index_post_detail,
	name:'index_post_detail',
meta:{auth:true}
},
{
	path: '/index/yyxcs_detail',
	component: index_yyxcs_detail,
	name:'index_yyxcs_detail',
meta:{auth:true}
},
{
	path: '/index/xt_intro_detail',
	component: index_xt_intro_detail,
	name:'index_xt_intro_detail',
meta:{auth:true}
},
{
	path: '/index/sys_intro',
	component: index_sys_intro,
	name:'index_sys_intro',
meta:{auth:true}
},
{
	path: '/sys_login',
	component: sys_login,
	name:'sys_login',
meta:{auth:true}
},
{
	path: '/user_msg_regist',
	component: user_msg_regist,
	name:'user_msg_regist',
meta:{auth:true}
},
{
	path: '/home',
	component: home,
	name:'home',
meta:{auth:true}
},
{
	path: '/home2',
	component: home2,
	name:'home2',
meta:{auth:true}
},
{
	path: '/admin/index',
	component: admin_index,
	name:'admin_index',
meta:{auth:true}
},
{
	path: '/user/index',
	component: user_index,
	name:'user_index',
meta:{auth:true}
},
{
	path: '/admin/yd_type_msg/list',
	component: admin_yd_type_msg_list,
	name:'admin_yd_type_msg_list',
meta:{auth:true}
},
{
	path: '/admin/ys_type_msg/list',
	component: admin_ys_type_msg_list,
	name:'admin_ys_type_msg_list',
meta:{auth:true}
},
{
	path: '/admin/user_msg/list',
	component: admin_user_msg_list,
	name:'admin_user_msg_list',
meta:{auth:true}
},
{
	path: '/user/yd_log/list',
	component: user_yd_log_list,
	name:'user_yd_log_list',
meta:{auth:true}
},
{
	path: '/user/ys_log/list',
	component: user_ys_log_list,
	name:'user_ys_log_list',
meta:{auth:true}
},
{
	path: '/admin/bmifw_msg/list',
	component: admin_bmifw_msg_list,
	name:'admin_bmifw_msg_list',
meta:{auth:true}
},
{
	path: '/admin/ynum_fw_msg/list',
	component: admin_ynum_fw_msg_list,
	name:'admin_ynum_fw_msg_list',
meta:{auth:true}
},
{
	path: '/admin/ydxhfw_msg/list',
	component: admin_ydxhfw_msg_list,
	name:'admin_ydxhfw_msg_list',
meta:{auth:true}
},
{
	path: '/admin/ysjh_msg/list',
	component: admin_ysjh_msg_list,
	name:'admin_ysjh_msg_list',
meta:{auth:true}
},
{
	path: '/user/ysjh_msg/list',
	component: user_ysjh_msg_list,
	name:'user_ysjh_msg_list',
meta:{auth:true}
},
{
	path: '/admin/ydjh_msg/list',
	component: admin_ydjh_msg_list,
	name:'admin_ydjh_msg_list',
meta:{auth:true}
},
{
	path: '/user/ydjh_msg/list',
	component: user_ydjh_msg_list,
	name:'user_ydjh_msg_list',
meta:{auth:true}
},
{
	path: '/user/ys_collect_msg/list',
	component: user_ys_collect_msg_list,
	name:'user_ys_collect_msg_list',
meta:{auth:true}
},
{
	path: '/user/yd_collect_msg/list',
	component: user_yd_collect_msg_list,
	name:'user_yd_collect_msg_list',
meta:{auth:true}
},
{
	path: '/admin/post_msg/list',
	component: admin_post_msg_list,
	name:'admin_post_msg_list',
meta:{auth:true}
},
{
	path: '/user/post_msg/list',
	component: user_post_msg_list,
	name:'user_post_msg_list',
meta:{auth:true}
},
{
	path: '/admin/dis_msg/list',
	component: admin_dis_msg_list,
	name:'admin_dis_msg_list',
meta:{auth:true}
},
{
	path: '/user/dis_msg/list',
	component: user_dis_msg_list,
	name:'user_dis_msg_list',
meta:{auth:true}
},
{
	path: '/admin/reply_msg/list',
	component: admin_reply_msg_list,
	name:'admin_reply_msg_list',
meta:{auth:true}
},
{
	path: '/user/reply_msg/list',
	component: user_reply_msg_list,
	name:'user_reply_msg_list',
meta:{auth:true}
},
{
	path: '/admin/lmsg_suggest_msg/list',
	component: admin_lmsg_suggest_msg_list,
	name:'admin_lmsg_suggest_msg_list',
meta:{auth:true}
},
{
	path: '/user/lmsg_suggest_msg/list',
	component: user_lmsg_suggest_msg_list,
	name:'user_lmsg_suggest_msg_list',
meta:{auth:true}
},
{
	path: '/admin/yyxcs_msg/list',
	component: admin_yyxcs_msg_list,
	name:'admin_yyxcs_msg_list',
meta:{auth:true}
},
{
	path: '/admin/xt_intro_msg/list',
	component: admin_xt_intro_msg_list,
	name:'admin_xt_intro_msg_list',
meta:{auth:true}
},
{
	path: '/admin/banner_msg/list',
	component: admin_banner_msg_list,
	name:'admin_banner_msg_list',
meta:{auth:true}
},
{
	path: '/user/personal',
	component: user_personal,
	name:'user_personal',
meta:{auth:true}
},
{
	path: '/admin/post_msg/detail',
	component: admin_post_msg_detail,
	name:'admin_post_msg_detail',
meta:{auth:true}
},
{
	path: '/user/post_msg/detail',
	component: user_post_msg_detail,
	name:'user_post_msg_detail',
meta:{auth:true}
},
{
	path: '/admin/yyxcs_msg/detail',
	component: admin_yyxcs_msg_detail,
	name:'admin_yyxcs_msg_detail',
meta:{auth:true}
},
{
	path: '/alter_password',
	component: alter_password,
	name:'alter_password',
meta:{auth:true}
},
{
	path: '/admin/yd_type_msg/add_page',
	component: admin_yd_type_msg_add,
	name:'admin_yd_type_msg_add',
meta:{auth:true}
},
{
	path: '/admin/yd_type_msg/update_page',
	component: admin_yd_type_msg_update,
	name:'admin_yd_type_msg_update',
meta:{auth:true}
},
{
	path: '/admin/ys_type_msg/add_page',
	component: admin_ys_type_msg_add,
	name:'admin_ys_type_msg_add',
meta:{auth:true}
},
{
	path: '/admin/ys_type_msg/update_page',
	component: admin_ys_type_msg_update,
	name:'admin_ys_type_msg_update',
meta:{auth:true}
},
{
	path: '/user/user_msg/update_page',
	component: user_user_msg_update,
	name:'user_user_msg_update',
meta:{auth:true}
},
{
	path: '/user/yd_log/add_page',
	component: user_yd_log_add,
	name:'user_yd_log_add',
meta:{auth:true}
},
{
	path: '/user/yd_log/update_page',
	component: user_yd_log_update,
	name:'user_yd_log_update',
meta:{auth:true}
},
{
	path: '/user/ys_log/add_page',
	component: user_ys_log_add,
	name:'user_ys_log_add',
meta:{auth:true}
},
{
	path: '/user/ys_log/update_page',
	component: user_ys_log_update,
	name:'user_ys_log_update',
meta:{auth:true}
},
{
	path: '/admin/bmifw_msg/add_page',
	component: admin_bmifw_msg_add,
	name:'admin_bmifw_msg_add',
meta:{auth:true}
},
{
	path: '/admin/bmifw_msg/update_page',
	component: admin_bmifw_msg_update,
	name:'admin_bmifw_msg_update',
meta:{auth:true}
},
{
	path: '/admin/ynum_fw_msg/add_page',
	component: admin_ynum_fw_msg_add,
	name:'admin_ynum_fw_msg_add',
meta:{auth:true}
},
{
	path: '/admin/ynum_fw_msg/update_page',
	component: admin_ynum_fw_msg_update,
	name:'admin_ynum_fw_msg_update',
meta:{auth:true}
},
{
	path: '/admin/ydxhfw_msg/add_page',
	component: admin_ydxhfw_msg_add,
	name:'admin_ydxhfw_msg_add',
meta:{auth:true}
},
{
	path: '/admin/ydxhfw_msg/update_page',
	component: admin_ydxhfw_msg_update,
	name:'admin_ydxhfw_msg_update',
meta:{auth:true}
},
{
	path: '/admin/ysjh_msg/add_page',
	component: admin_ysjh_msg_add,
	name:'admin_ysjh_msg_add',
meta:{auth:true}
},
{
	path: '/admin/ysjh_msg/update_page',
	component: admin_ysjh_msg_update,
	name:'admin_ysjh_msg_update',
meta:{auth:true}
},
{
	path: '/admin/ydjh_msg/add_page',
	component: admin_ydjh_msg_add,
	name:'admin_ydjh_msg_add',
meta:{auth:true}
},
{
	path: '/admin/ydjh_msg/update_page',
	component: admin_ydjh_msg_update,
	name:'admin_ydjh_msg_update',
meta:{auth:true}
},
{
	path: '/user/post_msg/add_page',
	component: user_post_msg_add,
	name:'user_post_msg_add',
meta:{auth:true}
},
{
	path: '/user/post_msg/update_page',
	component: user_post_msg_update,
	name:'user_post_msg_update',
meta:{auth:true}
},
{
	path: '/admin/lmsg_suggest_msg/hf_page',
	component: admin_lmsg_suggest_msg_hf,
	name:'admin_lmsg_suggest_msg_hf',
meta:{auth:true}
},
{
	path: '/user/lmsg_suggest_msg/add_page',
	component: user_lmsg_suggest_msg_add,
	name:'user_lmsg_suggest_msg_add',
meta:{auth:true}
},
{
	path: '/user/lmsg_suggest_msg/update_page',
	component: user_lmsg_suggest_msg_update,
	name:'user_lmsg_suggest_msg_update',
meta:{auth:true}
},
{
	path: '/admin/yyxcs_msg/add_page',
	component: admin_yyxcs_msg_add,
	name:'admin_yyxcs_msg_add',
meta:{auth:true}
},
{
	path: '/admin/yyxcs_msg/update_page',
	component: admin_yyxcs_msg_update,
	name:'admin_yyxcs_msg_update',
meta:{auth:true}
},
{
	path: '/admin/xt_intro_msg/update_page',
	component: admin_xt_intro_msg_update,
	name:'admin_xt_intro_msg_update',
meta:{auth:true}
},
{
	path: '/admin/banner_msg/add_page',
	component: admin_banner_msg_add,
	name:'admin_banner_msg_add',
meta:{auth:true}
},
{
	path: '/admin/banner_msg/update_page',
	component: admin_banner_msg_update,
	name:'admin_banner_msg_update',
meta:{auth:true}
},
]
const router = createRouter({
	mode: 'history', // 设置为history模式
	history:createWebHistory(),
	base: process.env.BASE_URL,
	routes
})
export default router
