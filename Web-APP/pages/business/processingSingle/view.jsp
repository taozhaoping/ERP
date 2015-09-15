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
			<li class="active">查看</li>
		</ul>
		<s:set name="ProcessId"
					value="processingSinglePrimary.id!=null&&processingSinglePrimary.id!=''" />
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
							<li><a id="storagedetailButt" href="#storagedetail" data-toggle="tab">加工产品</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<dl class="tab-pane fade dl-horizontal" id="home">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<dt>加工单号：</dt>
											<dd>${processingSinglePrimary.processingSingleId}</dd>
										</div>
									</div>
									
									<div class="span4">
										<div class="control-group">
											<dt>销售订单：</dt>
											<dd>
												<dd>${processingSinglePrimary.purchaseOrderId}</dd>
											</dd>
										</div>
									</div>
								</dir>
								
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<dt>状态：</dt>
											<dd>
												<s:if test="0 == processingSinglePrimary.status">发起</s:if>
												<s:elseif test="1 == processingSinglePrimary.status">审核</s:elseif>
												<s:elseif test="2 == processingSinglePrimary.status">完成</s:elseif>
											</dd>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<dt>创建时间：</dt>
											<dd>${processingSinglePrimary.createDate}</dd>
										</div>
									</div>
								</dir>
								
								<dir class="row">
									<div class="span8">
										<div class="control-group">
											<dt>备注：</dt>
											<dd>${processingSinglePrimary.remarks}</dd>
										</div>
									</div>
								</dir>
							</dl>
							
							<div class="tab-pane fade" id="storagedetail">
								<table class="table ">
									<thead>
										<tr>
											<th>序号</th>
											<th>物料</th>
											<th>数量</th>
											<th>生产时间</th>
											<th>结束时间</th>
										</tr>
									</thead>
									
									<tbody id="maillistSearch">
										<tr>
											<!-- 产品列表-->
											<s:iterator value="processingSingleDetailList" var="tp" status="index">
											<tr>
												<td><s:property value="#index.index +1" /></td>
												<td><s:property value="#tp.productsId" /></td>
												<td><s:property value="#tp.processingNumber" /></td>
												<td><s:date name="#tp.startDate" format="yyyy-MM-dd"/></td>
												<td><s:date name="#tp.endDate" format="yyyy-MM-dd"/></td>
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

	<form action="${menu2Id}!editor.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
		<input type="hidden" name="view" value="view">
		<input type="hidden" name="id" value="${processingSinglePrimary.id}">
		<input type="hidden" name="tabID" value="storagedetailButt">
	</form>
	<%@ include file="/pages/common/footer.jsp"%>
	<script src="<%=path%>/js/bootstrap.js"></script>
	<script src="<%=path%>/js/collapsePulg.js"></script>
	<script src="<%=path%>/js/querycommon.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		var menuId = '${menuId}';
		var menu2Id = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menu2Id).attr('url');
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		var tabID = "${tabID}";
		
	</script>
</body>
</html>