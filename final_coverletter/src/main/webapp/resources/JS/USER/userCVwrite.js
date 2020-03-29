/*---------- cv-container 복제 : add func ----------*/
function add() {
	// 마지막 cv-container를 복제
	var lastCVcontainer = $('.cv-container').last();
	var cloneElements = $(lastCVcontainer).clone(false);

	// 마지막 cv-container에 추가
	lastCVcontainer.after(cloneElements);

	// 소제목 영역, 작성영역 clear
	cloneElements.find('input[type=text]').val('');
	cloneElements.find('textarea').val('');
	cloneElements.find('#cntArea-a').text('');
	cloneElements.find('#cntArea-b').text('');
}

/*---------- cv-container 삭제 : remove func ----------*/
function remove(btn) {
	// 누른 버튼의 상위 cv-container 찾아서 삭제
	var btn = btn;
	var thisElements = $(btn).parents('.cv-container');
	thisElements.remove();
}

/*---------- 글자수 세기 : contentCnt func ----------*/
function contentCnt(textarea) {
	var thisElement = textarea;
	var cntRes = $(thisElement).val();
	var parent = $(thisElement).parents('.cv-container');

	// 공백포함
	var cntAreaA = $(parent).find('#cntArea-a');
	$(cntAreaA).text(cntRes.length);

	// 공백제거
	var cntAreaB = $(parent).find('#cntArea-b');
	var cntResTrim = cntRes.replace(/ /g, '');
	$(cntAreaB).text(cntResTrim.length);

}

/*---------- 맞춤법 검사 : spell func ----------*/