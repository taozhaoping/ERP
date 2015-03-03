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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.css">
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
				<span class="second">Company</span></a>
		</div>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">重置密码</p>
				<div class="block-body">
					<form id="resetPwdForm" action="<%=path %>/login/resetPasswordAction!resetPwdSubmit.jspa">
						<input type="hidden" value="${userInfo.loginName}" name="userInfo.loginName" id="loginName">
						<div class="control-group">
							<label>新密码</label>
							<input type="password" data-required="true" class="span12" id="password">
						</div>
						
						<div class="control-group">
							<label>确认密码</label>
							<input type="password" data-validate="password2" class="span12" id="password2" name="newPassWord">
						</div>
						
						<input type="submit" class="btn btn-primary pull-right" value="重置密码">
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
			<a href="<%=path %>/login/login.jspa">登陆页面</a>
		</div>
	</div>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script src="<%=path %>/js/jquery-validate.js"></script>
	<script type="text/javascript">
	    $("[rel=tooltip]").tooltip();
	    $(function() {
	        $('.demo-cancel-click').click(function(){return false;});
	    });
	    
		// 验证
		$('form').validate( {
			onKeyup : false,
			onSubmit : true,
			onChange : true,
			eachValidField : function() {
				$(this).closest('div').removeClass('error').addClass('success');
			},
			eachInvalidField : function() {
				$(this).closest('div').removeClass('success').addClass('error');
			}
		});
		
		jQuery.validateExtend({
			password2 : {
				required : true,
				//pattern : /^[0-9]+$/,
				conditional : function(value) {
					return $("#password2").val() == $("#password").val();
				}
			}
		});
	    
	</script>
</body>
</html>