<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript">
  function validate(){
	  <%--window.location.href="${pageContext.request.contextPath }/jsp/frame.jsp"--%>
		//验证
		var userCode=document.getElementById("userCode").value;
		var userPassword=document.getElementById("userPassword").value;
		var userCodeSpan=document.getElementById("userCodeSpan");
		var userPasswordSpan=document.getElementById("userPasswordSpan");
		var flag=true;
		// innerText火狐不支持
		if(userCode==null||userCode==""){
			userCodeSpan.innerHTML="请输入用户名";
			flag=false;
		}
		if(userPassword==null||userPassword==""){
			userPasswordSpan.innerHTML="请输入密码";
			flag=false;
		}
		
		//提交
		var actionForm=document.getElementById("actionForm");
		if(flag){
		actionForm.submit();
		}
	}
  </script>
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form  action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" id="userCode" name="userCode"/> <span id="userCodeSpan"></span></dd>
				<dt>密　码：</dt>
				<dd><input type="password"  class="input-text" id="userPassword" name="userPassword"/><span id="userPasswordSpan"></span></dd>
			</dl>
			<div class="buttons">
			${ error}
				<input type="button"   value="登录系统" class="input-button" onclick="validate();" />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
