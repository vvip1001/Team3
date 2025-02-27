$(function() {
	$("#error").hide();

});

function idpwcheck() {
	alert("확인")
	if ($("#newpw").val() != $("#pwcheck").val()) {
		alert("비밀번호를 확인해주세요.")
		return true;
	} else {
		return true;
	}
}

// 이메일 인증 팝업
function checkid() {
	window.open("USER_emailcheckpopup_login.do", "",
					"width=500px,height=500px");
	chk01 = true
}

// 일반 로그인
function login() {

	var joinemail = $("#joinemail").val().trim();
	var joinpw = $("#joinpw").val().trim();
	// console.log("joinemail : " + joinemail + " / joinpw : " + joinpw);

	var loginVal = {
		"joinemail" : joinemail,
		"joinpw" : joinpw
	};

	console.log(loginVal)

	// 유저아이디나 유저 비밀번호가 없다면
	if (joinemail == null || joinemail == "" || joinpw == null || joinpw == "") {
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

// 아이디,비밀번호 수정
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

}


//sns로그인===================================================

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
	
	Kakao.init('2faf3269d40b39fedcc93272389d1f56');
	Kakao.Auth.loginForm({		
		
		success : function (authObj) {
			
			 Kakao.API.request({
               url: '/v2/user/me',
	           success: function(res) {
	        	   console.log(res);
	        	   
	        	   var kakaoemail = res.kakao_account.email;
	        	   var joinname = res.kakao_account.profile.nickname;
	        	   var joinpw = "kakao123";
	        	   var joinbirth = res.kakao_account.birthday;
	        	   var joinsex = res.kakao_account.gender;
	        	   var params = {"joinemail" : kakaoemail};
	        	   
		      	   var paramslogin = {
		        			   "joinemail" : kakaoemail,
		        			   "joinpw" : joinpw
		        	}; 
		      	   
		      	   if(joinsex === "female"){
		      		 joinsex = "f"
		      	   }else if(joinsex === "male") {
		      		   joinsex = "m"
		      	   }
		      	   
		      	   var paramsjoin = {
	        			   "joinemail" : kakaoemail,
	        			   "joinname" : joinname,
	        			   "joinpw" : joinpw,
	        			   "joinbirth" : joinbirth,
	        			   "joinsex" : joinsex
	        	   }; 
		      	   
		      	   console.log(paramsjoin);
		      	   
		      	   postSend("USER_snslogin.do", paramsjoin,"post");
	
		      	   
//					$.ajax({
//						type : "post",
//						url : "USER_emailcheck.do",
//						data : {
//							joinemail : kakaoemail
//						},
//					//	contentType : "application/json",
//						dataType : "text",
//						success : function(res2) {
//							if (res2 === "중복") {
//								console.log(res2);
//								$.ajax({
//									type : "post",
//									url : "USER_loginAjax.do",
//									data : JSON.stringify(paramslogin),
//									contentType : "application/json",
//									dataType : "json",
//									success : function(msg) {
//
//										if (msg.check == true) {
//											location.href = "MAIN_main.do"
//										}
//
//									},
//									error : function() {
//										alert("로그인 통신 실패");
//									}
//								});
//							} else if (res2 === "사용가능") {
//								postSend("USER_joinRes.do", paramsjoin);
//							}
//						},
//						error : function() {
//							alert("중복체크 통신실패");
//						}
//					});

					console.log(res.id);//<---- 콘솔 로그에 id 정보 출력(id는 res안에 있기 때문에  res.id 로 불러온다)
					console.log(res.kakao_account.email);
					console.log(res.kakao_account.birthday);
					console.log(res.kakao_account.gender);
					console.log(res.properties['nickname']);//<---- 콘솔 로그에 닉네임 출력(properties에 있는 nickname 접근 
					console.log(authObj.access_token);//<---- 콘솔 로그에 토큰값 출력
				}
			})
		},
		fail : function(error) {
			alert(JSON.stringify(error));
		}
	});

}


//구글 로그인
function onSignIn(googleUser) {
	

	var profile = googleUser.getBasicProfile();
	console.log(profile);
	var joinemail = profile.getEmail();
	var joinname = profile.getName();
	var joinparams = {
			"joinemail" : joinemail,
			"joinname" : joinname,
	}
	var loginparams = {
			"joinemail" : joinemail,
			"joinpw" : "asd123"
	};
	
	$.ajax({
		type : "post",
		url : "USER_emailcheck.do",
		data : {
			joinemail : joinemail
		},
		dataType : "text",
		success : function(res2) {
			if (res2 === "중복") {
				alert("로그인");
				console.log(res2);
				$.ajax({
					type : "post",
					url : "USER_loginAjax.do",
					data : JSON.stringify(loginparams),
					contentType : "application/json",
					dataType : "json",
					success : function(msg) {

						if (msg.check == true) {
							location.href = "MAIN_main.do"
						}

					},
					error : function() {
						alert("로그인 통신 실패");
					}
				});
			} else if (res2 === "사용가능") {
				alert("필수항목 입력");
				postSend("USER_joinRes.do", joinparams);
			}
		},
		error : function() {
			alert("중복체크 통신실패");
		}
	});

}

