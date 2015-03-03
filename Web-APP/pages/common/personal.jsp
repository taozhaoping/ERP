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
<link rel="stylesheet"
	href="<%=path%>/js/datetimepicker/bootstrap-datetimepicker.css">
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
					<span class="number"><s:property value="#session.taskSize"/></span>tasks
				</p>
				<p class="stat">
					<span class="number">15</span>waiting
				</p>
			</div>

			<h1 class="page-title" id="menu2Name">&nbsp;</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="<%=path%>/home/main.jspa">主页</a> <span class="divider">/</span></li>
			<li class="active">编辑</li>
		</ul>

		<div class="container-fluid">
			<form id="editForm" class="form-horizontal"
				action="main!save.jspa" method="post">
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
							<li class="active"><a href="#home" data-toggle="tab">基本信息</a></li>
							<li><a href="#password" data-toggle="tab">修改密码</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active" id="home">
								
								<input type="hidden" name="user.id" value="${user.id}">
								<input type="hidden" name="menuId" value="${menuId}"> <input
									type="hidden" name="menu2Id" value="${menu2Id}">
								<dir class="row">
									<div class="span5">
										<div class="control-group" id="name_div">
											<label class="control-label" for="inputloginName">用户名:</label>
											<div class="controls">
													<span class="input-xlarge uneditable-input">${user.loginName}</span>

											</div>
										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputname">姓名:</label>
											<div class="controls">
												<input type="text" id="inputname" data-required="true"
													name="user.name" value="${user.name}"
													data-required="true" class="input-xlarge">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputemail">电子邮箱:</label>
											<div class="controls">
												<input type="text" id="inputemail" maxlength="60" data-required="true"
													name="user.email" value="${user.email}"
													class="input-xlarge">
											</div>
										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputage">出生日期:</label>
											<div class="controls ">
												<input size="16" id="inputage" name="user.age"
													type="text"
													value="<s:date name="user.age" format="yyyy-MM-dd" />"
													readonly class="form_datetime input-xlarge">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputsex">性别:</label>
											<div class="controls">
												<select id="inputsex" class="input-xlarge"
													name="user.sex">
													<option value="0">未知</option>
													<option value="1">男</option>
													<option value="2">女</option>
												</select>
											</div>
										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputentryTime">入职时间:</label>
											<div class="controls">
												<input size="16" id="inputentryTime" disabled="disabled"
													name="user.entryTime" type="text"
													value="<s:date name="user.entryTime" format="yyyy-MM-dd" />"
													readonly class="form_datetime input-xlarge">
											</div>
										</div>
									</div>
									
								</dir>
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputphone">座机号码:</label>
											<div class="controls">
												<input type="text" id="inputphone"  maxlength="15" name="user.phone"
													value="${user.phone}" class="input-xlarge">
											</div>
										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputmobileNumber">手机号码:</label>
											<div class="controls">
												<input type="number" id="inputmobileNumber"  maxlength="15"
													data-required="true" name="user.mobileNumber"
													value="${user.mobileNumber}" class="input-xlarge">
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputqq">QQ:</label>
											<div class="controls">
												<input type="number" id="inputqq" name="user.qq"  maxlength="18"
													value="${user.qq}" class="input-xlarge">
											</div>
										</div>
									</div>
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputeducationBackground">专业:</label>
											<div class="controls">
												<select id="inputeducationBackground" class="input-xlarge"
													name="user.educationBackground">
													<option value="0">大专</option>
													<option value="1">本科</option>
													<option value="2">研究生</option>
												</select>
											</div>
										</div>
									</div>
								</dir>
								<dir class="row">
									<div class="span10">
										<div class="control-group">
											<label class="control-label" for="inputaddress">家庭住址:</label>
											<div class="controls">
												<input type="text"  maxlength="95" id="inputaddress" name="user.address"
													value="${user.address}"
													class="input-xxlarge">
											</div>
										</div>
									</div>
								</dir>
							</div>
							<div class="tab-pane fade" id="password">
								<s:if test="user.id!=null">
									<div class="control-group">
										<label class="control-label" for="inputnewPassWord1">新密码:</label>
										<div class="controls">
											<input type="password" id="inputnewPassWord1"  maxlength="15"
												data-validate="PassWordVali" class="input-xlarge">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputnewPassWord">新密码:</label>
										<div class="controls">
											<input type="password" id="inputnewPassWord" maxlength="15"
												data-validate="PassWordVali" name="newPassWord"
												class="input-xlarge">
										</div>
									</div>
								</s:if>
								<s:else>
									<div class="control-group">
										<label class="control-label" for="inputnewPassWord1">新密码:</label>
										<div class="controls">
											<input type="password" data-required="true"
												id="inputnewPassWord1" data-validate="PassWordVali"
												class="input-xlarge">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputnewPassWord">新密码:</label>
										<div class="controls">
											<input type="password" data-required="true"
												id="inputnewPassWord" data-validate="PassWordVali"
												name="newPassWord" class="input-xlarge">
										</div>
									</div>
								</s:else>
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
	<script src="<%=path%>/js/datetimepicker/bootstrap-datetimepicker.js"></script>
	<script src="<%=path%>/js/select2/select2.js"></script>
	<script src="<%=path%>/js/select2/select2_locale_zh-CN.js"></script>
	<script
		src="<%=path%>/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>

	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		var id = '${menuId}';
		var menuId = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menuId).attr('url');

		$("#inputroleId").select2();
		
		$("#inputenterpriseId").select2();
		
		$("#inputsex").select2();
		$("#inputsex").val("${user.sex}").trigger("change");
		
		$("#inputeducationBackground").select2();
		jQuery.validateExtend({
			PassWordVali : {
				onChange : true,
				pattern : /^[A-Za-z0-9]+$/,
				conditional : function(value) {
					password = $("#inputnewPassWord").val();
					password1 = $("#inputnewPassWord1").val();
					return password == password1;
				}
			}
		});
	</script>
</body>
</html>