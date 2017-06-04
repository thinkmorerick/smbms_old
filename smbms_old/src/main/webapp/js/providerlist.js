$(function(){
	$(".viewProvider").on("click",function(){
		var obj=$(this);
		window.location.href=path+"/provider.do?method=view&pid="+obj.attr("proid");
	});
	
	$(".modifyProvider").on("click",function(){
		var obj=$(this);
		window.location.href=path+"/provider.do?method=modify&pid="+obj.attr("proid");
	});
	
	$(".deleteProvider").on("click",function(){
		var obj=$(this);
		
		if(confirm("你确定要删除供应商【"+obj.attr("proname")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/provider.do",
				data:{method:"delprovider",pid:obj.attr("proid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){ // 删除成功，移除当前行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){ // 删除失败
						alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
					}else{
						alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
				
			});
		}
	});
	
	
});