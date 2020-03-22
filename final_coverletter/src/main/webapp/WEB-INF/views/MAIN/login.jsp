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
<script type="text/javascript">
	$(function() {
		$("#error").hide();
		
	});

	
	//일반 로그인 
	function login() {
		
			var joinemail = $("#joinemail").val().trim();
			var joinpw = $("#joinpw").val().trim();
			//console.log("joinemail : " + joinemail + " / joinpw : " + joinpw);
	
			var loginVal = {
				"joinemail" : joinemail,
				"joinpw" : joinpw
			};
	
		console.log(loginVal)

		// 유저아이디나 유저 비밀번호가 없다면
		if (joinemail == null || joinemail == "" || joinpw == null
				|| joinpw == "") {
			alert("아이디나 비밀번호를 입력해주세요 !");
		} else {
			$.ajax({
				type : "post",
				url : "USER_loginAjax.do",
				data : JSON.stringify(loginVal),
				contentType : "application/json",
				dataType : "json",
				success : function(msg) {

					if (msg.check == true) {
						location.href = "MAIN_main.do"
					} else {
						$("#error").show();
						$("#error").html("ID 혹은 PW가 잘못되었습니다.");
					}

				},
				error : function() {
					alert("통신 실패");
				}
			});
		}
	}
	
	function modal() {
		$('#modal').modal('show');
		$("#M_error").hide();
	}
	
	
	
</script>

<style type="text/css">

#wap {
		display: flex;
	}
	.margin{
		flex: 1;
	}
	#loginform {
		flex: 2;
		margin-top: 14%;
		margin-bottom: 16%;
	}
	
	h1{
		text-align: center;
		font-weight: bold;
		margin-bottom: 50px;
	}
	.login{
		margin-left: 10%;
		width: 80%;
		border-collapse:inherit; 
		border-spacing: 12px;
		text-align: center; 
		
	}

	.login input {
	    display: table-cell;
	    vertical-align: middle;
	    height: 50px;
	    width: 100%;
	    border: 1px solid black;
	    border-radius: 5px 5px 5px 5px; 
	     
	}
	
	.logininfo{
	    display: table-cell;
	    width: fit-content;
	    height: fit-content;
	 
	}
	
	
	.logincell{
		vertical-align: middle;
	    text-align: center;
	    width: fit-content;
	    height: fit-content;

	}
	#loginbtn{
		background-color: gray;
		border-radius: 5px 5px 5px 5px;
		font-size: 20px;
		color: white;
		text-align: center;
		width: 100%;
		height: 110px;
		
	}
	#loginbtn:hover{
		background-color: #00bf6f;
	}
	
	#findidpw{
		text-align: right;
	}
	
	#snslogin button {
		width: 65%;
		height: 40px;
		margin-left: 16.5%;	
		margin-bottom: 4%;
	}
	#snslogin p {
		text-align: center;
		font-weight: bold;
		margin-top: 30px;
	}

	#error{
		color: red;
	}

	.M_table{
		border-spacing: 10px;
		border-collapse: separate;
	}
	
	.M_table input{
		height: 30px;
		border-radius: 5px 5px 5px 5px;
		margin-right: 6px;
	}
	
	.modal-content {
		margin-top: 38%;
	}
	
</style>




</head>
<body>

	<c:choose>
		<c:when test="${empty loginDto}">
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
							<td class="logininfo"><input type="text" id="joinemail" name="joinemail"
								class="idpw" placeholder="이메일"></td>
							<td rowspan="2" class="logincell" >
								<button id="loginbtn" onclick="login();">로그인</button>
							</td>
		
						</tr>				
						<tr>
							<td class="logininfo"><input type="password" id="joinpw" name="joinpw"
								class="idpw" placeholder="비밀번호"></td>
						</tr>
						<tr>
							<td colspan="2"><p id="findidpw"><a href="javascript:modal();">아이디/비밀번호 찾기</a>
						</tr>
						
						<tr>
							<td colspan="2" id="error" align="left"></td>
						</tr>
					</tbody>
				</table>
				<div id="snslogin" class="">
					<button onclick="kakaoLogin();" id="kakao">카카오로그인</button></br>
					<button onclick="">구글로그인</button>
					<p>	아직 회원이 아니세요?<a href="USER_join.do">회원가입</a> </p>
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
		     		<form action="USER_changepw.do" method="post">
		     			<table class="M_table">
		     			 		<tr>
		     			 			<th>이메일</th>
		     			 			<td><input type="text" id="joinemail" name="joinemail"> </td>
		     			 			<td><button class="btn btn-default" onclick="">입력</button></td>
		     			 		</tr>
		     			 		<tr>
		     			 			<td id="M_error" colspan="2" align="right">인증번호틀림</td>
		     			 		</tr>
		     			 		<tr>
		     			 			<th>인증번호</th>
		     			 			<td><input type="text" id="number" name="number"></td>
		     			 		</tr>
		     			 		<tr>
		     			 			<th>새비밀번호</th>
		     			 			<td><input type="password" id="newpw" name="newpw"></td>
		     			 		</tr>
		     			 		<tr>
		     			 			<th>비밀번호 확인</th>
		     			 			<td><input type="password" id="pwcheck" name="pwcheck"></td>
		     			 		</tr>
		     			 	</table>
		     			 </form>
    			</div>
     			 <div class="modal-footer"  >
      			 <button type="button" id="changepw" class="btn btn-default" data-dismiss="modal" onclick="#">변   경</button>
    		  </div>
  		 	</div>
		</div>
	</div>
	
	
	
	
</body>
</html>