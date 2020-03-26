<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/MAIN/login.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/MAIN/login.css"
	rel="stylesheet">

<!-- include modal -->
<script type="text/javascript"
	src="https://getbootstrap.com/docs/3.4/javascript/#modals"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
		
function postSend(path, params, method) {
	method = method || "post";
	var form = document.createElement("form");
	form.setAttribute("method", method);
	form.setAttribute("action", path);

	// 히든으로 값을 넣는다.
	for ( var key in params) { // {'name1':'var1','name2':'var2','name3':'var3'}
		var input_tag = document.createElement("input");
		input_tag.setAttribute("type", "hidden");
		input_tag.setAttribute("name", key) // name1, name2, name3
		input_tag.setAttribute("value", params[key]) // var1, var2, var3

		console.log("name : " + key);
		console.log("value : " + params[key]);

		form.appendChild(input_tag);
	}
	document.body.appendChild(form);
	form.submit();
}
	
		
		function kakao() {
			
		Kakao.init('5c66b81ac4ea858ce15c7241ac3dc1da');
		Kakao.Auth.loginForm({			
			success : function (authObj) {
				 Kakao.API.request({
					
	               url: '/v2/user/me',
		           success: function(res) {
		        	   console.log(res);
		        	   
		        	   var joinemail = res.kakao_account.email;
		        	   
		        	   var path = "USER_loginAjax.do";
		        	   var params = {
		        			   "joinemail" : joinemail,
		        			   "joinpw" : "kakao"
		        	   };
		        	   
		        	   postSend(path, params);
		        	   
		        	   
		            	   	console.log(res);
		 
		                     console.log(res.id);//<---- 콘솔 로그에 id 정보 출력(id는 res안에 있기 때문에  res.id 로 불러온다)
		 
		                     console.log(res.kaccount_email);//<---- 콘솔 로그에 email 정보 출력 (어딨는지 알겠죠?)
		 
		                     console.log(res.properties['nickname']);//<---- 콘솔 로그에 닉네임 출력(properties에 있는 nickname 접근 
		                             
		                 // res.properties.nickname으로도 접근 가능 )
		                     console.log(authObj.access_token);//<---- 콘솔 로그에 토큰값 출력
			}
		})
			},
	               fail: function(error) {
	                 alert(JSON.stringify(error));
	               }
	             });
	
		}
	
		
	</script>


</head>
<%
	int RandomNumber = (int) (Math.floor(Math.random() * (9999 - 1000 + 1)) + 1000);
%>
<body>

	<c:choose>
		<c:when test="${empty loginDto.joinemail}">
			<%@ include file="../ALL/header_logout.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../ALL/header_login.jsp"%>
		</c:otherwise>
	</c:choose>



	<div class="container">
		<div id="wap">
			<div class="margin"></div>
			<div id="loginform">
				<h1>로그인</h1>
				<table class="login">
					<tbody>
						<tr>
							<td class="logininfo"><input type="text" id="joinemail"
								name="joinemail" class="idpw" placeholder="이메일"></td>
							<td rowspan="2" class="logincell">
								<button id="loginbtn" onclick="login();">로그인</button>
							</td>

						</tr>
						<tr>
							<td class="logininfo"><input type="password" id="joinpw"
								name="joinpw" class="idpw" placeholder="비밀번호"></td>
						</tr>
						<tr>
							<td colspan="2"><p id="findidpw">
									<a href="javascript:modal();">아이디/비밀번호 찾기</a>
						</tr>

						<tr>
							<td colspan="2" id="error" align="left"></td>
						</tr>
					</tbody>
				</table>
				<div id="snslogin" class="">
				<button id="kakao-login-btn" onclick="kakao();">aa</button>
					<a href="http://developers.kakao.com/logout"></a>
					<!--  <button onclick="kakaoLogin();" id="kakao">카카오로그인</button>-->
					</br>
					<button onclick="">구글로그인</button>
					<p>
						아직 회원이 아니세요?<a href="USER_join.do">회원가입</a>
					</p>
				</div>
			</div>
			<div class="margin"></div>
		</div>
	</div>

	<!-- 모달 -->
	<div class="modal fade" role="dialog" id="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" align="center">아이디/비밀번호 찾기</h3>
				</div>
				<div class="modal-body" align="center">
					<form action="USER_changepw.do" method="post"
						enctype="application/x-www-form-urlencoded">
						<table class="M_table">
							<tr>
								<th>이메일</th>
								<td><input type="text" id="joinemail2" name="joinemail"
									onclick="checkid();"></td>
							</tr>
							<tr>
								<td id="M_error" colspan="2" align="right">*해당 메일로 가입된 아이디가
									있습니다.</td>
							</tr>
							<tr>
								<th>새비밀번호</th>
								<td><input type="password" id="newpw" name="joinpw"></td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" id="pwcheck"></td>
							</tr>
							<tr>
								<th></th>
								<td><span id="errormessge"></span></td>
							</tr>
						</table>
						<button type="button" onclick='form.submit()' id="changepw"
							class="btn btn-default" data-dismiss="modal">변 경</button>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	

</body>
</html>