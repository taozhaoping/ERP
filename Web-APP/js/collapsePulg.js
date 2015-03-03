//一个导航卡打开后，其余的关闭
$(".collapse").on('show', function (){
    $(this).siblings(".collapse").siblings(".in").collapse('hide');
});

//展开菜单
function collapseMenu(id){
	$("#"+id).addClass('in');
}