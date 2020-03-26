window.onload = function() { 
	document.getElementById('userUpdate').onclick = function() {
		$('#modal').modal('show');
		
		}
	
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
	          selectable: true,
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
	}

