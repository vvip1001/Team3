window.onload=function(){
			let bookmark = document.getElementById("bookmarkBtn")
			let companyseq = document.getElementById("companyseq").value
			if(bookmark != null){
				$.ajax({
					url:"JOB_isJobBookmark.do",
					type:"post",
					data:{"companyseq":companyseq},
					dataType : "text",
					success : function(res){
						if(res === "true"){
							console.log("등록되 있음")
							bookmark.setAttribute("id", "bookmarkBtn_register")
						} else {
							console.log("등록 안됨")
							bookmark.setAttribute("id", "bookmarkBtn")
						}	
					},
					error : function(){

					}
				});
			}
		
		}


function bookmark(companyseq){
	$.ajax({
		url:"JOB_jobBookmark.do",
		type:"post",
		data:{
			companyseq:companyseq
		},
		dataType:"text",
		success : function(res){
			let bookmark = document.getElementById("bookmarkBtn")
			if(bookmark != null){
				if(res === "success"){
					bookmark.setAttribute("bookmarkBtn_register")
					alert("즐겨찾기 등록 성공")
					//bookmark.setAttribute("bookmarkBtn")
				} else if (res === "fail"){
					alert("즐겨찾기 등록 실패")
				}
			} else {
				let bookmark = document.getElementById("bookmarkBtn_register")
				if(res === "success"){
					bookmark.setAttribute("bookmarkBtn")
					alert("즐겨찾기 제거 성공")
					//bookmark.setAttribute("bookmarkBtn")
				} else if (res === "fail"){
					alert("즐겨찾기 제거 실패")
				}
			}
			
			
		},
		error: function(){
			alert("통신실패, 관리자에게 문의하세요")	
		}
	});
}


