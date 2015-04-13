<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
					value="storagePrimary.id!=null&&storagePrimary.id!=''" />
		<div class="container-fluid">
				<input type="hidden" id="formChanged" name="formChanged" value="0" />
				<div class="row-fluid">

					<div class="btn-toolbar">
						<button id="formButton" class="btn btn-primary" type="submit">
							<i class="icon-save"></i> 保存
						</button>
						<a class="btn" id="backList" href=""> 返回</a>
						<div class="btn-group"></div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<s:if test="#ProcessId">
								<li><a id="productStructureButt" href="#productStructure" data-toggle="tab">入库清单</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<form id="editForm" class="form-horizontal"
										action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="id" value="${storagePrimary.id}"> <input
									type="hidden" name="menuId" value="${menuId}"> <input
									type="hidden" name="menu2Id" value="${menu2Id}"> <input
									type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputorderNoID" style="">入库单号：</label>
											<div class="controls">
												<s:if test="#ProcessId">
													<input type="text" maxlength="30" disabled="disabled"
														id="inputorderNoID" value="${storagePrimary.orderNoID}" class="input-medium"></input>
												</s:if>
												<s:else>
													<input type="text" maxlength="30"  name="storagePrimary.orderNoID" data-required="true"
														id="inputorderNoID" value="${storagePrimary.orderNoID}" class="input-medium"></input>
												</s:else>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputstoragedate" style="">入库时间：</label>
											<div class="controls">
												<input size="16" id="inputstoragedate" name="storagePrimary.storagedate"
													type="text" disabled="disabled"
													value="<s:date name="storagePrimary.storagedate" format="yyyy-MM-dd" />"
													readonly class="form_datetime input-xlarge">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputuserID" style="">收货人：</label>
											<div class="controls">
												<input type="number" maxlength="40" name="storagePrimary.userID"
													placeholder="收货人" id="inputuserID" value="${storagePrimary.userID}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputcustomerID" style="">发货客户：</label>
											<div class="controls">
												<input type="number" maxlength="40" name="storagePrimary.customerID"
													placeholder="发货客户" id="inputcustomerID" value="${storagePrimary.customerID}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								</form>
							</div>
							<div class="tab-pane fade" id="productStructure">
							<form id="productStructureForm" class="form-horizontal" action="${menu2Id}!saveMailList.jspa" method="post">
								<input type="hidden" name="menuId" value="${menuId}" /> 
								<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<input type="hidden" name="formId" value="${storagePrimary.id}" />
								<input type="hidden" name="tabID" value="productStructureButt" />
								<input type="hidden" id="mailListName" name="mailList.name" value="" />
								<input type="hidden" id="mailListPhone" name="mailList.phone" value="" />
								<button class="btn btn-small btn-primary" type="button"
								data-toggle="modal" data-target="#popupfirm">添加产品</button>
							</form>
							<table class="table">
								<thead>
									<tr>
										<th>编号</th>
										<th>名称</th>
										<th>产品类型</th>
										<th>来源</th>
										<th>主产品</th>
										<th>组</th>
										<th>主料/替代料</th>
										<th>数量</th>
									</tr>
								</thead>
								
								<tbody id="maillistSearch">
									<tr>
										<!-- 产品列表 
										<s:iterator value="productStructureList" var="tp" status="index">
										<tr>
											<td><s:property value="#tp.id" /></td>
											<td><s:property value="#tp.storagePrimary.name" /></td>
											<td><s:property value="#tp.storagePrimary.productType" /></td>
											<td><s:property value="#tp.storagePrimary.sourceType" /></td>
											<td><s:property value="#tp.storagePrimary.ismainstoragePrimary" /></td>
											<td><s:property value="#tp.storagePrimary.groupID" /></td>
											<td><s:property value="#tp.storagePrimary.maAlMeterials" /></td>
											<td><s:property value="#tp.storagePrimary.storagePrimaryNumber" /></td>
										</tr>
										</s:iterator>
										-->
									</tr>
								</tbody>
							</table>
							<div class="pagination">
								<ul id="pagination">
								</ul>
							</div>
						</div>
						</div>
					</div>
				</div>
		</div>
	</div>
	
	<form action="${menu2Id}.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
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
		var id = '${menuId}';
		var menuId = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menuId).attr('url');
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		
		$("select").select2();
		
		//进入指定的tbs
		var tabID = "${tabID}";
		if (null != tabID && "" != tabID) {
			$("#" + tabID).parent().addClass("active");
			$("#" + tabID.substring(0, tabID.length - 4)).removeClass("fade")
					.addClass("active");
		} else {
			tabID = "homeButt";
			$("#tabID").val("homeButt");
			$("#homeButt").parent().addClass("active");
			$("#home").removeClass("fade").addClass("active");
		}
		
		//提交按钮
		$("#formButton").click(function() {
			currTab = $("#tabID").val();
			saveForm();
		});
		
		//判读当前tab，需要保存那个form
		function saveForm() {
			$("#editForm").submit();
		}
		
		//自定义表单控件验证行为
        var checkvalue = function(e){
            var el = e.target;
            var id = el.value;
            selectProducts(id,el);
            e.stopPropagation();
            e.preventDefault();
        }
		
        //定义表单验证方法
        function invalidHandler(evt) {
            checkvalue(evt);
        }
        
        function loadDemo() {
           var myform = document.getElementById("editForm");
           //注册表单的oninvlid事件
           myform.addEventListener("invalid", invalidHandler, true);
          
           //注册表单元素的onchange事件，优化用户体验
           $('#inputId')[0].addEventListener("change",checkvalue,false);
        }
        
        //在页面初始化事件（onload）时注册的自定义事件
        window.addEventListener("load", loadDemo, false);
		
	
		/* 
		$.validator.addMethod("queryProducts",function(value,element,params){
			   return false;
			},"必须是一个字母,且a-f");
 */
		
	</script>
</body>
</html>