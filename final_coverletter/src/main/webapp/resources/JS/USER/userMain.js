window.onload = function() {
	document.getElementById('userUpdate').onclick = function() {
		$('#modal').modal('show');

	}
}

/*-----------------------chart.js : IT 역량------------------------*/
function createITChart() {
	var ctx = document.getElementById('ITChart').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : itChartLabel,
			datasets : [ {
				data : itChartData,
				backgroundColor : [ '#c6f1a2', '#a8d966', '#43a367', '#385380',
						'#fbf27c' ],
				barPercentage : 0.5
			} ]
		},
		options : {
			responsive : false,
			scales : {
				xAxes : [ {
					gridLines : {
						display : true
					},
					ticks : {
						display : true
					}
				} ],
				yAxes : [ {
					gridLines : {
						display : true
					},
					ticks : {
						display : true
					}
				} ],
				legend : {
					display : false
				}
			}
		}
	});
}

/*-----------------------chart.js : 나의 스펙------------------------*/
function createMYChart() {
	var ctx = document.getElementById('MyChart').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'radar',
		data : {
			labels : myChartLabel,
			datasets : [ {
				data : myChartData,
				backgroundColor : '#cbe2b0',
				borderColor : '#f6d186',
				borderCapStyle : 'round',
			} ]
		},
		options : {
			responsive : false,
			legend : {
				display : false
			}
		}
	});
}
