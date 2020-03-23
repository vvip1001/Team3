<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인적사항 입력</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/userDetail.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/rSlider.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/USER/userDetail.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>

	<div class="container">
		<div class="center">
			<div>
				<h3>1.인적사항</h3>
				<div class="col-md-1" id="photo">사진업로드</div>
				<input class="col-md-4" id="small" type="text" placeholder="이름">
				<input class="col-md-4" id="big" type="text" placeholder="생년월일">
				<input class="col-md-4" id="small" type="text" placeholder="성별">
				<input class="col-md-4" id="big" type="text" placeholder="이메일">
				<select class="col-md-4" id="small">
					<option>병역</option>
					<option>미필</option>
					<option>군필</option>
					<option>면제</option>
				</select> <input class="col-md-4" id="big" type="text" placeholder="전화번호">
				<input class="col-md-4" id="bigbig" type="text" placeholder="주소">
			</div>

			<div>
				<h3>2.학력</h3>
				<div>
					<div>
						<div id="default2">
							<select class="col-md-4" id="small">
								<option>학력구분</option>
								<option>대졸</option>
								<option>전문대졸</option>
								<option>고졸</option>
							</select> <input class="col-md-4" id="big2" type="text" placeholder="학교명">
							<input class="col-md-4" id="big1" type="text"
								placeholder="입학년월(2013.03)"> <input class="col-md-4"
								id="big1" type="text" placeholder="졸업년월(2020.03)"> </select> <input
								class="col-md-4" id="bigbig1" type="text" placeholder="전공명">
							<input class="col-md-4" id="bigbig1" type="text"
								placeholder="학점 / 4.5">
						</div>
						<div id="field2"></div>
						<div id="custom_button2">
							<button id="button2" onclick="add_div(this.id);">
								<img alt=""
									src="${pageContext.request.contextPath}/resources/IMG/button.png">
							</button>
							<button onclick="remove_div(this);">
								<img alt=""
									src="${pageContext.request.contextPath}/resources/IMG/minus.png">
							</button>
						</div>
					</div>
				</div>
			</div>
		
			<div>
				<h3>3.IT역량(가장 자신있는 기술을 5개 입력(필수!!!))</h3>
				<div id="itdiv" class="row">
					<input type="text" class="col-md-4" id="small" placeholder="기술">
					<div class="container1" class="col-md-4">
						<div class="slider-container" style="width: 300px;">
							<input type="text" id="slider1" class="slider" />
						</div>
					</div>
					<input type="text" class="col-md-4" id="small" placeholder="기술">
					<div class="container1">
						<div class="slider-container" style="width: 300px;">
							<input type="text" id="slider2" class="slider" />
						</div>
					</div>
					<input type="text" class="col-md-4" id="small" placeholder="기술">
					<div class="container1">
						<div class="slider-container" style="width: 300px;">
							<input type="text" id="slider3" class="slider" />
						</div>
					</div>
					<input type="text" class="col-md-4" id="small" placeholder="기술">
					<div class="container1">
						<div class="slider-container" style="width: 300px;">
							<input type="text" id="slider4" class="slider" />
						</div>
					</div>
					<input type="text" class="col-md-4" id="small" placeholder="기술">
					<div class="container1">
						<div class="slider-container" style="width: 300px;">
							<input type="text" id="slider5" class="slider" />
						</div>
					</div>
				</div>

			</div>
		</div>

		<br />

		<div>
			<h3>4.자격증</h3>
			<div id="default4">
				<input class="col-md-4" id="msmall" type="text" placeholder="자격증명">
				<input class="col-md-4" id="mbig" type="text" placeholder="발행기관">
				<input class="col-md-4" id="msmall" type="text" placeholder="취득일자">
			</div>
			<div id="field4"></div>
			<div class="btn333" id="custom_button4">
				<button id="button4" onclick="add_div(this.id);">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/button.png">
				</button>
				<button onclick="remove_div(this);">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/minus.png">
				</button>
			</div>
		</div>

		<div>
			<h3>5.어학점수</h3>
			<div id="default5">
				<input class="col-md-4" id="msmall" type="text" placeholder="공인시험명">
				<input class="col-md-4" id="mbig" type="text" placeholder="공인시험 점수">
				<input class="col-md-4" id="msmall" type="text" placeholder="취득일자">
			</div>
			<div id="field5"></div>
			<div class="btn333" id="custom_button5">
				<button id="button5" onclick="add_div(this.id);">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/button.png">
				</button>
				<button onclick="remove_div(this);">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/minus.png">
				</button>
			</div>

		</div>

		<div>
			<h3>6.공모전 참여이력</h3>
			<div id="default6">
				<input class="col-md-4" id="msmall" type="text" placeholder="공모전명">
				<input class="col-md-4" id="mbig" type="text" placeholder="시행기관">
				<input class="col-md-4" id="msmall" type="text" placeholder="참여일자">
			</div>
			<div id="field6"></div>
			<div class="btn333" id="custom_button6">
				<button id="button6" onclick="add_div(this.id);">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/button.png">
				</button>
				<button onclick="remove_div(this);">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/IMG/minus.png">
				</button>
			</div>
		</div>


	</div>
</body>
</html>