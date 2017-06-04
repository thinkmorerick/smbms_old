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
			<div class="title">账单管理&gt;&gt;</div>

		</div>
		<form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/bill.do">
			<input type="hidden" name="method" value="add">
			<div class="content">
				<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
			
				<table class="box">
					<tbody>
						<tr>
							<td class="field">订单编码：</td>
							<td><input type="text" name="billCode" class="text" id="billCode" value=""> 
							<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">商品名称：</td>
							<td><input type="text" name="productName" class="text" id="productName" value=""> 
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">商品单位：</td>
							<td><input type="text" name="productUnit" class="text" id="productUnit" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">商品数量：</td>
							<td><input type="text" name="productCount" class="text" id="productCount" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">总额：</td>
							<td><input type="text" name="totalPrice" class="text" id="totalPrice" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">供应商：</td>
							<td>
							<select name="providerId" id="providerId">
							</select>
							<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">是否付款：</td>
							<td><select name="isPayment" id="isPayment">
									<option value="1" checked="">已付款</option>
									<option value="2">未付款</option>
							</select>
							</td>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/billadd.js"></script>

</body>
</html>





