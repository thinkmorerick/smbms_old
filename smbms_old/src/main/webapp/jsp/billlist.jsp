<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>超市账单管理系统-订单管理</title>
    

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  </head>
  
  <body>
		<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
		<input name="rqueryProductName" id="rqueryProductName" type="hidden" value="${queryProductName }">
		<input name="rqueryProviderId"  id="rqueryProviderId" type="hidden" value="${queryProviderId }">
		<input name="rqueryIsPayment"  id="rqueryIsPayment" type="hidden" value="${queryIsPayment }">
<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" name="queryBill" id="queryBill" action="${pageContext.request.contextPath }/bill.do">
							<input name="method" value="query" class="input-text" type="hidden"> 
							<input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
							商品名称：<input name="queryProductName" class="input-text" type="text" value="${queryProductName }" size="8">
							供应商名称：<select name="queryProviderId">
										<c:if test="${providerList != null }">
							   				<option value="0">--不限--</option>
							  					 <c:forEach var="provider" items="${providerList}">
							   						<option <c:if test="${provider.id == queryProviderId }">selected="selected"</c:if>
							   							value="${provider.id}">${provider.proName}</option>
											     </c:forEach>
										</c:if>
									</select>
							是否付款：<select name="queryIsPayment">
										<option value="0">--请选择--</option>
										<option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>
										<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option>
		        					</select>
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加账单" class="input-button" onclick="window.location='${pageContext.request.contextPath }/jsp/billadd.jsp'" type="button">
			</em>
			<div class="title">订单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="80"><div  align="center">编号</div></td>
						<td width="80"><div  align="center">商品名称</div></td>
						<td width="100"><div align="center">供应商</div></td>
						<td width="100"><div align="center">账单金额</div></td>
						<td width="100"><div align="center">是否付款</div></td>
						<td width="150"><div align="center">创建时间</div></td>
						<td width="150"><div align="center">操作</div></td>
					</tr>
					
					<c:forEach var="bill" items="${billList }" varStatus="status">
						<tr>
							<td>
								<span>${bill.billCode }</span>
							</td>
							<td>
								<span>${bill.productName }</span>
							</td>
							<td>
								<span>${bill.providerName }</span>
							</td>
							<td>
								<span>${bill.totalPrice }</span>
							</td>
							<td>
							<span>
								<c:if test="${bill.isPayment == 1}">未付款</c:if>
								<c:if test="${bill.isPayment == 2}">已付款</c:if>
							</span>
							</td>
							<td>
							<span>
							<fmt:formatDate value="${bill.createDate}" pattern="yyyy-MM-dd"/>
							</span>
							</td>
							<td>
								<span><a class="viewBill" href="javascript:;" bid=${bill.id } bcode=${bill.billCode }>查看</a></span>
								<span><a class="modifyBill" href="javascript:;" bid=${bill.id } bcode=${bill.billCode }>修改</a></span>
								<span><a class="deleteBill" href="javascript:;" bid=${bill.id } bcode=${bill.billCode }>删除</a></span>
							</td>
						</tr>
					</c:forEach>
					
				
					
					
					
				</tbody>
			</table>
			<!-- 分页部分  -->
				<div class="borspan">				
					<a id="autopbn" href="javascript:;" 
					style="display:none" 
					recordnum="${pageSupport.recCount }"
					curpage="${pageSupport.currPageNo }"  
					totalpage="${pageSupport.totalPageCount }" 
					pageNavNum="${pageNavNum }">
					</a>
				</div>	
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>
	
    
  </body>
</html>


	

