<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>

	<!-- 자소서 제목 영역 -->
	<div class="container">

		<div id="title-area">
			<h1>자기소개서 작성</h1>

			<div class="input-group">
				<span class="input-group-addon">제목</span> <input id="msg"
					type="text" class="form-control" name="msg"
					placeholder="제목을 입력하세요.">
			</div>
		</div>
	</div>

	<!-- 중간 여백 영역 -->
	<div id="fake-div"></div>

	<!-- 자소서 작성 영역 -->
	<div class="container">
		<div id="cv-area">
			<div id="input-grp">
				<div class="input-group">
					<span class="input-group-addon">소제목</span> <input id="msg"
						type="text" class="form-control" name="msg"
						placeholder="소제목을 입력하세요.">
				</div>
				<div class="input-group">
					<span class="input-group-addon">항목</span> <select
						class="form-control">
						<option>지원자의 성장과정에 대해</option>
						<option>지원자의 성장과정에 대해</option>
						<option>지원자의 성장과정에 대해</option>
						<option>지원자의 성장과정에 대해</option>
						<option>지원자의 성장과정에 대해</option>
					</select>
				</div>

				<div class="row" class="">
					<div class="col-md-2">
						<fieldset class="cv-box">
							<legend class="legend">작성</legend>
							<textarea rows="10" cols="10">
							
							</textarea>
						</fieldset>
						
						<button class="btn">음성입력</button>
					</div>
					<div class="col-md-2">
						<fieldset class="cv-box">
							<legend class="legend">검사</legend>
							<textarea rows="10" cols="10">
							
							</textarea>
						</fieldset>
						
						<button class="btn">맞춤법검사</button>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>