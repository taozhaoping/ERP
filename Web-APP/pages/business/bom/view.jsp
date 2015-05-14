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
			<li class="active">查看</li>
		</ul>
		<div class="container-fluid">
				<input type="hidden" id="formChanged" name="formChanged" value="0" />
				<div class="row-fluid">

					<div class="btn-toolbar">
						<a class="btn" id="backList" href=""> 返回</a>
						<div class="btn-group"></div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li><a id="homeButt" href="#home" data-toggle="tab">基本信息</a></li>
							<li><a id="productStructButt" href="#productStructTab" data-toggle="tab">产品结构</a></li>
							<li><a id="productStructSubTabButt" href="#productStructSubTab" data-toggle="tab">替代料</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<dl class="tab-pane active dl-horizontal" id="home">
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<dt>产品编号：</dt>
											<dd>${bomPrimary.productsId}</dd>
										</div>
									</div>
									
									<div class="span4">
										<div class="control-group">
											<dt>描述：</dt>
											<dd>${bomPrimary.descr}</dd>
										</div>
									</div>
								</dir>
									
								<dir class="row">
									<div class="span4">
										<div class="control-group">
											<dt>生效日期：</dt>
											<dd>${bomPrimary.effdt}</dd>
										</div>
									</div>
									
									<div class="span4">
										<div class="control-group">
											<dt>生效状态：</dt>
											<dd>
												<s:if test="bomPrimary.effStatus == 1">
												已生效
												</s:if>
												<s:else>
												未生效
												</s:else>
											</dd>
										</div>
									</div>
								</dir>
							</dl>
							<div class="tab-pane fade" id="productStructTab">
								<table class="table">
									<thead>
										<tr>
											<th>组件编号</th>
											<th>名称</th>
											<th>主产品</th>
											<th>数量</th>
											<th>备注</th>
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
								<table class="table">
									<thead>
										<tr>
											<th>主料编号</th>
											<th>替代料编号</th>
											<th>替代料名称</th>
											<th>替代料数量</th>
											<th>替代料备注</th>
										</tr>
									</thead>
									
									<tbody id="maillistSearch">
										<!-- 产品列表 -->
										<s:iterator value="bomSubList" var="tp" status="index">
										<tr>
											<td><s:property value="#tp.mainProductsId" /></td>
											<td><s:property value="#tp.subProductsId" /></td>
											<td><s:property value="#tp.subProductsName" /></td>
											<td><s:property value="#tp.qty" /></td>
											<td><s:property value="#tp.remarks" /></td>
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
		var menuId = '${menuId}';
		var menu2Id = '${menu2Id}';
		var spaceId = '${spaceId}';
		var url = $("#" + menu2Id).attr('url');
		var totalPage = ${pageInfo.totalPage};
		var totalRow = ${pageInfo.totalRow};
		var pageSize = ${pageInfo.pageSize};
		var curPage = ${pageInfo.curPage};
		
		$("select").select2();
		
		//设置初始化值
		//$("#inputProductsId").val("${bomPrimary.productsId}").trigger("change");
		
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
        window.addEventListener("load", loadDemo, false);
		
	
		/* 
		$.validator.addMethod("queryProducts",function(value,element,params){
			   return false;
			},"必须是一个字母,且a-f");
 		*/
		
	</script>
</body>
</html>