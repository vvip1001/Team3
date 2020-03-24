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
<link
	href="${pageContext.request.contextPath}/resources/CSS/JOB/jobSearch.css"
	rel="stylesheet">
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
						<select class="form-control" name="business">
							<option value="" selected="selected">채용분야</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="languages">
							<option value="" selected="selected">언어선택</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="location_front">
							<option value="" selected="selected">지역(시)</option>
							<option value="서울시">서울시</option>
							<option>3</option>
							<option>4</option>
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
						<select class="form-control" name="target">
							<option value="" selected="selected">경력</option>
							<option>신입</option>
						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="enddate">
							<option value="" selected="selected">마감일</option>
							<option>상시모집</option>
							<option>1월</option>
							<option>2월</option>

						</select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="totalmember">
							<option value="" selected="selected">인원</option>
							<option>무관</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group">
						<select class="form-control" name="salary">
							<option value="" selected="selected">연봉</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
				</div>

				<div class="col-md-1" id="div_span02"></div>
			</div>



			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8" id="div_text_search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="회사명/키워드 입력">
					</div>
				</div>

				<div class="col-md-2" id="div_btn">
					<button type="submit" class="btn btn-success" id="btn_search"
						onclick="">Search</button>
					<button type="button" class="btn btn-success" id="btn_reset">reset</button>
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

	</div>
</body>
</html>