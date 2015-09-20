<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@  page import="com.zh.base.util.JspUtil" %>
<%
	String path = request.getContextPath();
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
<link rel="stylesheet" href="<%=path%>/js/select2/select2.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqPaginator.min.js"></script>
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
<jsp:useBean id="userName" class="com.zh.base.util.JspUtil" scope="session"></jsp:useBean>
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
					<span class="number"><s:property value="#session.taskSize" /></span>tasks
				</p>
				<p class="stat">
					<span class="number">15</span>waiting
				</p>
			</div>

			<h1 class="page-title" id="menu2Name">&nbsp;</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="<%=path%>/home/main.jspa">主页</a> <span
				class="divider">/</span></li>
			<li><a href="" id="navigation"></a> <span class="divider">/</span></li>
			<li class="active">编辑</li>
		</ul>
		<s:set name="ProcessId"
					value="cuttingScheme.id!=null&&cuttingScheme.id!=''" />
		<div class="container-fluid">
				<input type="hidden" id="formChanged" name="formChanged" value="0" />
				<div class="row-fluid">

					<div class="btn-toolbar">
						<button id="formButton" class="btn btn-primary" type="submit">
							<i class="icon-save"></i> 保存
						</button>
						<a class="btn" id="backList" href=""> 返回</a>
						<div class="btn-group"></div>
						<div class="pull-right">
							<s:if test="#ProcessId">
								<button class="btn btn-danger" type="button" id="approveBtn"
								data-toggle="modal" data-target="#forMchangefirm">
									<i class="icon-ok"></i> 
									<s:if test="cuttingScheme.enabled=='0'">激活</s:if>
									<s:else>停用</s:else>
								</button>
							</s:if>
						</div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active" id="home">
								<form id="editForm" class="form-horizontal" action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="id" value="${cuttingScheme.id}"> 
								<input type="hidden" name="menuId" value="${menuId}"> 
								<input type="hidden" name="menu2Id" value="${menu2Id}"> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputID" style="">编号：</label>
											<div class="controls">
													<input type="text" maxlength="30" disabled="disabled"
														id="inputID" value="${cuttingScheme.id}" class="input-large"></input>
												
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputname" style="">名称：</label>
											<div class="controls">
												<input size="16" id="inputname" name="cuttingScheme.name"
													type="text" data-required="true"
													value="${cuttingScheme.name}"
													class="input-large">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputrawMaterials" style="">原材料：</label>
											<div class="controls">
												<input size="16" id="inputrawMaterials" name="cuttingScheme.rawMaterials"
													type="text" data-required="true"
													value="${cuttingScheme.rawMaterials}"
													class="input-large">
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputenabled" style="">状态：</label>
											<div class="controls">
												<select id="inputenabled"  disabled="disabled"
													name="cuttingScheme.enabled" class="input-large" placeholder="状态" >
													<option value="0">无效</option>
													<option value="1">有效</option>
												</select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputmainProducts" style="">主产品编号：</label>
											<div class="controls">
												
												<input id="inputmainProducts"  data-required="true" value="${cuttingScheme.mainProducts}"
													name="cuttingScheme.mainProducts" class="input-large" placeholder="产品编号">
												</input>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputmanNumber" style="">主产品数量：</label>
											<div class="controls">
												<input size="16" id="inputmanNumber" name="cuttingScheme.manNumber"
													type="number" data-required="true"
													value="${cuttingScheme.manNumber}"
													class="input-large">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputbyProducts" style="">副产品编号：</label>
											<div class="controls">
												
												<input id="inputbyProducts"  data-required="true" value="${cuttingScheme.byProducts}"
													name="cuttingScheme.byProducts" class="input-large" placeholder="产品编号">
												</input>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputbyNumber" style="">副产品数量：</label>
											<div class="controls">
												<input size="16" id="inputbyNumber" name="cuttingScheme.byNumber"
													type="number" data-required="true"
													value="${cuttingScheme.byNumber}"
													class="input-large">
											</div>
										</div>
									</div>
								</dir>
								
								</form>
							</div>
							
						</div>
					</div>
				</div>
		</div>
	</div>
	
	<div class="modal small hide fade" id="forMchangefirm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">提示</h3>
		</div>
		<div class="modal-body">
			<p class="error-text">
				<i class="icon-warning-sign modal-icon "></i>是否切换当前切割方案状态.继续请按."确定" 否则请按 "取消"
			</p>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal"
				id="formChangefirmBtn">确定</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<form action="${menu2Id}.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
	</form>
	
	<form action="${menu2Id}!save.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="increaseStockForm" method="post">
		<input id="id" name="id" value="${cuttingScheme.id}" type="hidden"/>
		<input id="view" name="view" value="enabled" type="hidden"/>
		<input id="enabled" name="enabled" value="${cuttingScheme.enabled}" type="hidden"/>
	</form>
	
	<%@ include file="/pages/common/footer.jsp"%>
	<script src="<%=path%>/js/bootstrap.js"></script>
	<script src="<%=path%>/js/collapsePulg.js"></script>
	<script src="<%=path%>/js/common.js"></script>
	<script src="<%=path%>/js/jquery-validate.js"></script>
	<script src="<%=path%>/js/datetimepicker/bootstrap-datetimepicker.js"></script>
	<script src="<%=path%>/js/select2/select2.js"></script>
	<script src="<%=path%>/js/select2/select2_locale_zh-CN.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		var menuId = '${menuId}';
		var menu2Id = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menu2Id).attr('url');
		var id = '${cuttingScheme.id}';
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		$("select").select2();
		
		$("#inputenabled").val("${cuttingScheme.enabled}")
		.trigger("change");
		
		$("#inputrawMaterials").select2({
			placeholder : "查询产品编号",
			minimumInputLength : 3,
			//multiple:true,
			quietMillis : 3000,
			initSelection: function (element, callback) { 
	            callback({id: element.val(), text: element.val() + "(${cuttingScheme.rawName})"});//这里初始化 
	        },
			ajax : {
				url : basePath + "/interface/interfaceProducts!queryProductsList.jspa",
				dataType : 'json',
				data : function(term, page) {
					return {
						"productsID" : term,
						"products.sourceType" : '120',
						"pageInfo.curPage" : page
					};
				},
				results : function(data, page) {
					
					var more = (page * 10) < data.total;
					for ( var i = 0; i < data.rows.length; i++) {
						var parts = data.rows[i];
						parts.id = parts.id;
						parts.text = parts.id + "(" + parts.name + parts.specifications + ")";
					}
					partsArr = data.rows;
					return {
						results : data.rows,
						more : more
					};
				}
			},
			formatNoMatches : function() {
				return "没有找到匹配项";
			},

			formatInputTooShort : function(input, min) {
				var n = min - input.length;
				return "请最少输入" + n + "个字符";
			},

			formatInputTooLong : function(input, max) {
				var n = input.length - max;
				return "请删掉" + n + "个字符";
			},

			formatSelectionTooBig : function(limit) {
				return "你只能选择最多" + limit + "项";
			},

			formatLoadMore : function(pageNumber) {
				return "加载结果中...";
			},

			formatSearching : function() {
				return "搜索中...";
			}
		});
		
		$("#inputmainProducts").select2({
			placeholder : "查询产品编号",
			minimumInputLength : 3,
			//multiple:true,
			quietMillis : 3000,
			initSelection: function (element, callback) { 
	            callback({id: element.val(), text: element.val() + "(${cuttingScheme.mainName})"});//这里初始化 
	        },
			ajax : {
				url : basePath + "/interface/interfaceProducts!queryProductsList.jspa",
				dataType : 'json',
				data : function(term, page) {
					return {
						"productsID" : term,
						"products.sourceType" : '121',
						"products.isCuttingScheme":'1',
						"pageInfo.curPage" : page
					};
				},
				results : function(data, page) {
					
					var more = (page * 10) < data.total;
					for ( var i = 0; i < data.rows.length; i++) {
						var parts = data.rows[i];
						parts.id = parts.id;
						parts.text = parts.id + "(" + parts.name + parts.specifications + ")";
					}
					partsArr = data.rows;
					return {
						results : data.rows,
						more : more
					};
				}
			},
			formatNoMatches : function() {
				return "没有找到匹配项";
			},

			formatInputTooShort : function(input, min) {
				var n = min - input.length;
				return "请最少输入" + n + "个字符";
			},

			formatInputTooLong : function(input, max) {
				var n = input.length - max;
				return "请删掉" + n + "个字符";
			},

			formatSelectionTooBig : function(limit) {
				return "你只能选择最多" + limit + "项";
			},

			formatLoadMore : function(pageNumber) {
				return "加载结果中...";
			},

			formatSearching : function() {
				return "搜索中...";
			}
		});
		
		$("#inputbyProducts").select2({
			placeholder : "查询产品编号",
			minimumInputLength : 3,
			//multiple:true,
			quietMillis : 3000,
			initSelection: function (element, callback) { 
	            callback({id: element.val(), text: element.val() + "(${cuttingScheme.byName})"});//这里初始化 
	        },
			ajax : {
				url : basePath + "/interface/interfaceProducts!queryProductsList.jspa",
				dataType : 'json',
				data : function(term, page) {
					return {
						"productsID" : term,
						"products.sourceType" : '121',
						"pageInfo.curPage" : page
					};
				},
				results : function(data, page) {
					
					var more = (page * 10) < data.total;
					for ( var i = 0; i < data.rows.length; i++) {
						var parts = data.rows[i];
						parts.id = parts.id;
						parts.text = parts.id + "(" + parts.name + parts.specifications + ")";
					}
					partsArr = data.rows;
					return {
						results : data.rows,
						more : more
					};
				}
			},
			formatNoMatches : function() {
				return "没有找到匹配项";
			},

			formatInputTooShort : function(input, min) {
				var n = min - input.length;
				return "请最少输入" + n + "个字符";
			},

			formatInputTooLong : function(input, max) {
				var n = input.length - max;
				return "请删掉" + n + "个字符";
			},

			formatSelectionTooBig : function(limit) {
				return "你只能选择最多" + limit + "项";
			},

			formatLoadMore : function(pageNumber) {
				return "加载结果中...";
			},

			formatSearching : function() {
				return "搜索中...";
			}
		});
		
		
		//提交按钮
		$("#formButton").click(function() {
			saveForm();
		});
		
		//判读当前tab，需要保存那个form
		function saveForm() {
			$("#editForm").submit();
		}
		
		$("#formChangefirmBtn").click(function() {
			$("#increaseStockForm").submit();
		});
		
	</script>
</body>
</html>