$(function() {
		$("#error").hide();
		
	});


//이메일 인증 팝업
function checkid() {
	window.open("USER_emailcheckpopup_login.do", "", "width=500px,height=500px");
	chk01 = true
}
	
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
	
	
// [modal]================================================
	
//아이디,비밀번호 수정 
	window.onload = function() {

		// 비밀번호 일치 여부
		$('#pwcheck').focusout(function() {
			var pw = $('#newpw').val();
			var pwChk = $('#pwcheck').val();
			var res = $('#errormessge');
			
			if (pw != "" || pwChk != "") {
				if (pw == pwChk) {
					
					res.html("비밀번호가 일치합니다.");
				} else {
					
					res.html("비밀번호가 일치하지 않습니다");
				}
			}
		});
		
		function kakao() {
			KaKao.init('5c66b81ac4ea858ce15c7241ac3dc1da');
			
			KaKao.Auth.createLoginButton({
				container: '#kakao-login-btn', 
				success : function (authObj) {
					 Kakao.API.request({
						 
			               url: '/v1/user/me',
			               success: function(res) {
			 
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
	}

function idpwcheck() {
	alert("확인")
	if($("#newpw").val() != $("#pwcheck").val() ) {
		alert("비밀번호를 확인해주세요.")
		return true;
	}else {
		return true;
	}
}

	