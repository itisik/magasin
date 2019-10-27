$("#chartSearchBtn").click(function(){
	const chartIndex = $("[name = chartIndex]").val();
	// 결제일 기준 조회 혹은 배송완료일 기준 조회
	// purchaseDate, completeDate
	
	const startDate =  $("[name = datepicker1]").val();
	const endDate =  $("[name = datepicker2]").val();
	
	console.log(chartIndex);
	console.log(startDate);
	console.log(endDate);
});