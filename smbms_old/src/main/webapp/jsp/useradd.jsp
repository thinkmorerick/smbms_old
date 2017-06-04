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
		<form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user.do">
			<input type="hidden" name="method" value="add">
			<div class="content">
				<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
			
				<table class="box">
					<tbody>
						<tr>
							<td class="field">用户编码：</td>
							<td><input type="text" name="userCode" class="text" id="userCode" value=""> 
								<!-- 放置提示信息 -->
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户名称：</td>
							<td><input type="text" name="userName" class="text" id="userName" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户密码：</td>
							<td><input type="password" name="userPassword" class="text" id="userPassword" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input type="password" name="ruserPassword" class="text" id="ruserPassword" value="">
								<font color="red"></font>
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
							<td><input type="text" name="birthday" class="Wdate" id="birthday" readonly="readonly" onclick="WdatePicker();"> 
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户电话：</td>
							<td><input type="text" name="phone" class="text" id="phone"
								value=""> <font color="red"></font>
							</td>

						</tr>
						<tr>
							<td class="field">用户地址：</td>
							<td><input name="address" id="address" class="text" value="">
							</td>
						</tr>
						<tr>
							<td class="field">用户类别：</td>

							<td>
							<input type="radio" name="userType" value="1">管理员
							<input type="radio" name="userType" value="2">经理
							<input type="radio" name="userType" value="3" checked="true">普通用户</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="addBtn" id="addBtn" value="保存"
					class="input-button"> 
				<input type="button" name="button"
					id="button" onclick="history.back(-1)" value="返回"
					class="input-button">
			</div>

		</form>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/useradd.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>

</body>
</html>





