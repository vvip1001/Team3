<%@page import="com.job.coverletter.model.joinUser.dto.JoinUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/main.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/MAIN/main.css" rel="stylesheet">

</head>
<body>

<c:choose>
	<c:when test="${not empty loginDto}">
	<%@ include file="../ALL/header_logout.jsp"%>
	</c:when>
	<c:otherwise>	
	<%@ include file="../ALL/header_login.jsp"%>
	</c:otherwise>
</c:choose>

   	<div class="container" style="background-color: #ebe6e6;">
		<div id="MaintopDiv">
			<h1>[자소서 성공 페이지]</h1>
		</div>
		
		<div class="companySide"></div>
		<div class="company">
			<h5>웹 개발자</h5>
			
			<div class="companyItem">
				<div class="companyItemTop">
					<img class="companyImg" src="https://image.rocketpunch.com/company/114788/globalinformation_logo_1581308381.png?s=400x400&t=inside"/>
				</div>
				<div class="companyItemBottom">
					<h6>(주)글로벌인포메이션</h6>
					<div>PHP 웹프로그래머</div><br/><br/>
					<footer class="endDate">04/01 마감</footer>
				</div>
			</div>
			
			<div class="companyItem">
				<div class="companyItemTop">
					<img class="companyImg" src="https://image.rocketpunch.com/company/98782/reverselab_logo_1561621769.png?s=400x400&t=inside"/>
				</div>
				<div class="companyItemBottom">
					<h6>(주)리버스랩</h6>
					<div>PHP 웹프로그래머</div><br/><br/>
					<footer class="endDate">04/01 마감</footer>
				</div>
			</div>
			
			<div class="companyItem">
				<div class="companyItemTop">
					<img class="companyImg" src="https://static.rocketpunch.com/images/company/company.png"/>
				</div>
				<div class="companyItemBottom">
					<h6>(주)SK스타트업스튜디오</h6>
					<div>PHP 웹프로그래머</div><br/><br/>
					<footer class="endDate">04/01 마감</footer>
				</div>
			</div>
			
			<div class="companyItem">
				<div class="companyItemTop">
					<img class="companyImg" src="https://image.rocketpunch.com/company/20839/harinio_logo_1577707068.png?s=400x400&t=inside"/>
				</div>
				<div class="companyItemBottom">
					<h6>(주)트렌비</h6>
					<div>PHP 웹프로그래머</div><br/><br/>
					<footer class="endDate">04/01 마감</footer>
				</div>
			</div>
			
		
			
		</div>
		
		<div class="companySide"></div>
		<div class="company">
			<h5>프론트앤드</h5>
		
		</div>
		
		<div class="companySide"></div>
		<div class="company">
			<h5>백앤드</h5>
			
		</div>
		
		<div class="companySide"></div>
		<div class="totalCompany">
			<h5>전체</h5>
		
		</div>		
     
	</div>
</body>
</html>