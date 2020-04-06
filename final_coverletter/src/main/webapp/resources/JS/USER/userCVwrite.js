var idx = 1;

/*---------- cv-container 하나만 있으면 삭제불가 : removeBtn func ----------*/
$(function() {
	removeBtn ();
});

function removeBtn () {
	var removeBtn =  document.querySelectorAll('.remove-btn');
	if(removeBtn.length == 1){
		$(removeBtn).attr('disabled', true);
	} else {
		$(removeBtn).attr('disabled', false);
	}
}
/*---------- cv-container 복제 : add func ----------*/
function add() {
	// 마지막 cv-container를 복제
	var lastCVcontainer = $('.cv-container').last();
	var cloneElements = $(lastCVcontainer).clone(false);

	// 마지막 cv-container에 추가
	lastCVcontainer.after(cloneElements);

	// CLONE : 소제목 영역, 작성영역 clear & button 활성화
	cloneElements.find('input[type=text]').val('');
	cloneElements.find('textarea').val('');
	cloneElements.find('.cv-spell').text('');
	cloneElements.find('#cntArea-a').text('0');
	cloneElements.find('#cntArea-b').text('0');
	cloneElements.find('.remove-btn').attr('disabled', false);
	
	// insert path 지정 
	cloneElements.find('input[id=title]').attr('name', 'targets[' + idx + '].title');
	cloneElements.find('input[id=subtitle]').attr('name', 'targets[' + idx + '].subtitle');
	cloneElements.find('select[id=question]').attr('name', 'targets[' + idx + '].question');
	cloneElements.find('textarea[id=content]').attr('name', 'targets[' + idx + '].content');
	
	idx++;
	removeBtn();
}

/*---------- cv-container 삭제 : remove func ----------*/
function remove(btn) {
	// 누른 버튼의 상위 cv-container 찾아서 삭제
	var btn = btn;
	var thisElements = $(btn).parents('.cv-container');
	thisElements.remove();
	removeBtn();
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

/*---------- 맞춤법 검사 : spellCheck func ----------*/
function spellCheck(btn) {
	// 보낼 데이터 (맞춤법 검사할 데이터)
	var thisElement = btn;
	var parent = $(thisElement).parents('.cv-container');
	var ta = $(parent).find('textarea');
	var sd = $(parent).find('.cv-spell');

	// node server로 보내기
	$.ajax({
		type : 'post',
		url : 'http://127.0.0.1:3003/spellCheck/',
		data : ta.val(),
		crossOrigin : true,
	    crossDomain : true,
		async : false,
		dataType: 'json',
		success : function(data) {
			console.log('통신성공');
			console.log('넘어오는 데이터 : ' + data);
			
			// data = json 
			$.each(data, function(idx, obj) {
				$.each(obj, function(key, value) {
					console.log('key = ' + key);
					console.log('val = ' + value);
					/*
					 * -- KEY --
					 * token : 오류
					 * suggestions : 교정어
					 * info : 맞춤법 검사 결과 설명
					 * 
					 * */
					if(key == 'token'){
						
					}
					
					if(key == 'suggestions'){
						// button 생성
						sd.append
							("<button class='btn spell-btn' type='button'>"
							+ value
							+ "</button>");
					}
					
				});
			 });
			
		},
		error : function(request, status, error) {
			console.log('통신실패');
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}

	});
};

/*---------- Toasts : bootstrap4 toast ----------*/
$(function() {
	$("#question").change(function(){
	    var selected = $("option:selected", this);
	    
	    // toast 속성
		$('.toast').toast({
			delay: 9000
		});
		
		// 기본
	    if(selected.parent()[0].id == "one"){
	    	$('.toast-body').html('이 항목은 회사마다 달라야합니다. <br/> 질문의 의도에 맞게 <b>핵심</b> 위주로 대답하는 것이 좋습니다.');
	    	$('.toast').toast('show');
	    // 개인	
	    } else if(selected.parent()[0].id == "two"){
	    	$('.toast-body').html('성장과정을 물어보는 의도를 잘 생각해봅시다. <br/> 나의 인생 전체를 구술하기보다 기업과 직무에 연관되는 <b>특정한 사건, 인물 위주</b>로 작성하는 것이 좋습니다.');
	    	$('.toast').toast('show');
	    	
	    // 직무역량 
	    } else if(selected.parent()[0].id == "three"){
	    	$('.toast-body').html('자신이 해당 직무에 얼마나 <b>적합한 인재</b>인지 어필하는 항목입니다! <br/> 지원하는 직무에 필요한 역량을 분석하고 자신과 잘 연관시켜 작성하면 되겠죠? <br/> 마지막으로, 다짐까지 한 줄 추가해준다면 더 좋을 거예요.');
	    	$('.toast').toast('show');
	    	
	    // 경험과 사례 	
	    } else if(selected.parent()[0].id == "four"){
	    	$('.toast-body').html('경험과 사례는 최대한 구체적으로 작성해야합니다. <br/> 또한 나의 이야기를 설득력있게 전달하기 위해서는 이를 뒷받침해줄 <b>충분한 근거</b>가 필요합니다. <br/> 이 점을 잊지 말고 작성해보세요! 😊');
	    	
	    // 기타	
	    } else if(selected.parent()[0].id == "five"){
	    	$('.toast-body').html('자기소개서는 내가 어떤 사람인지 궁금해질 수 있도록, <br/> 나에 대한 <b>예고편</b>을 보여주는 것입니다.');
	    	$('.toast').toast('show');
	    } 
	});
});









