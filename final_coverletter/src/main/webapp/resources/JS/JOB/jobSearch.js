var page = 1;
var from = 0;		// 요청할 다음 번호 
var startPage = 1;
var endPage;
var totalPage;

//동기 이전 버튼 이벤트
function prev_maria(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "JOB_jobSearch.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
}

//동기 페이지 번호 클릭
function pagination_maria(page, range) {
		var url = "JOB_jobSearch.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;	
}

//동기 다음 버튼 이벤트
function next_maria(page, range, rangeSize) {
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

function searchType(selectType){
	if(selectType="검색"){
		
	}else if(selectType="키워드"){
		
	}
}


/* 검색 */
function companySearch(page, startPage, from){
	page = page;
	startPage = startPage;
	
	var business =  document.getElementById("business").value
	var languages =  document.getElementById("languages").value
	var location_front =  document.getElementById("location_front").value
	var location_back =  document.getElementById("location_back").value
	var target =  document.getElementById("target").value
	var enddate =  document.getElementById("enddate").value
	var totalmember =  document.getElementById("totalmember").value
	var salary =  document.getElementById("salary").value
	
	
	var keyWord = document.getElementById("search_company").value
	if(keyWord == ""){
		alert("키워드를 입력하세요")
	}else{
		//페이지를 다음으로 누를때는 from을 올린 검색결과 유지한 값을 보낸다.
		$.ajax({
			url:"JOB_jobSearchRes.do",
			type:"post",
			data:{
				form : from,
				//일단 중복없는 키워드만 
				target : target,
				enddate : enddate,
				totalmember : totalmember,
				salary : salary
				
				
			},
	        dataType :"text",
	        success : function(res){
	        	var jsonRes = JSON.parse(res)
	        	// 결과 총 개수 0부터 시작 한페이지에 10개 * 페이지 번호 10개 
				const total = jsonRes.hits.total.value
				totalPage = Math.ceil(total/10)
				
	        	// 결과 배열로 들어있음
	        	var comapanyArr = jsonRes.hits.hits
				
				
				// 페이지 10개 이하
				if(total < 10) {
					// 결과 그리기
					for(var i = 0; i<comapanyArr.length; i++){
						var compnay = comapanyArr[i]
						creatDiv(compnay.companyseq, compnay.imgurl, compnay.business, compnay.enddate, compnay.oneintro, compnay.mainfield, compnay.languages, compnay.companyname, compnay.location, compnay.salary, compnay.target)
					}
					
					// 페이징 그리기
					creatPageBtn(page, startPage, total)
					
				// 페이지 11개 이상	
				} else {
					if(total%10 === 0){
						//creatPageBtn(page, startPage, )
					}else {
						//creatPageBtn(page, startPage, )
					}
					//결과 0~10까지 10개 그리기
				}
			},
		    error: function(){
		       alert("통신 실패");
		    }
		})
	}
}



//비동기 페이징 버튼 생성
function creatPageBtn(page, startPage, endPage) {
	var pageArea = document.getElementsByClassName("pagination")[0]
	page = page; // 전역변수에 할당
	
	for(var i = startPage; i<endPage+1; i++){
		//li태그 생성
		var li = document.createElement("li")
		li.className = "page-item"
		if(i == page){
			li.setAttribute("class", "page-item active")
		}
		pageArea.appendChild(li)
		
		// a태그 생성
		var a = document.createElement("a")
		a.className = "page-link"						// 클래스 부여
		a.onclick = "companySearch(i, startPage, from + 10)"		// onclick 이벤트 부여	 : 클릭 >> ajax >> controller >> etc요청 >> json응답 >> 뷰로
		a.textContent = i								// text 부여
		li.appendChild(a)
	} 
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
	b_left.textContent = business
	h5.appendChild(b_left)
	var span = document.createElement("span")
	span.style.fontSize = "10px"
	span.textContent = enddate 		// 마감날짜 추가
	h5.appendChild(span)
	var br = document.createElement("br")
	h5.appendChild(br)
	//h5 끝
	
	//h5 추가
	company_left.appendChild(h5)

	//한줄 소개
	var span01 = document.createElement("span")
	span01.textContent = oneintro
	company_left.appendChild(span01)
	var br01 = document.createElement("br")
	company_left.appendChild(br01)
	//주요업무
	var span02 = document.createElement("span")
	span02.textContent = mainfield
	company_left.appendChild(span02)
	var br02 = document.createElement("br")
	company_left.appendChild(br02)
	// 사용언어
	var span03 = document.createElement("span")
	span03.textContent = languages
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
	span04.textContent = location
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
	
	var button = document.createElement("button")
	button.setAttribute("class", "btn_compnay")
	button.setAttribute("value", "기업정보")
	button.setAttribute("disabled", "disabled")
	
	//company_right 영역 추가
	companyDiv_10.appendChild(company_right)
	
	// 메인 div 추가
	var container = document.getElementById("search_container")
	container.appendChild(row)
	row.appendChild(imgDiv_2)
	row.appendChild(companyDiv_10)
}


//elastic용 비동기 이전 버튼 이벤트
function prev_etc(page, startPage, endPage) {
}

//elastic용 비동기 페이지 번호 클릭
function pagination_etc(page, startPage, endPage) {	// 해당 페이지 끝 번호 시작번호? 
}

//elastic용 비동기 다음 버튼 이벤트
function next_etc(page, startPage, endPage) {
}

