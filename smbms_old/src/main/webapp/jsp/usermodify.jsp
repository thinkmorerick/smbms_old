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
			<input type="hidden" name="method" value="modifysave">
			<div class="content">
				<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
				<input type="hidden" name="uid" value="${user.id }" />
				<table class="box">
					<tbody>
						<tr>
							<td class="field">用户名称：</td>
							<td><input type="text" name="userName" class="text" id="userName" value="${user.userName }">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户性别：</td>
							<td>
								<select name="gender" id="gender">
									<c:choose>
										<c:when test="${user.gender==1 }">
											<option value="1" selected="selected">男</option>
											<option value="2">女</option>
										</c:when>
										<c:otherwise>
											<option value="1">男</option>
											<option value="2" selected="selected">女</option>
										</c:otherwise>
									</c:choose>
								</select>
							</td>
						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td><input type="text" name="birthday" value="${user.birthday }" class="Wdate" id="birthday" readonly="readonly" onclick="WdatePicker();"> 
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">用户电话：</td>
							<td><input type="text" name="phone" value="${user.phone }" class="text" id="phone"
								value=""> <font color="red"></font>
							</td>

						</tr>
						<tr>
							<td class="field">用户地址：</td>
							<td><input name="address" id="address" class="text" value="${user.address }">
							</td>
						</tr>
						<tr>
							<td class="field">用户类别：</td>

							<td>
							<input type="radio" name="userType" value="1" <c:if test="${user.userType==1 }">checked="true"
							</c:if>>管理员
							<input type="radio" name="userType" value="2" <c:if test="${user.userType==2 }">checked="true"
							</c:if>>经理
							<input type="radio" name="userType" value="3" <c:if test="${user.userType==3 }">checked="true"
							</c:if>>普通用户
						</tr>
					</tbody>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="saveBtn" id="saveBtn" value="保存"
					class="input-button"> 
				<input type="button" name="button"
					id="button" onclick="history.back(-1)" value="返回"
					class="input-button">
			</div>

		</form>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/usermodify.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>

</body>
</html>





