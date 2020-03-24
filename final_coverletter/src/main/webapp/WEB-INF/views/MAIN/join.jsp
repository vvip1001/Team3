<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/join.js?ver=2"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/MAIN/join.css?ver=1" rel="stylesheet">
</head>

<body>
   <%@ include file="../ALL/header_logout.jsp"%>

   <div class="container" style="height: 800px;">
   
   
   
   <c:choose>
      <c:when test="${empty joinuserDto}">
         <f:form modelAttribute="joinuserDto" action="USER_joinRes.do" method="post" onsubmit="return confirmSubmit()">
           
            <h1 id="hello">환영합니다</h1>
            <table id="jointable">
               
               <tbody>
                  <tr>
                     <td id="info" colspan="2" align="right">* 값은 필수입니다.</td>
                  <tr>
                     <th>이 메 일*</th>
                     <td class="joininfo"><input type="text" id="joinemail" name="joinemail" class="register" readonly="readonly" placeholder="이메일을 입력을 위해 클릭하세요." onclick="checkid();"></td>
                     <td class="checkcell"></td> 
                  </tr>
                  <tr>
                   <th></th>
                     <td colspan="2" align="left" id="idcheck" >
                        <f:errors path="joinemail" />
                     </td>
                  </tr>
                  <tr>
                     <th>이    름*</th>
                     <td class="joininfo">
                     <input type="text" id="joinname" name="joinname" class="register" placeholder="이름을 입력하세요" >
                     </td>
                     </br>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="namecheck" >
                        <f:errors path="joinname" />
                     </td>
                  </tr>
                  <tr>
                     <th>비밀번호*</th>
                     <td class="joininfo"><input type="text" id="joinpw" name="joinpw" class="register" placeholder="비밀번호를 입력하세요"></td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="pwcheck"  >
                        <f:errors path="joinpw" />
                     </td>
                  </tr>
                  <tr>             
                     <th>비밀번호 확인*</th>
                     <td class="joininfo"><input type="text" id="joinpw2" class="register" placeholder="비밀번호를 확인하세요"></td>
                  </tr>
                  <tr>
                  <th></th>
                     <td colspan="2" align="left" id="pwcheck2" >
                        
                     </td>
                  </tr>
                  <tr>
                     <th>생년월일*</th>
                     <td class="joininfo">
                        <input type="text" name="joinbirth" id="joinbirth" class="register" placeholder="yyyynnmm 숫자만입력해주세요" maxlength="8">
                     </td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="birthcheck" >
                        <f:errors path="joinbirth"/>
                     </td>
                  </tr>
                  <tr>
                     <th>성   별*</th>
                     <td><input type="radio" name="joinsex" class="joinsex" id="joinsexF" value="F">
                          <label>여성</label>
                        <input type="radio" name="joinsex" class="joinsex" id="joinsexM" value="M">
                        <label>남성</label>                  
                     </td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="sexcheck" >
                        <f:errors path="joinsex"/>
                     </td>
                  </tr>
               </tbody>
                  <tr>
                     <td colspan="2" align="center" >
                        <button id="join" type="submit" >회원가입</button>
                     </td>
                  </tr>
            </table>
            </f:form>
      </c:when>
      <c:otherwise> <!-- dto가 있을때  -->
        <f:form modelAttribute="joinuserDto" action="USER_joinRes.do" method="post" onsubmit="return confirmSubmit()">
           
            <h1 id="hello">환영합니다</h1>
            <table id="jointable">
               
               <tbody>
                  <tr>
                     <td id="info" colspan="2" align="right">* 값은 필수입니다.</td>
                  <tr>
                     <th>이 메 일*</th>
                     <td class="joininfo"><input type="text" id="joinemail" name="joinemail" class="register" value="${joinuserDto.joinemail}"></td>
                     <td class="checkcell"></td> 
                  </tr>
                  <tr>
                   <th></th>
                     <td colspan="2" align="left" id="idcheck" >
                        <f:errors path="joinemail" />
                     </td>
                  </tr>
                  <tr>
                     <th>이    름*</th>
                     <td class="joininfo"><input type="text" id="joinname" name="joinname" class="register" value="${joinuserDto.joinname}"></td></br>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="namecheck" >
                        <f:errors path="joinname" />
                     </td>
                  </tr>
                  <tr>
                     <th>비밀번호*</th>
                     <td class="joininfo"><input type="text" id="joinpw" name="joinpw" class="register" value="${joinuserDto.joinpw}"></td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="pwcheck"  >
                        <f:errors path="joinpw" />
                     </td>
                  </tr>
                  <tr>             
                     <th>비밀번호 확인*</th>
                     <td class="joininfo"><input type="text" id="joinpw2" class="register" placeholder="비밀번호를 확인하세요" onck></td>
                  </tr>
                  <tr>
                  <th></th>
                     <td colspan="2" align="left" id="pwcheck2">
                        
                     </td>
                  </tr>
                  <tr>
                     <th>생년월일*</th>
                     <td class="joininfo">
                        <input type="text" name="joinbirth" id="joinbirth" class="register" value="${joinuserDto.joinbirth}" maxlength="8">
                     </td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="birthcheck" >
                        <f:errors path="joinbirth"/>
                     </td>
                  </tr>
                  <tr>
                     <th>성   별*</th>
                     <td><input type="radio" name="joinsex" class="joinsex" id="joinsexF" value="F" checked="${joinuserDto.joinsex eq 'F'? 'checked' : '' }">         
                          <label>여성</label>
                        <input type="radio" name="joinsex" class="joinsex" id="joinsexM" value="M" checked="${joinuserDto.joinsex eq 'M'? 'checked' : '' }">
                        <label>남성</label>                  
                     </td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="sexcheck">
                        <f:errors path="joinsex"/>
                     </td>
                  </tr>
               </tbody>
                  <tr>
                     <td colspan="2" align="center" >
                        <button id="join" type="submit" >회원가입</button>
                     </td>
                  </tr>
            </table>
            </f:form>
      
         </c:otherwise>      
      </c:choose> 
      </div>
</body>
<script type="text/javascript">




</script>

</html>

