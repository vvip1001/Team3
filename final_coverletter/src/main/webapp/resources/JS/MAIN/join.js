function checkid() {
	alert($("#joinemail").val())
	
	$.ajax({
		type: "post",
		url: "USER_emailcheck.do",
		data: {"joinemail" : $("#joinemail").val()},
		dataType: "text",
	
		success : function(result) {
			if(result == "중복") {
				$("#idcheck").html("이미 가입된 이메일입니다.");
				
			
			}else if(result == "사용가능") {
				$("#idcheck").html("가입가능한 이메일입니다.");
			
			}
		},
		error : function() {
			alert("통신실패");
		}
	});
	
}


