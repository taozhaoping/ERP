<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="com.zh.base.util.JspUtil"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
	<jsp:useBean id="userName" class="com.zh.base.util.JspUtil"
		scope="session"></jsp:useBean>
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
			<li class="active" id="navigation"></li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">
					<div>
						<form action="${menu2Id}.jspa?menuId=${menuId}&menu2Id=${menu2Id}"
							id="queryForm" method="post">
							<input id="curPage" name="pageInfo.curPage"
								value="${pageInfo.curPage}" type="hidden" /> <input
								type="hidden" name="spaceId" value="${spaceId}">
							<dir class="row">
								<div class="span5">
									<label class="control-label">供应商： <s:select
											id="inputcustomerID" list="customerList" listKey="id"
											listValue="name" name="purchasingAssistant.customerID"
											cssClass="input-medium" placeholder="供应商">
										</s:select>
								</div>
								<div class="span3">
									<button class="btn" type="button" id="btnSubmit">
										<i class=" icon-search"></i> 搜索
									</button>

									<button class="btn" type="button" id="btnClear">
										<i class="icon-remove"></i> 清除
									</button>
								</div>
							</dir>

							<dir class="row">
								<div class="span5">
									<label class="control-label">开始时间： <input type="text"
										maxlength="25" id="inputstartDate"
										name="purchasingAssistant.startDate"
										value="${purchasingAssistant.startDate}" readonly
										class="form_datetime input-large">
									</label>
								</div>
								<div class="span4">
									<label class="control-label">结束时间： <input type="text"
										maxlength="25" id="inputendDate"
										name="purchasingAssistant.endDate"
										value="${purchasingAssistant.endDate}" readonly
										class="form_datetime input-large">
									</label> </label>
								</div>
							</dir>
						</form>
					</div>
					<div class=".table-responsive" width="1000px" style="overflow: scroll;overflow-y:hidden;">
						<table style="width: 1300px" class="table table-striped table-bordered table-hover js-table" >
							<thead>
								<tr>
									<th >序号</th>
									<th>采购订单</th>
									<th>采购时间</th>
									<th>状态</th>
									<th>入库编号</th>
									<th>仓库</th>
									<th>送货单号</th>
									<th>入库时间</th>
									<th>产品编号</th>
									<th>产品名称</th>
									<th>单位</th>
									<th>采购数量</th>
									<th>入库数量</th>
									<th>单价</th>
									<th>总价</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="purchasingAssistantList" var="tp"
									status="index">
									<tr>
										<td><s:property value="#index.index + 1" /></td>
										<td><s:property value="#tp.purchaseOrderID" /></td>
										<td><s:property value="#tp.purchaseDate" /></td>
										<td><s:property value="#tp.status" /></td>
										<td><s:property value="#tp.orderNoID" /></td>
										<td><s:property value="#tp.warehouseName" /></td>
										<td><s:property value="#tp.deliveryNumber" /></td>
										<td><s:property value="#tp.storagedate" /></td>
										<td><s:property value="#tp.productsID" /></td>
										<td><s:property value="#tp.productsName" /></td>
										<td><s:property value="#tp.measurementCompany" /></td>
										<td><s:property value="#tp.purchaseNumber" /></td>
										<td><s:property value="#tp.storageNumber" /></td>
										<td><s:property value="#tp.price" /></td>
										<td><s:property value="#tp.orderValue" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="pagination">
						<ul id="pagination">
						</ul>
					</div>
			</div>
		</div>
	</div>
	<!-- 
	<form action="${menu2Id}.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
	</form>
	 -->
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
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};

		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
			var headText = $("#" + menu2Id).text();
			$("#menu2Name").text(headText);
			$("#navigation").text(headText);
			//展开一级菜单
			collapseMenu(menuId);

			//提交按钮
			$("#btnSubmit").click(function() {
				$('#curPage').val("1");
				$('#queryForm').submit();
			});

			//清空按钮
			$("#btnClear").click(function() {
				$("#inputcustomerID").val("");
				$("#inputstartDate").val("");
				$("#inputendDate").val("");

				$('#curPage').val("");
			});
			if (totalRow > 0) {
				$.jqPaginator('#pagination', {
					//设置分页的总页数
					totalPages : totalPage,
					//设置分页的总条目数
					totalCounts : totalRow,
					pageSize : pageSize,
					//最多显示的页码
					visiblePages : 10,
					currentPage : curPage,
					onPageChange : function(num, type) {
						if ("init" == type) {
							return false;
						}
						$('#curPage').val(num);
						$('#queryForm').submit();
						//document.getElementsByName("operateForm")[0].submit(); 
					}
				});
			}
		});
	</script>
</body>
</html>