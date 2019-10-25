$("#customerSearchBtn").click(
		function() {
			const searchIndex = $("[name = searchIndex]").val();
			const selectIndex = $("[name = selectIndex]").val();
			const dateSelect = $("[name = dateSelect]").val();
			const customer = $("[name = customer]").val();

			$.ajax({
				url : "/customerSearch",
				type : "get",
				data : {
					searchIndex : searchIndex,
					selectIndex : selectIndex,
					dateSelect : dateSelect,
					customer : customer
				},
				success : function(data) {
					let tbody = $("#customersResult tbody");
					tbody.html('');
					for ( let index in data) {
						const tr = $("<tr class='test'>");
						let ckTd = $("<td>").width('50px').html(
								'<input type="checkbox">');
						let idTd = $("<td style='width: 14%;'>").html(data[index].cusId);
						let nameTd = $("<td style='width: 14%;'>").html(
								decodeURIComponent(data[index].cusName));
						let pNameTd = $("<td style='width: 14%;'>").html(
								decodeURIComponent(data[index].cusPrdName));
						let pCountTd = $("<td style='width: 14%;'>").html(data[index].cusPrdCount);
						let orderDate = $("<td> style='width: 14%;'").html(
								decodeURIComponent(data[index].cusPurDate));
						let orderoutDate = $("<td> style='width: 14%;'").html(
								decodeURIComponent(data[index].cusOutDate));
						let orderCompDate = $("<td> style='width: 14%;'").html(
								decodeURIComponent(data[index].cusOutDate));

						tr.append(ckTd).append(idTd).append(nameTd).append(
								pNameTd).append(pCountTd).append(orderDate)
								.append(orderoutDate).append(orderCompDate);

						tbody.append(tr);
					}
				}
			});
		});