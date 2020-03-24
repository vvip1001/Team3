var chk01 = true; // 중복
var chk02 = true; // 비밀번호 일치
var chk03 = true; // 성별 라이오 버튼 클릭

window.onload = function() {

	// 비밀번호 일치 여부
	$('#joinpw2').focusout(function() {
		var pw = $('#joinpw').val();
		var pwChk = $('#joinpw2').val();
		var res = $('#pwcheck2');
		
		if (pw != "" || pwChk != "") {
			if (pw == pwChk) {
				chk02 = true;
				res.html("비밀번호가 일치합니다.");
			} else {
				chk02 = false;
				res.html("비밀번호가 일치하지 않습니다");
			}
		}
	});
}



// 이메일 인증 팝업
function checkid() {
	window.open("USER_emailcheckpopup.do", "", "width=500px,height=500px");
	chk01 = true
}


// 서브밋 유효성검사
function confirmSubmit() {
	if ($("#joinemail").val() != null &&
			$("#joinpw").val() == $("#joinpw2").val()) {
		var con = confirm("작성내용으로 회원가입 하시겠습니까?")
		if (con) {
			return true;
		} else {
			return false;
		}
	} else if ($("#joinemail").val() == null) {
		alert("이메일 중복 확인하세요");
		return false;
	} else if ($("#joinpw").val() != $("#joinpw2").val()) {
		alert("비밀번호가 일치하지 않습니다")
		return false;
	}
	return true;
}

