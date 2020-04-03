	
	function plus() {
		
		
		
		var plus = $("#PFdetail").clone(true);
		var chk = plus.children('#photo').children('.img_wrap');
		var chk2 = plus.children('#function').children('#functioninfo');
		var chk3 = plus.children('#viewinfo').children('#viewinfo1');
		chk.html('');
		chk2.html('');
		chk3.html('');
		
		$("#filed").append(plus);		
	}
	
	