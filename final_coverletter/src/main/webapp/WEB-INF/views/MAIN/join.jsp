<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/join.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/MAIN/join.css" rel="stylesheet">

<script type="text/javascript">
$(function () {
	$(".error").hide();
	
});
</script>




<style type="text/css">

#info{
	font-size: 15px;
	color: #DF7401;
}

th{
	font-size: 20px;
	width: 165px;
}

#hello {
	text-align: center;
	margin-top: 4%;
	margin-bottom: 1%;
	
}

#jointable {
	margin-left: 20%;
	width: 70%;
	border-collapse:inherit; 
	border-spacing: 12px;
	text-align: center; 
}

.register {
	display: table-cell;
	vertical-align: middle;
	height: 40px;
	width: 100%;
	border: 1px solid black;
	border-radius: 5px;
}

.joininfo{
	 display: table-cell;
	 width: fit-content;
	 height: fit-content;
}

.checkcell{
	vertical-align: middle;
	text-align: left;
	width: fit-content;
	height: fit-content;
}

#checkidbtn{
	width: 60%;
	height: 40px;
	background-color: #00bf6f;
	border-radius: 5px;
	color: white;
	text-align: center;
	font-size: 20px;
	
}

#join{
	margin-top: 5%;
	margin-left: 5%; 
	width: 100%;
	height: 50px;
	background-color: #00bf6f;
	border-radius: 5px;
	color: white;
	text-align: center;
	font-size: 15px;
}

#joinsex{
	display: table-cell;
	vertical-align: middle;
	width: 8%;
	height: 20px;
	position: relative;
	top: -5.5px;
	float: left;
}
#jointable label {
	top: 4px;
	font-size: 17px;
	float: left;
	margin-right: 30px;
}

</style>
</head>

<body>

<c:choose>
	<c:when test="${empty loginDto.joinemail}">
	<%@ include file="../ALL/header_logout.jsp"%>
	</c:when>
	<c:otherwise>	
	<%@ include file="../ALL/header_login.jsp"%>
	</c:otherwise>
</c:choose>



   <div class="container" style="height: 800px;">
         <form action="USER_joinRes.do" method="post">
        
         <h1 id="hello">환영합니다</h1>
         <table id="jointable">
         	
            <tbody>
               <tr>
                  <td id="info" colspan="2" align="right">* 값은 필수입니다.</td>
               <tr>
                  <th>이 메 일*</th>
                  <td class=""><input type="text" id="joinemail" name="joinemail" class="register" placeholder="이메일을 입력하세요"></td>
                  <td class="checkcell"><button id="checkidbtn" onclick="checkid();">중복확인</button></td>
               </tr>
               <tr>
               	<td colspan="2" align="center" id="idcheck" class="error" >아이디 유효성</td>
               </tr>
               <tr>
                  <th>이    름*</th>
                  <td class="joininfo"><input type="text" id="joinname" name="joinname" class="register" placeholder="이름을 입력하세요" ></td></br>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="namecheck" class="error" >이름 유효성</td>
               </tr>
               <tr>
                  <th>비밀번호*</th>
                  <td class="joininfo"><input type="text" id="joinpw" name="joinpw" class="register" placeholder="비밀번호를 입력하세요"></td>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="pwcheck" class="error" >비밀번호유효성</td>
               </tr>
               <tr>
                  <th>비밀번호 입력*</th>
                  <td class="joininfo"><input type="text" id="pwcheck" class="register" placeholder="비밀번호를 확인하세요"></td>
               </tr>
               <tr>
               	<td colspan="2" align="center" id="pwcheck2" class="error" >비밀번호유효성</td>
               </tr>
               <tr>
                  <th>생년월일*</th>
                  <td class="joininfo">
                     <input type="text" name="joinbirth" id="joinbirth" class="register" placeholder="yyyynnmm 숫자만입력해주세요">
                  </td>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="birthcheck" class="error" >생년월일 유효성</td>
               </tr>
               <tr>
                  <th>성   별*</th>
                  <td><input type="radio" name="joinsex" id="joinsex" value="F">
                  	  <label>여성</label>
                     <input type="radio" name="joinsex" id="joinsex" value="M">
                     <label>남성</label>                  
                  </td>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="sexcheck" class="error" >성별 유효성</td>
               </tr>
            </tbody>
               <tr>
                  <td colspan="2" align="center" >
                     <button id="join" type="submit" >회원가입</button>
                  </td>
               </tr>
         </table>
         </form>
      </div>
</body>
</html>