 import $ from 'jquery'
 
 export  var admin_utils={
	showLoading(imgPath) {
    },
    hideLoading() {
    },
	modalShowHtml(html){
		$("#bodyModalContent").html(html);
    	$("#bodyModal").css("display","block")
	},
	hideModal(){
		$("#bodyModal").css("display","none")
	},
	maxImg(e){
    	var src = $(e).attr("src");
    	var html = '';
    	html = '<img style="width:60%;margin-left:20%" src="'+src+'"/>';
    	$("#bodyModalContent").html(html);
    	$("#bodyModal").css("display","block")
	},
	 clickMenu(e){
		var div = $(e).next();
		if($(div).hasClass("admin-menu-none")){
			$(div).removeClass("admin-menu-none");
			$(e).children(".admin-arrow").html("-");
		}else{
			$(div).addClass("admin-menu-none");
			$(e).children(".admin-arrow").html(">");
		}
	},
  selectAll(e){
    	if($(e).prop("checked")==true){
    		$(".itemselect").prop("checked",true);
    	}else{
    		$(".itemselect").prop("checked",false);
    	}
    },
		addAllSelect(list){
		var map = {};
		map.id='';
		map.name='全部';
		var list2 =[];
		list2.push(map);
		for(var i=0;i<list.length;i++){
			var map2 = {};
			map2.id=list[i].id;
			map2.name=list[i].name;
			list2.push(map2);
		}
		return list2;
	},
	addAllSelect2(list){
		var map = {};
		map.id='';
		map.name='无';
		var list2 =[];
		list2.push(map);
		for(var i=0;i<list.length;i++){
			var map2 = {};
			map2.id=list[i].id;
			map2.name=list[i].name;
			list2.push(map2);
		}
		return list2;
	}
}
