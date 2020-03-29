<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<style type="text/css">

	input{
		width: 400px;
		height: 400px;
	}

</style>
</head>
<%
	String tid = (String)session.getAttribute("tid");
%>
<body>
	<h1>결제성공</h1>
	
	<script type="text/javascript">
	
	</script>	
	
	<form name="payForm" method="post" action="MAIN_payDetail.do">
		<input type="hidden" name="tid" value="<%=tid%>"/>
		<input type="submit" value="확인"/>
	</form>
	
	
</body>
</html>