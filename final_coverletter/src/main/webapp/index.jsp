<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	::selection{
		background-color: #00bf6f;
		color: white;
	}
</style>

</head>
<body>
<%@ include file="WEB-INF/views/ALL/header_login.jsp"%>
	<a href ="home.do"> 이동 </a> <br/>
	<a href ="error.do"> 에러 </a> <br/>
	<a href ="MAIN_main.do"> 메인페이지</a> <br/>
	<a href ="MAIN_SelectOne.do"> 회사</a> <br/>
	<a href ="USER_userMain.do"> 마페</a> <br/>
	<a href="USER_join.do">회원가입</a><br/>	
	
	<a href="JOB_jobSearch.do">회사검색</a><br/>	
	<a href="USER_userPFwrite.do">포폴쓰기</a>
	
	
	<a href ="BOARD_boardList.do">자유게시판</a><br/>
	<a href ="USER_userPFList.do">포폴게시판</a><br/>
	<a href ="USER_userCVList.do">이력서게시판</a><br/>
	<a href	="USER_userJobList.do">채용 즐겨찾기 게시판</a><br/>
	<a href ="JOB_jobCenter.do">취업센터</a><br/>
	<a href ="javascript:void(0);" onclick="window.open('MAIN_pay.do?joinemail=USER@GMAIL.COM', '', 'width=450,height=400,top=150,left=400');">후원하기</a><br/>
	<a href = "PAY_payList.do">후원내역 확인하기</a>
	
</body>
</html>