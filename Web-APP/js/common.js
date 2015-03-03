//公共js函数
var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol + "//" + localObj.host + "/"
				+ contextPath;
$(function() {
	
	$('.demo-cancel-click').click(function() {
		return false;
	});
	var headText = $("#" + menuId).text();
	$("#menu2Name").text(headText);
	$("#navigation").text(headText);
	//导航链接
	$("#navigation").attr("href", url + "?menuId=" + id + "&menu2Id=" + menuId + "&spaceId=" + spaceId);
	// 返回按钮
	$("#backList").attr("href", url + "?menuId=" + id + "&menu2Id=" + menuId + "&spaceId=" + spaceId);

	// 展开一级菜单
	collapseMenu(id);

	// 验证
	$('form').validate( {
		onKeyup : false,
		onSubmit : true,
		onChange : true,
		eachValidField : function() {

			$(this).closest('div').parents('div').removeClass('error')
					.addClass('success');
		},
		eachInvalidField : function() {

			$(this).closest('div').parents('div')
					.removeClass('success').addClass('error');
		}
	});
	
	//日期控件
	$(".form_datetime").datetimepicker({
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : true
	});
});

//培训信息
function selectActivities(id) {
	$.ajax({
		type : "POST", //访问WebService使用Post方式请求
		url : basePath + "/home/interface!queryActivities.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {}, //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
		dataType : 'json', //WebService 会返回Json类型
		traditional : false, //不要序列化参数
		error : function(err, textStatus) {
			//alert("error: " + err + " textStatus: " + textStatus);
		},
		success : function(result) {//回调函数，result，返回值
			//填充到table中
			fillTrainCourseList(result, id);
		}
	});
}

//培训信息
function selectTrainCourse(id,type) {
	$.ajax({
		type : "POST", //访问WebService使用Post方式请求
		url : basePath + "/home/interface!queryTrainCourse.jspa?type=" + type, //调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {}, //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
		dataType : 'json', //WebService 会返回Json类型
		traditional : false, //不要序列化参数
		error : function(err, textStatus) {
			//alert("error: " + err + " textStatus: " + textStatus);
		},
		success : function(result) {//回调函数，result，返回值
			//填充到table中
			fillTrainCourseList(result, id);
		}
	});
}

//展示培训选择列表
function fillTrainCourseList(trainCourseList, id) {
	//清空上次的查询结果
	$("#" + id + "Option").nextAll("option").remove();
	//动态生成用户列表
	for ( var i = 0; i < trainCourseList.length; i++) {
		var trainCourse = trainCourseList[i];
		$("#" + id + "Option").clone(true).removeAttr("selected").attr(
					"value", trainCourse.id).val(trainCourse.id).html(
							trainCourse.name + "(" + trainCourse.scheduleDate + ")").insertAfter(
					"#" + id + "Option");
	}
}


//选择人员
function selectEntryProcess(id) {
	$.ajax({
		type : "POST", //访问WebService使用Post方式请求
		url : basePath + "/home/interface!queryEntryProcess.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {}, //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
		dataType : 'json', //WebService 会返回Json类型
		traditional : false, //不要序列化参数
		error : function(err, textStatus) {
			//alert("error: " + err + " textStatus: " + textStatus);
		},
		success : function(result) {//回调函数，result，返回值
			//填充到table中
			fillEntryProcessList(result, id);
		}
	});
}

//展示用户选择列表
function fillEntryProcessList(entryProcessList, id) {
	//清空上次的查询结果
	$("#" + id + "Option").nextAll("option").remove();
	//动态生成用户列表
	for ( var i = 0; i < entryProcessList.length; i++) {
		var entryProcess = entryProcessList[i];
		$("#" + id + "Option").clone(true).removeAttr("selected").attr(
					"value", entryProcess.id).val(entryProcess.id).html(
							entryProcess.id + "(" + entryProcess.name + ")").insertAfter(
					"#" + id + "Option");
	}
}



/**
 * 选择用户 
 * @param id select的id
 * @param type 列表展示类型。 表单的人员选择：‘form’ 审批的人员选择:‘assign’
 * 
 */
function selectUsers(id, type) {
	$.ajax({
		type : "POST", //访问WebService使用Post方式请求
		url : basePath + "/home/interface!queryUsers.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {}, //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
		dataType : 'json', //WebService 会返回Json类型
		traditional : false, //不要序列化参数
		error : function(err, textStatus) {
			//alert("error: " + err + " textStatus: " + textStatus);
		},
		success : function(result) {//回调函数，result，返回值
			//填充到table中
			fillUserList(result, id, type);
		}
	});
}

//展示用户选择列表
function fillUserList(userList, id, type) {
	//清空上次的查询结果
	$("#" + id + "Option").nextAll("option").remove();
	var selectOptionValue = $("#" + id).attr("selectId");
	//动态生成用户列表
	for ( var i = 0; i < userList.length; i++) {
		var user = userList[i];
		if("assign" != type){
			if(user.id == selectOptionValue){
				$("#" + id + "Option").clone(true).attr("selected", "selected").attr(
						"id", user.id).val(user.id).html(
						user.name + "(" + user.loginName + ")").insertAfter(
						"#" + id + "Option");
				//设置选中项
				$("#" + id + "Option").val(user.id).trigger("change");
				
			}else{
				$("#" + id + "Option").clone(true).removeAttr("selected").attr(
						"id", user.id).val(user.id).html(
						user.name + "(" + user.loginName + ")").insertAfter(
						"#" + id + "Option");
			}
		}else{
			$("#" + id + "Option").clone(true).removeAttr("selected").attr(
					"id", user.id).val(user.loginName).html(
					user.name + "(" + user.loginName + ")").insertAfter(
					"#" + id + "Option");
		}
	}
}

Date.prototype.format = function(format)
{
var o = {
            "M+" : this.getMonth()+1, //month
            "d+" : this.getDate(), //day
            "h+" : this.getHours(), //hour
            "m+" : this.getMinutes(), //minute
            "s+" : this.getSeconds(), //second
            "q+" : Math.floor((this.getMonth()+3)/3), //quarter
            "S" : this.getMilliseconds() //millisecond
        }
    if(/(y+)/.test(format))
    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
    if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}