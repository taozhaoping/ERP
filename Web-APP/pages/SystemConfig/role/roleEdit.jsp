<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	Map map = (Map)request.getAttribute("dataMap");
	String osValue = map.get("osValue").toString();
	boolean isEdit = osValue.equalsIgnoreCase("edit");
	String curNavigation = "新增";
	if(isEdit){
		curNavigation = "编辑";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="getText('COM.OSFI.WINDOW.TITLE')" /></title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/theme.css">
<link rel="stylesheet" href="<%=path%>/css/font-awesome.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<!-- Demo page code -->
<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}

.offset30{
	margin-left: 30px;
}

</style>
<link href="<%=path%>/img/favicon_32.ico" rel="bookmark"
	type="image/x-icon" />
<link href="<%=path%>/img/favicon_32.ico" rel="icon" type="image/x-icon" />
<link href="<%=path%>/img/favicon_32.ico" rel="shortcut icon"
	type="image/x-icon" />
</head>
<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->
	<%@ include file="/pages/common/titleWithNav.jsp"%>
	<%@ include file="/pages/common/sidebarWithNav.jsp"%> 

	<div class="content">
		<div class="header">
			<div class="stats">
				<p class="stat">
					<span class="number">53</span>tickets
				</p>
				<p class="stat">
					<span class="number"><s:property value="#session.taskSize"/></span>tasks
				</p>
				<p class="stat">
					<span class="number">15</span>waiting
				</p>
			</div>

			<h1 class="page-title" id="menu2Name">&nbsp;</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="<%=path%>/home/main.jspa">主页</a> <span class="divider">/</span></li>
			<li><a href="role.jspa" id="navigation"></a> <span class="divider">/</span></li>
			<li class="active"><%=curNavigation%></li>
		</ul>
		
		<div class="container-fluid">
		<form id="editForm" class="form-horizontal" action="role!save.jspa" method="post">
			<div class="row-fluid">
				<div class="row-fluid">
				
					<div class="btn-toolbar">
						<button class="btn btn-primary" type="submit">
							<i class="icon-save"></i> 保存
						</button>
						<a href="role.jspa" class="btn" id="backList">
							返回</a>
						<div class="btn-group"></div>
					</div>
					<div class="well">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active" id="home">
								<input type="hidden" name="role.id" value="${role.id}">
								<input type="hidden" name="menuId" value="${menuId}">
								<input type="hidden" name="menu2Id" value="${menu2Id}">
								<input type="hidden" name="spaceId" value="${spaceId}">
								<input type="hidden" id="authoritiesListInputJson" name="authoritiesListJsonValue">
								<input type="hidden" id="menuListInputJson" name="menuListJsonValue">
								
								<div class="control-group" id="name_div">
									<label class="control-label" for="nameInput">名称：</label>
									<div class="controls">
										<input type="text" data-required="true"  id="nameInput" name="role.name" value="${role.name}" class="input-xlarge">
									</div>
								</div>
								
								<div class="control-group" id="name_div">
									<label class="control-label" for="describeInput">描述：</label>
									<div class="controls">
										<input type="text" data-required="true"  id="describeInput" name="role.describe" value="${role.describe}" class="input-xlarge">
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="authoritiesListInput">功能权限：</label>
									<div class="controls">
										<input type="text" data-required="true" id="authoritiesListInput" readonly="readonly" class="input-xlarge">
										<a href='#authoritiesListModal' data-toggle='modal' title="选择"><i class="icon-edit"></i></a>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="menuListInput">菜单权限：</label>
									<div class="controls">
										<input type="text" data-required="true" id="menuListInput" readonly="readonly" class="input-xlarge">
										<a href='#menuListModal' data-toggle='modal' title="选择"><i class="icon-edit"></i></a>
									</div>
								</div>
													
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 功能权限 -->
			<div class="modal small hide fade" id="authoritiesListModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">选择功能权限</h3>
				</div>
				<div class="modal-body" style="height: 150px;">
					<label class="checkbox" style="display: none;" id="authTemplate">
						<input type="checkbox">
					</label>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
					<button class="btn btn-danger" data-dismiss="modal" id="selectAuthBtn">确认</button>
				</div>
			</div>
			
			<!-- 菜单权限 -->
			<div class="modal small hide fade" id="menuListModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">选择菜单权限</h3>
				</div>
				<div class="modal-body" style="height: 250px;">
					<label class="checkbox" id="menuTemplate" style="display: none;">
						<input type="checkbox">
					</label>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
					<button class="btn btn-danger" data-dismiss="modal" id="selectMenuBtn">确认</button>
				</div>
			</div>

			</form>
		</div>
		</div>
		<%@ include file="/pages/common/footer.jsp"%>
		<script src="<%=path%>/js/bootstrap.js"></script>
		<script src="<%=path %>/js/collapsePulg.js"></script>
		<script src="<%=path %>/js/common.js"></script>
		<script src="<%=path %>/js/jquery-validate.js"></script>
		<script type="text/javascript">
			$("[rel=tooltip]").tooltip();
			var id='${menuId}';
			var menuId='${menu2Id}';
			var spaceId = '${spaceId}';
			var url=$("#"+menuId).attr("url");
			
			var localObj = window.location;
			var contextPath = localObj.pathname.split("/")[1];
			var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
			
			$("#authoritiesListModal").on('show', function () {
				$.ajax({
					type: "POST",   //访问WebService使用Post方式请求
					url: basePath + "/home/role!authoritiesExecute.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
					data: {},  //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
					dataType: 'json',   //WebService 会返回Json类型
					traditional: false,	//不要序列化参数
					error: function(err, textStatus){
						//alert("error: " + err + " textStatus: " + textStatus);
					},
					success: function(result) {//回调函数，result，返回值
						//填充到table中
						fillAuthList(result);
					}
				});
			});
			
			//展示权限列表
			function fillAuthList(authList){
				$("#authTemplate").prevAll("label").remove();
				//把查询的结果添加到DIV中
				for(var i = 0; i<authList.length; i++){
					var auth = authList[i];
					$("#authTemplate").clone(true).show().attr("id","auth"+auth.id)
					.children("input").val(auth.id).after(auth.name)
					.parent().insertBefore("#authTemplate");
				}
				
				var selAuthList = JSON.parse($("#authoritiesListInputJson").val());
				
				if(selAuthList != null && selAuthList != "" && selAuthList.length >0){
					for(var j = 0; j<selAuthList.length; j++){
						var selAuth = selAuthList[j];
						$("#auth"+selAuth.id).children("input").attr("checked", "checked");
					}
				}
			}
			<% if(isEdit){%>
			(function initAuth(){
				var selAuthList = ${dataMap.authListJson};//JSON.parse($("#authListJsonId").val());
				if(selAuthList != null && selAuthList != "" && selAuthList.length > 0){
					var selAuthsName = "";
					for(var j = 0; j<selAuthList.length; j++){
						var selAuth = selAuthList[j];
						selAuthsName = selAuthsName + selAuth.name + ";";
					}
					
					//$("#authoritiesListInput").attr("jsonval", JSON.stringify(selAuthList));
					$("#authoritiesListInputJson").val(JSON.stringify(selAuthList));
					$("#authoritiesListInput").val(selAuthsName);
				}
			})();
			<% }%>
			
			//菜单展开 去查询列表
			$("#menuListModal").on('show', function () {
				$.ajax({
					type: "POST",   //访问WebService使用Post方式请求
					url: basePath + "/home/role!menuExecute.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
					data: {},  //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
					dataType: 'json',   //WebService 会返回Json类型
					traditional: false,	//不要序列化参数
					error: function(err, textStatus){
						//alert("error: " + err + " textStatus: " + textStatus);
					},
					success: function(result) {//回调函数，result，返回值
						//填充到table中
						fillMenuList(result);
					}
				});
			});
			
			//展示菜单列表
			function fillMenuList(menuList){
				
				$("#menuTemplate").prevAll("label").remove();
				//把查询的结果添加到DIV中
				for(var i = 0; i<menuList.length; i++){
					var menu = menuList[i];
					$("#menuTemplate").clone(true).show().attr("id","menu"+menu.id)
					.addClass("levelMenu")
					.children("input").val(menu.id).after(menu.name)
					.parent().insertBefore("#menuTemplate");
					//二级菜单
					var menu2List = menu.menuList;
					if(menu2List != null && menu2List != "" && menu2List.length >0){
						for(var j = 0; j<menu2List.length; j++){
							var menu2 = menu2List[j];
							$("#menuTemplate").clone(true).show()
							.attr("id","menu"+menu2.id).attr("parentId", "menu"+menu.id)
							.addClass("offset30")
							.children("input").val(menu2.id).after(menu2.name)
							.parent().insertBefore("#menuTemplate");
						}
					}
				}
				
				var selMenuList = JSON.parse($("#menuListInputJson").val());
				
				if(selMenuList != null && selMenuList != "" && selMenuList.length > 0){
					for(var j = 0; j<selMenuList.length; j++){
						var selMenu = selMenuList[j];
						$("#menu"+selMenu.id).children("input").attr("checked", "checked");
						var selMenu2List = selMenu.menuList;
						if(selMenu2List != null && selMenu2List != "" && selMenu2List.length >0){
							for(var j = 0; j<selMenu2List.length; j++){
								var selMenu2 = selMenu2List[j];
								$("#menu"+selMenu2.id).children("input").attr("checked", "checked");
							}
						}
					}
				}
			}
			
			<% 
			if(isEdit){
			%>
			(function initMenu(){
				var selMenuList = ${dataMap.menuListJson}; //JSON.parse($("#menuListJsonId").val());
				
				if(selMenuList != null && selMenuList != "" && selMenuList.length > 0){
					var selectedMenus = new Array();
					var selMenuListValue = "";
					for(var j = 0; j<selMenuList.length; j++){
						var selMenu = selMenuList[j];
						
						var tempMenu = new Object();
						tempMenu.name = selMenu.name;
						tempMenu.id = selMenu.id;
						selectedMenus.push(tempMenu);
						
						selMenuListValue = selMenuListValue + selMenu.name + ";";
						var selMenu2List = selMenu.menuList;
						if(selMenu2List != null && selMenu2List != "" && selMenu2List.length >0){
							for(var j = 0; j<selMenu2List.length; j++){
								var selMenu2 = selMenu2List[j];
								selMenuListValue = selMenuListValue + selMenu2.name + ";";
								
								var tempMenu2 = new Object();
								tempMenu2.name = selMenu2.name;
								tempMenu2.id = selMenu2.id;
								selectedMenus.push(tempMenu2);
								
							}
						}
					}
					
					//$("#menuListInput").attr("jsonval",JSON.stringify(selMenuList));
					$("#menuListInputJson").val(JSON.stringify(selectedMenus));
					$("#menuListInput").val(selMenuListValue);
				}
			})();
			<%}%>
			
			//选择功能权限
			/*
			$(".levelMenu").children("input").click(function() {
				if ($(this).attr('checked') == 'checked') {
					$(this).nextAll(".offset30").each(function () {
						//只对可见的操作
						$(this).attr("checked", "checked");
					});
				}else {
					$(this).nextAll(".offset30").each(function () {
						//只对可见的操作
						$(this).removeAttr("checked");
					});
				}
			});
			*/
			//选择功能权限
			$("#selectAuthBtn").bind('click', function() {
				var curSelectAuth = "";
				var selectedAuths = new Array();
				$("#authoritiesListModal div label input[type='checkbox']:checked").each(function () {
					var parentText = $(this).parent("label").text();
					var authName = $.trim(parentText);
					curSelectAuth = curSelectAuth + authName + ";";
					var tempAuth = new Object();
					tempAuth.name = authName;
					tempAuth.id = $(this).val();
					selectedAuths.push(tempAuth);
				});
				
				//$("#authoritiesListInput").attr("jsonval", JSON.stringify(selectedAuths));
				$("#authoritiesListInputJson").val(JSON.stringify(selectedAuths));
				$("#authoritiesListInput").val(curSelectAuth);
			});
			
			//选择菜单权限
			$("#selectMenuBtn").bind('click', function() {
				var curSelectMenu = "";
				var selectedMenus = new Array();
				$("#menuListModal div label input[type='checkbox']:checked").each(function () {
					var parentText = $(this).parent("label").text();
					menuName = $.trim(parentText);
					curSelectMenu = curSelectMenu + menuName + ";";
					var tempMenu = new Object();
					tempMenu.name = menuName;
					tempMenu.id = $(this).val();
					selectedMenus.push(tempMenu);
				});
				
				//$("#menuListInput").attr("jsonval", JSON.stringify(selectedMenus));
				$("#menuListInputJson").val(JSON.stringify(selectedMenus));
				$("#menuListInput").val(curSelectMenu);
			});
			
		</script>
</body>
</html>