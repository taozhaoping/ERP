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
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

			</ul>
			<a class="brand" href="#"><span class="first">Your</span>
				<span class="second"><s:property value="getText('COM.OSFI.WINDOW.TITLE')" /></span></a>
		</div>
	</div>
	
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">登陆</p>
				<div class="block-body">
					<form method="post" name="loginform" id="loginform" action="login!loginUser.jspa">
						<input type="hidden" name="token" value="${token}" />
						<div class="control-group">
							<span style="color: red">${errorMessage}</span>
						</div>
						
						<div class="control-group">
							<label for="userName">用户名</label>
							<div class="controls">
								<input type="text" class="span12" id="userName" name="userInfo.loginName" value="${userInfo.loginName}" data-required="true"> 
							</div>
						</div>
						
						<div class="control-group">
							<label for="password">密码</label>
							<div class="controls">
								<input type="password" class="span12" id="password" name="userInfo.userPassword" data-required="true">
							</div>
						</div>
						
						<div class="control-group">
							<label for="validecode">验证码 </label>
							<div class="row-fluid">
								<input name="validecode" class="span8" type="text" id="validecode" data-required="true">
								<img id="imgUrl" onclick="showValidateCode()" title="点击刷新"></img>
							</div>
						</div>
						<input type="submit" class="btn btn-primary pull-right" value="登陆">
						
						<label class="remember-me"><input type="checkbox">记住密码</label>
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
			<p>
				<a href="<%=path %>/login/resetPasswordAction!resetPassword.jspa">忘记密码？</a>
			</p>
		</div>
	</div>
	<script type="text/javascript" src="<%=path %>/js/bootstrap.js"></script>
	<script src="<%=path %>/js/jquery-validate.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
			showValidateCode();
		});
		
		function showValidateCode() {
			var url = "../validatecode/validate!showValidateCode.jspa";
			$.ajax({
				type : "POST",
				url : url,
				success : function(data) {
					//var myObject = JSON2.parse(data);
					//var myObject = eval('(' + data + ')');
					document.getElementById('imgUrl').src = data.imgUrl;
				}
			});
		}
		
		// 验证
		$('form').validate( {
			onKeyup : false,
			onSubmit : true,
			onChange : true,
			eachValidField : function() {
				$(this).closest('div').parents('div').removeClass('error')
				.addClass('success');
			},
			eachInvalidField : function() {
				$(this).closest('div').parents('div').removeClass('success')
				.addClass('error');
			}
		});
	</script>
</body>
</html>