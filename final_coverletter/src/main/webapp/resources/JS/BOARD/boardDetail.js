/*---------- 모달 : deleteAlert func ----------*/
function deleteAlert() {
	$('.modal-title').addClass('glyphicon glyphicon-alert');
	$('.modal-title').text(' 경고!');
	$('.modal-body').text('글을 삭제하시겠습니까? \n 삭제된 글은 다시 복구되지 않습니다.');
	$('#modalBox').modal('show');
}

/*---------- 댓글 : replyInsert func ----------*/
function replyInsert() {
	//댓글 작성자, 작성내용
	var joinemail = 'babo@naver.com';
	var reply = $('.form-control').val();
	
	//댓글 맨 앞 요소
	var firstReply = $('.reply');
	
	var tr = '<tr>';
		tr += '<th>';
		tr += joinemail;
		tr += '</th>';
		tr += '<td>';
		tr += reply;
		tr += '</td>';
		tr += '<td>';
		tr += '<span><a href="#">삭제</a></span>'
		tr += '</td>';
		tr += '/tr>';
	
		firstReply.before(tr).trigger('pagecreate');
	
	//새댓글
	//var newReply = 
	
	alert('댓글작성=' + reply);
	
}
