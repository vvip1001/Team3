<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용공고 검색</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/JOB/jobSearch.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/JOB/jobSearch.css" rel="stylesheet">

<script type="text/javascript">

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


</script>	
	
</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
	<div class="container" id="main">
		<form action="" method="post">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h4>기업 정보 검색</h4>
				</div>
				<div class="col-md-2"></div>
			</div>

			<div class="row">
				<div class="col-md-2"></div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="business" onchange="selected_overlap(this);">
							<option value="" selected="selected">채용분야</option>
							<option value="웹프로그래밍">웹프로그래밍</option>
							<option value="프론트엔드">프론트엔드</option>
							<option value="백엔드">백엔드</option>
						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="languages" onchange="selected_overlap(this);">
							<option value="언어선택" selected="selected">언어선택</option>
							<option value="JAVA">JAVA</option>
							<option value="Javascript">Javascript</option>
							<option value="C">C</option>
							<option value="C++">C++</option>
							<option value="C#">C#</option>
							<option value="Python">Python</option>
							<option value="node.js">node.js</option>
						</select>
					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="location_front" onchange="selected_overlap(this);">
							<option value="" selected="selected">지역(시)</option>
							<option value="서울시">서울시</option>
							<option>파주시</option>
							<option>안양시</option>
							<option>인천광역시</option>
							<option>남양주시</option>
						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="location_back">
							<option value="" selected="selected">지역(구)</option>
							<option value="강남구">강남구</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
				</div>

				<div class="col-md-1">
					<span id="span01">* 중복가능</span>
				</div>
			</div>

			<div class="row">
				<div class="col-md-2"></div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="target" onchange="selected_only(this);">
							<option value="전체" selected="selected">전체</option>
							<option value="신입">신입</option>
							<option value="경력">경력</option>
						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="enddate" onchange="selected_only(this);">
							<option value="" selected="selected">마감일</option>
							<option value="상시모집">상시모집</option>
						<c:forEach var="i" begin="1" end="12" step="1">
							<option value="${i}월">${i}월</option>
						</c:forEach>	
						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="totalmember" onchange="selected_only(this);">
							<option value="" selected="selected">인원</option>
							<option>무관</option>
						<c:forEach var="i" begin="10" end="100" step="10">
							<option value="${i}인">${i}인</option>
						</c:forEach>
						</select>
					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="salary" onchange="selected_only(this);">
							<option value="" selected="selected">연봉</option>
							<option value="협상">협상 후 책정</option>
						<c:forEach var="i" begin="2000" end="9500" step="500">
							<option value="${i}만원">${i}만원 이상</option>
						</c:forEach>
							<option value="1억">1억 이상</option>
						</select>
					</div>
				</div>

				<div class="col-md-1" id="div_span02"></div>
			</div>



			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8" id="div_text_search">
					<div class="form-group">
						<input type="text" id="search_company" class="form-control" placeholder="회사명/키워드 입력">
					</div>
				</div>

				<div class="col-md-2" id="div_btn">
					<button type="submit" class="btn btn-success" id="btn_search" onclick="companySearch()">Search</button>
					<button type="button" class="btn btn-success" id="btn_reset"  onclick="companyReset()">reset</button>
				</div>
			</div>
		</form>
	</div>
	<br />


	<!-- 검색결과 -->
	<div class="container" id="search_container">


		<c:choose>
			<c:when test="${empty newCompanyList}">
				<div style="text-align: center;">
					<h3>=============검색결과가 없습니다.=============</h3>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${newCompanyList}" var="dto">
					
					<div class="row">
						<div class="col-md-2">
							<div class="div_img_top">
								<div class="div_img_mid">
									<img alt=""
										src="${dto.imgurl}">
								</div>
							</div>
						</div>
						<div class="col-md-10" class="row">
							<div class="company_left">
								<h5>
									<a href="JOB_companyDetail.do?companyseq=${dto.companyseq}"><b>${dto.business}</b></a><span style="font-size: 10px;">&nbsp;&nbsp;상시모집</span><br />
								</h5>
								<span>${dto.oneintro}</span><br /> 
								<span>${dto.mainfield}</span><br /> 
								<span>${dto.languages}</span><br />

							</div>
							<div class="company_right">
								<b>${dto.companyname}</b><br />
								<span>${dto.location}</span><br/> 
								<span>${dto.salary}</span><span>&nbsp;&nbsp;${dto.target}</span><br />
								<br /> 
								<input type="button" class="btn_compnay" value="기업정보" disabled="disabled" />
							</div>
						</div>
				
					</div>

				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8" style="text-align: center;">
			<!-- pagination{s} -->
			<div id="paginationBox">
				<ul class="pagination">
					<c:if test="${pagination.prev}">
						<li class="page-item">
							<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a>
						</li>
					</c:if>
						
					<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
						<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
							<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a>
						</li>
					</c:forEach>
						
					<c:if test="${pagination.next}">
						<li class="page-item">
							<a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
			<!-- pagination{e} -->
		</div>
		<div class="col-md-2"></div>
	</div>

	</div>
</body>
</html>