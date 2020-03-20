/*---------- 페이징 : paging func ----------*/
function paging(curPage) {
	location.href = "BOARD_boardListPaging.do?curPage=" + curPage;
}