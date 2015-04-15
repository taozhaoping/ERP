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
					value="storagePrimary.id!=null&&storagePrimary.id!=''" />
		<div class="container-fluid">
				<input type="hidden" id="formChanged" name="formChanged" value="0" />
				<div class="row-fluid">

					<div class="btn-toolbar">
						
						<a class="btn" id="backList" href=""> 返回</a>
						<div class="btn-group"></div>
						
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<li><a id="storagedetailButt" href="#storagedetail" data-toggle="tab">入库清单</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active" id="home">
								<form id="editForm" class="form-horizontal" method="post">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputorderNoID" style="">入库单号：</label>
											<div class="controls">
													<input type="text" maxlength="30" readonly="readonly"
														id="inputorderNoID" value="${storagePrimary.orderNoID}" class="input-medium"></input>
												
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputstoragedate" style="">入库时间：</label>
											<div class="controls">
												<input size="16" id="inputstoragedate" name="storagePrimary.storagedate"
													type="text" readonly="readonly"
													value="${storagePrimary.storagedate}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputuserID" >收货人：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="storagePrimary.userID" readonly="readonly"
													 id="inputuserID" value="<%=userName.queryUserName(String.valueOf(request.getAttribute("storagePrimary.userID"))) %>" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputcustomerID" style="">发货客户：</label>
											<div class="controls">
												<s:select id="inputcustomerID"  list="customerList" listKey="id" listValue="name" disabled="disabled"
													name="storagePrimary.customerID" cssClass="input-medium">
												</s:select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputwarehouseID" style="">收入仓库：</label>
											<div class="controls">
												<s:select id="inputwarehouseID" data-required="true"  list="warehouseList" listKey="id" listValue="name"
													name="storagePrimary.warehouseID" cssClass="input-medium" disabled="disabled">
												</s:select>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputstatus" style="">入库：</label>
											<div class="controls">
												<select id="inputstatus"  disabled="disabled"
													name="storagePrimary.status" class="input-medium" placeholder="是否入库">
													<option value="0">否</option>
													<option value="1">是</option>
												</select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span8">
										<div class="control-group">
											<label class="control-label" for="inputremarks" >备注：</label>
											<div class="controls">
												<input type="text" maxlength="500" name="storagePrimary.remarks"
													placeholder="备注" id="inputremarks" value="${storagePrimary.remarks}" class="input-xxlarge"></input>
											</div>

										</div>
									</div>
								
								</dir>
								</form>
							</div>
							<div class="tab-pane fade" id="storagedetail">
				
							<table class="table ">
								<thead>
									<tr>
									<th>序号</th>
										<th>产品编号</th>
										<th>产品名称</th>
										<th>入库数量</th>
										<th>用途</th>
										<th>备注</th>
									</tr>
								</thead>
								
								<tbody id="maillistSearch">
									<tr>
										<!-- 产品列表-->
										<s:iterator value="StorageDetailList" var="tp" status="index">
										<tr>
											<td><s:property value="#index.index +1" /></td>
											<td><s:property value="#tp.productsID" /></td>
											<td><s:property value="#tp.productsName" /></td>
											<td><s:property value="#tp.storageNumber" /></td>
											<td><s:property value="#tp.use" /></td>
											<td><s:property value="#tp.remarks" /></td>
										</tr>
										</s:iterator>
										
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
		$("#inputstatus").val("${storagePrimary.status}")
		.trigger("change");
		
		$.jqPaginator('#pagination', {
			//设置分页的总页数
	        totalPages: totalPage,
	        //设置分页的总条目数
	        totalCounts:totalRow,
	        pageSize:pageSize,
	        //最多显示的页码
	        visiblePages: 10,
	        currentPage: curPage,
	        onPageChange: function (num, type) {
	           if("init"==type)
	        	{
	        	 	return false;  
	        	}
	           $('#curPage').val(num);
	        	$('#queryForm').submit();
	        	//document.getElementsByName("operateForm")[0].submit(); 
	        }
	    });
	</script>
</body>
</html>