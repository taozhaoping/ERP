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
					value="processingSinglePrimary.id!=null&&processingSinglePrimary.id!=''" />
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
									<i class="icon-ok"></i> 审核
								</button>
							</s:if>
						</div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<s:if test="#ProcessId">
							<li><a id="processButt" href="#process" data-toggle="tab">加工产品</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<form id="editForm" class="form-horizontal" action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="id" value="${processingSinglePrimary.id}"> 
								<input type="hidden" name="menuId" value="${menuId}"> 
								<input type="hidden" name="menu2Id" value="${menu2Id}"> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputProcessingSingleId" style="">加工单号：</label>
											<div class="controls">
													<input type="text" maxlength="30" disabled="disabled"
														id="inputProcessingSingleId" value="${processingSinglePrimary.processingSingleId}" class="input-medium"></input>
												
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputPurchaseOrderId" style="">销售订单：</label>
											<div class="controls">
												<s:if test="#ProcessId">
													<input type="text" maxlength="30" disabled="disabled"
														id="inputPurchaseOrderId" name="processingSinglePrimary.purchaseOrderId" value="${processingSinglePrimary.purchaseOrderId}" class="input-large"></input>
												</s:if>
												<s:else>
													<s:select id="inputcustomerId"  list="salesOrderPrimaryList" data-required="true" listKey="id" listValue="orderID"
														name="processingSinglePrimary.purchaseOrderId" cssClass="input-large" placeholder="销售订单">
													</s:select>
												</s:else>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputStatus" style="">状态：</label>
											<div class="controls">
												<select id="inputStatus"  disabled="disabled"
													name="processingSinglePrimary.status" class="input-medium" placeholder="状态" >
													<option value="0">发起</option>
													<option value="1">审核</option>
													<option value="2">完成</option>
												</select>
												<!-- 
												<input type="text" maxlength="40" name="processingSinglePrimary.status" disabled="disabled"
													placeholder="状态" id="inputStatus" value="${processingSinglePrimary.status}" class="input-medium"></input>
												 -->
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputCreateDate" style="">创建时间：</label>
											<div class="controls">
												<input size="16" id="inputCreateDate" name="processingSinglePrimary.createDate"
													type="text" 
													value="${processingSinglePrimary.createDate}"
													readonly class="input-medium">
											</div>
										</div>
									</div>
								</dir>
								
								<dir class="row">
									<div class="span8">
										<div class="control-group">
											<label class="control-label" for="inputremarks" >备注：</label>
											<div class="controls">
												<input type="text" maxlength="500" name="processingSinglePrimary.remarks"
													placeholder="备注" id="inputremarks" value="${processingSinglePrimary.remarks}" class="input-xxlarge"></input>
											</div>

										</div>
									</div>
								
								</dir>
								</form>
							</div>
							
							<div class="tab-pane fade" id="process">
								<table class="table ">
									<thead>
										<tr>
											<th>序号</th>
											<th>生产物料</th>
											<th>生产数量</th>
											<th>主料/替代料</th>
											<th>主料编号</th>
											<th>层级</th>
											<th>生产时间</th>
											<th>结束时间</th>
											<th>生产</th>
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
												<td>
													<s:if test='#tp.mainsub=="Y"'>
														主料
													</s:if>
													<s:elseif test='#tp.mainsub=="N"'>
														替代料
													</s:elseif>
												</td>
												<td><s:property value="#tp.mainProductsID" /></td>
												<td>
													<s:if test="#tp.tier==0">
														成品
													</s:if>
													<s:else>
														半成品
													</s:else>
												</td>
												<td>
													<input size="16" id="inputStartDate" FID="${tp.id}" name="tp.startDate"
													type="text" value="<s:date name="#tp.startDate" format="yyyy-MM-dd"/>" onchange="changeQuantiy(this,'start')"
													readonly class="form_datetime input-medium">
												</td>
												<td>
													<input size="16" id="inputEndDate" FID="${tp.id}" name="tp.changeQuantiy"
													type="text" value="<s:date name="#tp.endDate" format="yyyy-MM-dd"/>" onchange="changeQuantiy(this,'end')"
													readonly class="form_datetime input-medium">
												</td>
												<td>
													<s:if test="#tp.productionMark==0">
														<a title="生产标示" style="margin: 0px 3px;"><i class="icon-ok"></i></a> 
													</s:if>
													<s:else>
														<i class="icon-remove"></i>
													</s:else>
												</td>
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
	
	<div class="modal small hide fade" id="forMchangefirm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">提示</h3>
		</div>
		<div class="modal-body">
			<p class="error-text">
				<i class="icon-warning-sign modal-icon "></i>当前单据审核后将不可更改.继续请按."审核" 否则请按 "取消"
			</p>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal"
				id="formChangefirmBtn">审核</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<form action="${menu2Id}!editor.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
		<input type="hidden" name="id" value="${processingSinglePrimary.id}">
		<input type="hidden" name="tabID" value="storageButt">
	</form>
	
	<form action="${menu2Id}!increaseProcessingSingle.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="increaseStockForm" method="post">
		<input id="formId" name="formId" value="${processingSinglePrimary.id}" type="hidden"/>
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
		var id = '${processingSinglePrimary.id}';
		var url = $("#" + menu2Id).attr('url');
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		$("select").select2();
		
		$("#inputstatus").val("${processingSinglePrimary.status}")
		.trigger("change");
		
		function changeQuantiy(obj,type)
		{
			var changeValue = $(obj).val()
			var changeID = $(obj).attr("FID");
			var data;
			if(type == "start")
			{
				data = {"id":changeID,
						"startDate":changeValue};
			}else
			{
				data = {"id":changeID,
						"endDate":changeValue};
			}
			$.ajax({
				   type: "POST",
				   url: basePath + "/" + spaceId + "/" + menu2Id + "!saveProcessingSingleDetail.jspa",
				   data: data,
				   success: function(msg){
				     if(msg.reult=="success")
				    {
				    	$(obj).parents("tr").addClass("success")
				    }else
				    {
				    	$(obj).parents("tr").addClass("error")
				    	$(obj).val(oldValue);
				    }
				   }
				}); 
		}
		
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
		
		$("#formChangefirmBtn").click(function() {
			$("#increaseStockForm").submit();
		});
		
		//提交按钮
		$("#formButton").click(function() {
			currTab = $("#tabID").val();
			saveForm();
		});
		
		//判读当前tab，需要保存那个form
		function saveForm() {
			$("#editForm").submit();
		}
		
		if ("" != id)
		{
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
		}
	</script>
</body>
</html>