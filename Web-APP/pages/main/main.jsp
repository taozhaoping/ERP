<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.zh.base.util.JspUtil" %>
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
<jsp:useBean id="userName" class="com.zh.base.util.JspUtil" scope="session"></jsp:useBean>
<!--<![endif]-->
	<s:if test="%{#request.role.menuList != null}">
		<s:set name="menuList" scope="session" value="#request.role.menuList"></s:set>
	</s:if>

	<s:if test="%{#request.taskNumber != null}">
		<s:set name="taskSize" scope="session" value="#request.taskNumber"></s:set>
	</s:if>
	
	
	
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

			<h1 class="page-title">主页</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="<%=path%>/home/main.jspa">主页</a> <span class="divider"></span></li>
			<!-- 
			<li class="active">主页</li>
			 -->
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="row-fluid">
					<div class="alert alert-info">
						<button type="button" class="close" data-dismiss="alert">×</button>
						<strong>预约提醒：</strong> 今天预约人数8人!
					</div>

					<div class="block">
						<a href="#page-stats" class="block-heading" data-toggle="collapse">信息统计</a>
						<div id="page-stats" class="block-body collapse in">
							<div class="stat-widget-container">
								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">500</p>
										<p class="detail">外派员工</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">299</p>
										<p class="detail">未外派员工</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">87</p>
										<p class="detail">正在签约</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">636</p>
										<p class="detail">签约合同</p>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="block span6">
						<a href="#tablewidget" class="block-heading"
							data-toggle="collapse">待处理任务
						</a>
						<!-- 
						<span class="label label-warning">+10</span>
						 -->
						<div id="tablewidget" class="block-body collapse in">
							<table class="table">
								<thead>
									<tr>
										<th>流程编号</th>
										<th>流程描述</th>
										<th>当前状态</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="technologicalProcessList" var="task" status="index">
										<tr>
											<td>
												<a href="<s:property value='#task.url'/>&formId=<s:property value='#task.id'/>">
													<s:property value="#task.id"/>
												</a>
											</td>
											<td><s:property value="#task.description"/></td>
											<td><s:property value="#task.state"/></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
							
							<p class="">
								默认最多显示5条.
								<!-- 
								<a href="users.html">More...</a>
								 -->
							</p>
						</div>
					</div>
					<div class="block span6">
						<a href="#widget1container" class="block-heading"
							data-toggle="collapse">系统公告 </a>
						<div id="widget1container" class="block-body collapse in">
							<table class="table">
								<thead>
									<tr>
										<th>编号</th>
										<th>标题</th>
										<th>时间</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="noticeList" var="notice" status="index">
										<tr>
											<td>
												<s:property value="#index.index+1"/>
											</td>
											<td>
												<a href="main!queryNotice.jspa?id=<s:property value='#notice.id'/>">
													<s:property value="#notice.title"/>
												</a>
											</td>
											<td><s:property value="#notice.createdate"/></td>
										</tr>
										</a>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="block span6">
						<a href="#widget2container" class="block-heading" data-toggle="collapse">待联系外教</a>
						
						<div id="widget2container" class="block-body collapse in">
							<table class="table list">
								<thead>
									<tr>
										<th>编号</th>
										<th>姓名</th>
										<th>联系状态</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="contactRecordVWList" var="tp" status="index">
										<tr>
											<td>
												<a href="<%=path%>/staffAdmin/contactrecord!editor.jspa?formId=<s:property value='#tp.id'/>&menuId=memorandum&menu2Id=contactrecord&spaceId=staffAdmin">
													<s:property value="#tp.id"/>
												</a>
											</td>
											<td>
												<s:property value="#tp.createUserId"/>
											</td>
											<td>
												<s:if test="#tp.type==1">
													已经签约
												</s:if>
												<s:elseif test="#tp.type==2">
													正在洽谈
												</s:elseif>
												<s:elseif test="#tp.type==3">
													有意向
												</s:elseif>
												<s:elseif test="#tp.type==4">
													潜在外教
												</s:elseif>
											</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="block span6">
						<a href="#widget3container" class="block-heading" data-toggle="collapse">待联系加盟商</a>
						
						<div id="widget3container" class="block-body collapse in">
							<table class="table list">
								<thead>
									<tr>
										<th>编号</th>
										<th>姓名</th>
										<th>联系状态</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="franchiseeRecordVWList" var="tp" status="index">
										<tr>
											<td>
												<a href="<%=path%>/staffAdmin/franchiseerecord!editor.jspa?formId=<s:property value='#tp.id'/>&menuId=memorandum&menu2Id=franchiseerecord&spaceId=staffAdmin">
													<s:property value="#tp.id"/>
												</a>
											</td>
											<td>
												<s:property value="#tp.workUserId"/>
											</td>
											<td>
												<s:if test="#tp.type==1">
													已经签约
												</s:if>
												<s:elseif test="#tp.type==2">
													正在洽谈
												</s:elseif>
												<s:elseif test="#tp.type==3">
													有意向
												</s:elseif>
												<s:elseif test="#tp.type==4">
													潜在外教
												</s:elseif>
											</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
				<!--  
				<footer>
				<hr>
				<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
				<!-- 
				<p class="pull-right">
					A <a href="http://www.portnine.com/bootstrap-themes"
						target="_blank">Free Bootstrap Theme</a> by <a
						href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>
				<p>
					&copy; 2012 <a href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>
				</footer>
				 -->

			</div>
		</div>
	</div>
	
	<%@ include file="/pages/common/footer.jsp"%>
	<script src="<%=path %>/js/bootstrap.js"></script>
	<script src="<%=path %>/js/collapsePulg.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>
</body>
</html>