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
		
		<!-- 글목록 영역 -->
		<div class="board-list">
			<h1>자유게시판</h1>

			<input type="button" value="글작성" class="btn"
				onclick="location.href='BOARD_boardWriteForm.do'">

			<table class="table table-bordered">
				<col width="100" />
				<col width="300" />
				<col width="100" />
				<col width="100" />

				<thead>
					<!-- 테이블 : 검색영역 -->
					<tr>
						<td colspan="4" class="search-form"><span>검색</span> <input
							type="text" class="search-input" placeholder="search">
							<button type="submit" class="search-btn">
								<i class="fa fa-search fa-lg"></i>
							</button></td>
					</tr>

					<!-- 테이블 : 게시글 목록 영역 -->
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
								<td colspan="4" id="boardlist-null">작성된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${boardList }" var="dto">
								<tr>
									<td class="board-seq"><fmt:formatNumber
											value="${dto.boardseq }" pattern="000" /></td>
									<td class="board-title"
										onClick="location.href='BOARD_boardDetail.do?boardseq=${dto.boardseq }'">${dto.title }</td>
									<td class="board-date"><fmt:formatDate
											value="${dto.regdate}" pattern="yy-MM-dd HH:mm" /></td>
									<td class="board-email">${dto.joinemail }</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>

		<!-- 페이징 영역 -->
		<nav aria-label="Page navigation" id="paging-nav">
			<ul class="pagination">
				<c:if test="${pagination.curRange ne 1 }">
					<li onClick="paging(1)"><a href="#" aria-label="Previous">
							<span aria-hidden="true">처음</span>
					</a></li>
				</c:if>
				<c:if test="${pagination.curPage ne 1}">
					<li onClick="paging('${pagination.prevPage }')"><a href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:forEach var="pageNum" begin="${pagination.startPage }"
					end="${pagination.endPage }">
					<c:choose>
						<c:when test="${pageNum eq  pagination.curPage}">
							<li onClick="paging('${pageNum }')"><a href="#"
								class="paging-focus">${pageNum }</a></li>
						</c:when>
						<c:otherwise>
							<li onClick="paging('${pageNum }')"><a href="#">${pageNum }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if
					test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
					<li onClick="paging('${pagination.nextPage }')"><a href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if
					test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
					<li onClick="paging('${pagination.pageCnt }')"><a href="#"
						aria-label="Next"> <span aria-hidden="true">마지막</span>
					</a></li>
				</c:if>

			</ul>
		</nav>
	</div>
</body>
</html>