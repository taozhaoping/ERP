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
					value="salesOrderPrimary.id!=null&&salesOrderPrimary.id!=''" />
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
									<i class="icon-ok"></i> 审批
								</button>
							</s:if>
						</div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">销售信息</a></li>
							<s:if test="#ProcessId">
							<li><a id="librarydetailButt" href="#librarydetail" data-toggle="tab">销售清单</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<form id="editForm" class="form-horizontal" action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="id" value="${salesOrderPrimary.id}"> 
								<input type="hidden" name="salesOrderPrimary.userID" value="${salesOrderPrimary.userID}">
								<input type="hidden" name="menuId" value="${menuId}"> 
								<input type="hidden" name="menu2Id" value="${menu2Id}"> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputorderNoID" style="">消耗单号：</label>
											<div class="controls">
													<input type="text" maxlength="30" disabled="disabled"
														id="inputorderNoID" value="${salesOrderPrimary.orderID}" class="input-medium"></input>
												
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputcontractNumber" style="">合同单号：</label>
											<div class="controls">
												<input size="16" id="inputcontractNumber" name="salesOrderPrimary.contractNumber"
													type="text" data-required="true"
													value="${salesOrderPrimary.contractNumber}"
													class="input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputuserID" style="">创建人：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="salesOrderPrimary.userID" disabled="disabled"
													placeholder="创建人" id="inputuserID" value="<%=userName.queryCustomer(String.valueOf(request.getAttribute("salesOrderPrimary.userID"))) %>" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputpaymentTerm" style="">付款方式：</label>
											<div class="controls">
												<s:select id="inputpaymentTerm"  list="customerList" listKey="id" listValue="name"
													name="salesOrderPrimary.paymentTerm" cssClass="input-medium" placeholder="发货客户">
												</s:select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputcurrencyPayment" style="">付款货币：</label>
											<div class="controls">
												<s:select id="inputcurrencyPayment" data-required="true"  list="warehouseList" listKey="id" listValue="name"
													name="salesOrderPrimary.currencyPayment" cssClass="input-medium" placeholder="发货仓库">
												</s:select>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputinspection" style="">检查日期：</label>
											<div class="controls">
												<input size="16" id="inputinspection" name="salesOrderPrimary.inspection"
													type="text" data-required="true"
													value="${salesOrderPrimary.inspection}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputlrddate" style="">进港日期：</label>
											<div class="controls">
												<input size="16" id="inputlrddate" name="salesOrderPrimary.lrddate"
													type="text" data-required="true"
													value="${salesOrderPrimary.lrddate}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputcontainerType" style="">集装箱号：</label>
											<div class="controls">
												<input size="16" id="inputcontainerType" name="salesOrderPrimary.containerType"
													type="text" data-required="true"
													value="${salesOrderPrimary.containerType}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputloadingPort" style="">装货港口：</label>
											<div class="controls">
												<input size="16" id="inputloadingPort" name="salesOrderPrimary.loadingPort"
													type="text" data-required="true"
													value="${salesOrderPrimary.loadingPort}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputdischargePort" style="">卸货港口：</label>
											<div class="controls">
												<input size="16" id="inputdischargePort" name="salesOrderPrimary.dischargePort"
													type="text" data-required="true"
													value="${salesOrderPrimary.dischargePort}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputloadingPort" style="">状态：</label>
											<div class="controls">
												<select id="inputstatus"  disabled="disabled" list=""
													name="storagePrimary.status" class="input-medium" placeholder="是否入库" >
													<option value="0">未审批</option>
													<option value="1">审批</option>
												</select>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputprice" style="">总价：</label>
											<div class="controls">
												<input size="16" id="inputprice" name="salesOrderPrimary.price"
													type="text" data-required="true"
													value="${salesOrderPrimary.price}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span8">
										<div class="control-group">
											<label class="control-label" for="inputremarks" >备注：</label>
											<div class="controls">
												<input type="text" maxlength="500" name="salesOrderPrimary.remarks"
													placeholder="备注" id="inputremarks" value="${salesOrderPrimary.remarks}" class="input-xxlarge"></input>
											</div>

										</div>
									</div>
								
								</dir>
								</form>
							</div>
							<div class="tab-pane fade" id="librarydetail">
								<form id="libraryDetailForm" class="form-horizontal" action="${menu2Id}!saveLibraryDetail.jspa" method="post">
								<input type="hidden" name="menuId" value="${menuId}" /> 
								<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<input type="hidden" name="tabID" value="librarydetailButt" />
								<input type="hidden" name="formId" value="${salesOrderPrimary.id}" />
								<input type="hidden" id="detailsalesOrderPrimaryID" name="libraryDetail.salesOrderPrimaryID" value="${salesOrderPrimary.id}" />
								<input type="hidden" id="detailproductsID" name="libraryDetail.productsID" value="" />
								<input type="hidden" id="detailqty" name="libraryDetail.storageNumber" value="" />
								<input type="hidden" id="detailuse" name="libraryDetail.use" value="" />
								<input type="hidden" id="detailremarks" name="libraryDetail.remarks" value="" />
										<button class="btn btn-small btn-primary" type="button"
										data-toggle="modal" data-target="#popupfirm">添加产品</button>
							</form>
							<table class="table ">
								<thead>
									<tr>
										<th>序号</th>
										<th>产品编号</th>
										<th>产品名称</th>
										<th>出库数量</th>
										<th>库存量</th>
										<th>用途</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								
								<tbody id="maillistSearch">
									<tr>
										<!-- 产品列表-->
										<!-- <s:iterator value="libraryDetailList" var="tp" status="index">
										<tr>
											<td><s:property value="#index.index +1" /></td>
											<td><s:property value="#tp.productsID" /></td>
											<td><s:property value="#tp.productsName" /></td>
											<td><s:property value="#tp.storageNumber" /></td>
											<td>
												<s:if test="#tp.storageNumber > #tp.stockNumber">
													<span style="color: red">
												</s:if>
												<s:else>
													<span>
												</s:else>
														<s:property value="#tp.stockNumber" />
													</span>
											</td>
											<td><s:property value="#tp.use" /></td>
											<td><s:property value="#tp.remarks" /></td>
											<td>
												<a title="状态" href="${menu2Id}!saveLibraryDetail.jspa?id=<s:property value='#tp.id'/>&formId=${salesOrderPrimary.id}&menuId=${menuId}&menu2Id=${menu2Id}&spaceId=${spaceId}&tabID=librarydetailButt"><i
												class="icon-remove"></i></a>
											</td>
										</tr>
										</s:iterator> -->
										
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
	
	<!-- 添加产品 -->
	<div class="modal small hide fade" id="popupfirm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="startModalLabel1">产品添加</h3>
		</div>
		<div class="modal-body">
			 	
				<dir class="row">
					<div class="span3">
						<div class="control-group">
							<label class="control-label" for="popupProductsID">产品编号：</label>
							<div class="controls">
								<input id="popupProductsID" class="input-large">
								</input>
							</div>
						</div>
					</div>

				</dir>
				<dir class="row">
					<div class="span3">
						<div class="control-group">
							<label class="control-label" for="popupQty">数量：</label>
							<div class="controls">
								<input type="text" id="popupQty" 
								placeholder="数量" class="input-large">
							</div>
						</div>
					</div>

				</dir>
				<dir class="row">
					<div class="span3">
						<div class="control-group">
							<label class="control-label" for="popupUse">用途：</label>
							<div class="controls">
								<input type="text" id="popupUse"
								placeholder="备注" class="input-large">
							</div>
						</div>
					</div>
				</dir>
				<dir class="row">
					<div class="span3">
						<div class="control-group">
							<label class="control-label" for="popupRemarks">备注：</label>
							<div class="controls">
								<input type="text" id="popupRemarks"
								placeholder="备注" class="input-large">
							</div>
						</div>
					</div>

				</dir>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-loading-text="正在保存"
				id="popupBtnConfirm">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
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
				<i class="icon-warning-sign modal-icon "></i>当前单据更新到库存后将不可更改.继续请按."更新" 否则请按 "取消"
			</p>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal"
				id="formChangefirmBtn">更新</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<form action="${menu2Id}.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
	</form>
	
	<form action="${menu2Id}!increaseStock.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="increaseStockForm" method="post">
		<input id="formId" name="formId" value="${salesOrderPrimary.id}" type="hidden"/>
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
		var id = '${salesOrderPrimary.id}';
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		$("select").select2();
		
		$("#inputstatus").val("${salesOrderPrimary.status}")
		.trigger("change");
		
		$("#formChangefirmBtn").click(function() {
			$("#increaseStockForm").submit();
		});
		
		$("#popupProductsID").select2({
			placeholder : "查询产品编号",
			minimumInputLength : 3,
			//multiple:true,
			quietMillis : 3000,
			ajax : {
				url : basePath + "/interface/interfaceProducts!queryProductsList.jspa",
				dataType : 'json',
				data : function(term, page) {
					return {
						"productsID" : term,
						"pageInfo.curPage" : page
					};
				},
				results : function(data, page) {
					
					var more = (page * 10) < data.total;
					for ( var i = 0; i < data.rows.length; i++) {
						var parts = data.rows[i];
						parts.id = parts.id;
						parts.text = parts.id + "(" + parts.name + ")";
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
		
		
		$("#popupBtnConfirm").click(function(x) {
			var _ProductsID = $("#popupProductsID").val();
			var _Qty = $("#popupQty").val();
			var _Use = $("#popupUse").val();
			var _Remarks = $("#popupRemarks").val();
			
			var ProductsID = $.trim(_ProductsID);
			var Qty = $.trim(_Qty);
			var Use = $.trim(_Use);
			var Remarks = $.trim(_Remarks);
			if (ProductsID == null || ProductsID == "") {
				$("#popupBtnConfirml").attr("title","产品编号必须选择 !");
				return;
			} 
			if (Qty == null || Qty == "") {
				$("#popupQty").attr("title","入库数量必须填写!");
				return;
			}
			
			
			$("#detailproductsID").val(ProductsID);
			$("#detailqty").val(Qty);
			$("#detailuse").val(Use);
			$("#detailremarks").val(Remarks);
			$('#popupfirm').modal('hide')
			$("#libraryDetailForm").submit();
	});
		
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