<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String pathTitle = request.getContextPath();
%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav pull-right">
			<li id="fat-menu" class="dropdown">
				<a href="javascript:void(0)" role="button" class="dropdown-toggle" data-toggle="dropdown">
					<i	class="icon-user"></i>${sessionScope.userInfo.name}(${sessionScope.userInfo.loginName}) <i class="icon-caret-down"></i>
				</a>
				<ul class="dropdown-menu">
					<li><a tabindex="-1" id="personalBtn" href="javascript:void(0)">我的账号</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" class="visible-phone" href="javascript:void(0)">设置</a></li>
					<li class="divider visible-phone"></li>
					<li>
						<!-- 
						<a tabindex="-1" href="login/login.jspa">退出</a>
						 -->
						<a href="javascript:void(0)" class="hidden-phone visible-tablet visible-desktop" role="button">设置</a>
					</li>
				</ul>
			</li>
			
			<li>
				<a tabindex="-1" href="#quitConfirm" data-toggle="modal"><i	class="icon-off"></i>登出</a>
			</li>
		</ul>
		<a class="brand" href="<%=pathTitle%>/home/main.jspa"><span class="first">Your</span>
			<span class="second"><s:property value="getText('COM.OSFI.WINDOW.TITLE')" /></span>
		</a>
		
		<ul class="nav">
			<li id="fat-menu" class="dropdown">
				<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
					新建<i class="icon-caret-down"></i>
				</a>
				<ul class="dropdown-menu">
					<!-- 
					<li>
						<a tabindex="-1" id="recruitmentBtn" href="javascript:void();">外教招聘流程</a>
					</li>
					<li class="divider"></li>
					<li>
						<a tabindex="-1" id="inductionBtn" href="javascript:void();">外教入职流程</a>
					</li>
					<li>
						<a tabindex="-1" id="applyfranchiseeBtn" href="javascript:void();">加盟商申请流程</a>
					</li>
					 -->
					<s:iterator value="#session.menuList" status="statu" id="menu">
						<s:if test='action == "workflow"'>
	      					<s:iterator value="#menu.menuList" id="menuTwo">
      						<li>
								<a tabindex="-1" id="${action}Btn" onclick="redirect('${nameSpace}','${action}')" href="javascript:void();"><s:property value="name" /></a>
							</li>
	      					</s:iterator>
	    				</s:if>
					</s:iterator>
					
				</ul>
			</li>
		</ul>
	</div>
</div>

<div class="modal small hide fade" id="quitConfirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">退出系统</h3>
  </div>
  <div class="modal-body">
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>您确认要退出系统吗?</p>
  </div>
  <div class="modal-footer">
    <button class="btn btn-danger" data-dismiss="modal" id="exitBtn">确认</button>
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
  </div>
</div>

<script type="text/javascript">
	$("#exitBtn").click( function () {
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		//跳转到登陆页面
		window.location.href = basePath + "/login/login.jspa";
	});
	
	
	function redirect(nameSpace, action){
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		var hrefStr = basePath + "/" +nameSpace +"/"+ action +"!editor.jspa?menuId="+nameSpace+"&menu2Id="+action;
		//跳转到登陆页面
		window.location.href = hrefStr;
	}
	
	$("#personalBtn").click( function () {
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		//跳转到用户信息
		window.location.href = basePath + "/home/main!queryPersonal.jspa";
	});
	
	/*
	$("#recruitmentBtn").click( function () {
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		//跳转到登陆页面
		window.location.href = basePath + "/workflow/recruitment!editor.jspa?menuId=workflow&menu2Id=recruitment";
	});
	
	$("#inductionBtn").click( function () {
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		//跳转到登陆页面
		window.location.href = basePath + "/workflow/induction!editor.jspa?menuId=workflow&menu2Id=induction";
	});
	
	$("#applyfranchiseeBtn").click( function () {
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		//跳转到登陆页面
		window.location.href = basePath + "/workflow/applyfranchisee!editor.jspa?menuId=workflow&menu2Id=applyfranchisee";
	});
	*/
</script>
