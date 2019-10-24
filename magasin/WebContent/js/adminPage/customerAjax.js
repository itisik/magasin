$("#customerSearchBtn").click(function() {
	const searchIndex = $("[name = searchIndex]").val();
	const selectIndex = $("[name = selectIndex]").val();
	const dateSelect = $("[name = dateSelect]").val();
	const customer = $("[name = customer]").val();
	
	$.ajax({
		url : "/customerSearch",
		type : "get",
		data : {
			searchIndex:searchIndex,
			selectIndex:selectIndex,
			dateSelect:dateSelect,
			customer:customer
		},
		success : function(data) {
			let tbody = $("#customersResult tbody");
			for (let index in data) {
				const tr = $("<tr class='test'>");
				let idTd = $("<td>").html(data[index].cusId);
				let nameTd = $("<td>").html(decodeURIComponent(data[index].cusName));
				let pNameTd = $("<td>").html(decodeURIComponent(data[index].cusPrdName));
				let pCountTd = $("<td>").html(data[index].cusPrdCount);
				let orderDate = $("<td>").html(decodeURIComponent(data[index].cusPurDate));
				let orderoutDate = $("<td>").html(decodeURIComponent(data[index].cusOutDate));
				tr.append(idTd).append(nameTd).append(pNameTd).append(pCountTd).append(orderDate).append(orderoutDate);
				console.log(tr.html());
				tbody.append(tr);
			}
		}
	});
});
// customersResult
