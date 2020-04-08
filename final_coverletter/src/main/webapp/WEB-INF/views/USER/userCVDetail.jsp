<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 입력</title>
<%@ include file="../ALL/header_login.jsp"%>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/USER/userCVwrite.js"></script>
<link
   href="${pageContext.request.contextPath}/resources/CSS/USER/userCVDetail.css"
   rel="stylesheet">
   
<!-- include cross origin -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery.ajax-cross-origin.min.js"></script>   
   
<!-- include -->   
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/JS/jspdf.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/JS/bluebird.min.js"></script>
	

<script type="text/javascript">

    function pdfPrint(){

        // 현재 document.body의 html을 A4 크기에 맞춰 PDF로 변환
        html2canvas(document.body, {
            onrendered: function (canvas) {

                // 캔버스를 이미지로 변환
                var imgData = canvas.toDataURL('image/png');

                var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
                var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
                var imgHeight = canvas.height * imgWidth / canvas.width;
                var heightLeft = imgHeight;

                var doc = new jsPDF('p', 'mm');
                var position = 0;

                // 첫 페이지 출력
                doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
                heightLeft -= pageHeight;

                // 한 페이지 이상일 경우 루프 돌면서 출력
                while (heightLeft >= 20) {
                    position = heightLeft - imgHeight;
                    doc.addPage();
                    doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
                    heightLeft -= pageHeight;
                }

                // 파일 저장
                doc.save('sample.pdf');


                //이미지로 표현
                //document.write('<img src="'+imgData+'" />');
            }
            
        });
        
    }

    window.onload = function(){
    	$('#cmd').click(function() {
    	pdfPrint();
    	});
    	
    }
</script>
</head>
<body>
<div class="container">
<button id="cmd">PDF</button>
	<div class="row">
		<table class="table table-bordered">
					<!-- 테이블 : 게시글 목록 영역 -->
					<tr class="header-bar">
						<th>지원회사</th>
						<th>지원분야</th>
						<th>희망연봉</th>
						<th>입사구분</th>
					</tr>
					<tr>
						<td><input type="text" class="form-control" id="usr"></td>
						<td><input type="text" class="form-control" id="usr"></td>
						<td><input type="text" class="form-control" id="usr"></td>
						<td><input type="text" class="form-control" id="usr"></td>
					</tr>
			</table>
	</div>

	<div id="whole">
		<form action="#">
			<div id="one">
				<div id="title">자기소개서</div>
				<div class="subtitle">1. 성장과정</div>
				<div class="line"></div>
				<div class="content">
					<textarea class="text" rows="20" cols="150"></textarea>
				</div>
			</div>
			<div id="two">
				<div class="subtitle">2. 학교생활/사회생활</div>
				<div class="line"></div>
				<div class="content">
					<textarea class="text" rows="20" cols="150"></textarea>
				</div>
			</div>
			<div id="three">
				<div class="subtitle">3. 성격의 장/단점</div>
				<div class="line"></div>
				<div class="content">
					<textarea class="text" rows="20" cols="150"></textarea>
				</div>
			</div>
			<div id="four">
				<div class="subtitle">4. 지원동기</div>
				<div class="line"></div>
				<div class="content">
					<textarea class="text" rows="20" cols="150"></textarea>
				</div>
			</div>
			<br>
			<br>
		</form>
	</div>
	</div>
</body>
</html>