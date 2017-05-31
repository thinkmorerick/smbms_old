$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）
	/**
	 * 绑定事件：bind、on、live、delegate
	 * jquery1.7官方推荐，性能高：on
	 */
	$(".viewUser").bind("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj=$(this);
		window.location.href=path+"/user.do?method=view&uid="+obj.attr("userid");
	});
	
	$(".modifyUser").bind("click",function(){
		var obj=$(this);
		window.location.href=path+"/user.do?method=modify&uid="+obj.attr("userid");
	});
	
	$(".deleteUser").bind("click",function(){
		var obj=$(this);
		if(confirm("你确定要删除用户【"+obj.attr("username")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/user.do",
				data:{method:"deluser",uid:obj.attr("userid")},
				dataType:"json",
				success:function(data){
					//删除成功：移除删除行
					if(data.delResult == "true"){
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){
						alert("对不起，删除用户【"+obj.attr("username")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，用户【"+obj.attr("username")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
				
			});
		}
	});
	
	
});