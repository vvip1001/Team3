/*----------  func ----------*/
//댓글작성 폼 비어있으면 (대댓글아님)
//$(function() {
//	$('.form-control').change(function() {
//		var content = $('.form-control').val();
//		if(content.trim() == ''){
//			$('.form-control').attr("onclick", "replyInsert(\'" + joinemail + "\'," + groupno + "," + groupseq + ")");
//			$('.form-control').attr('onKeyDown', "onKeyDown(\'" + joinemail + "\'," + groupno + "," + groupseq + ")");
//			}
//		});
//
//});

/*---------- 모달 : deleteAlert func ----------*/
function deleteAlert(text) {
	//글과 댓글 삭제 (고유 글번호)
	var board = $('#board-boardseq').val();
	var reply = $('#reply-boardseq').val();	
	
	$('.modal-title').addClass('glyphicon glyphicon-alert');
	$('.modal-title').text(' 경고!');
	$('.modal-body').text( text + '을 삭제하시겠습니까? 삭제된 ' + text + '은 다시 복구되지 않습니다.');
	
	if(text == '글'){
		$('#yes-btn').attr('onclick', 'boardDelete(' + board +');');
	} else if (text == '댓글') {
		$('#yes-btn').attr('onclick', 'replyDelete(' + reply +');');
	}

	$('#myModal').modal('show');
}

/*---------- 글삭제 : boardDelete func ----------*/
function boardDelete(boardseq) {
	location.href = 'boardDelete.do?boardseq=' + boardseq;
}

/*---------- 댓글삭제 : replyDelete func ----------*/
//댓글 seq + 보드 seq
function replyDelete(reply) {
	var boardseq = $('#board-boardseq').val();
	var boardGroupNo = $('#board-groupno').val();
	location.href = 'replyDelete.do?boardseq=' + boardseq + '&groupno=' + boardGroupNo +'&replyseq=' + reply;
}

/*---------- 댓글 : 엔터치면 입력 : onKeyDown func ----------*/
function onKeyDown(joinemail, boardseq, groupno) {
     if(event.keyCode == 13) {
          replyInsert(joinemail, boardseq, groupno);
     }
}

/*---------- 댓글 : replyInsert func ----------*/
function replyInsert(joinemail, boardseq, groupno) {
	//댓글 작성자, 작성내용
	var content = $('.form-control').val();

	//새댓글 (1:boardno/ 2:부모글의 groupno, 작성자의 joinemail, content)
	location.href = 'replyInsert.do?boardseq=' + boardseq + '&groupno=' + groupno + '&joinemail=' +joinemail +'&content=' + content;
	
	//댓글작성폼 초기화
	$('.form-control').val(' ');

}

/*---------- 대댓글 : rereply func ----------*/
//param : 부모댓글이메일, 로그인 세션 이메일(댓글작성자), 글그룹번호, 부모댓글의 순서
function rereply(replyemail, joinemail, groupno, groupseq) {
	//댓글작성폼에 부모댓글이메일 넣기
	$('.form-control').val('#' + replyemail + ' ');
	
	//대댓글 작성내용
	var content = $('.form-control').val();
	
	//댓글작성폼 대댓글에 맞는 함수로 바꿔주기
	$('.form-control').attr("onclick", "rereplyInsert(\'" + replyemail + "\', \'" + joinemail + "\'," + groupno + "," + groupseq + ")");
	$('.form-control').attr('onKeyDown', "reonKeyDown(\'" + replyemail + "\', \'" + joinemail + "\'," + groupno + "," + groupseq + ")");
	
	//대댓글작성함수 rereplyInsert
}

/*---------- 대댓글 : 엔터치면 입력 : ReonKeyDown func ----------*/
function reonKeyDown(replyemail, joinemail, groupno, groupseq) {
	if(event.keyCode == 13) {
        rereplyInsert(replyemail, joinemail, boardseq, groupno);
   }
}

/*---------- 대댓글 : rereInsert func ----------*/
function rereInsert(replyemail, joinemail, groupno, groupseq) {
	$('.form-control').val();
}

