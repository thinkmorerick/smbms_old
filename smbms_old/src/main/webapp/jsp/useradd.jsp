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
		<form id="form1" name="form1" method="post" action="user.do">
			<input type="hidden" name="method" value="add">
			<div class="content">
				<table class="box">
					<tbody>
						<tr>
							<td class="field">用户名：</td>
							<td><input type="text" name="name" class="text" id="name"
								value=""> <font color="red">*</font><font color="red"
								id="name_span"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户账号：</td>
							<td><input type="text" name="loginName" class="text"
								id="loginName" value=""> <font color="red">*</font><font
								color="red" id="loginName_span"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户密码：</td>
							<td><input type="password" name="password" class="text"
								id="password" value=""> <font color="red">*</font><font
								color="red" id="password_span"></font>
							</td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input type="password" name="rpassword" class="text"
								id="rpassword" value=""> <font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class="field">用户性别：</td>
							<td><select name="gender" id="gender">
									<option value="1" checked="">男</option>
									<option value="2">女</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td><input type="text" name="birthday" class="Wdate"
								id="birthday" readonly="readonly" onclick="WdatePicker();"> 
								<font color="red">*</font>
								<font color="red" id="birthDate_span"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户电话：</td>
							<td><input type="text" name="phone" class="text" id="phone"
								value=""> <font color="red">*</font><font color="red"
								id="phone_span"></font>
							</td>

						</tr>
						<tr>
							<td class="field">用户地址：</td>
							<td><input name="address" id="address" class="text" value="">
							</td>
						</tr>
						<tr>
							<td class="field">用户权限：</td>

							<td><input type="radio" name="userType" value="1">管理员<input
								type="radio" name="userType" value="2" checked="true">普通用户
								<input type="radio" name="userType" value="3">经理</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="add" id="add" value="保存"
					class="input-button"> <input type="button" name="button"
					id="button" onclick="history.back(-1)" value="返回"
					class="input-button">
			</div>

		</form>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/add.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>

</body>
</html>





