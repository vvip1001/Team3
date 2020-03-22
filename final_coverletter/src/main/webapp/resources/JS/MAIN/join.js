function checkid() {
	alert("test")
	$.ajax({
		type: "get",
		url: "USER_emailcheck.do",
		data: {"joinemail" : $("#joinemail").val},
		contentType: "application/json",
		dataType: "json",
		success : function(result) {
			if(result == 1) {
				$("#idcheck").html("이미 가입된 이메일입니다.");
			
			}else if(result ==0){
				$("#idcheck").html("가입가능한 이메일입니다.");
			
			}
		},
		error : function() {
			alert("통신실패");
		}
	});
	
}


