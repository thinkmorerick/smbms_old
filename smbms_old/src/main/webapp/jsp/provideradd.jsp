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
			<div class="title">供应商管理&gt;&gt;</div>

		</div>
		<form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/provider.do">
			<input type="hidden" name="method" value="add">
			<div class="content">
				<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
			
				<table class="box">
					<tbody>
						<tr>
							<td class="field">供应商编码：</td>
							<td><input type="text" name="proCode" class="text" id="proCode" value=""> 
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">供应商名称：</td>
							<td><input type="text" name="proName" class="text" id="proName" value=""> 
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">联系人：</td>
							<td><input type="text" name="proContact" class="text" id="proContact" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">联系电话：</td>
							<td><input type="text" name="proPhone" class="text" id="proPhone" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">联系地址：</td>
							<td><input type="text" name="proAddress" class="text" id="proAddress" value="">
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">传真：</td>
							<td><input type="text" name="proFax" class="text" id="proFax" value=""> 
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="field">描述：</td>
							<td><input type="text" name="proDesc" class="text" id="proDesc" value=""> 
								<font color="red"></font>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/provideradd.js"></script>

</body>
</html>





