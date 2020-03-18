<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글작성</title>
<%@ include file="../ALL/header_login.jsp"%>

<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/BOARD/boardWrite.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardWrite.css"
	rel="stylesheet">

<!-- include summernote -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>

</head>
<body>
	
	<div class="container">
		<h1>자유게시판</h1>

		<form method="post" action="boardWrite.do">
			<div class="board-title">
				<h2>제목</h2>
				<input type="text" placeholder="제목을 입력하세요." name="title" id="title">
			</div>

			<div class="board-write">
				<h2>내용</h2>
				<textarea rows="100" cols="100" class="summernote" name="content"></textarea>
			</div>

			<div id="btn-group">
				<input type="submit" value="작성" class="btn" onclick="boardWrite();">
				<input type="button" value="취소" class="btn"
					onclick="location.href='boardList.do'">
			</div>
		</form>
	</div>
	
	<!-- 모달 영역 -->
   <div class="modal fade" id="myModal" tabindex="-1">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title" id="myModalLabel">모달 타이틀</h4>
            </div>
            <div class="modal-body">모달 내용</div>
            <div class="modal-footer">
               <button type="button" class="btn btn-basic">예</button>
               <button type="button" class="btn btn-basic" data-dismiss="modal">아니오</button>
            </div>
         </div>
      </div>
   </div>
	
</body>
</html>