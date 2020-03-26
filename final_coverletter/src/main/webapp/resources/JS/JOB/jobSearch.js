
//이전 버튼 이벤트
function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "JOB_jobSearch.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;

	}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "JOB_jobSearch.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;	
}



//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		var url = "JOB_jobSearch.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
}

/* 중복가능 selectbox */
function selected_overlap(select){
    
	var res = select.options[select.selectedIndex].value;
    var text = document.getElementById("search_company").value += "#"+res
    //text.style.color = "rgba(255,238,51,0.99)"
    select.options[select.selectedIndex].disabled = true 
}

/* 중복불가 selectbox */
function selected_only(select){
	
	var res = select.options[select.selectedIndex].value;
    var text = document.getElementById("search_company").value += res
    
}

/* 검색 */
function companySearch(){
	
}

function companyReset() {
	var text = document.getElementById("search_company").value = ""
    
    // 전체 select 만큼
	var selectList = document.querySelectorAll(".form-control")
	
    for(var i = 0; i<selectList.length; i++){
    	
    	var select_options = document.querySelectorAll(".form-control")[i].options
    	console.log(select_options.length)
    	// 옵션 만큼
    	for(var j = 0; j<select_options.length-1; j++){
    		select_options[0].selected = true
    		if(select_options[j].disabled){
    			select_options[j].disabled = false;
    		}
    	}
    }
} 

