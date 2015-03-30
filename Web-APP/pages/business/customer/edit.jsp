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

		<div class="container-fluid">
			<form id="editForm" class="form-horizontal"
				action="${menu2Id}!save.jspa" method="post">
				<div class="row-fluid">

					<div class="btn-toolbar">
						<button class="btn btn-primary" type="submit">
							<i class="icon-save"></i> 保存
						</button>
						<a class="btn" id="backList" href=""> 返回</a>
						<div class="btn-group"></div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<s:if test="#ProcessId">
								<li><a id="maillistButt" href="#maillist" data-toggle="tab">通讯录</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active" id="home">
								<input type="hidden" name="id" value="${customer.id}"> <input
									type="hidden" name="menuId" value="${menuId}"> <input
									type="hidden" name="menu2Id" value="${menu2Id}"> <input
									type="hidden" name="spaceId" value="${spaceId}">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputId" style="">编号：</label>
											<div class="controls">
												<input type="text" maxlength="20" disabled="disabled"
													id="inputId" value="${customer.id}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputname" style="">客户名称：</label>
											<div class="controls">
												<input type="text" data-required="true" maxlength="40"
													placeholder="客户名称" id="inputname" name="customer.name"
													value="${customer.name}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputlegalPerson" style="">法人：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="customer.legalPerson"
													placeholder="法人" id="inputlegalPerson" value="${customer.legalPerson}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputtype" style="">客户类型：</label>
											<div class="controls">
												<s:select id="inputtype"  list="typeList" listKey="key" listValue="descr"
													name="customer.type" cssClass="input-medium" placeholder="客户类型">
												</s:select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputmail" style="">邮箱：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="customer.mail"
													placeholder="邮箱" id="inputmail" value="${customer.mail}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputfaxNumber">传真：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="customer.faxNumber" 
													placeholder="传真" id="inputfaxNumber" value="${customer.faxNumber}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputiphone" >电话号码：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="customer.iphone"
													placeholder="地址" id="inputiphone" value="${customer.iphone}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputenabled" style="">状态：</label>
											<div class="controls">
												<select id="inputtype" name="customer.enabled" class="input-medium">
													<option value="0">激活</option>
													<option value="1">未激活</option>
												</select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputopeningBank" >开户银行：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="customer.openingBank"
													placeholder="地址" id="inputopeningBank" value="${customer.openingBank}" class="input-medium"></input>
											</div>

										</div>
									</div>
									<div class="span4">
										<div class="control-group">
											<label class="control-label" for="inputbankAccount" style="">银行账号：</label>
											<div class="controls">
												<input type="text" maxlength="40" name="customer.bankAccount"
													placeholder="地址" id="inputbankAccount" value="${customer.bankAccount}" class="input-medium"></input>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span10">
										<div class="control-group">
											<label class="control-label" for="inputlev" >客户级别：</label>
											<div class="controls">
												<s:select id="inputlev"  list="dictionaryList" listKey="key" listValue="descr"
													name="customer.lev" cssClass="input-medium" placeholder="客户类型">
												</s:select>
											</div>

										</div>
									</div>
									
								</dir>
								<dir class="row">
									<div class="span10">
										<div class="control-group">
											<label class="control-label" for="inputaddress" >地址：</label>
											<div class="controls">
												<input type="text" maxlength="100" name="customer.address"
													placeholder="地址" id="inputaddress" value="${customer.address}" class="input-xxlarge"></input>
											</div>

										</div>
									</div>
									
								</dir>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/pages/common/footer.jsp"%>
	<script src="<%=path%>/js/bootstrap.js"></script>
	<script src="<%=path%>/js/collapsePulg.js"></script>
	<script src="<%=path%>/js/common.js"></script>
	<script src="<%=path%>/js/jquery-validate.js"></script>
	<script src="<%=path%>/js/select2/select2.js"></script>
	<script src="<%=path%>/js/select2/select2_locale_zh-CN.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		var id = '${menuId}';
		var menuId = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menuId).attr('url');

		$("select").select2();
		var enabled = '${customer.enabled}';
		if (enabled != null) {
			$("#inputenabled").val(enabled).trigger("change");
		}
	</script>
</body>
</html>