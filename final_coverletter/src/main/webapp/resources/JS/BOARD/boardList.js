/*---------- 페이징 : paging func ----------*/
function paging(curPage) {
	location.href = "BOARD_boardList.do?curPage=" + curPage;
}

/*---------- 상세글보기 : boardDetail func ----------*/
function boardDetail(boardseq) {
	var curPage = $('.paging-focus').text();
	location.href='BOARD_boardDetail.do?boardseq=' + boardseq + '&curPage=' + curPage;
}

/*---------- 검색 : search func ----------*/
function search() {
	var input = $('.search-input').val();
	location.href='';
}

/*---------- 검색(엔터치면 입력) : onKeyDown func ----------*/
function onKeyDown(boardseq) {
    if(event.keyCode == 13) {
         search();
    }
}