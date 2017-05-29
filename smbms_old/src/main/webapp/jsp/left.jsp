<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript">
	function logout() {
		top.location = "${pageContext.request.contextPath }/logout.do";
	}
</script>
</head>
<body class="frame-bd">
	<ul class="left-menu">
		<li><a href="billList.html" target="mainFrame"><img
				src="${pageContext.request.contextPath }/images/btn_bill.gif" />
		</a>
		</li>
		<li><a href="providerList.html" target="mainFrame"><img
				src="${pageContext.request.contextPath }/images/btn_suppliers.gif" />
		</a>
		</li>
		<li><a href="userList.html" target="mainFrame"><img
				src="${pageContext.request.contextPath }/images/btn_users.gif" />
		</a>
		</li>	
		<li><a href="updatePwd.html" target="mainFrame"><img
				src="${pageContext.request.contextPath }/images/btn_password.gif" />
		</a>
		</li>
		<li><a href="#" onClick="logout();"><img
				src="${pageContext.request.contextPath }/images/btn_exit.gif" />
		</a>
		</li>
	</ul>
</body>
</html>
