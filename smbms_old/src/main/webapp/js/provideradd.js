var proCode = null;
var proName = null;
var proPhone = null;
var proContact = null;
var addBtn = null;


$(function(){
	proCode = $("#proCode");
	proName = $("#proName");
	proPhone = $("#proPhone");
	proContact = $("#proContact");
	saveBtn = $("#saveBtn");
	
	proCode.next().html("*");
	proName.next().html("*");
	proPhone.next().html("*");
	proContact.next().html("*");
	
	
	
	
	proCode.on("focus",function(){
		validateTip(proCode.next(),{"color":"#666666"},"* 请输入供应商编码",false);
	}).on("blur",function(){
		if(proCode.val() != null && proCode.val() != ""){
			validateTip(proCode.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proCode.next(),{"color":"red"},imgNo+" 供应商编码不能为空，请重新输入",true);
		}
	});
	
	proName.on("focus",function(){
		validateTip(proName.next(),{"color":"#666666"},"* 请输入供应商名称",false);
	}).on("blur",function(){
		if(proName.val() != null && proName.val() != ""){
			validateTip(proName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proName.next(),{"color":"red"},imgNo+" 供应商名称不能为空，请重新输入",true);
		}
	});
	
	proContact.on("focus",function(){
		validateTip(proContact.next(),{"color":"#666666"},"* 请输入联系人名称",false);
	}).on("blur",function(){
		if(proContact.val() != null && proContact.val() != ""){
			validateTip(proContact.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proContact.next(),{"color":"red"},imgNo+" 联系人名称不能为空，请重新输入",true);
		}
	});
	
	proPhone.on("focus",function(){
		validateTip(proPhone.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).on("blur",function(){
		var partn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(proPhone.val().match(partn)){
			validateTip(proPhone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proPhone.next(),{"color":"red"},imgNo+" 您输入的手机号格式不正确，请重新输入",true);
		}
	});
	
	
	saveBtn.on("click",function(){
		if(proCode.attr("validateStatus") != "true"){
			proCode.blur();
		}else if (proName.attr("validateStatus") != "true"){
			proName.blur();
		}else if (proContact.attr("validateStatus") != "true"){
			proContact.blur();
		}else if(proPhone.attr("validateStatus") != "true"){
			proPhone.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#providerForm").submit();
			}
		}
	});
});