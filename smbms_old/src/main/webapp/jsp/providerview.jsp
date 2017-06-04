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
			<div class="content">
				<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
			
				<table class="box">
					<tbody>
						<tr>
							<td class="field">供应商编号：</td>
							<td>${provider.proCode } 
							</td>
						</tr>
						<tr>
							<td class="field">供应商名称：</td>
							<td>${provider.proName } 
							</td>
						</tr>
						<tr>
							<td class="field">联系人：</td>
							<td>${provider.proContact }
							</td>
						</tr>
						<tr>
							<td class="field">联系电话：</td>
							<td>${provider.proPhone }
							</td>
						</tr>
						<tr>
							<td class="field">联系地址：</td>
							<td>${provider.proAddress }
							</td>
						</tr>
						<tr>
							<td class="field">传真：</td>
							<td>${provider.proFax }
							</td>
						</tr>
						<tr>
							<td class="field">描述：</td>
							<td>${provider.proDesc }
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button"
					id="button" onclick="history.back(-1)" value="返回"
					class="input-button">
			</div>

	</div>


</body>
</html>





