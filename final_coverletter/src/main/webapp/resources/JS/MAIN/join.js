var chk01 = false;  // 중복
var chk02 = false;  // 비밀번호 일치
var chk03 = false;  // 성별 라이오 버튼 클릭

window.onload = function(){						
	
	// 비밀번호 일치 여부
	$(".joininfo").eq(1).keyup(function(){
		var pw = $(".joininfo").eq(0)
		var pwChk = $(".joininfo").eq(1)
		var res = $("#pwcheck2")
		
		if(pw.value == pwChk.value){
			chk02 = true;
			res.text("비빌번호가 일치합니다.")
		} else {
			chk02 = false;
			res.text("비빌번호가 일치하지 않습니다")
		}

	});	
}


// 이메일 인증 팝업
function checkid() {
	window.open("USER_emailcheckpopup.do","","width=500px,height=500px");
	chk01 = true
}

// 서브밋 유효성검사
function confirmSubmit() {
	if(chk1 && chk2){
		var con = confirm("작성내용으로 회원가입 하시겠습니까?")
		if(con){
			return true;
		} else {
			return false;
		}
	} else if(!chk1) {
		alert("이메일 중복 확인하세요");
		return false;
	} else if(!chk2) {
		alert("비밀번호가 일치하지 않습니다")
		return false;
	}
	return false;
}

