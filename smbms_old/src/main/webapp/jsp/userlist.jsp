<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>超市账单管理系统-用户管理</title>
    

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  </head>
  
  <body>
<div class="menu">
		<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="${pageContext.request.contextPath }/user.do">
							<input name="method" value="query" class="input-text" type="hidden"> 
							用户名：<input name="queryname" class="input-text" type="text" value="${queryUserName }">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加用户" class="input-button" onclick="window.location='${pageContext.request.contextPath }/jsp/useradd.jsp'" type="button">
			</em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="80"><div  align="center">用户编码</div></td>
						<td width="80"><div  align="center">用户名称</div></td>
						<td width="100"><div  align="center">性别</div></td>
						<td width="100"><div align="center">年龄</div></td>
						<td width="100"><div align="center">电话</div></td>
						<td width="150"><div align="center">用户类型</div></td>
						<td width="150"><div align="center">操作</div></td>
					</tr>
					
					<c:forEach var="user" items="${userList }" varStatus="status">
						<tr>
							<td>
								<span>${user.userCode }</span>
							</td>
							<td>
								<span>${user.userName }</span>
							</td>
							<td>
								<span>
									<c:if test="${user.gender==1 }">男</c:if>
									<c:if test="${user.gender==2 }">女</c:if>
								</span>
							</td>
							<td>
								<span>${user.age }</span>
							</td>
							<td>
								<span>${user.phone }</span>
							</td>
							<td>
								<span>
									<c:if test="${user.userType==1 }">系统管理员</c:if>
									<c:if test="${user.userType==2 }">经理</c:if>
									<c:if test="${user.userType==3 }">普通员工</c:if>
								</span>
							</td>
							<td>
								<span><a class="viewUser" href="javascript:;" userid=${user.id } username=${user.userName }>查看</a></span>
								<span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }>修改</a></span>
								<span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }>删除</a></span>
							</td>
						</tr>
					</c:forEach>
					
				
					
					
					
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/userlist.js"></script>
	
    
  </body>
</html>


	

