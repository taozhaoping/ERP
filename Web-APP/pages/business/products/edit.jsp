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
					value="products.id!=null&&products.id!=''" />
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
								<li><a id="maillistButt" href="#maillist" data-toggle="tab">产品结构</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<form id="editForm" class="form-horizontal"
										action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="id" value="${products.id}"> <input
									type="hidden" name="menuId" value="${menuId}"> <input
									type="hidden" name="menu2Id" value="${menu2Id}"> <input
									type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputId" style="">产品编号：</label>
											<div class="controls">
												<s:if test="#ProcessId">
													<input type="text" maxlength="20" disabled="disabled"
														id="inputId" value="${products.id}" class="input-medium"></input>
												</s:if>
												<s:else>
													<input type="text" maxlength="20"  name="products.id"
														id="inputId" value="${products.id}" class="input-medium"></input>
												</s:else>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputname" style="">名称：</label>
											<div class="controls">
												<input type="text" data-required="true" maxlength="40"
													placeholder="产品名称" id="inputname" name="products.name"
													value="${products.name}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputlongDegree" style="">长度：</label>
											<div class="controls">
												<input type="number" maxlength="40" name="products.longDegree"
													placeholder="长度" id="inputlongDegree" value="${products.longDegree}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputwideDegree" style="">宽度：</label>
											<div class="controls">
												<input type="number" maxlength="40" name="products.wideDegree"
													placeholder="长度" id="inputwideDegree" value="${products.wideDegree}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputspecifications" style="">规格：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="products.specifications"
													placeholder="规格" id="inputspecifications" value="${products.specifications}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputsurfaceTreatment">表面处理：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="products.surfaceTreatment" 
													placeholder="表面处理" id="inputsurfaceTreatment" value="${products.surfaceTreatment}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputipaint" >颜色：</label>
											<div class="controls">
												<s:select id="inputpaint"  list="paintList" listKey="key" listValue="descr"
													name="products.paint" cssClass="input-medium" placeholder="颜色">
												</s:select>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputenabled" style="">是否油漆：</label>
											<div class="controls">
												<select id="inputenabled" name="products.isPaint" class="input-medium">
													<option value="0">是</option>
													<option value="1">否</option>
												</select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputmeasurementCompany" >计量单位：</label>
											<div class="controls">
												<s:select id="inputmeasurementCompany"  list="dictionaryList" listKey="key" listValue="descr"
													name="products.measurementCompany" cssClass="input-medium" placeholder="计量单位">
												</s:select>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputsourceType" style="">来源：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="products.sourceType"
													placeholder="来源" id="inputsourceType" value="${products.sourceType}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputproductType" >产品类型：</label>
											<div class="controls">
												<s:select id="inputproductType"  list="productTypeList" listKey="key" listValue="descr"
													name="products.productType" cssClass="input-medium" placeholder="产品类型">
												</s:select>
											</div>

										</div>
									</div>
								
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputprocessingFee" >加工费：</label>
											<div class="controls">
												<input type="number" maxlength="20" name="products.processingFee"
													placeholder="加工费" id="inputprocessingFee" value="${products.processingFee}" class="input-medium"></input>
											</div>

										</div>
									</div>
									
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputestimatedPrice" >预估价：</label>
											<div class="controls">
												<input type="number" maxlength="20" name="products.estimatedPrice"
													placeholder="预估价" id="inputestimatedPrice" value="${products.estimatedPrice}" class="input-medium"></input>
											</div>

										</div>
									</div>
								
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputsalesPrice" >销售价：</label>
											<div class="controls">
												<input type="number" maxlength="20" name="products.salesPrice"
													placeholder="销售价" id="inputsalesPrice" value="${products.salesPrice}" class="input-medium"></input>
											</div>

										</div>
									</div>
									
								</dir>
								<dir class="row">
									<div class="span8">
										<div class="control-group">
											<label class="control-label" for="inputsafetyStock" >安全库存：</label>
											<div class="controls">
												<input type="number" maxlength="10" name="products.safetyStock"
													placeholder="安全库存" id="inputsafetyStock" value="${products.safetyStock}" class="input-medium"></input>
											</div>

										</div>
									</div>
								
								</dir>
								<dir class="row">
									<div class="span8">
										<div class="control-group">
											<label class="control-label" for="inputremarks" >备注：</label>
											<div class="controls">
												<input type="text" maxlength="500" name="products.remarks"
													placeholder="备注" id="inputremarks" value="${products.remarks}" class="input-xxlarge"></input>
											</div>

										</div>
									</div>
								
								</dir>
								</form>
							</div>
							<div class="tab-pane fade" id="maillist">
							<form id="mailListForm" class="form-horizontal" action="${menu2Id}!saveMailList.jspa" method="post">
								<input type="hidden" name="menuId" value="${menuId}" /> 
								<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
								<input type="hidden" name="spaceId" value="${spaceId}">
								<input type="hidden" name="formId" value="${products.id}" />
								<input type="hidden" name="tabID" value="maillistButt" />
								<input type="hidden" id="mailListName" name="mailList.name" value="" />
								<input type="hidden" id="mailListPhone" name="mailList.phone" value="" />
								<button class="btn btn-small btn-primary" type="button"
								data-toggle="modal" data-target="#popupfirm">添加产品</button>
							</form>
							<table class="table">
								<thead>
									<tr>
										<th style="width: 32px;">编号</th>
										<th style="width: 240px;">名称</th>
										<th style="width: 200px;">数量</th>
										<th style="width: 240px;">创建时间</th>
										<th>操作</th>
									</tr>
								</thead>
								
								<tbody id="maillistSearch">
									<tr>
										<!-- 产品列表 
										<s:iterator value="mailListList" var="tp" status="index">
										<tr>
											<td><s:property value="#index.index+1" /></td>
											<td><s:property value="#tp.name" /></td>
											<td>
												<s:property value="#tp.phone" />
											</td>
											<td><s:property value="#tp.createdate" /></td>
											<td>
												<a href="${menu2Id}!saveMailList.jspa?id=<s:property value='#tp.id'/>&formId=${franchisee.id}&view=delete&menuId=${menuId}&menu2Id=${menu2Id}&spaceId=${spaceId}&tabID=maillistButt"><i
												class="icon-remove"></i></a>
										</td>
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
	
	<!-- 添加通讯录 -->
	<div class="modal small hide fade" id="popupfirm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="startModalLabel1">人员添加</h3>
		</div>
		<div class="modal-body">
				<dir class="row">
					<div class="span3">
						<div class="control-group">
							<label class="control-label" for="popupName">姓名：</label>
							<div class="controls">
								<input type="text" id="popupName"
								placeholder="姓名" class="input-large">
							</div>
						</div>
					</div>

				</dir>
				<dir class="row">
					<div class="span3">
						<div class="control-group">
							<label class="control-label" for="popupPhone">号码：</label>
							<div class="controls">
								<input type="text" id="popupPhone"
								placeholder="号码" class="input-large">
							</div>
						</div>
					</div>

				</dir>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal"
				id="popupBtnConfirm">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
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
		
		
	</script>
</body>
</html>