<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글수정</title>
<%@ include file="../ALL/header_login.jsp"%>

<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/BOARD/boardUpdate.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardUpdate.css"
	rel="stylesheet">

<!-- include summernote -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>
</head>
<body>
	<div class="container">
		<form method="post" action="BOARD_boardWrite.do">
			<div class="board-title">
				<h2>제목</h2>
				<input type="text" value="${boardDetail.title }" name="title" id="title">
			</div>

			<div class="board-write">
				<h2>내용</h2>
				<textarea rows="100" cols="100" class="summernote" name="content">${boardDetail.content }</textarea>
			</div>

			<div id="btn-group">
				<input type="button" value="작성" class="btn" onclick="boardWrite();">
				<input type="button" value="취소" class="btn"
					onclick="location.href='BOARD_boardList.do'">
			</div>
		</form>
	</div>
</body>
</html>