<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/BOARD/boardDetail.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardDetail.css" rel="stylesheet">

<!-- include bootstrap -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   
</head>
<body>

<!-- 모달 영역 -->
   <div id="modalBox" class="modal fade" id="myModal" tabindex="-1">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title" id="myModalLabel">모달 타이틀</h4>
            </div>
            <div class="modal-body">모달 내용</div>
            <div class="modal-footer">
               <button type="button" class="btn btn-basic"
                  onclick="location.href='boardDelete.do?boardseq=${boardDetail.boardseq }'">예</button>
               <button type="button" class="btn btn-basic" data-dismiss="modal">아니오</button>
            </div>
         </div>
      </div>
   </div>

</body>
</html>