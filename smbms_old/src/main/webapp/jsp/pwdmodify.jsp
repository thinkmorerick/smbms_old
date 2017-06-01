<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
<head>

<title></title>


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
</head>

<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>

		</div>
		<form id="userForm" name="form1" method="post" action="${pageContext.request.contextPath }/user.do">
			<input type="hidden" name="method" value="savepwd">
			
			<div>${message }</div>
			<div class="content">
				<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
				<table class="box">
					<tbody>
						<tr>
							<td class="field">旧密码：</td>
							<td>
							<input type="password" name="oldpassword" class="text" id="oldpassword" value="">
								<font color="red"></font>
							</td>
						</tr>
						
						<tr>
							<td class="field">新密码：</td>
							<td>
							<input type="password" name="newpassword" class="text" id="newpassword" value="">
								<font color="red"></font>
							</td>
						</tr>
						
						<tr>
							<td class="field">确认密码：</td>
							<td>
							<input type="password" name="rnewpassword" class="text" id="rnewpassword" value="">
								<font color="red"></font>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="saveBtn" id="saveBtn" value="保存"
					class="input-button"> 
			</div>

		</form>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/pwdmodify.js"></script>

</body>
</html>





