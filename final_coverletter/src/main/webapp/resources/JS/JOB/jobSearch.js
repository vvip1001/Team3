var page;		
var startFrom;  	
var range;		 	
var startPage;	 	
var endPage;	 	
var totalPage;		
var from;		 	

//글자수 자르기
function StringCut(textLen, text){
	if(text.length > 0){
		if(text.length >= textLen){
			text = text.substring(0, textLen) + '...'
		}
	}
	return text 
}

//동기 이전 버튼 이벤트
function prev_maria(page, range, rangeSize) {
	var page = parseInt((range - 2) * rangeSize) + 1;
	var range = parseInt(range) - 1;
	var url = "JOB_jobSearch.do";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;
}

//동기 페이지 번호 클릭
function pagination_maria(page, range) {
	var url = "JOB_jobSearch.do";
	page = page
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;	
}

//동기 다음 버튼 이벤트
function next_maria(page, range, rangeSize) {
//	page = parseInt(page) - 1
//	if((page % 10) == 1){
//		range = parseInt(range) - 1;
//	}
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
    var text = document.getElementById("search_company").value += "#"+res+" "
    //text.style.color = "rgba(255,238,51,0.99)"
    select.options[select.selectedIndex].disabled = true 
}

/* 중복불가 selectbox */
function selected_only(select){
	var res = select.options[select.selectedIndex].value;
    var text = document.getElementById("search_company").value += "#"+res+" "
    for(var i = 0; i<select.options.length; i++){
    	select.options[i].disabled = true
    }
}


//검색 조건 리셋
function companyReset() {
	var text = document.getElementById("search_company").value = ""
	
    // 전체 select 만큼
	var selectList = document.querySelectorAll(".form-control")
    for(var i = 0; i<selectList.length; i++){
    	var select_options = document.querySelectorAll(".form-control")[i].options
    	// 옵션 만큼
    	for(var j = 0; j<select_options.length-1; j++){
    		select_options[0].selected = true
    		if(select_options[j].disabled){
    			select_options[j].disabled = false;
    		}
    	}
    }
}

//검색폼 변환
function searchType(selectType){
	if(selectType="검색"){
		
	}else if(selectType="키워드"){
		
	}
}


/* 검색 */
function companySearch(page, startPage, from, startFrom, range){
	console.log("page: " + page, "startPage: " + startPage, "from: " + from, "startFrom: " + startFrom, "range: " + range)
	
	page = page;			//현재 페이지번호
	startPage = startPage;	// 시작 페이지 번호
	range = range;			// 시작 1쪽
	from = from;			// 결과값 시작 index
	startFrom = startFrom;	// 현재 쪽의 결과값 시작 index
	endPage = startPage + 9 
	
	var business =  document.getElementById("business").value
	var languages =  document.getElementById("languages").value
	var location_front =  document.getElementById("location_front").value
	var location_back =  document.getElementById("location_back").value
	var target =  document.getElementById("target").value
	var enddate =  document.getElementById("enddate").value
	var totalmember =  document.getElementById("totalmember").value
	var salary =  document.getElementById("salary").value

	var jsonKey = {
					  from : from,		// 다음 요청 시작번호
					  target : target,
					  enddate : enddate,
					  totalmember : totalmember,
					  salary : salary
				   }
	
	
	var keyWord = document.getElementById("search_company").value
	if(keyWord == ""){
		alert("키워드를 입력하세요")
	}else{
		//페이지를 다음으로 누를때는 from을 올린 검색결과 유지한 값을 보낸다.
		$.ajax({
			url:"JOB_jobSearchRes.do",
			type:"post",
			///contentType: 'application/json',
			data:jsonKey,
	        dataType :"text",
	        success : function(res){
	        	
	        	console.log(res)
	        	var jsonRes = JSON.parse(res)
	        	
	        	// 데이터 개수는 0번 ~ 9번 한페이지에 10개 출력   페이지 번호 한 번에 10개씩
				const total = jsonRes.hits.total.value
				// 올림
				totalPage = Math.ceil(total/10)
				
	        	// 데이터 결과 배열로 들어있음
	        	var comapanyArr = jsonRes.hits.hits
	        	console.log(comapanyArr)
				
	        	// 검색결과 div 초기화
	        	var container = document.getElementById("search_container")
	        	container.innerHTML = "";
	        	
	        	// 가져온 데이터 그리기(최대 10개로 가져옴)
	        	for(var i = 0; i<comapanyArr.length; i++){
					var compnay = comapanyArr[i]
					creatDiv(compnay._source.companyseq, compnay._source.imgurl, compnay._source.business, compnay._source.enddate, compnay._source.oneintro, compnay._source.mainfield, compnay._source.languages, compnay._source.companyname, compnay._source.location, compnay._source.salary, compnay._source.target)
				}
				// 페이징 그리기
	        	creatPageBtn_etc(page, startPage, endPage)
			},
		    error: function(){
		       alert("통신 실패");
		    }
		})
	}
}

//비동기 페이징 버튼 생성	
function creatPageBtn_etc(clickPage, startPage, endPage) {
	var pageArea = document.getElementsByClassName("pagination")[0]
	pageArea.innerHTML = ""
	page = clickPage; // 전역변수에 할당

	if(endPage >= totalPage){ 
		endPage = totalPage		
	}
	//이전버튼
	if(startPage > 10){
		prev_etc()
	}
	//페이지 버튼 그리기
	for(var i = startPage; i < endPage+1; i++){
		console.log(startPage)
		pagination_etc(i)
		if(i > 1){
			from += 10
		}
	}
	//다음버튼
	if((endPage != totalPage) && (endPage < totalPage)){
		next_etc()
	}
}


//비동기 페이지 버튼생성
function pagination_etc(butNum){
	var pageArea = document.getElementsByClassName("pagination")[0]
	var li = document.createElement("li")
	if(butNum == page){	
		li.setAttribute("class", "page-item active")
	}
	pageArea.appendChild(li)
	li.innerHTML = "<a class='page-link' href='#' onclick='companySearch(" + butNum + ", " + startPage + ", " + ((butNum*10)-10) + ", " + startFrom + ", " + range + ")'>" + butNum + "</a>"
	
}


// 비동기 다음버튼 생성
function next_etc() {
	var pageArae = document.getElementsByClassName("pagination")[0]
	var li = document.createElement("li")
	li.setAttribute("class", "page-item")
	pageArae.appendChild(li)
	li.innerHTML = "<a class='page-link' href='#' onclick='companySearch(" + (startPage + 10) + ", " + (startPage + 10) + ", " + (startFrom + 100) + ", "+ (startFrom + 100) + ", " + (range + 1) + ")'>" + "Next" + "</a>"
	
}

// 비동기 이전 버튼 생성
function prev_etc() {
	var pageArae = document.getElementsByClassName("pagination")[0]
	var li = document.createElement("li")
	li.setAttribute("class", "page-item")
	pageArae.appendChild(li)
	li.innerHTML = "<a class='page-link' href='#' onclick='companySearch(" + (startPage - 10) + ", " + (startPage + 10) + ", " + (startFrom - 100) + ", "+ (startFrom - 100) +", "+ (range - 1) + ")'>" + "Previous" + "</a>"
	
}


//기업정보 div
function creatDiv(companyseq, imgurl, business, enddate, oneintro, mainfield, languages, companyname, location, salary, target){
	var row = document.createElement("div")
	row.setAttribute("class", "row")
	
	//이미지 영역
	var imgDiv_2 = document.createElement("div")
	imgDiv_2.setAttribute("class", "col-md-2")
	var imgTop = document.createElement("div")
	imgTop.setAttribute("class", "div_img_top")
	var imgMid = document.createElement("div")
	imgMid.setAttribute("class", "div_img_mid")
	var img = document.createElement("img")
	img.setAttribute("src", imgurl)
	
	imgDiv_2.appendChild(imgTop)
	imgTop.appendChild(imgMid)
	imgMid.appendChild(img)

	//회사정보 영역
	var companyDiv_10 =  document.createElement("div")
	companyDiv_10.setAttribute("class", "col-md-10")

	//company_left 영역
	var company_left = document.createElement("div")
	company_left.setAttribute("class", "company_left")
	//h5 시작
	var h5 = document.createElement("h5")
	var a = document.createElement("a")
	a.setAttribute("href", "JOB_companyDetail.do?companyseq="+companyseq)	// pk 추가 
	h5.appendChild(a)
	var b_left = document.createElement("b")
	b_left.textContent = StringCut(45, business)
	h5.appendChild(b_left)
	var span = document.createElement("span")
	span.style.fontSize = "10px"
	span.textContent = "  "+enddate 		// 마감날짜 추가
	h5.appendChild(span)
	var br = document.createElement("br")
	h5.appendChild(br)
	//h5 끝
	
	//h5 추가
	company_left.appendChild(h5)

	//한줄 소개
	var span01 = document.createElement("span")
	span01.textContent = StringCut(50, oneintro)
	company_left.appendChild(span01)
	var br01 = document.createElement("br")
	company_left.appendChild(br01)
	//주요업무
	var span02 = document.createElement("span")
	span02.textContent = StringCut(50, mainfield)
	company_left.appendChild(span02)
	var br02 = document.createElement("br")
	company_left.appendChild(br02)
	// 사용언어
	var span03 = document.createElement("span")
	span03.textContent = StringCut(50, languages)
	company_left.appendChild(span03)
	var br03 = document.createElement("br")
	company_left.appendChild(br03)
	
	//company_left 영역 추가
	companyDiv_10.appendChild(company_left)
	


	//company_right 영역
	var company_right = document.createElement("div")
	company_right.setAttribute("class", "company_right")
	// 회사명
	var b_right = document.createElement("b")
	b_right.textContent = companyname
	company_right.appendChild(b_right)
	var br04 = document.createElement("br")
	company_right.appendChild(br04)
	// 위치
	var span04 = document.createElement("span")
	span04.textContent = StringCut(17, location)
	company_right.appendChild(span04)
	var br05 = document.createElement("br")
	company_right.appendChild(br05)
	// 연봉
	var span05 = document.createElement("span")
	span05.textContent = salary
	company_right.appendChild(span05)
	// 경력/신입
	var span06 = document.createElement("span")
	span06.textContent = target
	company_right.appendChild(span06)
	var br06 = document.createElement("br")
	var br07 = document.createElement("br")
	company_right.appendChild(br06)
	company_right.appendChild(br07)
	
	var button = document.createElement("input")
	button.setAttribute("type", "button")
	button.setAttribute("class", "btn_compnay")
	button.setAttribute("value", "기업정보")
	button.setAttribute("disabled", "disabled")
	company_right.appendChild(button)
	
	//company_right 영역 추가
	companyDiv_10.appendChild(company_right)
	
	// 메인 div 추가
	var container = document.getElementById("search_container")
	container.appendChild(row)
	row.appendChild(imgDiv_2)
	row.appendChild(companyDiv_10)
}



