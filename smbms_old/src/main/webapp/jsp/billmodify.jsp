<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">

</head>
<body>
<div class="main">
	<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
	<div class="optitle clearfix">
		<div class="title">订单管理&gt;&gt;</div>

	</div>
	<form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/bill.do">
		<input type="hidden" name="method" value="modifysave">
		<input type="hidden" name="id" value="${bill.id }">
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">订单编码：</td>
					<td><input type="text" name="billCode" class="text" id="billCode" value="${bill.billCode }" readonly="readonly"> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
					</td>
				</tr>
				 <tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="productName" class="text" id="productName" value="${bill.productName }"> 
					<font color="red"></font>
					</td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td><input type="text" name="productUnit" class="text" id="productUnit" value="${bill.productUnit }"> 
					<font color="red"></font>
					</td>
				</tr>
				 <tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="productCount" class="text" id="productCount" value="${bill.productCount }"> 
					<font color="red"></font>
					</td>
				</tr>
				<tr>
					<td class="field">总金额：</td>
					<td><input type="text" name="totalPrice" class="text" id="totalPrice" value="${bill.totalPrice }"> 
					<font color="red"></font>
					</td>
				</tr>
				<tr>
					<td class="field">供应商：</td>
					<td>
					<input type="hidden" value="${bill.providerId }" id="pid" />
					<select name="providerId" id="providerId">
		        	</select>
					<font color="red"></font>
					</td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td>
					<c:if test="${bill.isPayment == 1 }">
						<input type="radio" name="isPayment" value="1" checked="checked">未付款
						<input type="radio" name="isPayment" value="2" >已付款
					</c:if>
					<c:if test="${bill.isPayment == 2 }">
						<input type="radio" name="isPayment" value="1">未付款
						<input type="radio" name="isPayment" value="2" checked="checked">已付款
					</c:if>
					</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="save" id="save" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billmodify.js"></script>


</body></html>