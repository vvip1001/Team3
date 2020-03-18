<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글상세</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/BOARD/boardDetail.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardDetail.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>

	<div class="container">
		<h1>자유게시판</h1>

		<table class="table table-bordered">
			<!-- 게시글 영역 -->
			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="3">${boardDetail.title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td colspan="3">${boardDetail.joinemail }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td colspan="3">${boardDetail.regdate }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">${boardDetail.content }</td>
				</tr>
				<tr>
					<td colspan="3"><span><a href="#">수정</a>|<a href="#"
							onclick="deleteAlert();">삭제</a></span></td>
				</tr>
			</tbody>

			<!-- 댓글 영역 -->
			<tfoot>
				<tr>
					<td colspan="3" class="reply-label">댓 글</td>
				</tr>
				<tr>
					<td colspan="4">
						<div class="reply-insert-area">
							<input type="text" class="form-control"
								placeholder="바르고 고운말을 사용합시다." aria-label="Recipient's username"
								aria-describedby="button-addon2">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button"
									id="button-addon2" onclick="replyInsert();">입력</button>
							</div>
						</div>
					</td>
				</tr>
				<tr class="reply">
					<c:forEach items="${replyList }" var="reply">

						<th>${reply.joinemail }</th>
						<td>${reply.content }</td>
						<td><c:choose>
								<c:when test="${reply.joinemail eq 'babo@naver.com' }">
									<span><a href="#">삭제</a></span>
								</c:when>
								<c:otherwise>
									<span><a href="#">답글</a></span>
								</c:otherwise>
							</c:choose></td>

					</c:forEach>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>