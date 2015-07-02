//公共js函数
var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol + "//" + localObj.host + "/"
				+ contextPath;
$(function() {
	
	$('.demo-cancel-click').click(function() {
		return false;
	});
	var headText = $("#" + menu2Id).text();
	$("#menu2Name").text(headText);
	$("#navigation").text(headText);
	//导航链接
	$("#navigation").attr("href", url + "?menuId=" + menuId + "&menu2Id=" + menu2Id + "&spaceId=" + spaceId);
	// 返回按钮
	$("#backList").attr("href", url + "?menuId=" + menuId + "&menu2Id=" + menu2Id + "&spaceId=" + spaceId);

	// 展开一级菜单
	collapseMenu(menuId);
	
	//进入指定的tbs
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
	
	$.jqPaginator('#pagination', {
		//设置分页的总页数
        totalPages: totalPage,
        //设置分页的总条目数
        totalCounts:totalRow,
        pageSize:pageSize,
        //最多显示的页码
        visiblePages: 10,
        currentPage: curPage,
        onPageChange: function (num, type) {
           if("init"==type)
        	{
        	 	return false;  
        	}
           $('#curPage').val(num);
           $('#queryForm').submit();
        }
    });
});
