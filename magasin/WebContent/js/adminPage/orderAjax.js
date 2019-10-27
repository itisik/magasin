$("#orderSearchBtn").click(function() {
	const timeIndex = $("[name = timeIndex]").val();
	// 조회 기간 카테고리
	
	const dateSelect2 = $("[name = dateSelect2]").val();
	// 조회 기간 디테일
	
	const detailIndex = $("[name = detailIndex]").val();
	// 상세조건 : 전체주문, 신규주문, ..........
	
	const order = $("[name = order]").val();
	// 검색 키워드
	
	const countList2 = $("#countList2");
	// 검색된 목록 개수
	
	const tbody = $("#orderResult tbody");
	if (timeIndex == "none2") {
		tbody.html('조회기간을 선택해주세요.');
		countList.html('0');
	} else if (order == "") {
		tbody.html('검색어를 입력해주세요');
		countList2.html('0');
	} else {
		$.ajax({
			url : "/orderSearch",
			type : "get",
			data : {
				timeIndex : timeIndex,
				dateSelect2 : dateSelect2,
				detailIndex : detailIndex,
				order : order
			},
			success : function(data) {
				if (data[0].cusId == "") {
					tbody.html('검색결과 없음');
					countList.html('0');
				} else {
					tbody.html('');
					for (let index in data) {
						const tr = $("<tr class='test'>");
						
						const chkTd = $("<td style='width: 50px;'>");
						chkTd.append($("<input type='checkbox' id='"+decodeURIComponent(data[index].orderStatus)+"'class='orderCheckBox'"))
						const idTd = $("<td style='width: 14.285714%;'>").html(data[index].cusId);
						const nameTd = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].orderCusName));
						const pNameTd = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].orderCusPrdName));
						const pCountTd = $("<td style='width: 14.285714%;'>").html(data[index].orderCusPrdCount);
						const orderDate = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].orderCusPurDate));
						const orderOutDate = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].orderCusOutDate));
						const orderComDate = $("<td style='width: 14.285714%;'>").html(decodeURIComponent(data[index].orderCusComDate));
						const orderStatus = $("<td style='width: %;'>");
						
						if(detailIndex == 0){
							const temp = append($("<button class='o0'>")).html("주문취소요청");
						} else if(detailIndex == 1){
							orderStatus.append($("<button class='o1'>")).html("신규주문");
						} else if(detailIndex == 2){
							orderStatus.append($("<button class='o2'>")).html("배송준비중");
						} else if(detailIndex == 3){
							orderStatus.append($("<button class='o3'>")).html("배송중");
						} else if(detailIndex == 4){
							orderStatus.append($("<button class='o4'>")).html("반품완료");
						} else if(detailIndex == 5){
							orderStatus.append($("<button class='o5'>")).html("반품신청");
						} else if(detailIndex == 6){
							orderStatus.append($("<button class='o6'>")).html("반품중");
						} else if(detailIndex = 7){
							orderStatus.append($("<button class='o7'>")).html("반품완료");
						} else if(detailIndex = -1){
							orderStatus.append($("<button class='oc'>")).html("취소완료");
						}
						
						tr.append(idTd).append(nameTd)
						.append(pNameTd)
						.append(pCountTd)
						.append(orderDate)
						.append(orderOutDate)
						.append(orderComDate)
						.append(orderComDate)
						.append(orderStatus);
						
						tbody.append(tr);
						countList2.html(Number(index)+Number(1));
					}
				}
			},
			error : function(){
				tbody.html('검색결과 없음');
				countList2.html('0');
				}
			});
		}
	});