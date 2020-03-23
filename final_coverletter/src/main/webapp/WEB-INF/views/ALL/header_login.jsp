<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- include bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/ALL/header_login.css">

<title>Insert title here</title>
</head>
<body>
   <div id="headerwap">
         <div id="logo"><img alt="logo" src="${pageContext.request.contextPath}/resources/IMG/logo.png" onclick="index.jsp"></div>
            <div id="menu1">
               <span><a href="#">공채캘린더</a></span> 
               <span><a href="#">채용검색</a> </span>
            </div>
            <div id="menu2">
               <span >|</span>
               <span><a href="#">마이페이지</a></span>
               <span><a href="#">취업센터</a></span>
               <span><a href="BOARD_boardList.do">자유게시판</a></span>
               <span >|</span>
               <span><a href="USER_logout.do">로그아웃</a></span>
            </div>    
   </div>

    
</body>
</html>