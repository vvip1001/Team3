/*---------- onLoad func ----------*/
$(function() {
	
});

/*---------- HTML태그제거 : removeHTML func ----------*/
function removeHTML (text) {
	text = text.replace(/<br\/>/ig, "\n");
	text = text.replace(/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/ig, "");
	return text;
}

/*---------- 썸머노트API summernote api ----------*/
$(document).ready(function() {
    $('.summernote').summernote({
          height: 300,					//에디터 높이
          disableDragAndDrop: true,
          toolbar: [
              ['style', ['style']],
              ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
              ['fontface', ['fontname']],
              ['textsize', ['fontsize']],
              ['color', ['color']],
              ['alignment', ['ul', 'ol', 'paragraph', 'lineheight']],
              ['height', ['height']],
              ['table', ['table']],
              ['insert', ['link','picture']],
              ['Misc',['undo','redo']]
          ],
    });
 });

/*---------- 글작성 : board write func ----------*/
function boardWrite() {
	// values
	var form = $('form');
	var title = $('#title').val();
	var content = $('.summernote').val();
	
	// 글작성
	if((title.trim() != '') && (content.trim() != '')){
		form.commandName = 'BoardDto';
		form.action = 'BOARD_boardUpdate.do';
		form.submit();
	} else if ((title.trim() == '') || (content.trim() == '')) {
	// 유효성검사
		$('.modal-title').addClass('glyphicon glyphicon-alert');
		$('.modal-title').text(' ERROR');
		$('.modal-body').text('내용을 입력해주세요.');
		$('#myModal').modal('show');
	}
	
}