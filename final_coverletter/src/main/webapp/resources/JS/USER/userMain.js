window.onload = function() {
	document.getElementById('userUpdate').onclick = function() {
		$('#modal').modal('show');

	}
}


/*-----------------------chart.js : IT 역량------------------------*/
$(function() {
	itChartLabel = [];
	itChartData = [];
	createITChart();
	/*
	 * $(document).ready(function() { $.each(data, function(idx, obj) {
	 * itChartLabels.push(obj.date); itChartData.push(obj.calorie); });
	 * createITChart(); });
	 */

	function createITChart() {
		var ctx = document.getElementById('ITChart').getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'doughnut',
			data : {
				labels : itChartLabel,
				datasets : [ {
					label : '나의 IT역량',
					data : itChartData,
					backgroundColor : [ 'rgba(192, 192, 192, 1)',
							'rgba(116, 116, 116, 1)', 'rgba(0, 0, 0, 1)' ]

				} ]
			},
			options : {
				responsive : false,
				scales : {
					xAxes : [ {
						gridLines : {
							display : false
						},
						ticks : {
							display : false
						}
					} ],
					yAxes : [ {
						gridLines : {
							display : false
						},
						ticks : {
							display : false
						}
					} ]
				}
			}
		});

	}
});

/*-----------------------chart.js : 나의 스펙------------------------*/
$(function() {
	myChartLabel = [ '스펙1', '스펙2', '스펙3', '스펙4', '스펙5' ];
	myChartData = [ 4, 3, 6 , 9, 4 ];
	createMyChart();
	
	function createMyChart() {
		var ctx = document.getElementById('MyChart').getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'radar',
			data : {
				labels : myChartLabel,
				datasets : [ {
					label : '나의 스펙',
					data : myChartData
				} ]
			},
		});
	}
});
