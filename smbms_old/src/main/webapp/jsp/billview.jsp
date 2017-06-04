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
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">订单编码：</td>
					<td>${bill.billCode }</td>
				</tr>
				 <tr>
					<td class="field">商品名称：</td>
					<td>${bill.productName }</td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td>${bill.productUnit }</td>
				</tr>
				 <tr>
					<td class="field">商品数量：</td>
					<td>${bill.productCount }</td>
				</tr>
				<tr>
					<td class="field">总金额：</td>
					<td>${bill.totalPrice }</td>
				</tr>
				<tr>
					<td class="field">供应商：</td>
					<td>${bill.providerName }</td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td>
					<c:if test="${bill.isPayment == 1}">未付款</c:if>
					<c:if test="${bill.isPayment == 2}">已付款</c:if>
					</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>
</div>


</body></html>