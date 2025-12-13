import $ from 'jquery';
import WangEditor from 'wangeditor';
var wangList=[];
export function initAllEditor(requestUri,domId){
    var divs = $(".editorDiv");
    for(var i=0;i<wangList.length;i++){
        if(wangList[i].id==domId){
            wangList.splice(i, 1);
        }
    }
    for(var i=0;i<divs.length;i++){
        var dataId = $(divs[i]).attr("data-id");
		if(dataId==domId){
		var editor =  new WangEditor(divs[i]);
        // 设置配置项
        editor.config.uploadImgServer = requestUri+'/imgUpload/imgUploadForWangEditor'  // 后端接口地址，用于处理文件上传
        editor.config.uploadFileName = 'files'  // 文件字段名称
        editor.config.uploadImgMaxSize = 3 * 1024 * 1024;
	    editor.config.uploadImgMaxLength = 5;
	    editor.config.uploadImgTimeout = 30000;
		editor.config.zIndex  = 500;
		editor.config.menus =  ['head', 'bold', 'italic', 'underline', 'strikeThrough', 'foreColor', 'backColor', 'link', 'list', 'justify', 'quote', 'table', 'code', 'undo', 'redo',"image"];
        editor.create();
        var introMap={};
        introMap.id=dataId;
        introMap.edit=editor;
        wangList.push(introMap); 
	}
   }
}
export function getEditVal(domId){
    for(var i=0;i<wangList.length;i++){
        if(wangList[i].id==domId){
            var editor = wangList[i].edit;
            return editor.txt.html();
        }
    }
    return "";
}
export function setEditorHtml(domId,htmlCode){
    for(var i=0;i<wangList.length;i++){
        if(wangList[i].id==domId){
            var editor = wangList[i].edit;
            editor.txt.clear();
            editor.txt.append(htmlCode);
        }
    }
}
