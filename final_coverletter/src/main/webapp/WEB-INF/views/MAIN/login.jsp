<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/login.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/MAIN/login.css" rel="stylesheet">

</head>
<body>
<%@ include file="../ALL/header_login.jsp"%>
   <div class="container">
         <form action="" id="form">
            <table class="login">
               <caption>로그인</caption>
               <tbody>
                  <tr>                  
                     <td><input type="text" id="userid" name="ID" class="idpw" placeholder="e-mail"></td>
                     <td rowspan="2" class="loginbtn" ><button type="submit">로그인</button></td>
                  </tr>
                  <tr>
                     <td><input type="password" id="userpw" name="PW" class="idpw" placeholder="password"></td>
                  </tr>   
                  <tr>
                     <td colspan="2" id="error">error메세지나오는 곳</td>
               </tbody>
            </table>
            <div id="snslogin">
               <button >카카오로그인</button>
               <button >구글로그인</button>
            </div>
         </form>
         <div><p>아직 회원이 아니세요?><a href="join.jsp">회원가입</a></div>
        
      
      
   </div>
</body>
</html>