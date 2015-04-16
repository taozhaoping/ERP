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
							<s:if test="#ProcessId">
								<li><a id="productStructButt" href="#productStructure" data-toggle="tab">产品结构</a></li>
							</s:if>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade" id="home">
								<dir class="row">
									<div class="span5">
										<div class="control-group">
											<label class="control-label" for="inputId" style="">产品编号：</label>
											<div class="controls">
												<input type="text" maxlength="20" name="bomPrimary.productsId" data-required="true"
													id="inputProductsId" value="${bomPrimary.productsId}" class="input-medium input-xlarge"></input>
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
												<input type="text" maxlength="40" name="products.effStatus" disabled="disabled"
													placeholder="生效状态" id="inputEffStatus" value="${products.effStatus}" class="input-medium input-xlarge"></input>
											</div>
										</div>
									</div>
								</dir>
							</div>
							
							<div class="tab-pane fade" id="productStructure">
								<form id="productStructureForm" class="form-horizontal" action="${menu2Id}!saveMailList.jspa" method="post">
									<input type="hidden" name="menuId" value="${menuId}" /> 
									<input type="hidden" name="menu2Id" value="${menu2Id}" /> 
									<input type="hidden" name="spaceId" value="${spaceId}">
									<input type="hidden" name="{bomPrimary.id" value="${bomPrimary.id}">
									<input type="hidden" name="bomPrimary.productsId" value="${bomPrimary.productsId}">
									<input type="hidden" name="tabID" value="productStructButt" />
									<button class="btn btn-small btn-primary" type="button" data-toggle="modal" data-target="#popupfirm">添加产品</button>
								</form>
								<table class="table">
									<thead>
										<tr>
											<th>产品编号</th>
											<th>名称</th>
											<th>库位号</th>
											<th>主产品</th>
											<th>数量</th>
											<th>备注</th>
										</tr>
									</thead>
									
									<tbody id="maillistSearch">
										<tr>
											<!-- 产品列表 -->
											<s:iterator value="bomDetailList" var="tp" status="index">
											<tr>
												<td><s:property value="#tp.subProductsId" /></td>
												<td></td>
												<td><s:property value="#tp.position" /></td>
												<td><s:property value="#tp.products.sourceType" /></td>
												<td><s:property value="#tp.isMainProducts" /></td>
												<td><s:property value="#tp.qty" /></td>
												<td><s:property value="#tp.remarks" /></td>
											</tr>
											</s:iterator>
										</tr>
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
		var id = '${menuId}';
		var menuId = '${menu2Id}';
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