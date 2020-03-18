/*---------- 모달 : deleteAlert func ----------*/
function deleteAlert() {
	$('.modal-title').addClass('glyphicon glyphicon-alert');
	$('.modal-title').text(' 경고!');
	$('.modal-body').text('글을 삭제하시겠습니까? \n 삭제된 글은 다시 복구되지 않습니다.');
	$('#myModal').modal('show');
}

/*---------- 삭제 : boardDelete func ----------*/
function boardDelete(boardseq) {
	location.href = 'boardDelete.do?boardseq=' + boardseq;
}

/*---------- 댓글 엔터치면 입력 : onKeyDown func ----------*/
function onKeyDown(boardseq, groupno) {
     if(event.keyCode == 13) {
          replyInsert(boardseq, groupno);
     }
}
/*---------- 댓글 : replyInsert func ----------*/
function replyInsert(boardseq, groupno) {
	alert(boardseq, groupno);
	//댓글 작성자, 작성내용
	var joinemail = 'babo@naver.com';
	var content = $('.form-control').val();
	
	//댓글작성폼 아래에 댓글 추가
	var form = $('.reply-area');	
	var tr = '<tr>';
		tr += '<th>';
		tr += joinemail;
		tr += '</th>';
		tr += '<td>';
		tr += content;
		tr += '</td>';
		tr += '<td>';
		tr += '<span><a href="#">삭제</a></span>'
		tr += '</td>';
		tr += '/tr>';
	
	form.after(tr);
	
	//새댓글 (1:boardno/ 2:부모글의 groupno, 작성자의 joinemail, content)
	location.href = 'replyInsert.do?boardseq=' + boardseq + '&groupno=' + groupno + '&joinemail=' +joinemail +'&content=' + content;
	
	//댓글작성폼 초기화
	$('.form-control').val(' ');
		
	
	
}
