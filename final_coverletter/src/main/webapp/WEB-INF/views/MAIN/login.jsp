<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/MAIN/login.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/MAIN/login.css"
	rel="stylesheet">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#error").hide();
		
	});
	
	function login(){
		
		
		
		var joinemail = $("#joinemail").val().trim();
		var joinpw = $("#joinpw").val().trim();
		//console.log("joinemail : " + joinemail + " / joinpw : " + joinpw);
			
		var loginVal = {"joinemail":joinemail, "joinpw":joinpw};
		
		// 유저아이디나 유저 비밀번호가 없다면
		if(joinemail == null || joinemail == "" || joinpw == null || joinpw == ""){
			alert("아이디나 비밀번호를 입력해주세요 !");
			
		}else{
			$.ajax({
				type: "post",
				url: "loginAjax.do",
				data: JSON.stringify(loginVal),
				contentType: "application/json",
				dataType: "json",
				success: function(msg){
					if(msg.check == true){
						location.href = "main.do"
					}else{
						$("#error").show();
						$("#error").html("ID 혹은 PW가 잘못됨");
						
					}
				
			}, error: function(){
				alert("통신 실패");
			}
		});
		}
		
	}
	
</script>

</head>
<body>

	<!-- 해더 -->
	<%@ include file="../ALL/header_login.jsp"%>


	<div class="container">

		<table class="login">
			<caption>로그인</caption>
			<tbody>
				<tr>
					<td><input type="text" id="joinemail" name="joinemail"
						class="idpw" placeholder="e-mail"></td>

				</tr>
				<tr>
					<td><input type="password" id="joinpw" name="joinpw"
						class="idpw" placeholder="password"></td>
				</tr>
				<tr>

					<td rowspan="2" class="loginbtn"><input type="button"
						onclick="login();" value="로그인" /></td>

				</tr>
				<tr>
					<td colspan="2" id="error"></td>
				</tr>
			</tbody>
		</table>
		<div id="snslogin">
			<button onclick="">카카오로그인</button>
			<button onclick="">구글로그인</button>
		</div>
		<div>
			<p>
				아직 회원이 아니세요?><a href="join.do">회원가입</a>
		</div>



	</div>
</body>
</html>