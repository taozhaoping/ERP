<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/theme.css">
<link rel="stylesheet" href="<%=path %>/css/font-awesome.css">
<script src="<%=path %>/js/jquery.js" type="text/javascript"></script>

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

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link href="<%=path%>/img/favicon_32.ico" rel="bookmark" type="image/x-icon" /> 
<link href="<%=path%>/img/favicon_32.ico" rel="icon" type="image/x-icon" /> 
<link href="<%=path%>/img/favicon_32.ico" rel="shortcut icon" type="image/x-icon" />
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 http-error"> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 http-error"> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 http-error"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="http-error">
	<!--<![endif]-->
	<div class="row-fluid">
		<div class="http-error">
			<h1>Oops!</h1>
			<p class="info">Something happened that we didn't expect.</p>
			<p>
				<a class="btn btn-link btn-large" href="<%=path %>/login/login.jspa"><i  class="icon-home"></i></a>
			</p>
				
				<p class="text-error text-center">${errorMsg}</p>
		</div>
	</div>

	<script src="<%=path %>/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		
	</script>
</body>
</html>


