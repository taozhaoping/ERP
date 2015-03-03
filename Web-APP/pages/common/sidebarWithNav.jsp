<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String pathTop = request.getContextPath();
%>
<div class="sidebar-nav">
	<s:iterator value="#session.menuList" status="statu" id="menu">
		<a href="#<s:property value="action" />" class="nav-header collapsed"
			data-toggle="collapse"> <i class="icon-exclamation-sign"></i>
		<s:property value="name" /></a>

		<ul id="<s:property value="action" />" class="nav nav-list collapse">
			<s:iterator value="#menu.menuList" id="menuTwo">
				<li><a 
					href="<%=pathTop %>/<s:property value="nameSpace"/>/<s:property value="url"/>?spaceId=<s:property value="nameSpace"/>&menuId=<s:property value="#menu.action" />&menu2Id=<s:property value="action"/>"
					id="<s:property value="action"/>" url="<%=pathTop %>/<s:property value="nameSpace"/>/<s:property value="url"/>"><s:property value="name" /></a></li>
			</s:iterator>
		</ul>
	</s:iterator>

	<!-- 
	<a href="#dashboard-menu" class="nav-header collapsed"
		data-toggle="collapse"><i class="icon-exclamation-sign"></i>系统管理</a>
	<ul id="dashboard-menu" class="nav nav-list collapse in">
		<li><a href="#">用户列表</a></li>
		<li><a href="#">角色列表</a></li>
		<li><a href="#">资源列表</a></li>
		<li><a href="enterprise.jspa">企业列表</a></li>
		<li><a href="#">参数配置</a></li>
	</ul>

	<a href="#accounts-menu" class="nav-header collapsed"
		data-toggle="collapse"><i class="icon-exclamation-sign"></i>我的账号</a>
	<ul id="accounts-menu" class="nav nav-list collapse">
		<li><a href="sign-in.html">登陆</a></li>
		<li><a href="sign-up.html">注册</a></li>
		<li><a href="reset-password.html">修改密码</a></li>
	</ul>

	<a href="#error-menu" class="nav-header collapsed"
		data-toggle="collapse"><i class="icon-exclamation-sign"></i>错误页面</a>
	<ul id="error-menu" class="nav nav-list collapse">
		<li><a href="403.html">403 page</a></li>
		<li><a href="404.html">404 page</a></li>
		<li><a href="500.html">500 page</a></li>
		<li><a href="503.html">503 page</a></li>
	</ul>
	 -->

</div>
