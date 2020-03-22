	$(function() {
		$("#error").hide();
		$("#M_error").hide();
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