<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인디테일</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/MAIN/main.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/MAIN/mainDetail.css"
	rel="stylesheet">
</head>
<body>

	<div id="All">
		<input type="hidden" id="companyseq" value="${maindetail.companyseq }"/>

		<div class="container" id="main">
			<div class="container" id=null></div>
			<form action="" method="post">
				<div class="row" id="img">
					<div class="col-md-12">
						<div class="logo_img">
							<img class="img" src="${mainDetail.imgurl }">
						</div>
					</div>
					<div class="row" id="companyname">
						<div class="col-md-12">${mainDetail.companyname }</div>

					</div>

				</div>

				<div class="row" id="oneintro">
					<div class="col-md-12">${mainDetail.oneintro }</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="bookmark" id="button">
						<button type="button" class="button" onclick="bookmark();">회사 즐겨찾기</button>
						</div>
					</div>
				</div>


				<div class="row" id="info">
					<div class="col-md-12">
						<h1 class="h1">${mainDetail.companyname }과(와)함께성장할 인재를 찾습니다</h1>
					</div>

				</div>



			</form>
		</div>


		<div class="container" id="side"></div>

		<div class="container" id="main">
			<form action="" method="post" id="">
				<div class="row">

					<div class="col-md-12">
						<h3>진행중인 채용정보</h3>
					</div>

				</div>


				<c:choose>
					<c:when test="${empty selectAll_group}">
						<h3>====================데이터가 없습니다.====================</h3>
					</c:when>
					<c:otherwise>
						<c:forEach items="${selectAll_group }" var="companyDto">

							<div class="information">

								${companyDto.companyname}<br> ${companyDto.business }<br>
								${companyDto.target }<br> ${companyDto.languages }<br>

							</div>


						</c:forEach>

					</c:otherwise>

				</c:choose>




			</form>

		</div>


		<div class="container" id="side"></div>

		<div class="container" id="main">
			<form action="" method="post">
				<div class="row">
					<div class="col-md-12">
						<h3>기업 소개</h3>
					</div>

				</div>


			</form>
			<div class="intro">${mainDetail.intro }</div>


		</div>

		<div class="container" id="side"></div>

		<div class="container" id="main">
			<form action="" method="post">
				<div class="row">
					<div class="col-md-12">
						<h3>복지</h3>

					</div>

				</div>

				<div id="welfare">

					<div>
						<div class="title">개인장비</div>

						<div class="content">${mainDetail.givetool }</div>

					</div>
					<br>

					<div>
						<div class="title">자기 계발</div>

						<div class="content">${mainDetail.selfgrowth }</div>

					</div>
					<br>

					<div>
						<div class="title">식사 시간</div>

						<div class="content">${mainDetail.mealtime }</div>

					</div>
					<br>

					<div>
						<div class="title">연차,휴가</div>

						<div class="content">${mainDetail.holiday }</div>

					</div>
					<br>

					<div>
						<div class="title">근무 형태</div>

						<div class="content">${mainDetail.workinghour }</div>

					</div>
					<br>

					<div>
						<div class="title">보험,의료</div>

						<div class="content">${mainDetail.insurance }</div>

					</div>
					<br>

				</div>

			</form>

		</div>


		<div class="container" id="side"></div>

		<div class="container" id="main">
			<form action="" method="post">
				<div class="row">
					<div class="col-md-12">
						<h3>기업정보</h3>
					</div>

				</div>


				<div id="incorporation">


					<div>
						<div class="title">설 립 일</div>

						<div class="content">${mainDetail.incorporation }</div>

					</div>
					<br>

					<div>
						<div class="title">구 성 원</div>

						<div class="content">${mainDetail.totalmember }</div>

					</div>
					<br>

					<div>
						<div class="title">홈페이지</div>


						<div class="content">
							<a href="${mainDetail.homepage }">${mainDetail.homepage }</a>
						</div>


					</div>
					<br>

					<div>
						<div class="title">산업분야</div>

						<div class="content">${mainDetail.mainfield }</div>

					</div>
					<br>


					<div>
						<div class="title">위 치</div>

						<div class="content">${mainDetail.location }</div>

					</div>
					<br>


				</div>
			</form>


		</div>



	</div>

</body>
</html>