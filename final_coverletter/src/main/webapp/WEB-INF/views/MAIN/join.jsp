<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/join.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/MAIN/join.css" rel="stylesheet">


<style type="text/css">

h1{
	text-align: center;
}
#info{
	text-align: right;
}

table {
	margin-left: 33%;
}

</style>
</head>
<body>
<%@ include file="../ALL/header_login.jsp"%>
   <div class="container" style="height: 800px;">
         <form action="joinRes.do" method="post">
        
         <h1>환영합니다</h1>
         <table>
            <tbody>
               <tr>
                  <td id="info">*은 필수입니다.</td>
               <tr>
                  <th>이 메 일*</th>
                  <td><input type="text" id="joinemail" name="joinemail" placeholder="이메일을 입력하세요">
                     <input type="button" value="중복 확인">
                  </td>
               </tr>
               <tr>
               	<td colspan="2" align="center" id="idcheck" >아이디 유효성</td>
               </tr>
               <tr>
                  <th>이    름*</th>
                  <td><input type="text" id="joinname" name="joinname" placeholder="이름을 입력하세요" ></td></br>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="namecheck" >이름 유효성</td>
               </tr>
               <tr>
                  <th>비밀번호*</th>
                  <td><input type="text" id="joinpw" name="joinpw" placeholder="비밀번호를 입력하세요"></td>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="pwcheck" >비밀번호유효성</td>
               </tr>
               <tr>
                  <th>비밀번호 입력*</th>
                  <td><input type="text" id="pwcheck" name="pwcheck" placeholder="비밀번호를 확인하세요"></td>
               </tr>
               <tr>
               	<td colspan="2" align="center" id="pwcheck2" >비밀번호유효성</td>
               </tr>
               <tr>
                  <th>생년월일*</th>
                  <td>
                     <select>
                        <option></option>
                     </select>
                     <select>
                        <option></option>
                     </select>
                     <select>
                        <option></option>
                     </select>
                  </td>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="birthcheck" >생년월일 유효성</td>
               </tr>
               <tr>
                  <th>성   별*</th>
                  <td><input type="radio" name="joinsex" value="female">여자
                     <input type="radio" name="joinsex" value="male">남자
                  </td>
               </tr>
                <tr>
               	<td colspan="2" align="center" id="sexcheck" >성별 유효성</td>
               </tr>
            </tbody>
               <tr>
                  <td colspan="2" align="center">
                     <button type="submit" >회원가입</button>
                  </td>
               </tr>
         </table>
         </form>
      </div>
</body>
</html>