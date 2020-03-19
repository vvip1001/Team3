<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글목록</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/BOARD/boardList.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardList.css"
	rel="stylesheet">

</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
	<div class="container">
		<h1>자유게시판</h1>

		<input type="button" value="글작성" class="btn"
			onclick="location.href='BOARD_boardWriteForm.do'">

		<table class="table table-bordered">
			<col width="100" />
			<col width="300" />
			<col width="100" />
			<col width="100" />

			<thead>
				<!-- table search -->
				<tr>
					<td colspan="4" class="search-form"><span>검색</span> <input
						type="text" class="search-input" placeholder="search">
						<button type="submit" class="search-btn">
							<i class="fa fa-search fa-lg"></i>
						</button></td>
				</tr>

				<!-- table column -->
				<tr class="header-bar">
					<th>글번호</th>
					<th>글제목</th>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${empty boardList }">
						<tr>
							<td colspan="4">작성된 글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${boardList }" var="dto">
							<tr>
								<td>${dto.boardseq }</td>
								<td id="title"><a
									href="BOARD_boardDetail.do?boardseq=${dto.boardseq }">${dto.title }</a></td>
								<td class="board-date"><fmt:formatDate value="${dto.regdate}" pattern="yy-MM-dd HH:mm" /></td>
								<td class="board-email">${dto.joinemail }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>