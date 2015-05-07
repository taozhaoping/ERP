<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/theme.css">
<link rel="stylesheet" href="<%=path%>/css/font-awesome.css">
<link rel="stylesheet" href="<%=path%>/js/select2/select2.css">
<link rel="stylesheet" href="<%=path%>/js/datetimepicker/bootstrap-datetimepicker.css">
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
<link href="<%=path%>/img/favicon_32.ico" rel="bookmark" type="image/x-icon" />
<link href="<%=path%>/img/favicon_32.ico" rel="icon" type="image/x-icon" />
<link href="<%=path%>/img/favicon_32.ico" rel="shortcut icon" type="image/x-icon" />
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
							<s:if test="bomPrimary.productsId">
								<button class="btn btn-danger" type="button" id="approveBtn" data-toggle="modal" data-target="#forMchangefirm">
									<i class="icon-ok"></i> 审核
								</button>
							</s:if>
						</div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<s:if test="bomPrimary.productsId">
								<li><a id="productStructTabButt" href="#productStructTab" data-toggle="tab">产品结构</a></li>
								<li><a id="productStructSubTabButt" href="#productStructSubTab" data-toggle="tab">替代料</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<form id="editForm" class="form-horizontal" action="${menu2Id}!save.jspa" method="post">
								<input type="hidden" name="bomPrimary.id" value="${bomPrimary.id}">
								<input type="hidden" name="menuId" value="${menuId}">
								<input type="hidden" name="menu2Id" value="${menu2Id}">
								<input type="hidden" name="spaceId" value="${spaceId}">
								
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputId" style="">产品编号：</label>
											<div class="controls">
												<s:if test="bomPrimary.productsId">
												<input type="text" maxlength="20" name="bomPrimary.productsId" data-required="true" readonly="readonly" value="${bomPrimary.productsId}" class="input-medium input-xlarge"></input>
												</s:if>
												<s:else>
												<input type="text" maxlength="20" name="bomPrimary.productsId" data-required="true" id="inputProductsId" value="${bomPrimary.productsId}" class="input-medium input-xlarge"></input>
												</s:else>
											</div>

										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputname" style="">描述：</label>
											<div class="controls">
												<input type="text" data-required="true" maxlength="40" data-required="true" 
													placeholder="描述" id="inputDescr" name="bomPrimary.descr"
													value="${bomPrimary.descr}" class="input-medium input-xlarge"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputlongDegree">生效日期：</label>
											<div class="controls">
												<input size="16" id="inputEffdt" data-required="true" name="bomPrimary.effdt" type="text"
													readonly="readonly" value="${bomPrimary.effdt}" class="form_datetime input-xlarge">
											</div>

										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputwideDegree">生效状态：</label>
											<div class="controls">
												<s:if test="#bomPrimary.effStatus == 1">
													<input type="text" maxlength="40" name="bomPrimary.effStatus" disabled="disabled"
														placeholder="生效状态" id="inputEffStatus" value="已生效" class="input-medium input-xlarge"></input>
												</s:if>
												<s:else>
													<input type="text" maxlength="40" name="bomPrimary.effStatus" disabled="disabled"
														placeholder="生效状态" id="inputEffStatus" value="未生效" class="input-medium input-xlarge"></input>
												</s:else>
											</div>
										</div>
									</div>
								</dir>
								</form>
							</div>
							
							<div class="tab-pane fade" id="productStructTab">
								<form id="productStructDetailForm" class="form-horizontal" action="${menu2Id}!saveDetail.jspa" method="post">
									<input type="hidden" name="menuId" value="${menuId}" /> 
									<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
									<input type="hidden" name="spaceId" value="${spaceId}">
									<input type="hidden" name="bomDetail.primaryId" value="${bomPrimary.id}">
									<!-- 
									<input type="hidden" name="bomDetail.id" value="${bomDetail.id}">
									 -->
									<input type="hidden" name="tabID" value="productStructTabButt" />
									
									<input type="hidden" name="bomDetail.id" id="bomDetailId" value="">
									<input type="hidden" name="bomDetail.subProductsId" id="bomDetailSubProductsId" value="">
									<input type="hidden" name="bomDetail.isMainProducts" id="bomDetailIsMainProducts" value="">
									<input type="hidden" name="bomDetail.qty" id="bomDetailQty" value="">
									<input type="hidden" name="bomDetail.remarks" id="bomDetailRemarks" value="">
									<button class="btn btn-small btn-primary" type="button" data-toggle="modal" data-target="#popupfirm">添加组件</button>
								</form>
								
								<form id="productStructDetailDelForm" class="form-horizontal" action="${menu2Id}!deleteDetail.jspa" method="post">
									<input type="hidden" name="menuId" value="${menuId}" /> 
									<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
									<input type="hidden" name="spaceId" value="${spaceId}">
									<input type="hidden" name="bomDetail.primaryId" value="${bomPrimary.id}">
									
									<input type="hidden" name="tabID" value="productStructTabButt" />
									
									<input type="hidden" name="bomDetail.id" id="delFormBomDetailId" value="">
									<input type="hidden" name="bomDetail.subProductsId" id="delFormBomDetailSubProductsId" value="">
								</form>
								<table class="table">
									<thead>
										<tr>
											<th>组件编号</th>
											<th>名称</th>
											<th>主产品</th>
											<th>数量</th>
											<th>备注</th>
											<th style="width: 60px;">操作</th>
										</tr>
									</thead>
									
									<tbody id="maillistSearch">
										<!-- 产品列表 -->
										<s:iterator value="bomDetailList" var="tp" status="index">
										<tr>
											<td><s:property value="#tp.subProductsId" /></td>
											<td><s:property value="#tp.subProductsName" /></td>
											<td>
												<s:if test="#tp.isMainProducts == 0">
													否
												</s:if>
												<s:elseif test="#tp.isMainProducts == 1">
													是
												</s:elseif>
											</td>
											<td><s:property value="#tp.qty" /></td>
											<td><s:property value="#tp.remarks" /></td>
											<td>
												<a title="添加替代料" style="margin: 0px 3px;" href="javascript:addSub('<s:property value="#tp.primaryId" />', '<s:property value="#tp.subProductsId" />');"><i class="icon-plus"></i></a>
												<a title="修改" style="margin: 0px 3px;" href="javascript:editDetail('<s:property value="#tp.id" />','<s:property value="#tp.subProductsId" />','<s:property value="#tp.isMainProducts" />','<s:property value="#tp.qty" />','<s:property value="#tp.remarks" />');"><i class="icon-pencil"></i></a>
												<a title="删除" style="margin: 0px 3px;" href="javascript:deleteDetail('<s:property value="#tp.id" />','<s:property value="#tp.subProductsId" />');"><i class="icon-remove"></i></a>
											</td>
										</tr>
										</s:iterator>
									</tbody>
								</table>
								<div class="pagination">
									<ul id="pagination">
									</ul>
								</div>
							</div>
							
							<div class="tab-pane fade" id="productStructSubTab">
								<form id="productStructSubForm" class="form-horizontal" action="${menu2Id}!saveSub.jspa" method="post">
									<input type="hidden" name="menuId" value="${menuId}" /> 
									<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
									<input type="hidden" name="spaceId" value="${spaceId}">
									<input type="hidden" name="bomSub.primaryId" value="${bomPrimary.id}">
								
									<input type="hidden" name="tabID" value="productStructSubTabButt" />
									
									<input type="hidden" name="bomSub.id" id="bomSubId" value="">
									<input type="hidden" name="bomSub.subProductsId" id="bomSubProductsId" value="">
									<input type="hidden" name="bomSub.mainProductsId" id="bomMainProductsId" value="">
									<input type="hidden" name="bomSub.qty" id="bomSubQty" value="">
									<input type="hidden" name="bomSub.remarks" id="bomSubRemarks" value="">
								</form>
								
								<form id="productStructSubDelForm" class="form-horizontal" action="${menu2Id}!deleteSub.jspa" method="post">
									<input type="hidden" name="menuId" value="${menuId}" /> 
									<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
									<input type="hidden" name="spaceId" value="${spaceId}">
									<input type="hidden" name="bomSub.primaryId" value="${bomPrimary.id}">
									
									<input type="hidden" name="tabID" value="productStructSubTabButt" />
									
									<input type="hidden" name="bomSub.id" id="delFormBomSubId" value="">
								</form>
								<table class="table">
									<thead>
										<tr>
											<th>主料编号</th>
											<th>替代料编号</th>
											<th>替代料名称</th>
											<th>替代料数量</th>
											<th>替代料备注</th>
											<th style="width: 40px;">操作</th>
										</tr>
									</thead>
									
									<tbody id="maillistSearch">
										<!-- 替代料列表 -->
										<s:iterator value="bomSubList" var="tp" status="index">
										<tr>
											<td><s:property value="#tp.mainProductsId" /></td>
											<td><s:property value="#tp.subProductsId" /></td>
											<td><s:property value="#tp.subProductsName" /></td>
											<td><s:property value="#tp.qty" /></td>
											<td><s:property value="#tp.remarks" /></td>
											<td>
												<a title="修改" style="margin: 0px 3px;" href="javascript:editSub('<s:property value="#tp.id" />','<s:property value="#tp.mainProductsId" />','<s:property value="#tp.subProductsId" />','<s:property value="#tp.qty" />','<s:property value="#tp.remarks" />');"><i class="icon-pencil"></i></a>
												<a title="删除" style="margin: 0px 3px;" href="javascript:deleteSub('<s:property value="#tp.id" />');"><i class="icon-remove"></i></a>
											</td>
										</tr>
										</s:iterator>
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
					<label class="control-label" style="color: red;" id="addProductPrompt"></label>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupProductsID">产品编号：</label>
						<div class="controls">
							<input id="popupProductsID" class="input-large">
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
						<label class="control-label" for="popupIsMainProducts">是否主要产品：</label>
						<div class="controls">
							<select id="popupIsMainProducts" class="input-medium" placeholder="是否主要产品" >
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
							<!-- 
							<input type="text" id="popupIsMainProducts"
							placeholder="是否主要产品" class="input-large">
							 -->
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
			<button class="btn btn-danger" data-loading-text="正在保存" id="popupBtnConfirm">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<!-- 编辑产品 -->
	<div class="modal small hide fade" id="popupDetailEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="detailEditModalLabel">产品编辑</h3>
		</div>
		<div class="modal-body">
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="detailEditProductId">产品编号：</label>
						<div class="controls">
							<input type="text" id="detailEditProductId" class="input-large" disabled="disabled">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="detailEditQty">数量：</label>
						<div class="controls">
							<input type="text" id="detailEditQty" placeholder="数量" class="input-large">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="detailEditIsMainProducts">是否主要产品：</label>
						<div class="controls">
							<select id="detailEditIsMainProducts" class="input-medium" placeholder="是否主要产品" >
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="detailEditRemarks">备注：</label>
						<div class="controls">
							<input type="text" id="detailEditRemarks" placeholder="备注" class="input-large">
						</div>
					</div>
				</div>
			</dir>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-loading-text="正在保存" id="detailEditBtnConfirm">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<!-- 添加替代料-->
	<div class="modal small hide fade" id="popupBomSubfirm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="startModalLabel1">添加替代料</h3>
		</div>
		<div class="modal-body">
			<dir class="row">
				<div class="span3">
					<label class="control-label" style="color: red;" id="addBomSubPrompt"></label>
				</div>
			</dir>
		
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupSubMainProductsId">主料产品编号：</label>
						<div class="controls">
							<input type="text" id="popupSubMainProductsId" class="input-large"  disabled="disabled">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupsubProductsId">替代料产品编号：</label>
						<div class="controls">
							<input id="popupsubProductsId" class="input-large">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupSubQty">数量：</label>
						<div class="controls">
							<input type="text" id="popupSubQty" placeholder="数量" class="input-large">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupSubRemarks">备注：</label>
						<div class="controls">
							<input type="text" id="popupSubRemarks" placeholder="备注" class="input-large">
						</div>
					</div>
				</div>
			</dir>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-loading-text="正在保存" id="popupBomSubBtnConfirm">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<!-- 编辑替代料-->
	<div class="modal small hide fade" id="popupEditBomSubfirm" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="startModalLabel1">编辑替代料</h3>
		</div>
		<div class="modal-body">
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupEditSubMainProductsId">主料产品编号：</label>
						<div class="controls">
							<input type="text" id="popupEditSubMainProductsId" class="input-large"  disabled="disabled">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupEditsubProductsId">替代料产品编号：</label>
						<div class="controls">
							<input type="text" id="popupEditsubProductsId" class="input-large" disabled="disabled">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupEditSubQty">数量：</label>
						<div class="controls">
							<input type="text" id="popupEditSubQty" placeholder="数量" class="input-large">
						</div>
					</div>
				</div>
			</dir>
			
			<dir class="row">
				<div class="span3">
					<div class="control-group">
						<label class="control-label" for="popupEditSubRemarks">备注：</label>
						<div class="controls">
							<input type="text" id="popupEditSubRemarks" placeholder="备注" class="input-large">
						</div>
					</div>
				</div>
			</dir>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-loading-text="正在保存" id="popupEditBomSubBtnConfirm">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<div class="modal small hide fade" id="deleteDetailConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">删除产品</h3>
	  </div>
	  <div class="modal-body">
	    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>您确认要删除产品吗?</p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn btn-danger" data-dismiss="modal" id="deleteDetailConfirmBtn">确认</button>
	    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	  </div>
	</div>
	
	<div class="modal small hide fade" id="deleteSubConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">删除替代料</h3>
	  </div>
	  <div class="modal-body">
	    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>您确认要删除删除替代料吗?</p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn btn-danger" data-dismiss="modal" id="deleteSubConfirmBtn">确认</button>
	    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	  </div>
	</div>
	
	<!-- 审核产品结构 -->
	<div class="modal small hide fade" id="forMchangefirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">提示</h3>
		</div>
		<div class="modal-body">
			<p class="error-text">
				<i class="icon-warning-sign modal-icon "></i>审核后结构将不可更改.继续请按."确认" 否则请按 "取消"
			</p>
		</div>
		<div class="modal-footer">
			<button class="btn btn-danger" data-dismiss="modal" id="formChangefirmBtn">确认</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	
	<!-- 审核生效 -->
	<form action="${menu2Id}!auditStatus.jspa" id="auditForm" method="post">
		<input type="hidden" name="bomPrimary.id" value="${bomPrimary.id}">
		<input type="hidden" name="menuId" value="${menuId}">
		<input type="hidden" name="menu2Id" value="${menu2Id}">
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
		var menuId = '${menuId}';
		var menu2Id = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menuId).attr('url');
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		
		$("select").select2();
		
		$("#inputProductsId").select2({
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
			
			initSelection: function(element, callback) {
		        // the input tag has a value attribute preloaded that points to a preselected repository's id
		        // this function resolves that id attribute to an object that select2 can render
		        // using its formatResult renderer - that way the repository name is shown preselected
		        var id = "${bomPrimary.productsId}";
		        if (id !== "") {
		            $.ajax(basePath + "/interface/interfaceProducts!queryProducts.jspa", {
		                dataType: "json",
		                data : {
							"id" : id
						},
		           	}).done(function(data) { callback({id:data.dataObject.id, text:data.dataObject.id + "(" + data.dataObject.name + ")"}); });
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
		//设置初始化值
		//$("#inputProductsId").val("${bomPrimary.productsId}").trigger("change");
		//添加产品组件
		$("#popupBtnConfirm").click(function(x) {
			var _ProductsID = $("#popupProductsID").val();
			var _Qty = $("#popupQty").val();
			var _IsMainProducts = $("#popupIsMainProducts").val();
			var _Remarks = $("#popupRemarks").val();
			
			var ProductsID = $.trim(_ProductsID);
			var Qty = $.trim(_Qty);
			var IsMainProducts = $.trim(_IsMainProducts);
			var Remarks = $.trim(_Remarks);
			if (ProductsID == null || ProductsID == "") {
				//$("#popupBtnConfirml").attr("title","产品编号必须选择 !");
				$("#popupProductsID").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#popupProductsID").closest('div').parents('div').removeClass('error').addClass('success');
			}
			if (Qty == null || Qty == "") {
				//$("#popupQty").attr("title","数量必须填写!");
				$("#popupQty").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#popupQty").closest('div').parents('div').removeClass('error').addClass('success');
			}
			//alert("ProductsID: " + ProductsID + " Qty: " + Qty + " IsMainProducts:" + IsMainProducts + " Remarks:" + Remarks);
			$("#bomDetailSubProductsId").val(ProductsID);
			$("#bomDetailQty").val(Qty);
			$("#bomDetailIsMainProducts").val(IsMainProducts);
			$("#bomDetailRemarks").val(Remarks);
			
			//判断要添加的组件是否会形成死循环
			var ret = verifyBomDetail(ProductsID);
			if(ret.status == '1'){
				$('#popupfirm').modal('hide');
				//提交表单
				$("#productStructDetailForm").submit();
				
			} else {
				$("#popupProductsID").closest('div').parents('div').removeClass('success').addClass('error');
				$("#addProductPrompt").html(ret.message);
				//alert(ret.message);
			}
		})
		
		/**
		 * 添加产品组件前，判断是否会形成死循环
		 * 
		 */
		function verifyBomDetail(subProductsId) {
			var bomPrimaryId = "${bomPrimary.id}";
			var productsId = "${bomPrimary.productsId}";
			var auditRet;

			$.ajax({
				type : "POST", //访问WebService使用Post方式请求
				async : false,//同步操作
				url : basePath + "/business/productStruct!verifySaveDetail.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
				data : {
					"bomDetail.primaryId":bomPrimaryId,
					"bomDetail.productsId":productsId,
					"bomDetail.subProductsId":subProductsId
					}, //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
				dataType : 'json', //WebService 会返回Json类型
				traditional : false, //不要序列化参数
				error : function(err, textStatus) {
					//alert("error: " + err + " textStatus: " + textStatus);
				},
				success : function(result) {//回调函数，result，返回值
					//alert("result: "+result);
					auditRet = result;
				}
			});
			
			return auditRet;
		}
		
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
			/*
			initSelection: function(element, callback) {
		        // the input tag has a value attribute preloaded that points to a preselected repository's id
		        // this function resolves that id attribute to an object that select2 can render
		        // using its formatResult renderer - that way the repository name is shown preselected
		        var id = "${bomPrimary.productsId}";
		        if (id !== "") {
		            $.ajax(basePath + "/interface/interfaceProducts!queryProducts.jspa", {
		                dataType: "json",
		                data : {
							"id" : id
						},
		           	}).done(function(data) { callback({id:data.dataObject.id, text:data.dataObject.id + "(" + data.dataObject.name + ")"}); });
				}
		    },
		    */
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
		
		$("#popupsubProductsId").select2({
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
		
		//编辑页面打开，初始化数据
		/*
		$('#popupDetailEdit').on('show', function () {
			//初始化产品编号
			var id = $("#bomDetailSubProductsId").val();
			$("#detailEditProductId").val(id);

			//初始化数量
			
			
			//初始化是否主要产品
			
			
			//初始化备注
			
		});
		*/
		
		//删除确认
		function deleteDetail(id, subProductsId){
			$("#delFormBomDetailId").val(id);
			$("#delFormBomDetailSubProductsId").val(subProductsId);
			$("#deleteDetailConfirm").modal('show');
		}
		
		//确认删除
		$("#deleteDetailConfirmBtn").click(function(){
			//提交表单
			$("#productStructDetailDelForm").submit();
		});
		
		//编辑产品
		function editDetail(id, productId, isMainProducts, qty, remarks){
			//产品结构明细的id
			$("#bomDetailId").val(id);
			//初始化产品编号
			$("#detailEditProductId").val(productId);

			//初始化是否主要产品
			$("#detailEditIsMainProducts").val(isMainProducts).trigger("change");;
			
			//初始化数量
			$("#detailEditQty").val(qty);
			
			//初始化备注
			$("#detailEditRemarks").val(remarks);
			
			$("#popupDetailEdit").modal('show');
		}
		//保存编辑
		$("#detailEditBtnConfirm").click(function(){
			var _ProductsID = $("#detailEditProductId").val();
			var _Qty = $("#detailEditQty").val();
			var _IsMainProducts = $("#detailEditIsMainProducts").val();
			var _Remarks = $("#detailEditRemarks").val();
			
			var ProductsID = $.trim(_ProductsID);
			var Qty = $.trim(_Qty);
			var IsMainProducts = $.trim(_IsMainProducts);
			var Remarks = $.trim(_Remarks);
			if (ProductsID == null || ProductsID == "") {
				//$("#popupBtnConfirml").attr("title","产品编号必须选择 !");
				$("#detailEditProductId").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#detailEditProductId").closest('div').parents('div').removeClass('error').addClass('success');
				
			}
			if (Qty == null || Qty == "") {
				//$("#popupQty").attr("title","数量必须填写!");
				$("#detailEditQty").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#detailEditQty").closest('div').parents('div').removeClass('error').addClass('success');
			}
			$("#bomDetailSubProductsId").val(ProductsID);
			$("#bomDetailQty").val(Qty);
			$("#bomDetailIsMainProducts").val(IsMainProducts);
			$("#bomDetailRemarks").val(Remarks);
			//提交编辑表单
			$("#productStructDetailForm").submit();
		});
		
		//添加替代料
		function addSub(primaryId, subProductsId){
			$("#popupSubMainProductsId").val(subProductsId);
			
			$("#popupBomSubfirm").modal('show');
		}
		
		//保存替代料
		$("#popupBomSubBtnConfirm").click(function(){
			var _SubMainProductsId = $("#popupSubMainProductsId").val();
			var _subProductsId = $("#popupsubProductsId").val();
			var _Qty = $("#popupSubQty").val();
			var _Remarks = $("#popupSubRemarks").val();
			
			var subMainProductsId = $.trim(_SubMainProductsId);
			var subProductsId = $.trim(_subProductsId);
			var qty = $.trim(_Qty);
			var remarks = $.trim(_Remarks);
			if (subProductsId == null || subProductsId == "") {
				//$("#popupBtnConfirml").attr("title","替代料产品编号必须选择 !");
				$("#popupsubProductsId").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#popupsubProductsId").closest('div').parents('div').removeClass('error').addClass('success');
			}
			if (qty == null || qty == "") {
				//$("#popupQty").attr("title","数量必须填写!");
				$("#popupSubQty").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#popupSubQty").closest('div').parents('div').removeClass('error').addClass('success');
			}
			//设置表单的值
			$("#bomMainProductsId").val(subMainProductsId);
			$("#bomSubProductsId").val(subProductsId);
			$("#bomSubQty").val(qty);
			$("#bomSubRemarks").val(remarks);
			//判断要添加替代料
			var ret = verifyBomSub(subMainProductsId, subProductsId);
			if(ret.status == '1'){
				//提交表单
				$("#productStructSubForm").submit();
				
			} else {
				$("#bomSubProductsId").closest('div').parents('div').removeClass('success').addClass('error');
				$("#addBomSubPrompt").html(ret.message);
			}
			
		});
		
		/**
		 * 添加产品组件前，判断是否会形成死循环
		 * 
		 */
		function verifyBomSub(subMainProductsId, subProductsId) {
			//产品的料号
			var productsId = "${bomPrimary.productsId}";
			var primaryId = "${bomPrimary.id}";
			var auditRet;

			$.ajax({
				type : "POST", //访问WebService使用Post方式请求
				async : false,//同步操作
				url : basePath + "/business/productStruct!verifySaveSub.jspa", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
				data : {
					"BomSub.productsId":productsId,
					"BomSub.mainProductsId":subMainProductsId,
					"BomSub.subProductsId":subProductsId,
					"BomSub.primaryId":primaryId
					}, //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到       
				dataType : 'json', //WebService 会返回Json类型
				traditional : false, //不要序列化参数
				error : function(err, textStatus) {
					//alert("error: " + err + " textStatus: " + textStatus);
				},
				success : function(result) {//回调函数，result，返回值
					//alert("result: "+result);
					auditRet = result;
				}
			});
			
			return auditRet;
		}
		
		
		//编辑替代料
		function editSub(id, mainProductsId, subProductsId, qty, remarks){
			//产品结构明细的id
			$("#bomSubId").val(id);
			//初始化主料产品编号
			$("#popupEditSubMainProductsId").val(mainProductsId);

			//初始化替代料产品编号
			$("#popupEditsubProductsId").val(subProductsId);
			
			//初始化数量
			$("#popupEditSubQty").val(qty);
			
			//初始化备注
			$("#popupEditSubRemarks").val(remarks);
			
			//编辑替代料的展示
			$("#popupEditBomSubfirm").modal('show');
		}
		
		//保存编辑替代料
		$("#popupEditBomSubBtnConfirm").click(function(){
			var _SubMainProductsId = $("#popupEditSubMainProductsId").val();
			var _subProductsId = $("#popupEditsubProductsId").val();
			var _Qty = $("#popupEditSubQty").val();
			var _Remarks = $("#popupEditSubRemarks").val();
			
			var subMainProductsId = $.trim(_SubMainProductsId);
			var subProductsId = $.trim(_subProductsId);
			var qty = $.trim(_Qty);
			var remarks = $.trim(_Remarks);
			if (subProductsId == null || subProductsId == "") {
				//$("#popupBtnConfirml").attr("title","替代料产品编号必须选择 !");
				$("#popupEditsubProductsId").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#popupEditsubProductsId").closest('div').parents('div').removeClass('error').addClass('success');
			}
			if (qty == null || qty == "") {
				//$("#popupQty").attr("title","数量必须填写!");
				$("#popupEditSubQty").closest('div').parents('div').removeClass('success').addClass('error');
				return;
			} else {
				$("#popupEditSubQty").closest('div').parents('div').removeClass('error').addClass('success');
			}
			//设置表单的值
			$("#bomMainProductsId").val(subMainProductsId);
			$("#bomSubProductsId").val(subProductsId);
			$("#bomSubQty").val(qty);
			$("#bomSubRemarks").val(remarks);
			//提交表单
			$("#productStructSubForm").submit();
		});
		
		//删除确认
		function deleteSub(id){
			$("#delFormBomSubId").val(id);
			$("#deleteSubConfirm").modal('show');
		}
		
		//确认删除
		$("#deleteSubConfirmBtn").click(function(){
			//提交表单
			$("#productStructSubDelForm").submit();
		});
		
		//审核生效状态
		$("#formChangefirmBtn").click(function(){
			//提交表单
			$("#auditForm").submit();
		});
		
		//进入指定的tbs
		var tabID = "${tabID}";
		if (null != tabID && "" != tabID) {
			$("#" + tabID).parent().addClass("active");
			$("#" + tabID.substring(0, tabID.length - 4)).removeClass("fade").addClass("active");
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
       // window.addEventListener("load", loadDemo, false);
		
	
		/* 
		$.validator.addMethod("queryProducts",function(value,element,params){
			   return false;
			},"必须是一个字母,且a-f");
 		*/
		
	</script>
</body>
</html>