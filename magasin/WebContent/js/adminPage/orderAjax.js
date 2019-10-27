$("#orderSearchBtn").click(function() {
	const widthSize = 10;
	
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
	
	const oneShotForOrder = $(".oneShotForOrder");
	oneShotForOrder.removeClass('o1')
	.removeClass('o2').removeClass('o3')
	.removeClass('o4').removeClass('o5')
	.removeClass('o6').removeClass('o7')
	.removeClass('o0').removeClass('oc');
	
	if(-2 < detailIndex && detailIndex < 8){
		oneShotForOrder.show();
	} else {
		oneShotForOrder.hide();
	}
	
	const tbody = $("#orderResult tbody");
	if (timeIndex == "none2") {
		tbody.html('조회기간을 선택해주세요.');
		countList2.html('0');
	} else if (order == "" && (detailIndex == "customerName2" || detailIndex == "customerId2" || detailIndex == "prdName2" )) {
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
				if(data[0].orderNum == 999 || data[0].orderCusPurDate == "내용없음") {
					tbody.html('검색결과 없음');
					countList.html('0');
				} else {
					tbody.html('');
					for (let index in data) {
						const tr = $("<tr>");
						
						const chkTd = $("<td style='width: 4.2%;'>");
						
						let status;
						
						switch(data[index].orderStatus){
						case 1:
							status = "o1";
						break;
						case 2:
							status = "o2";
							break;
						case 3:
							status = "o3";
							break;
						case 4:
							status = "o4";
							break;
						case 5:
							status = "o5";
							break;
						case 6:
							status = "o6";
							break;
						case 7:
							status = "o7";
							break;
						case 0:
							status = "o0";
							break;
						case -1:
							status = "oc";
							break;
						}
						
						chkTd.append($("<input type='checkbox' id='"+status+"'class='orderCheckBox'>"))
						
						const idTd = $("<td style='width: "+ widthSize +"%;'>").html(data[index].orderCusId);
						const nameTd = $("<td style='width: "+ widthSize +"%;'>").html(decodeURIComponent(data[index].orderCusName));
						const pNameTd = $("<td style='width: "+ widthSize +"%;'>").html(decodeURIComponent(data[index].orderCusPrdName));
						const addr = $("<td style='width: "+ widthSize +"%;'>").html(decodeURIComponent("<div class='purAddr' id='"+ data[index].orderNum +"'>배송 예정지 보기</div>"));
						const pCountTd = $("<td style='width: "+ widthSize +"%;'>").html(data[index].orderCusPrdCount);
						const orderDate = $("<td style='width: "+ widthSize +"%;'>").html(decodeURIComponent(data[index].orderCusPurDate));
						const orderOutDate = $("<td style='width: "+ widthSize +"%;'>").html(decodeURIComponent(data[index].orderCusOutDate));
						const orderComDate = $("<td style='width: "+ widthSize +"%;'>").html(decodeURIComponent(data[index].orderCusComDate));
						const orderStatus = $("<td style='width: "+ widthSize +"%;'>");
						
						let temp = "";
						

						switch(data[index].orderStatus){
						case 1:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o1' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("신규주문"));
							oneShotForOrder.addClass('o1');
						break;
						case 2:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o2' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("배송준비중"));
							oneShotForOrder.addClass('o2');
							break;
						case 3:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o3' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("배송중"));
							oneShotForOrder.addClass('o3');
							break;
						case 4:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o4' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("배송완료"));
							oneShotForOrder.addClass('o4');
							break;
						case 5:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o5' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("반품신청"));
							oneShotForOrder.addClass('o5');
							break;
						case 6:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o6' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("반품중"));
							oneShotForOrder.addClass('o6');
							break;
						case 7:
							temp = $("<button id='"+ data[index].orderNum +"' class='o7' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("반품완료"));
							oneShotForOrder.addClass('o7');
							break;
						case 0:
							temp = $("<button id='"+ data[index].orderNum +"' class='orderProgress o0' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("주문취소요청"));
							oneShotForOrder.addClass('o0');
							break;
						case -1:
							temp = $("<button id='"+ data[index].orderNum +"' class='oc' status='"+ data[index].orderStatus + "'>").html(decodeURIComponent("취소완료"));
							oneShotForOrder.addClass('oc');
							break;
						}
						orderStatus.append(temp);
						
						tr.append(chkTd)
						.append(idTd)
						.append(nameTd)
						.append(pNameTd)
						.append(addr)
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