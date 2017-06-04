var proContact=null;
var proPhone=null;
var saveBtn=null;


$(function(){
	proContact=$("#proContact");
	proPhone=$("#proPhone");
	saveBtn=$("#saveBtn");
	
	proContact.next().html("*");
	proPhone.next().html("*");
	
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
		validateTip(proPhone.next(),{"color":"#666666"}," * 请输入手机号",false);
	}).on("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(proPhone.val().match(patrn)){
			validateTip(proPhone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proPhone.next(),{"color":"red"},imgNo+" 你输入的手机号格式不正确",false);
		}
	});
	
	saveBtn.on("click",function(){
		proContact.blur();
		proPhone.blur();
		if(proContact.attr("validateStatus") == "true" && proPhone.attr("validateStatus") == "true" ){
			if(confirm("是否确认要提交数据？")){
				$("#providerForm").submit();
			}
		}
	});
});