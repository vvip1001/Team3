<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/userMain.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/USER/userMain.css" rel="stylesheet">
<!-- include FullCalendar CSS/JS -->
<link href="${pageContext.request.contextPath}/resources/CSS/USER/FullCalendar/core/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/CSS/USER/FullCalendar/daygrid/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/CSS/USER/FullCalendar/timegrid/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/CSS/USER/FullCalendar/list/main.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/FullCalendar/core/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/FullCalendar/daygrid/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/FullCalendar/timegrid/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/FullCalendar/intersaction/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/FullCalendar/list/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/USER/FullCalendar/core/ko.js"></script>

<!-- include modal -->
<script type="text/javascript"
   src="https://getbootstrap.com/docs/3.4/javascript/#modals"></script>
<script
   src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
   src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid' ,'timeGrid'],
     
      header: {
    	  left: 'prevYear,prev,next,nextYear today',
    	  center: 'title',
    	  right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      buttonText: {
    	   today : "오늘",
    	   month : "월",
    	   week : "주",
    	   day : "일",
    	   },
      locale: 'ko',
      navLinks: true,
      //selectable: true,
      selectMirror: true,
      select: function(arg) {
        var title = prompt('추가할 내용:');
        if (title) {
          calendar.addEvent({
            title: title,
            start: arg.start,
            end: arg.end,
            allDay: arg.allDay
          })
        }
        calendar.unselect()
      },
      editable: true,
      eventLimit: true,
      events: [
          {
            title: 'All Day Event',
            start: '2020-02-01'
          },
          {
              title: 'Event',
              start: '2020-03-23 12:00',
              end: '2020-03-23 12:30'
            }
         ],
         eventClick: function(arg) {
             if (confirm('삭제하시겠습니까?')) {
               arg.event.remove()
             }
           }
    });
    calendar.render();
  });
</script>
<style type="text/css">
	#full {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
    
  }

  #calendar {
    max-width: 700px;
    margin: 0 auto;
  }
</style>
</head>
<body>
	<%@ include file="../ALL/header_login.jsp"%>
   <div class="topside">
   
   </div>
   <div class="userContainer">
      <div class="side">
      
      </div>
      
      <div class="center1">
         <div class="topside"></div>
         <div class="center1height" align="center">
            <br>
            <img alt="#" src="img/ex.png">
            <h2>김라이언 님</h2>
            <br>
            <br>
            <button class="btn" id="userUpdate">개인정보 수정</button>
            <br>
            <br>
            <span style="font-weight: bold;">---나의 이력---</span>
            <br>
            <button class="btn" onclick="location.href='USER_userDetail.do'">인적사항</button>
            <br>
            <button class="btn" onclick="#">취업센터</button>
         </div>
         <div class="center1heightside"></div>
         
         
      </div>
      
      <div class="centerside">
      
      </div>      
      <div class="center2">
         <div class="topside">
   
         </div>
         <div class="center2height">
            <h2>나의 준비현황</h2>
         </div>
         <div class="center2heightside">
         
         </div>
         <div class="center2height">
            <h2>나의 IT역량</h2>
         </div>
         <div class="center2heightside">
         
         </div>
         <div class="center2height">
            <h2>나의 스펙</h2>
         </div>
         <div class="center2heightside">
         
         </div>
         <div class="center2calendar">
            <h2>채용일정 캘린더</h2>
            <div id="full">
            	<div id="calendar"></div>
            </div>
         </div>
         <div class="center2calendarside">
         
         </div>
      
      </div>
      
      <div class="side">
      
      </div>
      
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
        	새 비밀번호<br>
        	<input type="text" id="pw"><br>
        	비밀번호 확인<br>
        	<input type="password" id="pwConfirm">
        </p>
      </div>
      <div class="modal-footer"  >
        <button type="button" id="soo" class="btn btn-default" data-dismiss="modal" onclick="#">확	인</button>
        <br><br>
        <div id="deleteDiv">탈퇴하러가기  <a href="#" id="delete">회원탈퇴</a></div>
      </div>
    </div>

  </div>
</div>

</body>
</html>