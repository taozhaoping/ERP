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
						<button id="formButton" class="btn btn-primary" type="submit">
							<i class="icon-save"></i> 保存
						</button>
						<a class="btn" id="backList" href=""> 返回</a>
						<div class="btn-group"></div>
						<div class="pull-right">
							<s:if test="#ProcessId">
								<button class="btn btn-danger" type="button" id="approveBtn"
								data-toggle="modal" data-target="#forMchangefirm">
									<i class="icon-ok"></i> 入库
								</button>
							</s:if>
						</div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<s:if test="#ProcessId">
							<li><a id="storageButt" href="#storage" data-toggle="tab">入库清单</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<form id="editForm" class="form-horizontal" action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="id" value="${storagePrimary.id}"> 
								<input type="hidden" name="storagePrimary.userID" value="${storagePrimary.userID}">
								<input type="hidden" name="menuId" value="${menuId}"> 
								<input type="hidden" name="menu2Id" value="${menu2Id}"> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputorderNoID" style="">入库单号：</label>
											<div class="controls">
													<input type="text" maxlength="30" disabled="disabled"
														id="inputorderNoID" value="${storagePrimary.orderNoID}" class="input-medium"></input>
												
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputstoragedate" style="">入库时间：</label>
											<div class="controls">
												<input size="16" id="inputstoragedate" name="storagePrimary.storagedate"
													type="text" data-required="true"
													value="${storagePrimary.storagedate}"
													readonly class="form_datetime input-medium">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputuserID" style="">收货人：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="storagePrimary.userID" disabled="disabled"
													placeholder="收货人" id="inputuserID" value="<%=userName.queryUserName(String.valueOf(request.getAttribute("storagePrimary.userID"))) %>" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputcustomerID" style="">发货客户：</label>
											<div class="controls">
												<s:select id="inputcustomerID"  list="customerList" listKey="id" listValue="name"
													name="storagePrimary.customerID" cssClass="input-medium" placeholder="发货客户">
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
													name="storagePrimary.warehouseID" cssClass="input-medium" placeholder="收入仓库">
												</s:select>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputstatus" style="">入库：</label>
											<div class="controls">
												<select id="inputstatus"  disabled="disabled" list=""
													name="storagePrimary.status" class="input-medium" placeholder="是否入库" >
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
							<div class="tab-pane fade" id="storage">
								<form id="storageDetailForm" class="form-horizontal" action="${menu2Id}!saveStorageDetail.jspa" method="post">
								<input type="hidden" name="menuId" value="${menuId}" /> 
								<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<input type="hidden" name="tabID" value="storageButt" />
								<input type="hidden" name="formId" value="${storagePrimary.id}" />
								<input type="hidden" id="detailstoragePrimaryID" name="storageDetail.storagePrimaryID" value="${storagePrimary.id}" />
								<input type="hidden" id="detailproductsID" name="storageDetail.productsID" value="" />
								<input type="hidden" id="detailqty" name="storageDetail.storageNumber" value="" />
								<input type="hidden" id="detailuse" name="storageDetail.use" value="" />
								<input type="hidden" id="detailremarks" name="storageDetail.remarks" value="" />
										<button class="btn btn-small btn-primary" type="button"
										data-toggle="modal" data-target="#popupfirm">添加产品</button>
							</form>
							<table class="table ">
								<thead>
									<tr>
									<th>序号</th>
										<th>产品编号</th>
										<th>产品名称</th>
										<th>入库数量</th>
										<th>用途</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								
								<tbody id="maillistSearch">
									<tr>
										<!-- 产品列表-->
										<s:iterator value="storageDetailList" var="tp" status="index">
										<tr>
											<td><s:property value="#index.index +1" /></td>
											<td><s:property value="#tp.productsID" /></td>
											<td><s:property value="#tp.productsName" /></td>
											<td><s:property value="#tp.storageNumber" /></td>
											<td><s:property value="#tp.use" /></td>
											<td><s:property value="#tp.remarks" /></td>
											<td>
												<a title="状态" href="${menu2Id}!saveStorageDetail.jspa?id=<s:property value='#tp.id'/>&formId=${storagePrimary.id}&menuId=${menuId}&menu2Id=${menu2Id}&spaceId=${spaceId}&tabID=storageButt"><i
												class="icon-remove"></i></a>
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
								<input id="popupProductsID" data-required="true" class="input-large">
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
								<input type="text" id="popupQty" data-required="true"
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
	
	<form action="${menu2Id}!editor.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="queryForm" method="post">
		<input id="curPage" name="pageInfo.curPage" value="${pageInfo.curPage}" type="hidden"/>
		<input type="hidden" name="spaceId" value="${spaceId}">
		<input type="hidden" name="id" value="${storagePrimary.id}">
		<input type="hidden" name="tabID" value="storageButt">
	</form>
	
	<form action="${menu2Id}!increaseStock.jspa?menuId=${menuId}&menu2Id=${menu2Id}" id="increaseStockForm" method="post">
		<input id="formId" name="formId" value="${storagePrimary.id}" type="hidden"/>
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
		var id = '${storagePrimary.id}';
		var url = $("#" + menu2Id).attr('url');
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		$("select").select2();
		
		$("#inputstatus").val("${storagePrimary.status}")
		.trigger("change");
		
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
		
		$("#popupProductsID").select2({
			placeholder : "查询产品编号",
			minimumInputLength : 5,
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
				$("#popupProductsID").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else
			{
				$("#popupProductsID").closest('div').parents('div').removeClass('error').addClass('success');
			}
			
			if (Qty == null || Qty == "") {
				$("#popupQty").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			}else
			{
				$("#popupQty").closest('div').parents('div').removeClass('error').addClass('success');
			}
			
			
			$("#detailproductsID").val(ProductsID);
			$("#detailqty").val(Qty);
			$("#detailuse").val(Use);
			$("#detailremarks").val(Remarks);
			$('#popupfirm').modal('hide')
			$("#storageDetailForm").submit();
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