<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 입력</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script type="text/javascript"
	src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/userPFwrite.js?ver=2"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/USER/userPFwrite.css"
	rel="stylesheet">


</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
	
	<div class="container">
		<div class="center" id="center">
			<div id="pdfwrap">
				<div id="PFinfo">
				<form action="PFinsert.do" method="post"> 
				<input type="hidden" name="pdfScr" id="pdfScr">
					<h1 id="item">포트폴리오 필수항목</h1>
					<table class="PFtable">
						<tr>
							<th>프로젝트명</th>
							<td class="PFinfo"><input type="text" name="title"></td>
						</tr>
						<tr>
							<th>수행기간</th>
							<td class="PFinfo"><input type="text" ></td>
						</tr>
						<tr>
							<th>개발목표</th>
							<td class="PFinfo"><textarea rows="7" cols="60"></textarea></td>
						</tr>
						<tr>
							<th>개발환경</th>
							<td class="PFinfo"><textarea rows="7" cols="60"></textarea></td>
						</tr>
						<tr>
							<th>구현기능</th>
							<td class="PFinfo"><textarea rows="7" cols="60"></textarea></td>
						</tr>
						<tr>
							<th>담당역할</th>
							<td class="PFinfo"><textarea rows="7" cols="60"></textarea></td>
						</tr>
						<tr>
							<th>참여도 / 기여도</th>
							<td class="PFinfo"><input type="text" ></td>
						</tr>
					</table>
				</div>





				<div id="PFdetail">
					<div id="PFbtn">
						<button id="minus" onclick="minus(this);" style="float: left;">
							<!-- <img alt="minus" src="resources/IMG/minus.png" style="width: 20px; height: 20px;"> -->
							삭제
						</button>
						<input type="file" class="input_img" >
					</div>

					<div id="PFcenter" style="display: flex;">
						<div class="margin" style="flex: 0.1;"></div>
						<div id="main" style="flex: 2; display: flex;">
							<div id="photo" style="flex: 2;">
								<div class="img_wrap">
									화면이미지첨부 <img style="width: 100%; height: 100%;" />
								</div>
							</div>
							<div id="between" style="flex: 0.1;"></div>
							<fieldset id="function" style="flex: 2;">
								<legend class="le">기능설명</legend>
								<textarea rows="10" cols="60" id="functioninfo"></textarea>
							</fieldset>
						</div>
						<div class="margin" style="flex: 0.1;"></div>
					</div>

					<div id="PFlast">
						<fieldset id="viewinfo">
							<legend class="le">화면설명</legend>
							<textarea rows="8" cols="90" id="viewinfo1"></textarea>
						</fieldset>
					</div>
				</div>
				<div id="filed"></div>
			</div>
			</form>
			<button id="create_pdf" onclick="pdfprint();">포트폴리오 PDF변환</button>


			<button id="plus" onclick="plus();">
				<img id="plusbtn" alt="plusbtn" src="resources/IMG/plus.jpg">
			</button>








		</div>
	</div>
</body>


</html>