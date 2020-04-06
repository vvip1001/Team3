<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 입력</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/userCVwrite.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/USER/userCVwrite.css"
	rel="stylesheet">
	
<!-- include -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery.ajax-cross-origin.min.js"></script>	

</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>

<f:form action="USER_userCVinsert.do" method="post"
			modelAttribute="MultiRowTarget">
			<f:input type="hidden" path="targets[0].joinemail" value="a"/>
	<!-- 자소서 제목 영역 -->
	<div class="container title-container">
		<div id="title-area">
			<h1>자기소개서 작성</h1>
			
			<div class="input-group">
				<span class="input-group-addon">제&nbsp;&nbsp;목</span> 
				<f:input
					type="text" cssClass="form-control" id="title" path="targets[0].title"
					placeholder="제목을 입력하세요."/>
			</div>
		</div>
	</div>
	<!-- 자소서 제목 영역 끝-->
	<!-- 중간 여백 영역 -->
	<div id="fake-div"></div>

	<!-- 자소서 작성 영역 -->
	<div class="container cv-container">
		<div id="cv-area">
			<div id="input-grp">
				<div class="input-group">
					<span class="input-group-addon">소제목</span> 
					<f:input 
						type="text" class="form-control" id="subtitle" path="targets[0].subtitle"
						placeholder="소제목을 입력하세요."/>
				</div>
				<div class="input-group">
					<span class="input-group-addon">항&nbsp;&nbsp;&nbsp;&nbsp;목</span> 
					<f:select
						class="form-control" id="question" path="targets[0].question">
						<f:option value="지원동기"></f:option>
						<f:option value="성격의 장단점"></f:option>
						<f:option value="성장과정"></f:option>
						<f:option value="입사 후 포부"></f:option>
						<f:option value="지원동기"></f:option>
						<f:option value="지원동기"></f:option>
						<f:option value="지원동기"></f:option>
					</f:select>
				</div>
				
				<!-- 글자수 영역 -->
				<div class="count-area">
					<p class="count-text">공백 포함 <span class="count-span" id="cntArea-a">0</span>자 / 공백 미포함 <span class="count-span" id="cntArea-b">0</span>자 </p>
				</div>
				<!-- 글자수 영역 끝 -->
				
				<div class="row" class="">
					<div class="col-md-2">
						<fieldset class="cv-box">
							<legend class="legend">작성</legend>
							<f:textarea class="textarea" onkeydown="contentCnt(this);" id="content" path="targets[0].content"></f:textarea>
						</fieldset>
						
						<button class="btn cv-btn" type="button">음성입력</button>
					</div>
					<div class="col-md-2">
						<fieldset class="cv-box">
							<legend class="legend">검사</legend>
							<div class="cv-spell"></div>
						</fieldset>
						
						<button class="btn cv-btn" type="button" onclick="spellCheck(this);">맞춤법검사</button>
					</div>
				</div>
			</div>
			<!-- CLONE button 영역 -->
			<div class="clone-btn-grp" id="">
				<button class="add-btn" onclick="add();" type="button">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/button.png">
				</button>
				<button class="remove-btn" onclick="remove(this)" type="button">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/minus.png">
				</button>
			</div>
		</div>
	</div>
	<!-- 자소서 작성 영역 끝-->
	<!-- submit 영역 -->
	<div class="container submit-container">
		<div class="submit-area">
			<input type="submit" class="btn" value="작성완료" >
			<button class="btn" onclick="location.href='JOB_jobCenter.do'" type="button">돌아가기</button>
		</div>
	</div>
	</f:form>
</body>
</html>