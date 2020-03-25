<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/userMain.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/USER/userMain.css"
	rel="stylesheet">
<!-- include modal -->
<script type="text/javascript"
	src="https://getbootstrap.com/docs/3.4/javascript/#modals"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>


<!-- include chart.js -->
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>


</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
	<div class="topside"></div>
	<div class="userContainer">
		<div class="side"></div>

		<div class="center1">
			<div class="topside"></div>
			<div class="center1height" align="center">
				<br> <img alt="#" src="img/ex.png">
				<h2>김라이언 님</h2>
				<br> <br>
				<button class="btn" id="userUpdate">개인정보 수정</button>
				<br> <br> <span style="font-weight: bold;">---나의
					이력---</span> <br>
				<button class="btn" onclick="location.href='userDetail.do'">인적사항</button>
				<br>
				<button class="btn" onclick="#">취업센터</button>
			</div>
			<div class="center1heightside"></div>


		</div>

		<div class="centerside"></div>
		<div class="center2">
			<div class="topside"></div>
			<div class="center2height">
				<h2>나의 준비현황</h2>
			</div>
			<div class="center2heightside"></div>
			<div class="center2height">
				<h2>나의 IT역량</h2>
				<div class="chart">
					<canvas id="ITChart"></canvas>
				</div>
			</div>
			<div class="center2heightside"></div>
			<div class="center2height">
				<h2>나의 스펙</h2>
				<div class="chart">
					<canvas id="MyChart"></canvas>
				</div>
			</div>
			<div class="center2heightside"></div>
			<div class="center2calendar">
				<h2>채용일정 켈린더</h2>
			</div>
			<div class="center2calendarside"></div>

		</div>

		<div class="side"></div>

	</div>


	<!-- Modal -->
	<div class="modal fade" role="dialog" id="modal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" align="center">개인정보수정</h3>
				</div>
				<div class="modal-body" align="center">
					<p>
						새 비밀번호<br> <input type="text" id="pw"><br> 비밀번호
						확인<br> <input type="password" id="pwConfirm">
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" id="soo" class="btn btn-default"
						data-dismiss="modal" onclick="#">확 인</button>
					<br> <br>
					<div id="deleteDiv">
						탈퇴하러가기 <a href="#" id="delete">회원탈퇴</a>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
<!-- chart.js 영역 -->
<script type="text/javascript">
$(function() {
	itChartLabel = [];
	itChartData = [];
	
	$.each(${itSkill }, function(idx, obj) {
		itChartLabel.push(obj.skill);
		itChartData.push(obj.score);   
	});
    createITChart();
    
    myChartLabel = [];
	myChartData = [];
	
	$.each(${mySkill }, function(idx, obj) {
		$.each(obj, function(idx2, obj2) {
			myChartLabel.push(idx2);
			myChartData.push(obj2);
		});	
	});
    createMYChart();
});
</script>
</html>