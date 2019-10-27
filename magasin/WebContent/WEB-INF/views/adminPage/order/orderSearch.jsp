<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="tab5-order">
	<div class="order-top">
		<div class="top-title">
			<i class="fas fa-list"></i>&nbsp;&nbsp;&nbsp;주문조회
		</div>
	</div>

	<div class="order-view">
		<div class="view0-title">
			<i class="fas fa-store"></i>&nbsp;전체주문&nbsp;<a href="#"><span>64</span></a>건
		</div>
		<div class="view0-content"></div>
		<div class="view1-title">
			<i class="fas fa-box-open"></i>&nbsp;신규주문&nbsp;<a href="#"><span>11</span></a>건
		</div>
		<div class="view1-content"></div>
		<div class="view2-title">
			<i class="fas fa-shipping-fast"></i>&nbsp;배송중&nbsp;<a href="#"><span>20</span></a>건
		</div>
		<div class="view2-content"></div>
		<div class="view3-title">
			<i class="fas fa-people-carry"></i>&nbsp;배송완료&nbsp;<a href="#"><span>32</span></a>건
		</div>
		<div class="view3-content"></div>
		<div class="view4-title">
			<i class="fas fa-ban"></i>&nbsp;취소|<i class="fas fa-undo-alt"></i>환불요청&nbsp;<a
				href="#"><span>1</span></a>건
		</div>
		<div class="view4-content"></div>
	</div>

	<div class="order-search">
		<div style="text-align: right;"> ※ 배송완료된 주문건의 경우, 배송완료일로부터 14일간만 조회됩니다.</div>
		<div class="search-top">
			<div class="top-title">조회기간</div>
			<div class="top-select">
				<select name="timeIndex" class="timeIndex">
					<option value="none2">--선택--</option>
					<option value="all2">전체기간</option>
					<option value="purchaseDate2">결제일</option>
					<option value="outDate2">발송일</option>
				</select>
			</div>
			<div class="top-date-select" style="display: none;">
				<input id="dateSelect2" name="dateSelect2" class="dateSelect2" type="hidden" />
				<button value="7" type="button">1주일</button>
				<button value="14" type="button">2주일</button>
				<button value="30" type="button">1달</button>
				<button value="90" type="button">3달</button>
			</div>
		</div>

		<div class="search-bottom">
			<div class="bottom-title">상세조건</div>
			<div class="bottom-select">
				<select name="detailIndex" class="detailIndex">
					<option value="none3">--선택--</option>
					<option value = "1">신규주문</option>
					<option value = "0">주문취소요청</option>
					<option value = "-1">주문취소완료</option>
					<option value = "2">배송준비중</option>
					<option value = "3">배송중</option>
					<option value = "4">배송완료</option>
					<option value = "5">반품신청</option>
					<option value = "6">반품중</option>
					<option value = "7">반품완료</option>
					<option value = "customerName2">고객 이름</option>
					<option value = "customerId2">고객 아이디</option>
					<option value = "prdName2">구매상품이름</option>
				</select>
			</div>
			<div class="bottom-input" style="display: none;">
				<input name="order" type="text" />
			</div>
		</div>
		<div class="search-btn">
			<button id="orderSearchBtn">검색</button>
		</div>
	</div>

	<div class="order-bottom">
		<div class="bottom-title">
			<div>목록 (총 <span id="countList2">0</span>개)</div>
			<div><button id="oneShotForOrder" class="oneShotForOrder" style="display: none;">일괄처리</button></div>
		</div>
		<div class="bottom-list">
			<div class="list-title">
				<table>
					<tr>
						<td>
						<input type="checkbox" id="orderAll"
							class="orderCheckBox">
						</td>
						<!-- 
						<td>고객아이디</td>
						<td>고객이름</td>
						<td>배송주소</td>
						<td>상품이름</td>
						<td>상품개수</td>
						<td>결제일시</td>
						<td>발송일시</td>
						<td>배송완료일시</td>
						<td>현재 상태</td>
						 -->
						<td>고객아이디</td>
						<td style="padding-right: 5px;">고객이름</td>
						<td style="padding-right: 8px;">배송주소</td>
						<td style="padding-right: 10px;">상품이름</td>
						<td style="padding-right: 15px;">상품개수</td>
						<td style="padding-right: 18px;">결제일시</td>
						<td style="padding-right: 20px;">발송일시</td>
						<td style="padding-right: 25px;">배송완료일시</td>
						<td style="padding-right: 30px;">현재 상태</td>
					</tr>
				</table>
			</div>
			<div class="list-content" style="padding-right: 10px;">
				<table id="orderResult" >
					<tr>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript" src="/js/adminPage/orderAjax.js"></script>

<!-- jQuery confirm을 위한 Load -->	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<script>
	$(".timeIndex").change(function() {
		var isAll = $(".timeIndex>option:selected").val();
		if (isAll != "all2" && isAll != "none2") {
			$(".top-date-select").show();
		} else {
			$(".top-date-select").hide();
		}
	});
	
	$(".detailIndex").change(function(){
		var isDate = $(".detailIndex>option:selected").val();
		if(isDate != "customerName2" && isDate != "customerId2" && isDate != "prdName2"){
			$(".bottom-input").hide();
		} else {
			$(".bottom-input").show();
		}
	});
	
	$(function(){ //전체선택 체크박스 클릭
		$("#orderAll").click(function(){ //만약 전체 선택 체크박스가 체크된상태일 경우
			if($("#orderAll").prop("checked")) { //해당화면에 전체 checkbox들을 체크해준다
				$("input[class=orderCheckBox]").prop("checked",true); // 전체선택 체크박스가 해제된 경우
				} else { //해당화면에 모든 checkbox들의 체크를해제시킨다.
					$("input[class=orderCheckBox]").prop("checked",false);
				}
		});
	});
	
	$(document).on('click', '.orderProgress', function(){
		let detailIndex = $("[name = detailIndex]").val();
		let msg = "";
		
		if(detailIndex == 0){
			msg = "주문 취소 요청을 수락";
		} else if (detailIndex == 1){
			msg = "신규주문에 대한 배송을 준비";
		} else if (detailIndex == 2){
			msg = "발송처리";
		} else if (detailIndex == 3){
			msg = "배송완료 처리";
		} else if (detailIndex == 4){
			msg = "반품처리";
		} else if (detailIndex == 5){
			msg = "반품 요청을 수락";
		} else if (detailIndex == 6){
			msg = "반품완료 처리";
		} else {
			alert("잘못된 요청입니다.");
			return;
		}
		isGo = confirm(msg + "하시겠습니까?");
		
		if(isGo){
			$.ajax({
				url : "/orderProgress",
				type : "get",
				data : {
					orderStatus : $(this).attr("status"),
					orderNum : $(this).attr("id")
				},
				success : function(data) {
					if(data > 0){
						$("#orderSearchBtn").trigger('click');
					} else {
						alert("주문 처리가 비정상적으로 종료되었습니다.");
					}
				},
				error : function(){
					alert("주문 처리가 비정상적으로 종료되었습니다.");
					}
			})
		}
1	});
</script>