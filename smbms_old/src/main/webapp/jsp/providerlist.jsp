<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>超市账单管理系统-供应商管理</title>
    

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  </head>
  
  <body>
<div class="menu">
		<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="${pageContext.request.contextPath }/provider.do">
							<input name="method" value="query" class="input-text" type="hidden"> 
							供应商名称：<input name="queryProName" class="input-text" type="text" value="${queryProName }">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加供应商" class="input-button" onclick="window.location='${pageContext.request.contextPath }/jsp/provideradd.jsp'" type="button">
			</em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="80"><div  align="center">编码</div></td>
						<td width="100"><div  align="center">供应商名称</div></td>
						<td width="100"><div  align="center">联系人</div></td>
						<td width="100"><div align="center">联系电话</div></td>
						<td width="100"><div align="center">传真</div></td>
						<td width="150"><div align="center">创建时间</div></td>
						<td width="150"><div align="center">操作</div></td>
					</tr>
					
					<c:forEach var="provider" items="${providerList }" varStatus="status">
						<tr>
							<td>
								<span>${provider.proCode }</span>
							</td>
							<td>
								<span>${provider.proName }</span>
							</td>
							<td>
								<span>${provider.proContact }</span>
							</td>
							<td>
								<span>${provider.proPhone }</span>
							</td>
							<td>
								<span>${provider.proFax }</span>
							</td>
							<td>
								<span>
									<fmt:formatDate value="${provider.creationDate }" pattern="yyyy-MM-dd"/>
								</span>
							</td>
							<td>
								<span><a class="viewProvider" href="javascript:;" proid=${provider.id } proname=${provider.proName }>查看</a></span>
								<span><a class="modifyProvider" href="javascript:;" proid=${provider.id } proname=${provider.proName }>修改</a></span>
								<span><a class="deleteProvider" href="javascript:;" proid=${provider.id } proname=${provider.proName }>删除</a></span>
							</td>
						</tr>
					</c:forEach>
					
				
					
					
					
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/providerlist.js"></script>
	
    
  </body>
</html>


	

