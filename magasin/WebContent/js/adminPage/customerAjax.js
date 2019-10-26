$("#customerSearchBtn").click(function() {
					const searchIndex = $("[name = searchIndex]").val();
					const selectIndex = $("[name = selectIndex]").val();
					const dateSelect = $("[name = dateSelect]").val();
					const customer = $("[name = customer]").val();
					const countList = $("#countList");

					const tbody = $("#customersResult tbody");
					
					if (searchIndex == "none") {
						tbody.html('조회기간을 선택해주세요.');
						countList.html('0');
					} else if (customer == "") {
						tbody.html('검색어를 입력해주세요');
						countList.html('0');
					} else {
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
								if (data[0].cusId == "") {
									tbody.html('검색결과 없음');
									countList.html('0');
								} else {
									tbody.html('');
									for (let index in data) {
										const tr = $("<tr>");
										const idTd = $("<td style='width: 14.285714%;'>").html(data[index].cusId);
										const nameTd = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].cusName));
										const pNameTd = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].cusPrdName));
										const pCountTd = $("<td style='width: 14.285714%;'>").html(data[index].cusPrdCount);
										const orderDate = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].cusPurDate));
										const orderOutDate = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].cusOutDate));
										const orderComDate = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].cusComDate));
										
										tr.append(idTd).append(nameTd)
										.append(pNameTd)
										.append(pCountTd)
										.append(orderDate)
										.append(orderOutDate)
										.append(orderComDate);
										
										tbody.append(tr);
										
										countList.html(Number(index)+Number(1));
									}
								}
							},
							error : function(){
								tbody.html('검색결과 없음');
								countList.html('0');
							}
						});
					}
				});