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

</head>
<body>
<%@ include file="../ALL/header_login.jsp"%>
   <div class="container">
         <form action="/signup" method="post">
        
         <table>
            <caption>환영합니다!</caption>
            <tbody>
               <tr>
                  <td id="info">*은 필수입니다.</td>
               <tr>
                  <th>이 메 일*</th>
                  <td><input type="text" id="joinemail" name="joinemail" placeholder="이메일을 입력하세요">
                     <input type="button" value="">
                  </td>
                  <td id="idcheck" >아이디 유효성</td>
               </tr>
               <tr>
                  <th>이    름*</th>
                  <td><input type="text" id="joinname" name="joinname" placeholder="이름을 입력하세요" ></td>
                  <td id="namecheck">이름 유효성</td>
               </tr>
               <tr>
                  <th>비밀번호*</th>
                  <td><input type="text" id="joinpw" name="joinpw" placeholder="비밀번호를 입력하세요"></td>
                  <td id="pwcheck">비밀번호유효성</td>
               </tr>
               <tr>
                  <th>비밀번호 입력*</th>
                  <td><input type="text" id="pwcheck" name="pwcheck" placeholder="비밀번호를 확인하세요"></td>
                  <td id="pwcheck2">비밀번호 유효성</td>
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
                  <th>성   별*</th>
                  <td><input type="radio" name="joinsex" value="female">여자
                     <input type="radio" name="joinsex" value="male">남자
                  </td>
                  <td id="sexcheck">성별 체크</td>
               </tr>
            </tbody>
               <tr>
                  <td colspan="2">
                     <button type="submit" >회원가입</button>
                  </td>
               </tr>
         </table>
         </form>
         
      </div>
</body>
</html>