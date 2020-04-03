<%@page import="java.util.ArrayList"%>
<%@page import="com.job.coverletter.model.company.dto.CompanyDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/MAIN/main.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/MAIN/main.css"
	rel="stylesheet">
</head>



<body>

<c:if test="${empty list_cnt20}">
	<c:set var="list_cnt20" value="<%=new ArrayList<CompanyDto>() %>"/>
</c:if>
	
	<c:choose>
		<c:when test="${empty login }">
			<%@ include file="../ALL/header_logout.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../ALL/header_login.jsp"%>
		</c:otherwise>
	</c:choose>
	
	<div class="container" style="background-color: #ebe6e6;">
		<div id="MaintopDiv">
			<h1>[자소서 성공 페이지]</h1>
		</div>

		<div class="companySide"></div>
		<div class="company">
			<h5 class="h5">웹 개발자</h5>

			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=148"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/37802/clab_logo_1584507642.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>주식회사 언더핀</h5>

					<div class="front">Most be loved Global AI & BlockChain Company from Dreamer</div>
					<br /> <br />
				</div>
			</div>
 
			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=275"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/296/alice_logo_1541492949.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>에피</h5>

					<div class="front">★망리단길에서 글로벌 70개국 사용자 기반의 "HR플랫폼" 서비스와 "비주얼 협업" 툴을 운영중</div>
					<br /> <br />
				</div>
			</div>
			
			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=412"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/116429/repan_logo_1583194289.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5 >리판</h5>

					<div class="front">분산된 부동산 자산운용을 위한 플랫폼</div>
					<br /> <br />
				</div>
			</div>
			
			
			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=428"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/102123/wishhome_logo_1574901002.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5 >위시홈</h5>

					<div class="front">최저가 인테리어 브랜드 비교 서비스</div>
					<br /> <br />
				</div>
			</div>



		</div>

		<div class="companySide"></div>
		<div class="company">
			<h5 class="h5">프론트앤드</h5>

			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=1378"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/2909/howtomarry_logo_1556186768.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>웨딩북</h5>
					<div class="front">처음하는 결혼준비를 데이터로 돕는 웨딩 플랫폼</div>
					<br /> <br />
				</div>
			</div>


			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=1124"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/7791/pxd_logo.gif?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>피엑스디</h5>
					<div class="front">UX Design Consultancy</div>
					<br /> <br />
				</div>
			</div>


			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=944"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/15448/seoulsoft_logo_1457595048.jpg?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>서울소프트</h5>
					<div class="front">비전과 가치를 함께하실 분들을 기다립니다.</div>
					<br /> <br />
				</div>
			</div>




			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=899"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/31303/freshcode_logo_1534758442.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>프레시코드</h5>
					<div class="front">건강편의식 거점배송 플랫폼</div>
					<br /> <br />
				</div>
			</div>




		</div>

		<div class="companySide"></div>

		<div class="company">
			<h5 class="h5">백앤드</h5>

			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=402"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/112945/doobitnaraesoft_logo_1578915347.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>두빛나래소프츠</h5>


					<div>Fintech 소프트웨어 개발</div>
					<br /> <br />
				</div>
			</div>

			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=917"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/90111/crunchprice_logo_1580703917.png?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>크프</h5>

					<div>가격만 본다면, 크프</div>
					<br /> <br />
				</div>
			</div>


			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=1094"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/19671/bitbyte_logo_1498635827.jpg?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>쉬폰코퍼레이션</h5>

					<div>모바일 키보드 앱 '플레이키보드'</div>
					<br /> <br />
				</div>
			</div>



			<div class="companyItem">
				<div class="companyItemTop">
					<a href="MAIN_mainDetail.do?companyseq=1236"> <img
						class="companyImg"
						src="https://image.rocketpunch.com/company/14445/zipfund_logo_1467363601.jpg?s=400x400&t=inside" />
					</a>
				</div>
				<br> <br>
				<div class="companyItemBottom">

					<h5>집펀드</h5>

					<div>부동산 빅데이터/핀테크</div>
					<br/> <br/>
				</div>
			</div>








		</div>


		<div class="companySide"></div>
		<article>
			<div class="totalCompany">

				<h5 class="h6">전체</h5>


				<c:choose>
					<c:when test="${empty list_cnt20}">
						<h3>====================데이터가 없습니다.====================</h3>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list_cnt20}" var="companyDto">
							<div class="totalCompanyItem">
								<div class="companyItemTop">
									<a
										href="MAIN_mainDetail.do?companyseq=${companyDto.companyseq }&groupno=${companyDto.groupno}">
										<img class="companyImg2" src="${companyDto.imgurl}" />
									</a>
									
								</div>
								<div class="companyItemBottom">
									<div class="companyname" id="companyname">${companyDto.companyname}</div>
									<div class="business">${companyDto.business}</div>
								</div>
							</div>



						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</article>

		<nav class="bottomNav"></nav>
	</div>




</body>
</html>